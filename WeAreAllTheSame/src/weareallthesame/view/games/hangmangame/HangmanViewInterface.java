package weareallthesame.view.games.hangmangame;

import java.io.Serializable;
import java.util.List;

import weareallthesame.model.items.Item;


public interface HangmanViewInterface extends Serializable {
	
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
	 * Ovoj metod se koristi za inicijalizacija i update na ponudenite bukvi i koi od niv se iskoristeni pri sekoja promena
	 * na sostojbata na igrata.
	 * @param allOfferedLetters site ponudeni bukvi megu koi moze da ima i veke iskoristeni
	 */
	public void setOrUpdateOfferedLetters(List<Character> allOfferedLetters);
	
	/**
	 * Ovoj metod se korisi za setiranje ili update na momentalniot odgovor na korisnikot sto ja igra igrata.
	 * @param userAnswer vo ovaa lista se cuva odgovorot na korisnikot
	 */
	public void setOrUpdateUserAnswer(List<Character> userAnswer);
}
