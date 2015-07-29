package weareallthesame.model.games.connectitemsgames;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class AddConnectionCommand extends AbstractCommand {

	private ConnectItemsInterface game;
	private int positionOne;
	private int positionTwo;
	
	public AddConnectionCommand(ConnectItemsInterface game, int positionOne, int positionTwo) {
		this.game = game;
		this.positionOne = positionOne;
		this.positionTwo = positionTwo;
	}
	@Override
	public String getType() {
		return "AddConnection";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.addConnection(positionOne, positionTwo);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		game.removeConnection(positionOne, positionTwo);
	}

}
