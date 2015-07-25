package weareallthesame.model.interfaces;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface ChooseNumberInterface {

	/**
	 * So ovoj metod se izbira eden od ponudenite broevi kako odgovor.
	 * @param number brojot sto e izbran
	 * @throws GameOverException igrata e zavrsena ne moze da se napravi izbor
	 * @throws CommandException ispraten e broj sto ne e ponuden
	 */
	public void chooseNumber(int number) throws GameOverException, CommandException;
	
}
