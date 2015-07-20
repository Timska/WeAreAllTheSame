package weareallthesame.factories;

import weareallthesame.model.commands.Command;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.interfaces.TypeHolder;

public interface CommandFactory extends TypeHolder {

	/**
	 * So povikot na ovoj metod ke se kreira nova komanda vo zavisnost od tipot
	 * i parametrite i ke se vrati na korisnikot. Tipovite na komandi mozete da
	 * gi dobiete od {@link TypeHolder#getTypes()} metodot, koj isto taka e
	 * implementiran vo ovoj interfejs.
	 * 
	 * @param type
	 *            ja definira komandata koja treba da se kreira.
	 * @param arguments
	 *            ja definiraat strukturata na komandata. Tie se edinstveni za
	 *            sekoj tip na komanda, t.e. zavisat od tipot.
	 * @return komanda koja korespondira so tipot i argumentite koi se prosledeni.
	 * @throws CommandDoesNotExistException ne postoi komanda od toj tip
	 */
	public Command getCommand(String type, Object... arguments) throws CommandDoesNotExistException;

	/**
	 * So povikot na ovoj metod se kreira nova komanda so predodreden tip.
	 * Parametrite se prosleduvaat.
	 * 
	 * @param arguments
	 *            ja definiraat strukturata na komandata. Tie se edinstveni za
	 *            sekoj tip na komanda, t.e. zavisat od tipot.
	 * @return komanda koja korespondira argumentite koi se prosledeni.
	 */
	public Command getDefault(Object... arguments);
	
}