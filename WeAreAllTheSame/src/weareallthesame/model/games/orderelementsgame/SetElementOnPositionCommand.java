package weareallthesame.model.games.orderelementsgame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class SetElementOnPositionCommand extends AbstractCommand {

	private OrderElementsInterface game;
	private int position;
	private String element;
	
	public SetElementOnPositionCommand(OrderElementsInterface game, int position, String element) {
		this.game = game;
		this.position = position;
		this.element = element;
	}
	
	@Override
	public String getType() {
		return "SetElementOnPosition";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.setOnPosition(element, position);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		game.removeFromPosition(position, element);
	}

}
