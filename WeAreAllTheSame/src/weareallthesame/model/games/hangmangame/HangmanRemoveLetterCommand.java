package weareallthesame.model.games.hangmangame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.WrongAnswerException;

public class HangmanRemoveLetterCommand extends AbstractCommand {
	
	private static final long serialVersionUID = 4091614579984946656L;

	private HangmanInterface game;
	private int positionFrom;
	private int positionTo;
	
	public HangmanRemoveLetterCommand(HangmanInterface game, int positionFrom, int positionTo) {
		this.game = game;
		this.positionFrom = positionFrom;
		this.positionTo = positionTo;
	}

	@Override
	public String getType() {
		return "HangmanRemoveLetter";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.removeLetter(positionFrom, positionTo);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException, WrongAnswerException {
		game.setLetter(positionTo, positionFrom);
	}

}
