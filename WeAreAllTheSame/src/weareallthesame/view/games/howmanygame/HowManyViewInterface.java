package weareallthesame.view.games.howmanygame;

import java.util.Set;

import weareallthesame.model.items.Item;

public interface HowManyViewInterface {

	/**
	 * So ovoj metod se setira odgovorot na igrata.
	 * @param item nestoto sto ke se povtoruva poveke pati
	 * @param howMany kolku pati ke se povtoruva nestoto
	 */
	public void setAnswer(Item item, int howMany);
	
	/**
	 * So ovoj metod se setiraat ponudenite odgovori.
	 * @param offeredAnswers ponudeni odgovori
	 */
	public void setOfferedAnswers(Set<Integer> offeredAnswers);
	
	/**
	 * So ovoj metod se izvestuva view-to deka igrata zavrsi. Korisnikot odgovoril tocno.
	 */
	public void gameOver();
	
	/**
	 * So ovoj metod se izvestuva view-to deka korisnikot odgovoril pogresno.
	 */
	public void wrongAnswer();
}
