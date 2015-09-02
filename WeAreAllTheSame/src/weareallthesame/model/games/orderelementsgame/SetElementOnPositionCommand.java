package weareallthesame.model.games.orderelementsgame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.WrongAnswerException;

public class SetElementOnPositionCommand extends AbstractCommand {

	private static final long serialVersionUID = 6964522172665804055L;

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
	public void executeNow() throws GameOverException, CommandException, WrongAnswerException {
		game.setOnPosition(element, position);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		game.removeFromPosition(position, element);
	}

}
