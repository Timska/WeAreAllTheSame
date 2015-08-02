package weareallthesame.view.games.chooseitemgame;

import java.io.Serializable;
import java.util.List;

import weareallthesame.model.items.Item;

public interface ChooseItemViewInterface extends Serializable {

	/**
	 * So ovoj metod se setira resenieto na igrata.
	 * @param answer resenieto na igrata
	 */
	public void setAnswer(Item answer);

	/**
	 * So ovoj metod se isprakaat ponudenite odgovori za igrata.
	 * @param offeredAnswers ponudeni odgovori
	 */
	public void setOfferedAnswers(List<Item> offeredAnswers);
	
	/**
	 * So ovoj metod se izvestuva view-to deka igrata e zavrsena.
	 */
	public void gameOver();
	
	/**
	 * So ovoj metod se izvestuva view-to deka korisnikot odgovoril pogresno.
	 */
	public void wrongAnswer();

	
}
