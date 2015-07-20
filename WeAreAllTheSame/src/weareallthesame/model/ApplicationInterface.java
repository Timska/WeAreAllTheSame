package weareallthesame.model;

import java.util.Iterator;

import weareallthesame.exceptions.CategoryDoesNotExistException;
import weareallthesame.factories.CategoryFactory;
import weareallthesame.model.categories.CategoryInterface;

public class ApplicationInterface {

	private CategoryFactory categoryFactory;
	private CategoryInterface currentCategory;
	
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
	public void setCategory(String type) throws CategoryDoesNotExistException{
		currentCategory = categoryFactory.getCategory(type);
	}
}
