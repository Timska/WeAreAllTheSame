package weareallthesame.model.commands;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.interfaces.ChooseNumberInterface;

public class ChooseNumberCommand extends AbstractCommand {

	private static final long serialVersionUID = -8110169976977012868L;

	private ChooseNumberInterface game;
	private int number;
	
	public ChooseNumberCommand(ChooseNumberInterface game, int number) {
		this.game = game;
		this.number = number;
	}

	@Override
	public String getType() {
		return "ChooseNumber";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.chooseNumber(number);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		
	}

}
