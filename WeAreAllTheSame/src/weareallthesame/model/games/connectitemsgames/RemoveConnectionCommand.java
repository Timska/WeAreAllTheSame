package weareallthesame.model.games.connectitemsgames;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class RemoveConnectionCommand extends AbstractCommand {

	private static final long serialVersionUID = 8800967773626149312L;

	private ConnectItemsInterface game;
	private int positionOne;
	private int positionTwo;
	
	public RemoveConnectionCommand(ConnectItemsInterface game, int positionOne, int positionTwo) {
		this.game = game;
		this.positionOne = positionOne;
		this.positionTwo = positionTwo;
	}
	@Override
	public String getType() {
		return "RemoveConnection";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.removeConnection(positionOne, positionTwo);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		game.addConnection(positionOne, positionTwo);
	}
}
