package weareallthesame.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class FillDatabase {

	private static ContentResolver resolver;

	public static void setContext(Context context) {
		resolver = context.getContentResolver();
	}

	public static void fillCategories() {
		Cursor cursor = resolver
				.query(CategoryContentProvider.CONTENT_URI,
						new String[] { CategoryOpenHelper.COLUMN_ID }, null,
						null, null);
		
		if (cursor.getCount() == 0) {
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("letters", "букви", "letters"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("shapes", "форми", "forms"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("numbers", "броеви", "numbers"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("animals", "животни", "animals"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("fruitsandvegetables", "овошје и зеленчук", "fruit_vegetables"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("weather", "временски услови", "weather"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("year", "година", "months_days"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("day", "ден", "day_details"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("colorsandobjects", "бои и предмети", "colors_objects"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("prepositions", "предлози", "prepositions"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("clothesandbodyparts", "облека и делови на тело", "clothes"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("emotions", "емоции", "emotions"));
		}
	}

	private static ContentValues toCategoryContentValues(String type, String name, String resource) {
		ContentValues cv = new ContentValues();
		cv.put(CategoryOpenHelper.COLUMN_TYPE, type);
		cv.put(CategoryOpenHelper.COLUMN_NAME, name);
		cv.put(CategoryOpenHelper.COLUMN_RESOURCE, resource);
		return cv;
	}

	
	public static void fillWholeDatabase() {
		fillCategories();
	}
}
