package weareallthesame.model.games.hangmangame;

import weareallthesame.model.commands.AbstractCommand;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public class HangmanInsertLetterCommand extends AbstractCommand{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4843645896249953348L;
	
	private HangmanStandardInterface game;
	private Character letter;
	
	
	public HangmanInsertLetterCommand(HangmanStandardInterface game, Character letter) {
		this.game = game;
		this.letter = letter;
	}
	
	@Override
	public String getType() {
		return "HangmanInsertLetter";
	}

	@Override
	public void executeNow() throws GameOverException, CommandException {
		game.chooseLetter(letter);
	}

	@Override
	public void undoNow() throws GameOverException, CommandException {
		
	}

}
