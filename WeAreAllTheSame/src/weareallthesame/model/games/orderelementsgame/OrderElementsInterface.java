package weareallthesame.model.games.orderelementsgame;

import java.io.Serializable;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface OrderElementsInterface extends Serializable {

	public void setOnPosition(String element, int position) throws CommandException, GameOverException;
	
	public void removeFromPosition(int position, String element) throws GameOverException, CommandException;
	
	public void changeElementPosition(int from, int to) throws GameOverException, CommandException;
}
