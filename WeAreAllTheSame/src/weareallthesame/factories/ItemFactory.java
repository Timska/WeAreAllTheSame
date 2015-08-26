package weareallthesame.factories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import weareallthesame.db.ItemContentProvider;
import weareallthesame.db.ItemOpenHelper;
import weareallthesame.db.ItemTagsContentProvider;
import weareallthesame.db.ItemTagsOpenHelper;
import weareallthesame.db.ResourceContentProvider;
import weareallthesame.db.ResourceOpenHelper;
import weareallthesame.model.items.Item;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;

/**
 * Ovaa klasa ke se koristi za kreiranje na itemi.
 * 
 * @author i5
 *
 */
public class ItemFactory {

	// Sluzi za povici do bazata
	private static ContentResolver resolver;

	public static void setContext(Context context) {
		resolver = context.getContentResolver();
	}

	/**
	 * Ovoj metod se koristi za povlekuvanje na itemi od baza.
	 * 
	 * @param tags
	 *            tagovite so koi ke treba da se tagirani itemite za da bidat
	 *            povleceni od baza.
	 * @param numberOfItems
	 *            kolku itemi da bidat povleceni.
	 * @return
	 */
	public static Iterator<Item> getItem(Iterator<String> tags,
			int numberOfItems) {
		// TODO ke treba da se implementira citanje od baza na itemi za dadenite
		// tagovi i da se vrati tocno numberOfItems itemi

		Cursor cursor = resolver.query(ItemTagsContentProvider.CONTENT_URI,
				new String[] { ItemTagsOpenHelper.COLUMN_NAME },
				ItemTagsOpenHelper.COLUMN_TAG + "=" + "'" + tags.next() + "'",
				null, null);

		Set<String> itemsSet = getItemNamesFromCursor(cursor);
		cursor.close();

		while (tags.hasNext()) {
			cursor = resolver.query(ItemTagsContentProvider.CONTENT_URI,
					new String[] { ItemTagsOpenHelper.COLUMN_NAME },
					ItemTagsOpenHelper.COLUMN_TAG + "=" + "'" + tags.next()
							+ "'", null, null);

			itemsSet.retainAll(getItemNamesFromCursor(cursor));
			cursor.close();
		}

		List<String> items = new ArrayList<String>(itemsSet);
		Collections.shuffle(items);

		int size = items.size();
		for (int i = size - 1; i >= 0; i--) {
			if (items.size() <= numberOfItems) {
				break;
			}
			items.remove(i);
		}

		List<Item> result = new ArrayList<Item>();
		for (String str : items) {
			cursor = resolver.query(ItemContentProvider.CONTENT_URI,
					new String[] { ItemOpenHelper.COLUMN_RESOURCE },
					ItemOpenHelper.COLUMN_NAME + "=" + "'" + str + "'", null,
					null);

			Map<String, String> resources = new HashMap<String, String>();
			while (cursor.moveToNext()) {
				int resourceID = cursor.getInt(cursor
						.getColumnIndex(ItemOpenHelper.COLUMN_RESOURCE));

				Cursor resCursor = resolver.query(
						ResourceContentProvider.CONTENT_URI, new String[] {
								ResourceOpenHelper.COLUMN_RESNAME,
								ResourceOpenHelper.COLUMN_RESTYPE },
						ResourceOpenHelper.COLUMN_ID + "=" + resourceID, null,
						null);

				resCursor.moveToFirst();
				String resourceName = resCursor.getString(resCursor
						.getColumnIndex(ResourceOpenHelper.COLUMN_RESNAME));
				String resourceType = resCursor.getString(resCursor
						.getColumnIndex(ResourceOpenHelper.COLUMN_RESTYPE));
				resources.put(resourceType, resourceName);

				resCursor.close();
			}

			result.add(new Item(str, resources));

			cursor.close();
		}

		return result.iterator();
	}

	public static Set<String> getItemNamesFromCursor(Cursor cursor) {
		Set<String> result = new HashSet<String>();
		while (cursor.moveToNext()) {
			String itemName = cursor.getString(cursor
					.getColumnIndex(ItemTagsOpenHelper.COLUMN_NAME));
			result.add(itemName);
		}
		return result;
	}

}
