package weareallthesame.model.categories;

import java.util.Iterator;

import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.games.Game;

public class CategoryDay extends AbstractCategory {

	public CategoryDay(String name, String resourceName) {
		super(name, resourceName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Game getGame(String type, Iterator<String> tags, Object view,
			String question) throws GameDoesNotExistException,
			InvalidViewTypeException, MissingTagException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<String> getTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		return "Day";
	}

}
