package weareallthesame.model.games.choosesigngames;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class ChooseSignCommand extends AbstractCommand{

	private ChooseSignInterface game;
	private Character sign;
	
	public ChooseSignCommand(ChooseSignInterface game, Character sign) {
		this.game = game;
		this.sign = sign;
	}

	@Override
	public String getType() {
		return "ChooseSign";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.chooseSign(sign);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		
	}

}
