package weareallthesame.model;

import java.util.ArrayList;
import java.util.List;

import weareallthesame.view.R;


public class MainInitialization {

	public static final int NumeberOfCategories = 15;
	
	private static String[] names = {"Букви", "Бројки", "Форми", "Животни", 
		"Овошје и зеленчук", "Временски услови", "Годишни времиња", "Денови и месеци",
		"Ден", "Бои и предмети", "Предлози", "Хигиена", "Делови од тело", "Облека", "Емоции"};
	
	private static Integer[] mThumbIds = { 
			R.drawable.letters, R.drawable.numbers,
			R.drawable.forms, R.drawable.animals,
			R.drawable.fruit_vegetables, R.drawable.weather,
			R.drawable.seasons, R.drawable.months_days, 
			R.drawable.day_details, R.drawable.colors_objects, 
			R.drawable.prepositions, R.drawable.hygiene, 
			R.drawable.body_parts, R.drawable.emotions, 
			R.drawable.clothes };
	
	public static List<Category> initializeCategories(){
		List<Category> list = new ArrayList<Category>();
		for(int i=0; i<NumeberOfCategories; ++i){
			Category c = new Category(names[i], mThumbIds[i]);
			list.add(c);
		}
		
		return list;
	}
}
