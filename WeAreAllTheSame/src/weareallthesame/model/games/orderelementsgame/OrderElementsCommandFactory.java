package weareallthesame.model.games.orderelementsgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.CommandFactory;
import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.WrongArgumentTypeException;
import weareallthesame.model.exceptions.WrongNumberOfArgumentsException;

public class OrderElementsCommandFactory implements CommandFactory {

	private OrderElementsInterface receiver;
	
	public OrderElementsCommandFactory(OrderElementsInterface receiver) {
		this.receiver = receiver;
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> types = new ArrayList<String>();
		types.add("SetElementOnPosition");
		types.add("RemoveElementFromPosition");
		types.add("ChangeElementPosition");
		return types.iterator();
	}

	@Override
	public Command getCommand(String type, Object... arguments)
			throws CommandDoesNotExistException,
			WrongNumberOfArgumentsException, WrongArgumentTypeException {
		
		if(type.equalsIgnoreCase("SetElementOnPosition")){
			if(arguments.length != 2){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			if(!(arguments[1] instanceof String)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			return new SetElementOnPositionCommand(receiver, (Integer) arguments[0], (String) arguments[1]);
		}
		if(type.equalsIgnoreCase("RemoveElementFromPosition")){
			if(arguments.length != 2){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			if(!(arguments[1] instanceof String)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			return new RemoveElementFromPositionCommand(receiver, (Integer) arguments[0], (String) arguments[1]);
		}
		if(type.equalsIgnoreCase("ChangeElementPosition")){
			if(arguments.length != 2){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			if(!(arguments[1] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			return new ChangeElementPositionCommand(receiver, (Integer) arguments[0], (Integer) arguments[1]);
		}
		throw new CommandDoesNotExistException("Ne postoi komanda od isprateniot tip");
	}

}
