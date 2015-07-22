package weareallthesame.model.games.hangmangame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.CommandFactory;
import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.WrongArgumentTypeException;
import weareallthesame.model.exceptions.WrongNumberOfArgumentsException;

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
	public Command getCommand(String type, Object... arguments) throws CommandDoesNotExistException, WrongNumberOfArgumentsException, WrongArgumentTypeException {
		if(type.equalsIgnoreCase("hangmanaddletter")){
			if(arguments.length != 2){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			if(!(arguments[1] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 1 e od pogresen tip za komandata od tip %s", type));
			}
			return new HangmanAddLetterCommand(receiver, (Integer) arguments[0], (Integer) arguments[1]);
		}
		else if(type.equalsIgnoreCase("hangmanremoveletter")){
			if(arguments.length != 2){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			if(!(arguments[1] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 1 e od pogresen tip za komandata od tip %s", type));
			}
			return new HangmanRemoveLetterCommand(receiver, (Integer) arguments[0], (Integer) arguments[1]);
		}
		throw new CommandDoesNotExistException(String.format("Komandata od tip %s", type));
	}

}
