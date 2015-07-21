package weareallthesame.model;

import java.util.Iterator;

import weareallthesame.exceptions.CategoryDoesNotExistException;
import weareallthesame.factories.CategoryFactory;
import weareallthesame.model.categories.CategoryInterface;
import weareallthesame.model.exceptions.CategoryNotChosenException;
import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.GameNotOpenException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.Game;

public class ApplicationInterface {

	private CategoryFactory categoryFactory;
	private CategoryInterface currentCategory;
	private Game currentGame;
	
	public ApplicationInterface() {
		categoryFactory = new CategoryFactory();
	}

	/**
	 * So ovoj metod ke se dobijat tipovite na site kategorii
	 * @return tipot na site kategorii
	 */
	public Iterator<String> getCategories(){
		return categoryFactory.getTypes();
	}
	
	/**
	 * So ovoj metod se dobiva resursot na kategorijata ako e daden nejziniot tip
	 * @param type tipot na kategorijata, moze da se dobie so {@link ApplicationInterface#getCategories()}
	 * @return resurs za kategorijata od pusteniot tip
	 */
	public String getResourceForCategory(String type){
		return categoryFactory.getCategoryResource(type);
	}
	
	/**
	 * So ovoj metod se dobiva imeto na kategorijata ako e daden nejziniot tip
	 * @param type tipot na kategorijata, moze da se dobie so {@link ApplicationInterface#getCategories()}
	 * @return imeto na kategorijata od pusteniot tip
	 */
	public String getNameForCategory(String type){
		return categoryFactory.getCategoryName(type);
	}
	
	/**
	 * Se izbira kategorija za dadeniot tip
	 * @param type tipot na kategorija
	 * @throws CategoryDoesNotExistException
	 */
	public void openCategory(String type) throws CategoryDoesNotExistException{
		currentCategory = categoryFactory.getCategory(type);
	}
	
	/**
	 * So ovoj metod se dobivaat site igri vo momentalno otvorenata kategorija.
	 * @return tipovite na igri vo momentalno otvorenata kategorija
	 * @throws CategoryNotChosenException nitu edna kategorija ne e momentalno otvorena
	 */
	public Iterator<String> getGamesFromOpenedCategory() throws CategoryNotChosenException{
		if(currentCategory == null){
			throw new CategoryNotChosenException("Ne moze da se dobijat igri bidejki nema izbrano kategorija");
		}
		return currentCategory.getTypes();
	}
	
	/**
	 * So ovoj metod se otvora nova igra.
	 * @param type tipot na igrata sto sakame da ja otvorime
	 * @param tags tagovite spored koi ke se pravi prebaruvanje na potrebni itemi
	 * @param view pogledot koj ke se spravi so prikazuvanje na igrata sto sakame da ja otvorime
	 * @throws CategoryNotChosenException ne moze da se otvori igra bidejki se nema izbrano kategorija
	 * @throws GameDoesNotExistException vo izbranata kategorija ne postoi igra od toj tip
	 * @throws InvalidViewTypeException isptateniot pogled ne znae kako da se spravi so igrata sto se kreira
	 */
	public void openGame(String type, Iterator<String> tags, Object view) throws CategoryNotChosenException, GameDoesNotExistException, InvalidViewTypeException{
		if(currentCategory == null){
			throw new CategoryNotChosenException("Ne moze da se izberi igra bidejki nema izbrano kategorija");
		}
		currentGame = currentCategory.getGame(type, tags, view);
	}
	
	/**
	 * So ovoj metod se zatvora momentalno otvorenata igra.
	 * @throws GameNotOpenException ne moze da se zatvori igra ako prethodno nema otvoreno
	 */
	public void exitGame() throws GameNotOpenException{
		if(currentGame == null){
			throw new GameNotOpenException("Ne moze da se zatvori igrata bidejki nema otvorena igra");
		}
		currentGame = null;
	}
	
	
}
