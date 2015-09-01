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

	private static ContentResolver resolver;

	public static void setContext(Context context) {
		resolver = context.getContentResolver();
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
				QuestionTagsOpenHelper.COLUMN_TAG + "=" + "'" + tags.next()
						+ "'", null, null);

		Set<Integer> questionsSet = getQuestionsFromCursor(cursor);
		cursor.close();

		while (tags.hasNext()) {
			cursor = resolver.query(QuestionTagsContentProvider.CONTENT_URI,
					new String[] { QuestionTagsOpenHelper.COLUMN_QUESTION },
					QuestionTagsOpenHelper.COLUMN_TAG + "=" + "'" + tags.next()
							+ "'", null, null);

			questionsSet.retainAll(getQuestionsFromCursor(cursor));
			cursor.close();
		}

		List<Integer> questions = new ArrayList<Integer>(questionsSet);
		Collections.shuffle(questions);

		int size = questions.size();
		for (int i = size - 1; i >= 0; i--) {
			if (questions.size() <= numberOfItems) {
				break;
			}
			questions.remove(i);
		}

		List<Question> result = new ArrayList<Question>();
		for (Integer q : questions) {
			cursor = resolver.query(QuestionContentProvider.CONTENT_URI,
					new String[] { QuestionOpenHelper.COLUMN_QUESTION,
							QuestionOpenHelper.COLUMN_ANSWER },
					QuestionOpenHelper.COLUMN_ID + "=" + q, null, null);

			cursor.moveToFirst();
			String question = cursor.getString(cursor
					.getColumnIndex(QuestionOpenHelper.COLUMN_QUESTION));
			String answer = cursor.getString(cursor
					.getColumnIndex(QuestionOpenHelper.COLUMN_ANSWER));
			result.add(new Question(question, answer));
			cursor.close();
		}

		return result.iterator();
	}

	public static Set<Integer> getQuestionsFromCursor(Cursor cursor) {
		Set<Integer> result = new HashSet<Integer>();
		while (cursor.moveToNext()) {
			Integer itemName = cursor.getInt(cursor
					.getColumnIndex(QuestionTagsOpenHelper.COLUMN_QUESTION));
			result.add(itemName);
		}
		return result;
	}

}
