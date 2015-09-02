package weareallthesame.model.games.connectitemsgames;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.WrongAnswerException;

public class AddConnectionCommand extends AbstractCommand {

	private static final long serialVersionUID = -460778132414107878L;

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
	public void executeNow() throws GameOverException, CommandException, WrongAnswerException {
		game.addConnection(positionOne, positionTwo);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		game.removeConnection(positionOne, positionTwo);
	}

}
