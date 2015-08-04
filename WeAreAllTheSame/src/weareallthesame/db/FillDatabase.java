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
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("letters", "Букви", "letters"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("shapes", "Форми", "forms"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("numbers", "Броеви", "numbers"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("animals", "Животни", "animals"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("fruitsandvegetables", "Овошје и зеленчук", "fruit_vegetables"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("weather", "Временски услови", "weather"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("year", "Година", "months_days"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("day", "Ден", "day_details"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("colorsandobjects", "Бои и предмети", "colors_objects"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("prepositions", "Предлози", "prepositions"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("clothesandbodyparts", "Облека и делови на тело", "clothes"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("emotions", "Емоции", "emotions"));
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
			fillAnimals();
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
	
	private static void fillAnimals() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("камила", "kamila"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кенгур", "kengur"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кокошка", "kokoshka"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("коњ", "konj"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("крава", "krava"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("куче", "kuche"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лав", "lav"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лисица", "lisica"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("мачка", "machka"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("мечка", "mechka"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("овца", "ovca"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("слон", "slon"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("свиња", "svinja"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("тигар", "tigar"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("верверичка", "ververichka"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("волк", "volk"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зајак", "zajak"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зебра", "zebra"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("жирафа", "zirafa"));
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
						new String[] { ItemTagsOpenHelper.COLUMN_ID }, null,
						null, null);
		
		if (cursor.getCount() == 0) {
			fillFruitsAndVegetablesTags();
			fillAnimalsTags();
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
	
	private static void fillAnimalsTags() {
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("камила", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кенгур", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кокошка", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("коњ", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("крава", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("куче", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лав", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лисица", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мачка", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мечка", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("овца", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("слон", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("свиња", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("тигар", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("верверичка", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("волк", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зајак", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зебра", "animals"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("жирафа", "animals"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("камила", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кенгур", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кокошка", "domestic"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("коњ", "domestic"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("крава", "domestic"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("куче", "domestic"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лав", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лисица", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мачка", "domestic"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мечка", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("овца", "domestic"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("слон", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("свиња", "domestic"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("тигар", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("верверичка", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("волк", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зајак", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зебра", "wild"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("жирафа", "wild"));
	}
	
	private static ContentValues toItemTagsContentValues(String itemName, String tag) {
		ContentValues cv = new ContentValues();
		cv.put(ItemTagsOpenHelper.COLUMN_NAME, itemName);
		cv.put(ItemTagsOpenHelper.COLUMN_TAG, tag);
		return cv;
	}
	
	public static void fillGames() {
		Cursor cursor = resolver
				.query(GameContentProvider.CONTENT_URI,
						new String[] { GameOpenHelper.COLUMN_ID }, null,
						null, null);
		
		if (cursor.getCount() == 0) {
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("letters", "ChooseStringFromSound", "letters_chooseLetter"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("letters", "HangmanEasy", "letters_fillLetters"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("letters", "Hangman", "letters_orderLetters"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("shapes", "ChooseItem", "shapes_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("shapes", "ChooseItem", "shapes_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("shapes", "ChooseSimilarItem", "shapes_similarity"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("shapes", "ChooseSimilarItem", "shapes_looksLike"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "ChooseStringFromSound", "numbers_chooseNumber"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "HowMany", "numbers_countObjects"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "ChooseSignBetweenNumbers", "numbers_findSign"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "ChooseSignBetweenSets", "numbers_sets"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "AdditionAndSubtractionNumbers", "numbers_addSets"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "AdditionAndSubtractionSets", "numbers_addNumbers"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "AdditionAndSubtractionNumbers", "numbers_substractSets"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "AdditionAndSubtractionSets", "numbers_substractNumbers"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "ChooseItem", "numbers_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "ChooseItem", "numbers_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("numbers", "OrderElements", "numbers_orderNumbers"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("animals", "ChooseItem", "animals_chooseAnimal"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("animals", "ChooseItem", "animals_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("animals", "ConnectItemAndResurs", "animals_connectAnimals"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("animals", "ItemsClassification", "animals_groupWords"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("animals", "ItemsClassification", "animals_groupPictures"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("animals", "ChooseItem", "animals_chooseWord"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("fruitsandvegetables", "ChooseItem", "fruitsandvegetables_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("fruitsandvegetables", "ChooseItem", "fruitsandvegetables_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("fruitsandvegetables", "ConnectItemAndResurs", "fruitsandvegetables_connectPictures"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("fruitsandvegetables", "ItemsClassification", "fruitsandvegetables_groupWords"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("fruitsandvegetables", "ItemsClassification", "fruitsandvegetables_groupPictures"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("weather", "ChooseItem", "weather_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("weather", "ChooseItem", "weather_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("weather", "ChooseItem", "weather_outsideWeather"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("weather", "ConnectItemAndResurs", "weather_connectPictures"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("year", "Question", "year_questions"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("year", "OrderElements", "year_orderDays"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("year", "OrderElements", "year_orderMonths"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("year", "ItemsClassification", "year_groupWords"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("day", "ChooseItem", "day_whatsTheTime"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("day", "OrderElements", "day_dayParts"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("colorsandobjects", "ChooseItem", "colorsandobjects_chooseColor"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("colorsandobjects", "ChooseItem", "colorsandobjects_chooseObject"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("colorsandobjects", "ConnectItemAndResurs", "colorsandobjects_connect"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("colorsandobjects", "ConnectItems", "colorsandobjects_whatsTheColor"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("prepositions", "ChooseItem", "prepositions_choosePreposition"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("prepositions", "ChooseItem", "prepositions_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("prepositions", "ChooseItem", "prepositions_connect"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("clothesandbodyparts", "ChooseItem", "clothesandbodyparts_chooseBodyPartFromWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("clothesandbodyparts", "ChooseItem", "clothesandbodyparts_chooseBodyPartFromPicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("clothesandbodyparts", "ChooseItem", "clothesandbodyparts_chooseClothingFromWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("clothesandbodyparts", "ConnectItems", "clothesandbodyparts_chooseClothingFromPicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("clothesandbodyparts", "ConnectItems", "clothesandbodyparts_connect"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("emotions", "ChooseItem", "emotions_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("emotions", "ChooseItem", "emotions_choosePicture"));
		}
	}
	
	private static ContentValues toGameContentValues(String categoryType, String gameType, String gameName) {
		ContentValues cv = new ContentValues();
		cv.put(GameOpenHelper.COLUMN_CATTYPE, categoryType);
		cv.put(GameOpenHelper.COLUMN_GAMETYPE, gameType);
		cv.put(GameOpenHelper.COLUMN_GAMENAME, gameName);
		return cv;
	}
	
	public static void fillWholeDatabase() {
		fillCategories();
		fillItems();
		fillItemTags();
		fillGames();
	}
}
