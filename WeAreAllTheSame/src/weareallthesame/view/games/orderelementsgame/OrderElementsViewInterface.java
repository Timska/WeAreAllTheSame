package weareallthesame.view.games.orderelementsgame;

import java.util.List;
import java.util.Set;

public interface OrderElementsViewInterface {

	/**
	 * So ovoj metod se setiraat elementite koi treba da se podredat.
	 * @param elements elementite za podreduvanje
	 */
	public void setElements(Set<String> elements);

	/**
	 * So ovoj metod se setira podredenata lista.
	 * @param orderedElements listata od podredeni elementi
	 */
	public void setOrdered(List<String> orderedElements);

	/**
	 * So ovoj metod se izvestuva view-to deka korisnikot odgovoril pogresno.
	 */
	public void wrongAnswer();

	/**
	 * So ovoj metod se izvestuva view-to deka igrata zavrsi.
	 */
	public void gameOver();

}
