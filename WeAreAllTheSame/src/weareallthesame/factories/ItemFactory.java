package weareallthesame.factories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import weareallthesame.db.ItemContentProvider;
import weareallthesame.db.ItemOpenHelper;
import weareallthesame.db.ItemTagsContentProvider;
import weareallthesame.db.ItemTagsOpenHelper;
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

	// Contekstot (odnosno Activity) ni treba za da moze ContentResolver-ot da
	// se inicijalizira
	// Namesto da se povikuva konstruktor, moze i kako parametar vo potrebnite
	// metodi da se pusti
	private static Context ctx;
	// Sluzi za povici do bazata
	private static ContentResolver resolver;

	public ItemFactory(Context ctx) {
		ItemFactory.ctx = ctx;
		resolver = ctx.getContentResolver();
	}

	public ItemFactory() {

	}

	public Context getContext() {
		return ctx;
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
				getSelectionOfTags(tags), null, null);

		List<String> items = new ArrayList<String>();
		while (cursor.moveToNext()) {
			String itemName = cursor.getString(cursor
					.getColumnIndex(ItemTagsOpenHelper.COLUMN_NAME));
			if (!items.contains(itemName)) {
				items.add(itemName);
			}
		}
		Collections.shuffle(items);

		int size = items.size();
		for (int i = size; i >= 0; i--) {
			if (items.size() <= numberOfItems) {
				break;
			}
			items.remove(i);
		}

		List<Item> result = new ArrayList<Item>();
		for (String str : items) {
			cursor = resolver.query(ItemContentProvider.CONTENT_URI,
					new String[] { ItemOpenHelper.COLUMN_RESOURCE },
					ItemOpenHelper.COLUMN_NAME + "=" + str, null, null);
			List<String> resources = new ArrayList<String>();
			while (cursor.moveToNext()) {
				String resourceID = cursor.getString(cursor
						.getColumnIndex(ItemOpenHelper.COLUMN_RESOURCE));
				resources.add(resourceID);
			}

			result.add(new Item(str, resources.iterator()) {

			});
		}

		return result.iterator();
	}

	private static String getSelectionOfTags(Iterator<String> tagsList) {
		StringBuilder sb = new StringBuilder();
		sb.append(ItemTagsOpenHelper.COLUMN_TAG + "=" + tagsList.next());
		while (tagsList.hasNext()) {
			sb.append(" or " + ItemTagsOpenHelper.COLUMN_TAG + "="
					+ tagsList.next());
		}
		return sb.toString();
	}

}
