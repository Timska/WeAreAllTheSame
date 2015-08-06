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
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("Letters", "Букви", "letters"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("Shapes", "Форми", "forms"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("Numbers", "Броеви", "numbers"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("Animals", "Животни", "animals"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("FruitsAndVegetables", "Овошје и зеленчук", "fruit_vegetables"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("Weather", "Временски услови", "weather"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("Year", "Година", "months_days"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("Day", "Ден", "day_details"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("ColorsAndObjects", "Бои и предмети", "colors_objects"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("Prepositions", "Предлози", "prepositions"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("ClothesAndBodyParts", "Облека и делови на тело", "clothes"));
			resolver.insert(CategoryContentProvider.CONTENT_URI, toCategoryContentValues("Emotions", "Емоции", "emotions"));
		}
		cursor.close();
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
			fillNumbers();
			fillLetters();
		}
		cursor.close();
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
	
	private static void fillNumbers() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("0", "zero"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("1", "one"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("2", "two"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("3", "three"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("4", "four"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("5", "five"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("6", "six"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("7", "seven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("8", "eight"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("9", "nine"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("10", "ten"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("11", "eleven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("12", "twelve"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("13", "thirteen"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("14", "fourteen"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("15", "fifteen"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("16", "sixteen"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("17", "seventeen"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("18", "eighteen"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("19", "ninety"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("20", "twenty"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("21", "twenty_one"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("22", "twenty_two"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("23", "twenty_three"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("24", "twenty_four"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("25", "twenty_five"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("26", "twenty_six"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("27", "twenty_seven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("28", "twenty_eight"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("29", "twenty_nine"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("30", "thirty"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("31", "thirty_one"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("32", "thirty_two"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("33", "thirty_three"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("34", "thirty_four"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("35", "thirty_five"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("36", "thirty_six"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("37", "thirty_seven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("38", "thirty_eight"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("39", "thirty_nine"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("40", "fourty"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("41", "fourty_one"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("42", "fourty_two"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("43", "fourty_three"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("44", "fourty_four"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("45", "fourty_five"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("46", "fourty_six"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("47", "fourty_seven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("48", "fourty_eight"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("49", "fourty_nine"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("50", "fifty"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("51", "fifty_one"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("52", "fifty_two"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("53", "fifty_three"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("54", "fifty_four"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("55", "fifty_five"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("56", "fifty_six"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("57", "fifty_seven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("58", "fifty_eight"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("59", "fifty_nine"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("60", "sixty"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("61", "sixty_one"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("62", "sixty_two"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("63", "sixty_three"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("64", "sixty_four"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("65", "sixty_five"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("66", "sixty_six"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("67", "sixty_seven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("68", "sixty_eight"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("69", "sixty_nine"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("70", "seventy"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("71", "seventy_one"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("72", "seventy_two"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("73", "seventy_three"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("74", "seventy_four"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("75", "seventy_five"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("76", "seventy_six"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("77", "seventy_seven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("78", "seventy_eight"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("79", "seventy_nine"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("80", "eighty"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("81", "eighty_one"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("82", "eighty_two"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("83", "eighty_three"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("84", "eighty_four"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("85", "eighty_five"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("86", "eighty_six"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("87", "eighty_seven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("88", "eighty_eight"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("89", "eighty_nine"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("90", "ninety"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("91", "ninety_one"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("92", "ninety_two"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("93", "ninety_three"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("94", "ninety_four"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("95", "ninety_five"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("96", "ninety_six"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("97", "ninety_seven"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("98", "ninety_eighty"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("99", "ninety_nine"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("100", "one_hundred"));
	}
	
	private static void fillLetters() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("А", "a"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Б", "b"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("В", "v"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Г", "g"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Д", "d"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ѓ", "gj"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Е", "e"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ж", "zh"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("З", "z"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ѕ", "dz"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("И", "i"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ј", "j"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("К", "k"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Л", "l"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Љ", "lj"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("М", "m"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Н", "n"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Њ", "nj"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("О", "o"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("П", "p"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Р", "r"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("С", "s"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Т", "t"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ќ", "kj"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("У", "u"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ф", "f"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Х", "h"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ц", "c"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ч", "ch"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Џ", "dzh"));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ш", "sh"));
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
			fillNumbersTags();
			fillLettersTags();
		}
		cursor.close();
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
	
	private static void fillNumbersTags() {
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("0", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("1", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("2", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("3", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("4", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("5", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("6", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("7", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("8", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("9", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("10", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("11", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("12", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("13", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("14", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("15", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("16", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("17", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("18", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("19", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("20", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("21", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("22", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("23", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("24", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("25", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("26", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("27", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("28", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("29", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("30", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("31", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("32", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("33", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("34", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("35", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("36", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("37", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("38", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("39", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("40", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("41", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("42", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("43", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("44", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("45", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("46", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("47", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("48", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("49", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("50", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("51", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("52", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("53", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("54", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("55", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("56", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("57", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("58", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("59", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("60", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("61", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("62", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("63", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("64", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("65", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("66", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("67", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("68", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("69", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("70", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("71", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("72", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("73", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("74", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("75", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("76", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("77", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("78", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("79", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("80", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("81", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("82", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("83", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("84", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("85", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("86", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("87", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("88", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("89", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("90", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("91", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("92", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("93", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("94", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("95", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("96", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("97", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("98", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("99", "numbers"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("100", "numbers"));
	}
	
	private static void fillLettersTags() {
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("А", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Б", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("В", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Г", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Д", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ѓ", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Е", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ж", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("З", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ѕ", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("И", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ј", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("К", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Л", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Љ", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("М", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Н", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Њ", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("О", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("П", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Р", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("С", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Т", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ќ", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("У", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ф", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Х", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ц", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ч", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Џ", "letters"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ш", "letters"));
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
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Letters", "ChooseStringFromSound", "letters_chooseLetter"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Letters", "HangmanEasy", "letters_fillLetters"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Letters", "Hangman", "letters_orderLetters"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ChooseItem", "shapes_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ChooseItem", "shapes_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ChooseSimilarItem", "shapes_similarity"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ChooseSimilarItem", "shapes_looksLike"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseStringFromSound", "numbers_chooseNumber"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "HowMany", "numbers_countObjects"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseSignBetweenNumbers", "numbers_findSign"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseSignBetweenSets", "numbers_sets"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "AdditionAndSubtractionNumbers", "numbers_addSets"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "AdditionAndSubtractionSets", "numbers_addNumbers"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "AdditionAndSubtractionNumbers", "numbers_substractSets"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "AdditionAndSubtractionSets", "numbers_substractNumbers"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseItem", "numbers_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseItem", "numbers_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "OrderElements", "numbers_orderNumbers"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ChooseItem", "animals_chooseAnimal"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ChooseItem", "animals_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ConnectItemAndResurs", "animals_connectAnimals"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ItemsClassification", "animals_groupWords"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ItemsClassification", "animals_groupPictures"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ChooseItem", "animals_chooseWord"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ChooseItem", "fruitsandvegetables_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ChooseItem", "fruitsandvegetables_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ConnectItemAndResurs", "fruitsandvegetables_connectPictures"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ItemsClassification", "fruitsandvegetables_groupWords"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ItemsClassification", "fruitsandvegetables_groupPictures"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Weather", "ChooseItem", "weather_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Weather", "ChooseItem", "weather_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Weather", "ChooseItem", "weather_outsideWeather"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Weather", "ConnectItemAndResurs", "weather_connectPictures"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Year", "Question", "year_questions"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Year", "OrderElements", "year_orderDays"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Year", "OrderElements", "year_orderMonths"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Year", "ItemsClassification", "year_groupWords"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Day", "ChooseItem", "day_whatsTheTime"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Day", "OrderElements", "day_dayParts"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("ColorsAndObjects", "ChooseItem", "colorsandobjects_chooseColor"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("ColorsAndObjects", "ChooseItem", "colorsandobjects_chooseObject"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("ColorsAndObjects", "ConnectItemAndResurs", "colorsandobjects_connect"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("ColorsAndObjects", "ConnectItems", "colorsandobjects_whatsTheColor"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Prepositions", "ChooseItem", "prepositions_choosePreposition"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Prepositions", "ChooseItem", "prepositions_choosePicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Prepositions", "ChooseItem", "prepositions_connect"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("ClothesAndBodyParts", "ChooseItem", "clothesandbodyparts_chooseBodyPartFromWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("ClothesAndBodyParts", "ChooseItem", "clothesandbodyparts_chooseBodyPartFromPicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("ClothesAndBodyParts", "ChooseItem", "clothesandbodyparts_chooseClothingFromWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("ClothesAndBodyParts", "ConnectItems", "clothesandbodyparts_chooseClothingFromPicture"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("ClothesAndBodyParts", "ConnectItems", "clothesandbodyparts_connect"));
			
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Emotions", "ChooseItem", "emotions_chooseWord"));
			resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Emotions", "ChooseItem", "emotions_choosePicture"));
		}
		cursor.close();
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
