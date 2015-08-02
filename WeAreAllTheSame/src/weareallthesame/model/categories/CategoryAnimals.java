package weareallthesame.model.categories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.games.Game;
import weareallthesame.model.games.chooseitemgame.ChooseItemGame;
import weareallthesame.model.games.connectitemsgames.ConnectItemAndResursGame;

public class CategoryAnimals extends AbstractCategory {

	private static final long serialVersionUID = -8026836090450261866L;

	public CategoryAnimals(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public Game getGame(String type, Iterator<String> tags, Object view,
			String question) throws GameDoesNotExistException,
			InvalidViewTypeException, MissingTagException {
		if(type.equalsIgnoreCase("ChooseItem")){
			return new ChooseItemGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("ConnectItemAndResurs")){
			return new ConnectItemAndResursGame(tags, view, question);
		}
		
		throw new GameDoesNotExistException("Igrata sto ja barate ne postoi");
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> types = new ArrayList<String>();
		types.add("ConnectItemAndResurs");
		types.add("ChooseItem");
		return types.iterator();
	}

	@Override
	public String getType() {
		return "Animals";
	}

}
