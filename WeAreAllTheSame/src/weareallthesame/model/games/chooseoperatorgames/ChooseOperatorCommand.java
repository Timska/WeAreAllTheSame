package weareallthesame.model.games.chooseoperatorgames;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class ChooseOperatorCommand extends AbstractCommand{

	private static final long serialVersionUID = 2886814732252564002L;

	private ChooseOperatorInterface game;
	private Character operator;
	
	public ChooseOperatorCommand(ChooseOperatorInterface game, Character operator) {
		this.game = game;
		this.operator = operator;
	}

	@Override
	public String getType() {
		return "ChooseOperator";
	}

	@Override
	public void executeNow() throws GameOverException {
		game.chooseOperator(operator);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		
	}

}
