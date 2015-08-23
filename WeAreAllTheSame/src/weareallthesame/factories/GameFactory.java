package weareallthesame.factories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import weareallthesame.db.GameContentProvider;
import weareallthesame.db.GameOpenHelper;
import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.games.Game;
import weareallthesame.model.games.additionandsubtractiongames.AdditionAndSubtractionNumbersGame;
import weareallthesame.model.games.additionandsubtractiongames.AdditionAndSubtractionSetsGame;
import weareallthesame.model.games.choosecharacterfromsoundgame.ChooseStringFromSoundGame;
import weareallthesame.model.games.chooseitemgame.ChooseItemGame;
import weareallthesame.model.games.chooseitemgame.ChooseSimilarItemGame;
import weareallthesame.model.games.choosesigngames.ChooseSignBetweenNumbersGame;
import weareallthesame.model.games.choosesigngames.ChooseSignBetweenSetsGame;
import weareallthesame.model.games.connectitemsgames.ConnectItemAndResursGame;
import weareallthesame.model.games.connectitemsgames.ConnectItemsGame;
import weareallthesame.model.games.hangmangame.HangmanEasyGame;
import weareallthesame.model.games.hangmangame.HangmanGame;
import weareallthesame.model.games.howmanygame.HowManyGame;
import weareallthesame.model.games.orderelementsgame.OrderElementsGame;
import weareallthesame.model.games.questiongame.QuestionGame;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;

public class GameFactory {

	private static ContentResolver resolver;

	public static void setContext(Context context) {
		resolver = context.getContentResolver();
	}

	public static Iterator<String> getGameNamesForCategory(String categoryType) {
		// Da se dobijat site razlicni iminja na igrite vo taa kategorija
		Cursor cursor = resolver.query(GameContentProvider.CONTENT_URI,
				new String[] { GameOpenHelper.COLUMN_GAMENAME },
				GameOpenHelper.COLUMN_CATTYPE + "=" + "'" + categoryType + "'",
				null, null);

		List<String> result = new ArrayList<String>();
		while (cursor.moveToNext()) {
			String gameName = cursor.getString(cursor
					.getColumnIndex(GameOpenHelper.COLUMN_GAMENAME));
			result.add(gameName);
		}
		cursor.close();
		return result.iterator();
	}

	public static Iterator<String> getGameTypesForCategory(String categoryType) {
		// Da se dobijat site tipovi na igri za dadenata kategorija
		Cursor cursor = resolver.query(GameContentProvider.CONTENT_URI,
				new String[] { GameOpenHelper.COLUMN_GAMETYPE },
				GameOpenHelper.COLUMN_CATTYPE + "=" + "'" + categoryType + "'",
				null, null);

		Set<String> result = new HashSet<String>();
		while (cursor.moveToNext()) {
			String gameType = cursor.getString(cursor
					.getColumnIndex(GameOpenHelper.COLUMN_GAMETYPE));
			result.add(gameType);
		}
		cursor.close();
		return result.iterator();
	}

	public static String getGameType(String gameName, String categoryType) {
		// Za dadeno ime na igra i kategorija da se vrati tipot na igrata
		Cursor cursor = resolver.query(GameContentProvider.CONTENT_URI,
				new String[] { GameOpenHelper.COLUMN_GAMETYPE },
				GameOpenHelper.COLUMN_CATTYPE + "=" + "'" + categoryType + "'"
						+ " and " + GameOpenHelper.COLUMN_GAMENAME + "=" + "'"
						+ gameName + "'", null, null);

		String result = cursor.getString(cursor
				.getColumnIndex(GameOpenHelper.COLUMN_GAMETYPE));
		cursor.close();
		return result;
	}

	public static Game getGame(String type, Iterator<String> tags, Object view,
			String question) throws InvalidViewTypeException,
			MissingTagException, GameDoesNotExistException {
		if (type.equalsIgnoreCase("Hangman")) {
			return new HangmanGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("HangmanEasy")) {
			return new HangmanEasyGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("ChooseSimilarItem")) {
			return new ChooseSimilarItemGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("ChooseItem")) {
			return new ChooseItemGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("ConnectItemAndResurs")) {
			return new ConnectItemAndResursGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("ConnectItems")) {
			return new ConnectItemsGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("ChooseStringFromSound")) {
			return new ChooseStringFromSoundGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("HowMany")) {
			return new HowManyGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("ChooseSignBetweenNumbers")) {
			return new ChooseSignBetweenNumbersGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("ChooseSignBetweenSets")) {
			return new ChooseSignBetweenSetsGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("AdditionAndSubtractionNumbers")) {
			return new AdditionAndSubtractionNumbersGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("AdditionAndSubtractionSets")) {
			return new AdditionAndSubtractionSetsGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("OrderElements")) {
			return new OrderElementsGame(tags, view, question);
		}
		if (type.equalsIgnoreCase("Question")) {
			return new QuestionGame(tags, view, question);
		}

		throw new GameDoesNotExistException("Igrata sto ja barate ne postoi");
	}
}
