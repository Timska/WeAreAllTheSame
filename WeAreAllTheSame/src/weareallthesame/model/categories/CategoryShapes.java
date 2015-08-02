package weareallthesame.model.categories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.Game;
import weareallthesame.model.games.chooseitemgame.ChooseItemGame;
import weareallthesame.model.games.chooseitemgame.ChooseSimilarItemGame;

public class CategoryShapes extends AbstractCategory{

	private static final long serialVersionUID = 6110816817295728504L;

	public CategoryShapes(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public Game getGame(String type, Iterator<String> tags, Object view,
			String question) throws GameDoesNotExistException,
			InvalidViewTypeException {
		if(type.equalsIgnoreCase("chooseitem")){
			return new ChooseItemGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("choosesimilaritem")){
			return new ChooseSimilarItemGame(tags, view, question);
		}
		
		
		throw new GameDoesNotExistException("Igrata sto ja barate ne postoi");
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> types = new ArrayList<String>();
		types.add("ChooseItem");
		types.add("ChooseSimilarItem");
		return types.iterator();
	}

	@Override
	public String getType() {
		return "Shapes";
	}

}
