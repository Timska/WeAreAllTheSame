package weareallthesame.model.games.chooseitemgame;

import java.io.Serializable;

import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.items.Item;

public interface ChooseItemInterface extends Serializable {

	/**
	 * So ovoj metod se izbira eden odgovor.
	 * @param item odgovorot sto e izbran
	 * @throws GameOverException igrata e zavrsena pa ne moze da se napravi izbor
	 */
	public void chooseAnswer(Item item) throws GameOverException;
}
