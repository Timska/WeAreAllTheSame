package weareallthesame.view.games.additionandsubtractiongames;

import weareallthesame.model.items.Item;

public interface AdditionAndSubtractionSetsViewInterface extends AdditionAndSubtractionNumbersViewInterface {

	/**
	 * So ovoj metod se setira itemot od koj se sostaveni mnozestavata.
	 * @param item
	 */
	public void setItem(Item item);
}
