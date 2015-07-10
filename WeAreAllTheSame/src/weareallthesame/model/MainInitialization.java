package weareallthesame.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import weareallthesame.view.R;

public class MainInitialization {

	public static final int NumeberOfCategories = 15;

	private static Integer[] stringIds = { R.string.letters, R.string.numbers,
			R.string.forms, R.string.animals, R.string.fruit_vegetables,
			R.string.weather, R.string.seasons, R.string.months_days,
			R.string.day_details, R.string.colors_objects,
			R.string.prepositions, R.string.hygiene, R.string.body_parts,
			R.string.emotions, R.string.clothes };

	private static Integer[] mThumbIds = { R.drawable.letters,
			R.drawable.numbers, R.drawable.forms, R.drawable.animals,
			R.drawable.fruit_vegetables, R.drawable.weather,
			R.drawable.seasons, R.drawable.months_days, R.drawable.day_details,
			R.drawable.colors_objects, R.drawable.prepositions,
			R.drawable.hygiene, R.drawable.body_parts, R.drawable.emotions,
			R.drawable.clothes };

	public static List<Category> initializeCategories(Context ctx) {
		List<Category> list = new ArrayList<Category>();
		for (int i = 0; i < NumeberOfCategories; ++i) {
			Category c = new Category(ctx.getString(stringIds[i]), mThumbIds[i]);
			list.add(c);
		}

		return list;
	}
}
