package weareallthesame.model.categories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.Game;
import weareallthesame.model.games.hangmangame.HangmanGame;

public class LettersCategory implements CategoryInterface{

	private String name;

	public LettersCategory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> types = new ArrayList<String>();
		types.add("Hangman");
		
		// TODO treba da se dodadat i ostanatite tipovi na igri vo ovaa kategorija
		
		return types.iterator();
	}

	@Override
	public String getType() {
		return "Letters";
	}

	@Override
	public Game getGame(String type, Iterator<String> tags, Object view) throws GameDoesNotExistException, InvalidViewTypeException {
		// TODO Treba da se dodadat i drugite igri
		if(type.equalsIgnoreCase("hangman")){
			return new HangmanGame(tags, view);
		}
		
		throw new GameDoesNotExistException("Igrata sto ja barate ne postoi");
		
	}

	

}