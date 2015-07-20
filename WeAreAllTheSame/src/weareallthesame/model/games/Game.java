package weareallthesame.model.games;

import java.util.Iterator;

import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.interfaces.Typable;

public interface Game extends Typable {

	/**
	 * Za sekoja akcija sto ke se izvrsuva vo igrata ke se povikuva ovoj metod.
	 * @param type definira koja komanda da se izvrsi i pritoa tipovite mozat da se dobijat od {@link Game#getCommandTypes()}.
	 * @param arguments gi cuva argumentite potrebni da se izvrsi komandata navedena so tipot.
	 * @throws CommandException 
	 * @throws GameOverException 
	 * @throws CommandDoesNotExistException 
	 */
	public void execute(String type, Object... arguments) throws GameOverException, CommandException, CommandDoesNotExistException;
	
	/**
	 * Ovoj metod e povrzan so {@link Game#execute(String, Object...)} metodot i dokolku se povika pravi revert na posledno 
	 * izvrsenata komanda. Ako nema izvrsena komanda ovoj metod ne pravi nisto. Dokolku pak se povika nekolku pati ke napravi revert
	 * na onolku komandi kolku sto pati e povikan.
	 * @throws CommandException 
	 * @throws GameOverException 
	 */
	public void undo() throws GameOverException, CommandException;
	
	/**
	 * Ovoj metod se koristi za da se dobijat site tipovi na komandi koi mozat da se izvrsat vo igrata.
	 * @return lista od tipovi na komandi.
	 */
	public Iterator<String> getCommandTypes();
	
}
