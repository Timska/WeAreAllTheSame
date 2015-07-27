package weareallthesame.model.commands;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.interfaces.ChooseStringInterface;

public class ChooseStringCommand extends AbstractCommand{

	private ChooseStringInterface game;
	private String string;
	
	public ChooseStringCommand(ChooseStringInterface game, String string) {
		this.game = game;
		this.string = string;
	}

	@Override
	public String getType() {
		return "ChooseString";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.chooseAnswer(string);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		
	}

}
