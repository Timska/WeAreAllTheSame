package weareallthesame.view.games.choosecharacterfromsoundgame;

import java.io.Serializable;
import java.util.Set;

import weareallthesame.model.items.Item;

public interface ChooseStringFromSoundViewInterface extends Serializable {

	/**
	 * Ovoj metod se koristi za da se oznaci tocniot odgovor na igrata.
	 * @param item odgovorot na igrata (go sodrzi odgovorot i resurs do nego)
	 */
	public void setAnswer(Item item);
	
	/**
	 * Ovoj metod se koristi za da se oznaci deka igrata e zavrsena.
	 */
	public void gameOver();
	
	/**
	 * Ovoj metod se koristi za da se izvesti deka izbraniot odgovor e pogresen. Igrata bi trebalo
	 * da prodolzi dokolku odgovorot e pogresen. Korisnikot povtorno da bira.
	 */
	public void wrongAnswer();
	
	/**
	 * Ovoj metod se koristi za inicijalizacija na ponudenite bukvi.
	 * @param allOfferedLetters site ponudeni bukvi (site se razlicni)
	 */
	public void setOfferedAnswers(Set<String> allOfferedLetters);
	
}
