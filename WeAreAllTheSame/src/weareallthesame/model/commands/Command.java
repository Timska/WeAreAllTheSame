package weareallthesame.model.commands;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.interfaces.Typable;

/**
 * Ovoj objekt pretstavuva komanda koja moze da bide izvrsena ili vratena.
 */
public interface Command extends Typable{
	/**
	 * Ja izvrsuva komandata dokolku ne e veke povikana ili dokolku posledno e
	 * povikan metodot {@link Command#undo()}. Vo sprotivno ne se slucuva nisto.
	 * @throws CommandException se javuva greska pri izvrsuvanje na komandata
	 * @throws GameOverException komandata ne moze da se izvrsi bidejki igrata e zavrsena
	 */
	public void execute() throws GameOverException, CommandException;

	/**
	 * Pravi revert na komandata dokolku posledno e izvrsen metodot execute. Vo
	 * sprotivno ne se slucuva nisto.
	 * @throws CommandException se javuva greska pri vrakanje na komandata
	 * @throws GameOverException ne moze da se vrati nazad komandata bidejki igrata e zavrsena
	 */
	public void undo() throws GameOverException, CommandException;
}
