package weareallthesame.model.games.choosecharacterfromsoundgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.CommandFactory;
import weareallthesame.model.commands.ChooseStringCommand;
import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.WrongArgumentTypeException;
import weareallthesame.model.exceptions.WrongNumberOfArgumentsException;
import weareallthesame.model.interfaces.ChooseStringInterface;

public class ChooseStringFromSoundCommandFactory implements CommandFactory {

	private static final long serialVersionUID = -341189746589081861L;
	
	private ChooseStringInterface receiver;
	
	public ChooseStringFromSoundCommandFactory(ChooseStringInterface receiver) {
		this.receiver = receiver;
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> types = new ArrayList<String>();
		types.add("ChooseString");
		return types.iterator();
	}

	@Override
	public Command getCommand(String type, Object... arguments)
			throws CommandDoesNotExistException, WrongArgumentTypeException, WrongNumberOfArgumentsException {
		
		if(type.equalsIgnoreCase("choosestring")){
			if(arguments.length != 1){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof String)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			return new ChooseStringCommand(receiver, (String) arguments[0]);
		}
		throw new CommandDoesNotExistException("Ne postoi komanda od isprateniot tip");
	}

}
