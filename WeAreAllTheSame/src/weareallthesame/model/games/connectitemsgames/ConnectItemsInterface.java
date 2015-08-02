package weareallthesame.model.games.connectitemsgames;

import java.io.Serializable;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface ConnectItemsInterface extends Serializable {

	public void addConnection(int positionOne, int positionTwo) throws GameOverException, CommandException;
	
	public void removeConnection(int positionOne, int positionTwo) throws GameOverException, CommandException;
}
