package weareallthesame.model.games.orderelementsgame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class ChangeElementPositionCommand extends AbstractCommand {

	private OrderElementsInterface game;
	private int from;
	private int to;
	
	public ChangeElementPositionCommand(OrderElementsInterface game, int from, int to) {
		this.game = game;
		this.from = from;
		this.to = to;
	}

	@Override
	public String getType() {
		return "ChangeElementPosition";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.changeElementPosition(from, to);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		game.changeElementPosition(to, from);
	}
	
}
