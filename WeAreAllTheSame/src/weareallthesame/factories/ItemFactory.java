package weareallthesame.factories;

import java.util.Iterator;

import weareallthesame.model.items.Item;

/**
 * Ovaa klasa ke se koristi za kreiranje na itemi.
 * @author i5
 *
 */
public class ItemFactory {

	/**
	 * Ovoj metod se koristi za povlekuvanje na itemi od baza.
	 * @param tags tagovite so koi ke treba da se tagirani itemite za da bidat povleceni od baza.
	 * @param numberOfItems kolku itemi da bidat povleceni.
	 * @return
	 */
	public static Iterator<Item> getItem(Iterator<String> tags, int numberOfItems){
		// TODO ke treba da se implementira citanje od baza na itemi za dadenite tagovi i da se vrati tocno numberOfItems itemi
		return null;
	}
	
}
