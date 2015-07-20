package weareallthesame.factories;

import java.util.Iterator;

import weareallthesame.exceptions.CategoryDoesNotExistException;
import weareallthesame.model.categories.AbstractCategory;
import weareallthesame.model.categories.CategoryInterface;
import weareallthesame.model.categories.LettersCategory;
import weareallthesame.model.interfaces.TypeHolder;

public class CategoryFactory implements TypeHolder{

	/**
	 * Ovoj metod se koristi za kreiranje na kategorii
	 * @param type tipot so koj ednoznacno e opredelena kategorijata
	 * @param name imeto na kategorijata na makedonski sto ke se prikaze na krajniot korisnik
	 * @return kategorija
	 * @throws CategoryDoesNotExistException ne znae da kreira kategorija za dadeniot tip
	 */
	public AbstractCategory getCategory(String type, String name, String resourceName) throws CategoryDoesNotExistException{
		/* TODO ke treba da se doimplementira za dadeniot tip da se kreira soodvetnata kategorija.
			Ne e seuste implementirano bidejki ne se kreirani site kategorii. */
		
		if(type.equalsIgnoreCase("letters")){
			return new LettersCategory(name, resourceName);
		}
		
		throw new CategoryDoesNotExistException("Ne postoi kategorija za dadeniot tip");
	}

	@Override
	public Iterator<String> getTypes() {
		/* TODO da se procitaat kateoriite od baza ili staticki vo lista da se dodadat kako sto imam
		  	vo HangmanCommandFactory getTypes() metodot */
		return null;
	}

}
