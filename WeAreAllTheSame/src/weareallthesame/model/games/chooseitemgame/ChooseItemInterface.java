package weareallthesame.model.games.chooseitemgame;

import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.items.Item;

public interface ChooseItemInterface {

	/**
	 * So ovoj metod se izbira eden odgovor.
	 * @param item odgovorot sto e izbran
	 * @throws GameOverException igrata e zavrsena pa ne moze da se napravi izbor
	 */
	public void chooseAnswer(Item item) throws GameOverException;
}
