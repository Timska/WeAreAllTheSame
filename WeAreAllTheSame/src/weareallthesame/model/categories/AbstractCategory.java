package weareallthesame.model.categories;

import java.util.Iterator;

import weareallthesame.factories.GameFactory;
import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.games.Game;

public abstract class AbstractCategory implements CategoryInterface{

	private static final long serialVersionUID = 5539055391491450343L;

	private String name;
	private String resourceName;
	
	public AbstractCategory(String name, String resourceName) {
		super();
		this.name = name;
		this.resourceName = resourceName;
	}

	public String getName() {
		return name;
	}

	public String getResourceName() {
		return resourceName;
	}

	@Override
	public Game getGame(String type, Iterator<String> tags, Object view,
			String question) throws GameDoesNotExistException,
			InvalidViewTypeException, MissingTagException {

		return GameFactory.getGame(type, tags, view, question);
	}

	@Override
	public Iterator<String> getTypes() {
		return GameFactory.getGameTypesForCategory(getType());
	}
}
