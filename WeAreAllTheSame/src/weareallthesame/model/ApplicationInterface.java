package weareallthesame.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.db.FillDatabase;
import weareallthesame.factories.CategoryFactory;
import weareallthesame.factories.GameFactory;
import weareallthesame.factories.ItemFactory;
import weareallthesame.factories.QuestionFactory;
import weareallthesame.model.categories.AbstractCategory;
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
import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationInterface implements Serializable {

	private static final long serialVersionUID = -2398754556365634431L;
	private static final String PREFS_NAME = "DBSetFile";
	
	private CategoryFactory categoryFactory;
	private CategoryInterface currentCategory;
	private Game currentGame;
	
	public ApplicationInterface(Context context) {
		System.out.println("Application Interface constructor");
		
		SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
		if (prefs.getBoolean("isDBFilled", false) == false) {
			SharedPreferences.Editor editor = prefs.edit();
			editor.putBoolean("isDBFilled", true);
			editor.commit();
			
			FillDatabase.setContext(context);
			FillDatabase.fillWholeDatabase();
		}
		
		categoryFactory = new CategoryFactory(context);
		ItemFactory.setContext(context);
		QuestionFactory.setContext(context);
		GameFactory.setContext(context);
	}

	/**
	 * So ovoj metod ke se dobijat tipovite na site kategorii
	 * @return tipot na site kategorii
	 */
	public Iterator<String> getCategoryTypes(){
		return categoryFactory.getTypes();
	}
	
	/**
	 * So ovoj metod se dobivaat site kategorii.
	 * @return lista od kategorii
	 */
	public List<AbstractCategory> getCategories() {
		List<AbstractCategory> resultList = new ArrayList<AbstractCategory>();
		Iterator<String> categoryTypesIterator = getCategoryTypes();
		while(categoryTypesIterator.hasNext()){
			try {
				AbstractCategory category = getCategory(categoryTypesIterator.next());
				resultList.add(category);
			} catch (CategoryDoesNotExistException e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	
	/**
	 * So ovoj metod za daden tip se dobiva instanca od kategorija.
	 * @param type tipot na kategorijata
	 * @return kategorijata
	 * @throws CategoryDoesNotExistException
	 */
	public AbstractCategory getCategory(String type) throws CategoryDoesNotExistException{
		return categoryFactory.getCategory(type);
	}
	
	/**
	 * So ovoj metod se dobiva resursot na kategorijata ako e daden nejziniot tip
	 * @param type tipot na kategorijata, moze da se dobie so {@link ApplicationInterface#getCategoryTypes()}
	 * @return resurs za kategorijata od pusteniot tip
	 */
	public String getResourceForCategory(String type){
		return categoryFactory.getCategoryResource(type);
	}
	
	/**
	 * So ovoj metod se dobiva imeto na kategorijata ako e daden nejziniot tip
	 * @param type tipot na kategorijata, moze da se dobie so {@link ApplicationInterface#getCategoryTypes()}
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
	 * So ovoj metod se dobiva tipot na momentalno otvorenata kategorija.
	 * @return tipot na otvorenata kategorija
	 */
	public String getCurrentCategoryType(){
		return currentCategory.getType();
	}
	
	/**
	 * So ovoj metod se dobivaat site iminja na igri vo momentalno otvorenata kategorija.
	 * @return tipovite na igri vo momentalno otvorenata kategorija
	 * @throws CategoryNotChosenException nitu edna kategorija ne e momentalno otvorena
	 */
	public Iterator<String> getGamesFromOpenedCategory() throws CategoryNotChosenException{
		if(currentCategory == null){
			throw new CategoryNotChosenException("Ne moze da se dobijat igri bidejki nema izbrano kategorija");
		}
		return GameFactory.getGameNamesForCategory(currentCategory.getType());
	}
	
	/**
	 * So ovoj metod se dobiva tipot na igrata sto pripaga vo momentalno otvorenata kategorija za dadeno ime na igra.
	 * @param gameName imeto na igrata
	 * @return tipot na igrata
	 * @throws CategoryNotChosenException nitu edna kategorija ne e momentalno otvorena
	 */
	public String getGameType(String gameName) throws CategoryNotChosenException{
		if(currentCategory == null){
			throw new CategoryNotChosenException("Nema izbrano kategorija");
		}
		System.out.println(gameName + " " + currentCategory.getType());
		return GameFactory.getGameType(gameName, currentCategory.getType());
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
		System.out.println("Se otvora igra");
		System.out.println(type);
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

	/**
	 * So ovoj metod se dobivaat tagovte so koi e povikana momentalnata igra.
	 * @return lista od tagovi
	 */
	public ArrayList<String> getCurrentGameTags() {
		Iterator<String> it = currentGame.getTags();
		ArrayList<String> tags = new ArrayList<String>();
		while(it.hasNext()){
			tags.add(it.next());
		}
		return tags;
	}

	/**
	 * So ovoj metod se dobiva tipot na momentalno otvorenata igra.
	 * @return tip na igra
	 */
	public String getCurrentGameType() {
		return currentGame.getType();
	}

}
