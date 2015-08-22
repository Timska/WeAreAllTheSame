package weareallthesame.model.games.chooseoperatorgames;

import java.util.Iterator;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.chooseoperatorgames.ChooseOperatorBetweenSetsViewInterface;

public class ChooseOperatorBetweenSetsGame extends ChooseOperatorBetweenNumbersGame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7987115548458834247L;

	private Item item;
	
	public ChooseOperatorBetweenSetsGame(Iterator<String> tags, Object view,
			String question) throws InvalidViewTypeException {
		super(tags, view, question);
		setItem();
	}
	
	private void setItem() throws InvalidViewTypeException{
		item = ItemFactory.getItem(this.getTags(), 1).next();
		ChooseOperatorBetweenSetsViewInterface view;
		if(this.getView() instanceof ChooseOperatorBetweenSetsViewInterface){
			view = (ChooseOperatorBetweenSetsViewInterface) this.getView();
			view.setItem(item);
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
	}

	@Override
	public String getType() {
		return "ChooseOperatorBetweenSets";
	}
}
