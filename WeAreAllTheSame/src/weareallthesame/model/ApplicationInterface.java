package weareallthesame.model;

import java.util.Iterator;

import android.content.Context;
import weareallthesame.db.FillDatabase;
import weareallthesame.factories.CategoryFactory;
import weareallthesame.factories.ItemFactory;
import weareallthesame.factories.QuestionFactory;
import weareallthesame.model.categories.CategoryInterface;
import weareallthesame.model.exceptions.CategoryDoesNotExistException;
import weareallthesame.model.exceptions.CategoryNotChosenException;
import weareallthesame.model.exceptions.CommandDoesNotExistException;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameDoesNotExistException;
import weareallthesame.model.exceptions.GameNotOpenException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.exceptions.WrongArgumentTypeException;
import weareallthesame.model.exceptions.WrongNumberOfArgumentsException;
import weareallthesame.model.games.Game;

public class ApplicationInterface {

	private CategoryFactory categoryFactory;
	private CategoryInterface currentCategory;
	private Game currentGame;
	
	public ApplicationInterface(Context context) {
		FillDatabase.setContext(context);
		FillDatabase.fillCategories();
		FillDatabase.fillItems();
		FillDatabase.fillItemTags();
		
		categoryFactory = new CategoryFactory(context);
		ItemFactory.setContext(context);
		QuestionFactory.setContext(context);
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
	 * So ovoj metod se zatvora kategorijata sto bila otvorena
	 * @throws CategoryNotChosenException nema otvorena kategorija
	 */
	public void closeCategory() throws CategoryNotChosenException{
		if(currentCategory == null){
			throw new CategoryNotChosenException("Ne moze da se zatvori kategorijata bidejki nema otvoreno kategorija");
		}
		currentCategory = null;
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
	 * @throws MissingTagException nedostiga tag za definiranje na igrata
	 */
	public void openGame(String type, Iterator<String> tags, Object view, String question) throws CategoryNotChosenException, GameDoesNotExistException, InvalidViewTypeException, MissingTagException{
		if(currentCategory == null){
			throw new CategoryNotChosenException("Ne moze da se izberi igra bidejki nema izbrano kategorija");
		}
		currentGame = currentCategory.getGame(type, tags, view, question);
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
	
	/**
	 * So ovoj metod se dobivaat site tipovi na komandi koi mozat da se izvrsat vo aktivnata igra.
	 * @return tipovite na komandi za aktivnata igra
	 * @throws GameNotOpenException nema aktivna igra
	 */
	public Iterator<String> getCommandsForActiveGame() throws GameNotOpenException{
		if(currentGame == null){
			throw new GameNotOpenException("Nema aktivna igra za da se dobijat nejzini komandi");
		}
		return currentGame.getCommandTypes();
	}
	
	/**
	 * So ovoj metod se izvrsuva komada.
	 * @param type tipot na komandata sto sakame da ja izvrsime
	 * @param arguments argumentite potrebni za da se izvrsi komandata
	 * @throws GameNotOpenException nema aktivna igra
	 * @throws GameOverException igrata e zavrsena i ne moze poveke da se izvrsuvaat komandi
	 * @throws CommandException greska pri izvrsuvanje na komandata
	 * @throws CommandDoesNotExistException ne postoi takva komanda za aktivnata igra
	 * @throws WrongArgumentTypeException  pogresen broj na isprateni argumenti
	 * @throws WrongNumberOfArgumentsException nekoj od argumentite e od pogresen tip
	 */
	public void executeCommand(String type, Object... arguments) throws GameNotOpenException, GameOverException, CommandException, CommandDoesNotExistException, WrongNumberOfArgumentsException, WrongArgumentTypeException {
		if(currentGame == null){
			throw new GameNotOpenException("Ne moze da se izvrsi komanda bidejki nema aktivna igra");
		}
		currentGame.execute(type, arguments);
	}
	
	/**
	 * So ovoj metod igrata se vraka vo sostojbata vo koja bila pred da se izvrsi poslednata komanda.
	 * @throws GameNotOpenException nema aktivna igra
	 * @throws GameOverException igrata e zavrsena
	 * @throws CommandException greska pri vrakanje na prethodnata sostojba na igrata
	 */
	public void undoLastCommand() throws GameNotOpenException, GameOverException, CommandException{
		if(currentGame == null){
			throw new GameNotOpenException("Ne moze da se ponisti poslednata komanda bidejki nema aktivna igra");
		}
		currentGame.undo();
	}
}
