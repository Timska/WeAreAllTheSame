package weareallthesame.model.categories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.games.Game;
import weareallthesame.model.games.additionandsubtractiongames.AdditionAndSubtractionNumbersGame;
import weareallthesame.model.games.additionandsubtractiongames.AdditionAndSubtractionSetsGame;
import weareallthesame.model.games.choosecharacterfromsoundgame.ChooseStringFromSoundGame;
import weareallthesame.model.games.chooseitemgame.ChooseItemGame;
import weareallthesame.model.games.choosesigngames.ChooseSignBetweenNumbersGame;
import weareallthesame.model.games.choosesigngames.ChooseSignBetweenSetsGame;
import weareallthesame.model.games.howmanygame.HowManyGame;
import weareallthesame.model.games.orderelementsgame.OrderElementsGame;

public class CategoryNumbers extends AbstractCategory {

	private static final long serialVersionUID = -8977897324894763392L;

	public CategoryNumbers(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public Game getGame(String type, Iterator<String> tags, Object view,
			String question) throws GameDoesNotExistException,
			InvalidViewTypeException, MissingTagException {
		if(type.equalsIgnoreCase("ChooseStringFromSound")){
			return new ChooseStringFromSoundGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("HowMany")){
			return new HowManyGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("ChooseSignBetweenNumbers")){
			return new ChooseSignBetweenNumbersGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("ChooseSignBetweenSets")){
			return new ChooseSignBetweenSetsGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("AdditionAndSubtractionNumbers")){
			return new AdditionAndSubtractionNumbersGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("AdditionAndSubtractionSets")){
			return new AdditionAndSubtractionSetsGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("ChooseItem")){
			return new ChooseItemGame(tags, view, question);
		}
		if(type.equalsIgnoreCase("OrderElements")){
			return new OrderElementsGame(tags, view, question);
		}
		
		throw new GameDoesNotExistException("Igrata sto ja barate ne postoi");
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> types = new ArrayList<String>();
		types.add("ChooseStringFromSound");
		types.add("HowMany");
		types.add("ChooseSignBetweenNumbers");
		types.add("ChooseSignBetweenSets");
		types.add("AdditionAndSubtractionNumbers");
		types.add("AdditionAndSubtractionSets");
		types.add("ChooseItem");
		types.add("OrderElements");
		return types.iterator();
	}

	@Override
	public String getType() {
		return "Numbers";
	}

}
