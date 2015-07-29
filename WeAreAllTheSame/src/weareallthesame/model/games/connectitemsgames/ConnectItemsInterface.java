package weareallthesame.model.games.connectitemsgames;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface ConnectItemsInterface {

	public void addConnection(int positionOne, int positionTwo) throws GameOverException, CommandException;
	
	public void removeConnection(int positionOne, int positionTwo) throws GameOverException, CommandException;
}
