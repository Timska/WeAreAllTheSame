package weareallthesame.view.games.classifyitemsgames;

import java.util.Map;
import java.util.Set;

import weareallthesame.model.items.Item;

public interface ClassifyItemsViewInterface {

	/**
	 * So ovoj metod se setiraat ponudenite itemi koi treba da se klasificiraat.
	 * @param offeredItems ponudenite itemi
	 */
	public void setOrUpdate(Set<Item> offeredItems);

	/**
	 * So ovoj metod se setira ili azurira klasifikacijata na elementite od korisnikot.
	 * Na pocetokot mnozestvata se prazni
	 * @param classSetMap odgovorot na korisnikot
	 */
	public void setOrUpdateClassElements(Map<String, Set<Item>> classSetMap);

	/**
	 * So ovoj metod se izvestuva korisnikot deka posledniot napraven izbor e pogresen.
	 */
	public void wrongChoice();

	/**
	 * So ovoj metod se izvestuva korisnikot deka igrata zavrsi.
	 */
	public void gameOver();

}
