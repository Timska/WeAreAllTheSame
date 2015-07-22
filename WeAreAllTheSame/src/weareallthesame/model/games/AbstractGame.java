package weareallthesame.model.games;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import weareallthesame.factories.CommandFactory;
import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.WrongArgumentTypeException;
import weareallthesame.model.exceptions.WrongNumberOfArgumentsException;

public abstract class AbstractGame implements Game {
	private List<String> tags;
	private CommandFactory commandFactory;
	private Stack<Command> commands;

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	public AbstractGame(Iterator<String> tags, String question) {
		this.tags = new ArrayList<String>();
		while (tags.hasNext())
			this.tags.add(tags.next());
		commands = new Stack<Command>();
	}

	@Override
	public void execute(String type, Object... arguments) throws GameOverException, CommandException, CommandDoesNotExistException, WrongNumberOfArgumentsException, WrongArgumentTypeException {
		Command command = commandFactory.getCommand(type, arguments);
		command.execute();
		commands.add(command);
	}

	@Override
	public void undo() throws GameOverException, CommandException {
		if (!commands.isEmpty()) {
			Command command = commands.pop();
			command.undo();
		}
	}

	@Override
	public Iterator<String> getCommandTypes() {
		return commandFactory.getTypes();
	}
	
	public Iterator<String> getTags(){
		return this.tags.iterator();
	}

}
