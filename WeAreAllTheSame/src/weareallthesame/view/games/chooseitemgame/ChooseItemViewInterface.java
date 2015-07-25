package weareallthesame.view.games.chooseitemgame;

import java.util.Iterator;
import java.util.List;

import weareallthesame.model.items.Item;

public interface ChooseItemViewInterface {

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

	/**
	 * So ovoj metod se bara do view-to da isprati so koi tagovi e oznaceno resenieto na igrata.
	 * @return iterator od tagovi
	 */
	public Iterator<String> getAnswerTags();

}
