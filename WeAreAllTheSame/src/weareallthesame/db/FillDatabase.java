package weareallthesame.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

public class FillDatabase {

	private static ContentResolver resolver;

	public static void setContext(Context context) {
		resolver = context.getContentResolver();
	}

	public static void fillCategories() {
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

	private static ContentValues toCategoryContentValues(String type, String name, String resource) {
		ContentValues cv = new ContentValues();
		cv.put(CategoryOpenHelper.COLUMN_TYPE, type);
		cv.put(CategoryOpenHelper.COLUMN_NAME, name);
		cv.put(CategoryOpenHelper.COLUMN_RESOURCE, resource);
		return cv;
	}
	
	public static void fillResources() {
		fillFruitsAndVegetablesResources();
		fillAnimalsResources();
		fillNumbersResources();
		fillLettersResources();
		fillWeatherResources();
		fillClothesAndBodyPartsResources();
		fillEmotionsResources();
		fillPrepositionsResources();
	}
	
	private static void fillFruitsAndVegetablesResources() {
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(1, "ananas", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(2, "banana", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(3, "brokula", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(4, "grozje", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(5, "dinja", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(6, "domat", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(7, "zelka", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(8, "jabolko", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(9, "jagoda", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(10, "kajsija", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(11, "kivi", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(12, "krastavica", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(13, "kromid", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(14, "limon", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(15, "lubenica", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(16, "malina", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(17, "mandarina", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(18, "morkov", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(19, "piperka", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(20, "portokal", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(21, "praska", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(22, "sliva", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(23, "smokva", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(24, "cresha", "picture"));
	}
	
	private static void fillAnimalsResources() {
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(25, "kamila", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(26, "kengur", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(27, "kokoshka", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(28, "konj", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(29, "krava", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(30, "kuche", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(31, "lav", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(32, "lisica", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(33, "machka", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(34, "mechka", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(35, "ovca", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(36, "slon", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(37, "svinja", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(38, "tigar", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(39, "ververichka", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(40, "volk", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(41, "zajak", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(42, "zebra", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(43, "zirafa", "picture"));
		
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(176, "bear", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(177, "camel", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(178, "cat", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(179, "chicken", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(180, "cow", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(181, "dog", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(182, "elephant", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(183, "fox", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(184, "horse", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(185, "lion", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(186, "pig", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(187, "rabbit", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(188, "sheep", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(189, "squirrel", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(190, "tiger", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(191, "wolf", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(192, "zebra", "sound"));
	}
	
	private static void fillNumbersResources() {
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(44, "zero", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(45, "one", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(46, "two", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(47, "three", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(48, "four", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(49, "five", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(50, "six", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(51, "seven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(52, "eight", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(53, "nine", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(54, "ten", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(55, "eleven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(56, "twelve", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(57, "thirteen", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(58, "fourteen", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(59, "fifteen", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(60, "sixteen", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(61, "seventeen", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(62, "eighteen", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(63, "nineteen", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(64, "twenty", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(65, "twenty_one", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(66, "twenty_two", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(67, "twenty_three", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(68, "twenty_four", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(69, "twenty_five", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(70, "twenty_six", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(71, "twenty_seven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(72, "twenty_eight", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(73, "twenty_nine", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(74, "thirty", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(75, "thirty_one", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(76, "thirty_two", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(77, "thirty_three", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(78, "thirty_four", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(79, "thirty_five", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(80, "thirty_six", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(81, "thirty_seven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(82, "thirty_eight", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(83, "thirty_nine", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(84, "fourty", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(85, "fourty_one", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(86, "fourty_two", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(87, "fourty_three", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(88, "fourty_four", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(89, "fourty_five", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(90, "fourty_six", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(91, "fourty_seven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(92, "fourty_eight", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(93, "fourty_nine", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(94, "fifty", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(95, "fifty_one", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(96, "fifty_two", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(97, "fifty_three", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(98, "fifty_four", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(99, "fifty_five", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(100, "fifty_six", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(101, "fifty_seven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(102, "fifty_eight", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(103, "fifty_nine", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(104, "sixty", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(105, "sixty_one", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(106, "sixty_two", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(107, "sixty_three", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(108, "sixty_four", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(109, "sixty_five", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(110, "sixty_six", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(111, "sixty_seven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(112, "sixty_eight", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(113, "sixty_nine", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(114, "seventy", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(115, "seventy_one", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(116, "seventy_two", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(117, "seventy_three", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(118, "seventy_four", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(119, "seventy_five", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(120, "seventy_six", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(121, "seventy_seven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(122, "seventy_eight", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(123, "seventy_nine", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(124, "eighty", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(125, "eighty_one", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(126, "eighty_two", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(127, "eighty_three", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(128, "eighty_four", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(129, "eighty_five", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(130, "eighty_six", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(131, "eighty_seven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(132, "eighty_eight", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(133, "eighty_nine", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(134, "ninety", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(135, "ninety_one", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(136, "ninety_two", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(137, "ninety_three", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(138, "ninety_four", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(139, "ninety_five", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(140, "ninety_six", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(141, "ninety_seven", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(142, "ninety_eight", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(143, "ninety_nine", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(144, "one_hundred", "sound"));
	}
	
	private static void fillLettersResources() {
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(145, "a", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(146, "b", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(147, "v", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(148, "g", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(149, "d", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(150, "gj", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(151, "e", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(152, "zh", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(153, "z", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(154, "dz", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(155, "i", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(156, "j", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(157, "k", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(158, "l", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(159, "lj", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(160, "m", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(161, "n", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(162, "nj", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(163, "o", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(164, "p", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(165, "r", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(166, "s", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(167, "t", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(168, "kj", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(169, "u", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(170, "f", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(171, "h", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(172, "c", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(173, "ch", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(174, "dzh", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(175, "sh", "sound"));
	}
	
	private static void fillWeatherResources() {
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(193, "wind", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(194, "rain", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(195, "rain_thunder", "sound"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(196, "thunder", "sound"));
		
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(234, "wind", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(235, "rain", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(236, "rain_thunder", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(237, "thunder", "picture"));
	}
	
	private static void fillClothesAndBodyPartsResources() {
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(197, "arm", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(198, "ears", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(199, "elbow", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(200, "eyelashes", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(201, "face", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(202, "foot", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(203, "forehead", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(204, "hands", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(205, "head", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(206, "mouth", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(207, "teeth", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(208, "wrist", "picture"));
		
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(221, "bluza", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(222, "chizmi", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(223, "corapi", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(224, "dukserka", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(225, "dzemper", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(226, "fustan", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(227, "koshula", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(228, "maica", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(229, "patiki", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(230, "rakavici", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(231, "trenerki", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(232, "vratovrska", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(233, "zdolnishte", "picture"));
	}
	
	private static void fillEmotionsResources() {
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(209, "angry", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(210, "confused", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(211, "content", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(212, "excited", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(213, "frightened", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(214, "happy", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(215, "nervous", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(216, "proud", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(217, "sad", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(218, "surprised", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(219, "thoughtful", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(220, "tired", "picture"));
	}
	
	private static void fillPrepositionsResources() {
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(238, "behind", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(239, "in", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(240, "in_front_of", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(241, "next_to", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(242, "on_top_of", "picture"));
		resolver.insert(ResourceContentProvider.CONTENT_URI, toResourceContentValues(243, "under", "picture"));
	}
	
	private static ContentValues toResourceContentValues(int id, String name, String type) {
		ContentValues cv = new ContentValues();
		cv.put(ResourceOpenHelper.COLUMN_ID, id);
		cv.put(ResourceOpenHelper.COLUMN_RESNAME, name);
		cv.put(ResourceOpenHelper.COLUMN_RESTYPE, type);
		return cv;
	}

	public static void fillItems() {
		fillFruitsAndVegetables();
		fillAnimals();
		fillNumbers();
		fillLetters();
		fillWeather();
		fillClothesAndBodyParts();
		fillEmotions();
		fillYear();
		fillPrepositions();
	}
	
	private static void fillFruitsAndVegetables() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("ананас", 1));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("банана", 2));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("брокула", 3));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("грозје", 4));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("диња", 5));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("домат", 6));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зелка", 7));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("јаболко", 8));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("јагода", 9));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кајсија", 10));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("киви", 11));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("краставица", 12));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кромид", 13));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лимон", 14));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лубеница", 15));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("малина", 16));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("мандарина", 17));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("морков", 18));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("пиперка", 19));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("портокал", 20));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("праска", 21));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("слива", 22));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("смоква", 23));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("цреша", 24));
	}
	
	private static void fillAnimals() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("камила", 25));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кенгур", 26));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кокошка", 27));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("коњ", 28));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("крава", 29));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("куче", 30));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лав", 31));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лисица", 32));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("мачка", 33));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("мечка", 34));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("овца", 35));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("слон", 36));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("свиња", 37));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("тигар", 38));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("верверичка", 39));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("волк", 40));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зајак", 41));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зебра", 42));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("жирафа", 43));
		
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("камила", 177));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кокошка", 179));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("коњ", 184));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("крава", 180));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("куче", 181));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лав", 185));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лисица", 183));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("мачка", 178));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("мечка", 176));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("овца", 188));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("слон", 182));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("свиња", 186));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("тигар", 190));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("верверичка", 189));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("волк", 191));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зајак", 187));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зебра", 192));
	}
	
	private static void fillNumbers() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("0", 44));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("1", 45));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("2", 46));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("3", 47));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("4", 48));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("5", 49));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("6", 50));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("7", 51));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("8", 52));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("9", 53));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("10", 54));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("11", 55));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("12", 56));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("13", 57));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("14", 58));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("15", 59));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("16", 60));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("17", 61));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("18", 62));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("19", 63));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("20", 64));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("21", 65));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("22", 66));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("23", 67));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("24", 68));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("25", 69));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("26", 70));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("27", 71));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("28", 72));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("29", 73));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("30", 74));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("31", 75));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("32", 76));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("33", 77));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("34", 78));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("35", 79));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("36", 80));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("37", 81));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("38", 82));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("39", 83));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("40", 84));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("41", 85));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("42", 86));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("43", 87));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("44", 88));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("45", 89));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("46", 90));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("47", 91));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("48", 92));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("49", 93));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("50", 94));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("51", 95));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("52", 96));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("53", 97));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("54", 98));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("55", 99));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("56", 100));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("57", 101));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("58", 102));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("59", 103));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("60", 104));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("61", 105));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("62", 106));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("63", 107));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("64", 108));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("65", 109));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("66", 110));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("67", 111));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("68", 112));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("69", 113));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("70", 114));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("71", 115));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("72", 116));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("73", 117));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("74", 118));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("75", 119));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("76", 120));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("77", 121));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("78", 122));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("79", 123));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("80", 124));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("81", 125));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("82", 126));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("83", 127));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("84", 128));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("85", 129));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("86", 130));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("87", 131));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("88", 132));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("89", 133));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("90", 134));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("91", 135));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("92", 136));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("93", 137));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("94", 138));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("95", 139));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("96", 140));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("97", 141));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("98", 142));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("99", 143));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("100", 144));
	}
	
	private static void fillLetters() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("А", 145));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Б", 146));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("В", 147));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Г", 148));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Д", 149));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ѓ", 150));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Е", 151));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ж", 152));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("З", 153));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ѕ", 154));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("И", 155));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ј", 156));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("К", 157));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Л", 158));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Љ", 159));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("М", 160));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Н", 161));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Њ", 162));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("О", 163));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("П", 164));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Р", 165));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("С", 166));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Т", 167));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ќ", 168));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("У", 169));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ф", 170));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Х", 171));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ц", 172));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ч", 173));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Џ", 174));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ш", 175));
	}
	
	private static void fillWeather() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("дува ветар", 193));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("врне дожд", 194));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("врне дожд и грми", 195));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("грми", 196));
		
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("дува ветар", 234));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("врне дожд", 235));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("врне дожд и грми", 236));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("грми", 237));
	}
	
