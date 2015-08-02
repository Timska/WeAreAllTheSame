package weareallthesame.model.games.connectitemsgames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.CommandFactory;
import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.WrongArgumentTypeException;
import weareallthesame.model.exceptions.WrongNumberOfArgumentsException;

public class ConnectItemsCommandFactory implements CommandFactory {

	private static final long serialVersionUID = 3909339879350333794L;

	private ConnectItemsInterface receiver;
	
	public ConnectItemsCommandFactory(ConnectItemsInterface receiver) {
		this.receiver = receiver;
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> types = new ArrayList<String>();
		types.add("AddConnection");
		types.add("RemoveConnection");
		return types.iterator();
	}

	@Override
	public Command getCommand(String type, Object... arguments)
			throws CommandDoesNotExistException,
			WrongNumberOfArgumentsException, WrongArgumentTypeException {
		
		if(type.equalsIgnoreCase("AddConnection")){
			if(arguments.length != 2){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			if(!(arguments[1] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 1 e od pogresen tip za komandata od tip %s", type));
			}
			return new AddConnectionCommand(receiver, (Integer) arguments[0], (Integer) arguments[1]);
		}
		if(type.equalsIgnoreCase("RemoveConnection")){
			if(arguments.length != 2){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			if(!(arguments[1] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 1 e od pogresen tip za komandata od tip %s", type));
			}
			return new RemoveConnectionCommand(receiver, (Integer) arguments[0], (Integer) arguments[1]);
		}
		throw new CommandDoesNotExistException("Ne postoi komanda od isprateniot tip");
	}

}
