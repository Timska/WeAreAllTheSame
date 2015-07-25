package weareallthesame.view.games.choosesigngames;

import weareallthesame.model.items.Item;

public interface ChooseSignBetweenSetsViewInterface extends ChooseSignBetweenNumbersViewInterface{

	/**
	 * So ovoj metod se setiraat itemite od koi ke bidat sostaveni dvete mnozestva.
	 * @param itemOne 
	 * @param itemTwo
	 */
	public void setItems(Item itemOne, Item itemTwo);
}