	private static void fillClothesAndBodyParts() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("рака", 197));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("уши", 198));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лакт", 199));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("трепки", 200));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("лице", 201));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("стапало", 202));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("чело", 203));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("дланки", 204));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("глава", 205));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("уста", 206));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("заби", 207));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("зглоб", 208));
		
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("блуза", 221));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("чизми", 222));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("чорапи", 223));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("дуксерка", 224));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("џемпер", 225));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("фустан", 226));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("кошула", 227));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("маица", 228));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("патики", 229));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("ракавици", 230));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("тренерки", 231));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("вратоврска", 232));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("здолниште", 233));
	}
	
	private static void fillEmotions() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("изнервирано", 209));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("збунето", 210));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("задоволно", 211));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("возбудено", 212));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("исплашено", 213));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("среќно", 214));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("нервозно", 215));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("гордо", 216));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("тажно", 217));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("изненадено", 218));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("замислено", 219));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("изморено", 220));
	}
	
	private static void fillYear() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Понеделник", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Вторник", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Среда", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Четврток", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Петок", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Сабота", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Недела", 0));
		
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Јануари", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Февруари", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Март", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Април", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Мај", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Јуни", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Јули", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Август", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Септември", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Октомври", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Ноември", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Декември", 0));
		
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Пролет", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Лето", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Есен", 0));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Зима", 0));
	}
	
	private static void fillPrepositions() {
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Позади", 238));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Во", 239));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Пред", 240));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("До", 241));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Над", 242));
		resolver.insert(ItemContentProvider.CONTENT_URI, toItemContentValues("Под", 243));
	}
	
	private static ContentValues toItemContentValues(String itemName, int resourceID) {
		ContentValues cv = new ContentValues();
		cv.put(ItemOpenHelper.COLUMN_NAME, itemName);
		cv.put(ItemOpenHelper.COLUMN_RESOURCE, resourceID);
		return cv;
	}
	
	public static void fillItemTags() {
		fillFruitsAndVegetablesTags();
		fillAnimalsTags();
		fillNumbersTags();
		fillLettersTags();
		fillWeatherTags();
		fillClothesAndBodyPartsTags();
		fillEmotionsTags();
		fillYearTags();
		fillPrepositionsTags();
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
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("ананас", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("банана", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("брокула", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("грозје", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("диња", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("домат", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зелка", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("јаболко", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("јагода", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кајсија", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("киви", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("краставица", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кромид", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лимон", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лубеница", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("малина", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мандарина", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("морков", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("пиперка", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("портокал", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("праска", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("слива", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("смоква", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("цреша", "hangman"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("ананас", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("банана", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("брокула", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("грозје", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("диња", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("домат", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зелка", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("јаболко", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("јагода", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кајсија", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("киви", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("краставица", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кромид", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лимон", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лубеница", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("малина", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мандарина", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("морков", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("пиперка", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("портокал", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("праска", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("слива", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("смоква", "set"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("цреша", "set"));
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
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("камила", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кенгур", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кокошка", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("коњ", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("крава", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("куче", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лав", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лисица", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мачка", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мечка", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("овца", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("слон", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("свиња", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("тигар", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("верверичка", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("волк", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зајак", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зебра", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("жирафа", "hangman"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("камила", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кокошка", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("коњ", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("крава", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("куче", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лав", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лисица", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мачка", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("мечка", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("овца", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("слон", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("свиња", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("тигар", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("верверичка", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("волк", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зајак", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зебра", "sound"));
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
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("0", "notOddNotEven"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("1", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("2", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("3", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("4", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("5", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("6", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("7", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("8", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("9", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("10", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("11", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("12", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("13", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("14", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("15", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("16", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("17", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("18", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("19", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("20", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("21", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("22", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("23", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("24", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("25", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("26", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("27", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("28", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("29", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("30", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("31", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("32", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("33", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("34", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("35", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("36", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("37", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("38", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("39", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("40", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("41", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("42", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("43", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("44", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("45", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("46", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("47", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("48", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("49", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("50", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("51", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("52", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("53", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("54", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("55", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("56", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("57", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("58", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("59", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("60", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("61", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("62", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("63", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("64", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("65", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("66", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("67", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("68", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("69", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("70", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("71", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("72", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("73", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("74", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("75", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("76", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("77", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("78", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("79", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("80", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("81", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("82", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("83", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("84", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("85", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("86", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("87", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("88", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("89", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("90", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("91", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("92", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("93", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("94", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("95", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("96", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("97", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("98", "even"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("99", "odd"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("100", "even"));
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
	
	private static void fillWeatherTags() {
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("дува ветар", "weather"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("врне дожд", "weather"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("врне дожд и грми", "weather"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("грми", "weather"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("дува ветар", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("врне дожд", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("врне дожд и грми", "sound"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("грми", "sound"));
	}
	
	private static void fillClothesAndBodyPartsTags() {
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("рака", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("уши", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лакт", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("трепки", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лице", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("стапало", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("чело", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("дланки", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("глава", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("уста", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("заби", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зглоб", "clothesAndBodyParts"));
	
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("рака", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("уши", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лакт", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("трепки", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лице", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("стапало", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("чело", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("дланки", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("глава", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("уста", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("заби", "bodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зглоб", "bodyParts"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("рака", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("уши", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лакт", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("трепки", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("лице", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("стапало", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("чело", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("дланки", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("глава", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("уста", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("заби", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("зглоб", "hangman"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("блуза", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("чизми", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("чорапи", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("дуксерка", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("џемпер", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("фустан", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кошула", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("маица", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("патики", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("ракавици", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("тренерки", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("вратоврска", "clothesAndBodyParts"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("здолниште", "clothesAndBodyParts"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("блуза", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("чизми", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("чорапи", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("дуксерка", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("џемпер", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("фустан", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кошула", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("маица", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("патики", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("ракавици", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("тренерки", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("вратоврска", "clothes"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("здолниште", "clothes"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("блуза", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("чизми", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("чорапи", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("дуксерка", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("џемпер", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("фустан", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("кошула", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("маица", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("патики", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("ракавици", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("тренерки", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("вратоврска", "hangman"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("здолниште", "hangman"));
	}
	
	private static void fillEmotionsTags() {
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("изнервирано", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("збунето", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("задоволно", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("возбудено", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("исплашено", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("среќно", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("нервозно", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("гордо", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("тажно", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("изненадено", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("замислено", "emotions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("изморено", "emotions"));
	}
	
	private static void fillYearTags() {
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Понеделник", "day"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Вторник", "day"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Среда", "day"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Четврток", "day"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Петок", "day"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Сабота", "day"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Недела", "day"));
		
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Јануари", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Февруари", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Март", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Април", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Мај", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Јуни", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Јули", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Август", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Септември", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Октомври", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Ноември", "month"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Декември", "month"));

		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Пролет", "season"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Лето", "season"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Есен", "season"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Зима", "season"));
	}
	
	private static void fillPrepositionsTags() {
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Позади", "prepositions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Во", "prepositions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Пред", "prepositions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("До", "prepositions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Над", "prepositions"));
		resolver.insert(ItemTagsContentProvider.CONTENT_URI, toItemTagsContentValues("Под", "prepositions"));
	}
	
	private static ContentValues toItemTagsContentValues(String itemName, String tag) {
		ContentValues cv = new ContentValues();
		cv.put(ItemTagsOpenHelper.COLUMN_NAME, itemName);
		cv.put(ItemTagsOpenHelper.COLUMN_TAG, tag);
		return cv;
	}
	
	public static void fillGames() {
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Letters", "ChooseStringFromSound", "letters_chooseLetter"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Letters", "HangmanEasy", "letters_fillLetters"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Letters", "Hangman", "letters_orderWord"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Letters", "HangmanStandard", "letters_hangman"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Letters", "OrderElements", "letters_orderLetters"));
			
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ChooseItem", "shapes_choosePicture"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ChooseItem", "shapes_chooseWord"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ChooseSimilarItem", "shapes_similarity"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ChooseSimilarItem", "shapes_looksLike"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ClassifyItems", "shapes_classifyWords"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Shapes", "ClassifyItems", "shapes_classifyPictures"));
			
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseStringFromSound", "numbers_chooseNumber"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "HowMany", "numbers_countObjects"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseSignBetweenNumbers", "numbers_findSign"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseSignBetweenSets", "numbers_sets"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "AdditionAndSubtractionNumbers", "numbers_addNumbers"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "AdditionAndSubtractionSets", "numbers_addSets"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "AdditionAndSubtractionNumbers", "numbers_substractNumbers"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "AdditionAndSubtractionSets", "numbers_substractSets"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseItem", "numbers_choosePicture"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseItem", "numbers_chooseWord"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "OrderElements", "numbers_orderNumbers"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ClassifyItems", "numbers_classify"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseOperatorBetweenNumbers", "numbers_chooseOperator"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Numbers", "ChooseOperatorBetweenSets", "numbers_chooseOperatorSets"));
			
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ChooseItem", "animals_chooseAnimal"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ChooseItem", "animals_choosePicture"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ConnectItemAndResurs", "animals_connectAnimals"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ClassifyItems", "animals_groupWords"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ClassifyItems", "animals_groupPictures"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Animals", "ChooseItem", "animals_chooseWord"));
			
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ChooseItem", "fruitsandvegetables_choosePicture"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ChooseItem", "fruitsandvegetables_chooseWord"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ConnectItemAndResurs", "fruitsandvegetables_connectPictures"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ClassifyItems", "fruitsandvegetables_groupWords"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("FruitsAndVegetables", "ClassifyItems", "fruitsandvegetables_groupPictures"));
			
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Weather", "ChooseItem", "weather_choosePicture"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Weather", "ChooseItem", "weather_chooseWord"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Weather", "ChooseItem", "weather_outsideWeather"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Weather", "ConnectItemAndResurs", "weather_connectPictures"));
			
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Year", "Question", "year_questions"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Year", "OrderElements", "year_orderDays"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Year", "OrderElements", "year_orderMonths"));
		resolver.insert(GameContentProvider.CONTENT_URI, toGameContentValues("Year", "ClassifyItems", "year_groupWords"));
			
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
	
	private static ContentValues toGameContentValues(String categoryType, String gameType, String gameName) {
		ContentValues cv = new ContentValues();
		cv.put(GameOpenHelper.COLUMN_CATTYPE, categoryType);
		cv.put(GameOpenHelper.COLUMN_GAMETYPE, gameType);
		cv.put(GameOpenHelper.COLUMN_GAMENAME, gameName);
		return cv;
	}
	
	public static void fillWholeDatabase() {
		fillCategories();
		fillResources();
		fillItems();
		fillItemTags();
		fillGames();
	}
}
