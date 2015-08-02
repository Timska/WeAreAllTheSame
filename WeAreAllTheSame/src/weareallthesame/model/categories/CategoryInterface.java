package weareallthesame.model.categories;

import java.io.Serializable;
import java.util.Iterator;

import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.games.Game;
import weareallthesame.model.interfaces.Typable;
import weareallthesame.model.interfaces.TypeHolder;

/**
 * Sekoja klasa sto ke go implementira ovoj interfejs ke bide fabrika za igri.
 * @author i5
 *
 */
public interface CategoryInterface extends TypeHolder, Typable, Serializable{

	/**
	 * Ovoj metod ke kreira igra spored tipot.
	 * @param type tipot na igrata sto treba da se kreira
	 * @param tags tagovite koi potoa ke se predadat na igrata sto se kreira
	 * @return kreiranata igra
	 * @throws GameDoesNotExistException kategorijata od koja sto ja barate igrata ne znae da ja kreira
	 * @throws InvalidViewTypeException ispratenoto view ne moze da se iskoristi za toj tip na igra
	 * @throws MissingTagException nedostiga nekoj tag za definiranje na igrata
	 */
	public Game getGame(String type, Iterator<String> tags, Object view, String question) throws GameDoesNotExistException, InvalidViewTypeException, MissingTagException;
	
	public String getName();
	
	public String getResourceName();
}
