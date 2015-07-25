package weareallthesame.model.games.howmanygame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class HowManyChooseNumberCommand extends AbstractCommand {

	private HowManyInterface game;
	private int number;
	
	public HowManyChooseNumberCommand(HowManyInterface game, int number) {
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
