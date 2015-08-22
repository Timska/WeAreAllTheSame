package weareallthesame.model.games.classifyitemsgame;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.items.Item;

public interface ClassifyItemsInterface {

	public void classifyItem(Item item, String category) throws GameOverException, CommandException;
}
