package weareallthesame.model.games.orderelementsgame;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface OrderElementsInterface {

	public void setOnPosition(String element, int position) throws CommandException, GameOverException;
}
