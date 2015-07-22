package weareallthesame.model.games.choosecharacterfromsoundgame;

import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class ChooseStringCommand implements Command{

	private ChooseCharacterFromSoundInterface game;
	private String string;
	
	public ChooseStringCommand(ChooseCharacterFromSoundInterface game, String string) {
		this.game = game;
		this.string = string;
	}

	@Override
	public String getType() {
		return "ChooseString";
	}

	@Override
	public void execute() throws GameOverException, CommandException {
		game.chooseAnswer(string);
		
	}

	@Override
	public void undo() throws GameOverException, CommandException {
		
	}

}
