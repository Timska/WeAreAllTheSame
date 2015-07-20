package weareallthesame.model.games.hangmangame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class HangmanAddLetterCommand extends AbstractCommand{

	private HangmanInterface game;
	private int positionFrom;
	private int positionTo;
	
	public HangmanAddLetterCommand(HangmanInterface game, int positionFrom, int positionTo) {
		this.game = game;
		this.positionFrom = positionFrom;
		this.positionTo = positionTo;
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.setLetter(positionFrom, positionTo);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		game.removeLetter(positionTo, positionFrom);
	}

	@Override
	public String getType() {
		return "HangmanAddLetter";
	}

}
