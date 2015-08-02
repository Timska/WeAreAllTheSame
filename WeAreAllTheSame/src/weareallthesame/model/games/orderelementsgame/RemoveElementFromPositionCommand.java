package weareallthesame.model.games.orderelementsgame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class RemoveElementFromPositionCommand extends AbstractCommand {

	private static final long serialVersionUID = 7339346597700119255L;

	private OrderElementsInterface game;
	private int position;
	private String element;
	
	public RemoveElementFromPositionCommand(OrderElementsInterface game, int position, String element) {
		this.game = game;
		this.position = position;
		this.element = element;
	}
	
	@Override
	public String getType() {
		return "RemoveElementFromPosition";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.removeFromPosition(position, element);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		game.setOnPosition(element, position);
	}

}
