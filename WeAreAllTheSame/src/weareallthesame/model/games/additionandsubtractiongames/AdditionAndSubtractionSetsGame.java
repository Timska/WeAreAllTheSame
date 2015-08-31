package weareallthesame.model.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.additionandsubtractiongames.AdditionAndSubtractionSetsViewInterface;

public class AdditionAndSubtractionSetsGame extends AdditionAndSubtractionNumbersGame{

	private static final long serialVersionUID = -4841658647601075370L;
	private Item item;
	
	public AdditionAndSubtractionSetsGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException,MissingTagException {
		super(tags, view, question);
		setItem();
	}
	
	private void setItem() throws InvalidViewTypeException{
		Iterator<String> tags = this.getTags();
		tags.next();
		List<String> itemTags = new ArrayList<String>();
		itemTags.add(tags.next());
		item = ItemFactory.getItem(itemTags.iterator(), 1).next();
		AdditionAndSubtractionSetsViewInterface view;
		if(this.getView() instanceof AdditionAndSubtractionSetsViewInterface){
			view = (AdditionAndSubtractionSetsViewInterface) this.getView();
			view.setItem(item);
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
	}

	@Override
	public String getType() {
		return "AdditionAndSubtractionSets";
	}
}
