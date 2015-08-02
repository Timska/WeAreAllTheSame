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
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("ананас", "ananas"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("банана", "banana"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("брокула", "brokula"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("грозје", "grozje"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("диња", "dinja"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("домат", "domat"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зелка", "zelka"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("јаболко", "jabolko"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("јагода", "jagoda"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кајсија", "kajsija"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("киви", "kivi"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("краставица", "krastavica"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кромид", "kromid"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лимон", "limon"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лубеница", "lubenica"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("малина", "malina"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("мандарина", "mandarina"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("морков", "morkov"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("пиперка", "piperka"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("портокал", "portokal"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("праска", "praska"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("слива", "sliva"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("смоква", "smokva"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("цреша", "cresha"));
	}
	
	private static ContentValues toItemContentValues(String itemName, String resource) {
		ContentValues cv = new ContentValues();
		cv.put(ItemOpenHelper.COLUMN_NAME, itemName);
		cv.put(ItemOpenHelper.COLUMN_RESOURCE, resource);
		return cv;
	}
	
	public static void fillItemTags() {
		Cursor cursor = resolver
				.query(ItemTagsContentProvider.CONTENT_URI,
						new String[] { ItemOpenHelper.COLUMN_ID }, null,
						null, null);
		
		if (cursor.getCount() == 0) {
			fillFruitsAndVegetablesTags();
		}
	}
	
	private static void fillFruitsAndVegetablesTags() {
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("ананас", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("банана", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("брокула", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("грозје", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("диња", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("домат", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зелка", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("јаболко", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("јагода", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кајсија", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("киви", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("краставица", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кромид", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лимон", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лубеница", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("малина", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мандарина", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("морков", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("пиперка", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("портокал", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("праска", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("слива", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("смоква", "fruitsAndVegetables"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("цреша", "fruitsAndVegetables"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("ананас", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("банана", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("брокула", "vegetable"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("грозје", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("диња", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("домат", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зелка", "vegetable"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("јаболко", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("јагода", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кајсија", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("киви", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("краставица", "vegetable"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кромид", "vegetable"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лимон", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лубеница", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("малина", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мандарина", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("морков", "vegetable"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("пиперка", "vegetable"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("портокал", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("праска", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("слива", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("смоква", "fruit"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("цреша", "fruit"));
	}
	
	private static ContentValues toItemTagsContentValues(String itemName, String tag) {
		ContentValues cv = new ContentValues();
		cv.put(ItemTagsOpenHelper.COLUMN_NAME, itemName);
		cv.put(ItemTagsOpenHelper.COLUMN_TAG, tag);
		return cv;
	}
	
	public static void fillWholeDatabase() {
		fillCategories();
		fillItems();
		fillItemTags();
	}
}
