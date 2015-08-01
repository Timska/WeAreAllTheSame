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

	public static void fillItems() {
		Cursor cursor = resolver
				.query(ItemContentProvider.CONTENT_URI,
						new String[] { ItemOpenHelper.COLUMN_ID }, null,
						null, null);
		if (cursor.getCount() == 0) {
			fillFruitsAndVegetables();
		}
	}
	
	private static void fillFruitsAndVegetables() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("ананас", "ананас"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("банана", "банана"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("брокула", "брокула"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("грозје", "грозје"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("диња", "диња"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("домат", "домат"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зелка", "зелка"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("јаболко", "јаболко"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("јагода", "јагода"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кајсија", "кајсија"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("киви", "киви"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("краставица", "краставица"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кромид", "кромид"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лимон", "лимон"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лубеница", "лубеница"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("малина", "малина"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("мандарина", "мандарина"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("морков", "морков"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("пиперка", "пиперка"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("портокал", "портокал"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("праска", "праска"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("слива", "слива"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("смоква", "смоква"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("цреша", "цреша"));
	}
	
	private static ContentValues toItemContentValues(String itemName, String resource) {
		ContentValues cv = new ContentValues();
		cv.put(ItemOpenHelper.COLUMN_NAME, itemName);
		cv.put(ItemOpenHelper.COLUMN_RESOURCE, resource);
		return cv;
	}
	
	
	public static void fillWholeDatabase() {
		fillCategories();
		fillItems();
	}
}
