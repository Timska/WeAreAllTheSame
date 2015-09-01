package weareallthesame.model.games.hangmangame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.WrongAnswerException;

public class HangmanAddLetterCommand extends AbstractCommand{

	private static final long serialVersionUID = 2326101513395626601L;

	private HangmanInterface game;
	private int positionFrom;
	private int positionTo;
	
	public HangmanAddLetterCommand(HangmanInterface game, int positionFrom, int positionTo) {
		this.game = game;
		this.positionFrom = positionFrom;
		this.positionTo = positionTo;
	}

	@Override
	public void executeNow() throws GameOverException, CommandException, WrongAnswerException {
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
