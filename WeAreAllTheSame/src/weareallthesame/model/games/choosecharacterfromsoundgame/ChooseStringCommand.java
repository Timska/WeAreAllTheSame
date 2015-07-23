package weareallthesame.model.games.choosecharacterfromsoundgame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class ChooseStringCommand extends AbstractCommand{

	private ChooseStringFromSoundInterface game;
	private String string;
	
	public ChooseStringCommand(ChooseStringFromSoundInterface game, String string) {
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
