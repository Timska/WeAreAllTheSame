package weareallthesame.model.commands;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.WrongAnswerException;
import weareallthesame.model.interfaces.Typable;

public abstract class AbstractCommand implements Command, Typable {
	
	private static final long serialVersionUID = 818291402355120542L;
	
	private boolean executed;

	@Override
	public final void execute() throws GameOverException, CommandException, WrongAnswerException {
		if (!executed) {
			executed = true;
			executeNow();
		}
	}
	
	public abstract void executeNow() throws GameOverException, CommandException, WrongAnswerException;

	@Override
	public final void undo() throws GameOverException, CommandException, WrongAnswerException {
		if (executed) {
			executed = false;
			undoNow();
		}
	}
	
	public abstract void undoNow() throws GameOverException, CommandException, WrongAnswerException;
	
}
