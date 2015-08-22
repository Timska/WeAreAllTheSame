package weareallthesame.model.games.classifyitemsgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.CommandFactory;
import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.WrongArgumentTypeException;
import weareallthesame.model.exceptions.WrongNumberOfArgumentsException;
import weareallthesame.model.items.Item;

public class ClassifyItemsCommandFactory implements CommandFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7531770214646427732L;
	
	private ClassifyItemsInterface receiver;
	
	public ClassifyItemsCommandFactory(ClassifyItemsInterface receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public Iterator<String> getTypes() {
		List<String> types = new ArrayList<String>();
		types.add("ClassifyItem");
		return types.iterator();
	}

	@Override
	public Command getCommand(String type, Object... arguments)
			throws CommandDoesNotExistException,
			WrongNumberOfArgumentsException, WrongArgumentTypeException {
		if(type.equalsIgnoreCase("classifyitem")){
			if(arguments.length != 2){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof Item)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			if(!(arguments[1] instanceof String)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			return new ClassifyItemCommand(receiver, (Item) arguments[0], (String) arguments[1]);
		}
		throw new CommandDoesNotExistException("Ne postoi komanda od isprateniot tip");
	}

}
