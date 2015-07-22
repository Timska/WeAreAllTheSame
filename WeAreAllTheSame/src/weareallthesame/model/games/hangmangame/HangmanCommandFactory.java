package weareallthesame.model.games.hangmangame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.CommandFactory;
import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;

public class HangmanCommandFactory implements CommandFactory {

	private HangmanInterface receiver;

	public HangmanCommandFactory(HangmanInterface receiver) {
		this.receiver = receiver;
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> commandTypes = new ArrayList<String>();
		commandTypes.add("HangmanAddLetter");
		commandTypes.add("HangmanRemoveLetter");
		return commandTypes.iterator();
	}

	@Override
	public Command getCommand(String type, Object... arguments) throws CommandDoesNotExistException {
		if(type.equalsIgnoreCase("hangmanaddletter")){
			return new HangmanAddLetterCommand(receiver, (Integer) arguments[0], (Integer) arguments[1]);
		}
		else if(type.equalsIgnoreCase("hangmanremoveletter")){
			return new HangmanRemoveLetterCommand(receiver, (Integer) arguments[0], (Integer) arguments[1]);
		}
		throw new CommandDoesNotExistException(String.format("Komandata od tip %s", type));
	}

	@Override
	public Command getDefault(Object... arguments) {
		// TODO Auto-generated method stub
		return null;
	}
}
