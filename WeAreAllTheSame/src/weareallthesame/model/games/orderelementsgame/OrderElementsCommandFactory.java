package weareallthesame.model.games.orderelementsgame;

import java.util.Iterator;

import weareallthesame.factories.CommandFactory;
import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.WrongArgumentTypeException;
import weareallthesame.model.exceptions.WrongNumberOfArgumentsException;

public class OrderElementsCommandFactory implements CommandFactory {

	private OrderElementsInterface receriver;
	
	public OrderElementsCommandFactory(OrderElementsInterface receriver) {
		this.receriver = receriver;
	}

	@Override
	public Iterator<String> getTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command getCommand(String type, Object... arguments)
			throws CommandDoesNotExistException,
			WrongNumberOfArgumentsException, WrongArgumentTypeException {
		// TODO Auto-generated method stub
		return null;
	}

}
