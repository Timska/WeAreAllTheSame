package weareallthesame.model.categories;

import java.util.Iterator;

import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.Game;

public class ShapeCategory extends AbstractCategory{

	public ShapeCategory(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public Game getGame(String type, Iterator<String> tags, Object view,
			String question) throws GameDoesNotExistException,
			InvalidViewTypeException {
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
		// TODO Auto-generated method stub
		return null;
	}

}
