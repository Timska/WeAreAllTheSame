package weareallthesame.factories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import weareallthesame.db.QuestionContentProvider;
import weareallthesame.db.QuestionOpenHelper;
import weareallthesame.db.QuestionTagsContentProvider;
import weareallthesame.db.QuestionTagsOpenHelper;
import weareallthesame.model.Question;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;

public class QuestionFactory {

	private static Context ctx;
	private static ContentResolver resolver;

	public static void setContext(Context context) {
		ctx = context;
		resolver = ctx.getContentResolver();
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
	public static Iterator<Question> getQuestion(Iterator<String> tags,
			int numberOfItems) {
		Cursor cursor = resolver.query(QuestionTagsContentProvider.CONTENT_URI,
				new String[] { QuestionTagsOpenHelper.COLUMN_QUESTION },
				QuestionTagsOpenHelper.COLUMN_TAG + "=" + tags.next(), null,
				null);

		Set<String> questionsSet = getQuestionsFromCursor(cursor);

		while (tags.hasNext()) {
			cursor = resolver.query(QuestionTagsContentProvider.CONTENT_URI,
					new String[] { QuestionTagsOpenHelper.COLUMN_QUESTION },
					QuestionTagsOpenHelper.COLUMN_TAG + "=" + tags.next(),
					null, null);

			questionsSet.retainAll(getQuestionsFromCursor(cursor));
		}

		List<String> questions = new ArrayList<String>(questionsSet);
		Collections.shuffle(questions);

		int size = questions.size();
		for (int i = size; i >= 0; i--) {
			if (questions.size() <= numberOfItems) {
				break;
			}
			questions.remove(i);
		}

		List<Question> result = new ArrayList<Question>();
		for (String str : questions) {
			cursor = resolver.query(QuestionContentProvider.CONTENT_URI,
					new String[] { QuestionOpenHelper.COLUMN_ANSWER },
					QuestionOpenHelper.COLUMN_QUESTION + "=" + str, null, null);

			cursor.moveToFirst();
			String answer = cursor.getString(cursor
					.getColumnIndex(QuestionOpenHelper.COLUMN_ANSWER));
			result.add(new Question(str, answer));
		}

		return result.iterator();
	}

	public static Set<String> getQuestionsFromCursor(Cursor cursor) {
		Set<String> result = new HashSet<String>();
		while (cursor.moveToNext()) {
			String itemName = cursor.getString(cursor
					.getColumnIndex(QuestionTagsOpenHelper.COLUMN_QUESTION));
			result.add(itemName);
		}
		return result;
	}

}
