package weareallthesame.model.categories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.games.Game;
import weareallthesame.model.games.choosecharacterfromsoundgame.ChooseStringFromSoundGame;
import weareallthesame.model.games.hangmangame.HangmanEasyGame;
import weareallthesame.model.games.hangmangame.HangmanGame;

public class LettersCategory extends AbstractCategory{

	public LettersCategory(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> types = new ArrayList<String>();
		types.add("Hangman");
		types.add("HangmanEasy");
		types.add("ChooseStringFromSound");
		return types.iterator();
	}

	@Override
	public String getType() {
		return "Letters";
	}

	@Override
	public Game getGame(String type, Iterator<String> tags, Object view, String question) throws GameDoesNotExistException, InvalidViewTypeException, MissingTagException {
		if(type.equalsIgnoreCase("hangman")){
			return new HangmanGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("hangmaneasy")){
			return new HangmanEasyGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("choosestringfromsound")){
			return new ChooseStringFromSoundGame(tags, view, question);
		}
		
		throw new GameDoesNotExistException("Igrata sto ja barate ne postoi");
		
	}

	

}
