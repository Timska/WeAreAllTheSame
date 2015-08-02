package weareallthesame.model.games.howmanygame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.CommandFactory;
import weareallthesame.model.commands.ChooseNumberCommand;
import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.WrongArgumentTypeException;
import weareallthesame.model.exceptions.WrongNumberOfArgumentsException;
import weareallthesame.model.interfaces.ChooseNumberInterface;

public class HowManyCommandFactory implements CommandFactory{

	private static final long serialVersionUID = -8750615745646906739L;

	private ChooseNumberInterface receiver;
	
	public HowManyCommandFactory(ChooseNumberInterface receiver) {
		this.receiver = receiver;
	}

	@Override
	public Iterator<String> getTypes() {
		List<String> commandTypes = new ArrayList<String>();
		commandTypes.add("ChooseNumber");
		return commandTypes.iterator();
	}

	@Override
	public Command getCommand(String type, Object... arguments)
			throws CommandDoesNotExistException,
			WrongNumberOfArgumentsException, WrongArgumentTypeException {
		if(type.equalsIgnoreCase("choosenumber")){
			if(arguments.length != 1){
				throw new WrongNumberOfArgumentsException(String.format("Pogresen broj na argumenti za komandata od tip %s", type));
			}
			if(!(arguments[0] instanceof Integer)){
				throw new WrongArgumentTypeException(String.format("Argumentot 0 e od pogresen tip za komandata od tip %s", type));
			}
			return new ChooseNumberCommand(receiver, (Integer)arguments[0]);
		}
		throw new CommandDoesNotExistException("Ne postoi komanda od isprateniot tip");
	}

}
