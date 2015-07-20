package weareallthesame.model.commands;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public abstract class AbstractCommand implements Command {
	private boolean executed;

	@Override
	public final void execute() throws GameOverException, CommandException {
		if (!executed) {
			executed = true;
			executeNow();
		}
	}
	
	public abstract void executeNow() throws GameOverException, CommandException;

	@Override
	public final void undo() throws GameOverException, CommandException {
		if (executed) {
			executed = false;
			undoNow();
		}
	}
	
	public abstract void undoNow() throws GameOverException, CommandException;
	
}