package weareallthesame.model.games.classifyitemsgame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.ObjectDoesNotBelongInSetException;
import weareallthesame.model.items.Item;

public class ClassifyItemCommand extends AbstractCommand {

	/**
	 * 
	 */
	private static final long serialVersionUID = -625564078237181855L;
	
	private ClassifyItemsInterface game;
	private Item item;
	private String category;
	
	public ClassifyItemCommand(ClassifyItemsInterface game, Item item, String category) {
		this.game = game;
		this.item = item;
		this.category = category;
	}
	
	@Override
	public String getType() {
		return "ClassifyItem";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException, ObjectDoesNotBelongInSetException {
		game.classifyItem(item, category);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		
	}

}
