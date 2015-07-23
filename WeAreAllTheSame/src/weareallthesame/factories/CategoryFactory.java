package weareallthesame.factories;

import java.util.Iterator;

import weareallthesame.exceptions.CategoryDoesNotExistException;
import weareallthesame.model.categories.AbstractCategory;
import weareallthesame.model.categories.LettersCategory;
import weareallthesame.model.categories.ShapeCategory;
import weareallthesame.model.interfaces.TypeHolder;

public class CategoryFactory implements TypeHolder{

	/**
	 * Ovoj metod se koristi za kreiranje na kategorii
	 * @param type tipot so koj ednoznacno e opredelena kategorijata
	 * @return kategorija
	 * @throws CategoryDoesNotExistException ne znae da kreira kategorija za dadeniot tip
	 */
	public AbstractCategory getCategory(String type) throws CategoryDoesNotExistException{
		/* TODO ke treba da se doimplementira za dadeniot tip da se kreira soodvetnata kategorija.
			Treba da procita od baza. */
		
		if(type.equalsIgnoreCase("letters")){
			return new LettersCategory("Букви", "letters");
		}
		if(type.equalsIgnoreCase("shape")){
			return new ShapeCategory("Форми", "shape");
		}
		throw new CategoryDoesNotExistException("Ne postoi kategorija za dadeniot tip");
	}
	
	/**
	 * Ovoj metod ke vraka resurs za tip na kategorija
	 * @param type tipot na kategorijata
	 * @return resurs do slika za kategorijata
	 */
	public String getCategoryResource(String type){
		//TODO od baza da se napravi vcituvanje na resursot za dadenata kategorija
		return null;
	}
	
	public String getCategoryName(String type){
		//TODO od baza da se napravi vcituvanje na imeto za dadenata kategorija
		return null;
	}
	
	@Override
	public Iterator<String> getTypes() {
		/* TODO da se procitaat kateoriite od baza ili staticki vo lista da se dodadat kako sto imam
		  	vo HangmanCommandFactory getTypes() metodot */
		return null;
	}

}
