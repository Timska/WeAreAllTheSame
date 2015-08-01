package weareallthesame.model.games.choosesigngames;

import java.util.Iterator;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.choosesigngames.ChooseSignBetweenSetsViewInterface;

public class ChooseSignBetweenSetsGame extends ChooseSignBetweenNumbersGame{

	private Item itemOne;
	private Item itemTwo;
	
	public ChooseSignBetweenSetsGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, view, question);
		setItems();
	}

	private void setItems() throws InvalidViewTypeException{
		Iterator<Item> it = ItemFactory.getItem(this.getTags(), 2);
		itemOne = it.next();
		itemTwo = it.next();
		ChooseSignBetweenSetsViewInterface view;
		if(this.getView() instanceof ChooseSignBetweenSetsViewInterface){
			view = (ChooseSignBetweenSetsViewInterface) this.getView();
			view.setItems(itemOne, itemTwo);
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
	}
	
	@Override
	public String getType(){
		return "ChooseSignBetweenSets";
	}
}
