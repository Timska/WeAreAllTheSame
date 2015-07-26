package weareallthesame.factories;

import java.util.Iterator;

import weareallthesame.model.Question;
import android.content.Context;

public class QuestionFactory {

	private static Context ctx;
	
	public static void setContext(Context context) {
		ctx = context;
	}
	
	/**
	 * Ovoj metod se koristi za povlekuvanje na prasanja od baza.
	 * 
	 * @param tags
	 *            tagovite so koi ke treba da se tagirani prasanjata za da bidat
	 *            povleceni od baza.
	 * @param numberOfItems
	 *            kolku prasanja da bidat povleceni.
	 * @return
	 */
	public static Iterator<Question> getQuestion(Iterator<String> tags, int numberOfItems){
		return null;
	}

}
