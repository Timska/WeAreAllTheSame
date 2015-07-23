package weareallthesame.model.commands;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.interfaces.ChooseItemInterface;
import weareallthesame.model.items.Item;

public class ChooseItemCommand extends AbstractCommand{

	private ChooseItemInterface game;
	private Item item;
	
	public ChooseItemCommand(ChooseItemInterface game, Item item) {
		this.game = game;
		this.item = item;
	}

	@Override
	public String getType() {
		return "ChooseItem";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.chooseAnswer(item);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		
	}

}
