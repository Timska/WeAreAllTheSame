package weareallthesame.factories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.db.CategoryContentProvider;
import weareallthesame.db.CategoryOpenHelper;
import weareallthesame.model.categories.AbstractCategory;
import weareallthesame.model.categories.CategoryAnimals;
import weareallthesame.model.categories.CategoryClothesAndBodyParts;
import weareallthesame.model.categories.CategoryColorsAndObjects;
import weareallthesame.model.categories.CategoryDay;
import weareallthesame.model.categories.CategoryEmotions;
import weareallthesame.model.categories.CategoryFruitsAndVegetables;
import weareallthesame.model.categories.CategoryLetters;
import weareallthesame.model.categories.CategoryNumbers;
import weareallthesame.model.categories.CategoryPrepositions;
import weareallthesame.model.categories.CategoryShapes;
import weareallthesame.model.categories.CategoryWeather;
import weareallthesame.model.categories.CategoryYear;
import weareallthesame.model.exceptions.CategoryDoesNotExistException;
import weareallthesame.model.interfaces.TypeHolder;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;

public class CategoryFactory implements TypeHolder {

	// Contekstot (odnosno Activity) ni treba za da moze ContentResolver-ot da
	// se inicijalizira
	// Namesto da se povikuva konstruktor, moze i kako parametar vo potrebnite
	// metodi da se pusti
	private Context ctx;
	// Sluzi za povici do bazata
	private ContentResolver resolver;

	public CategoryFactory(Context ctx) {
		this.ctx = ctx;
		resolver = ctx.getContentResolver();
	}

	public CategoryFactory() {

	}

	public Context getContext() {
		return ctx;
	}

	/**
	 * Ovoj metod se koristi za kreiranje na kategorii
	 * 
	 * @param type
	 *            tipot so koj ednoznacno e opredelena kategorijata
	 * @return kategorija
	 * @throws CategoryDoesNotExistException
	 *             ne znae da kreira kategorija za dadeniot tip
	 */
	public AbstractCategory getCategory(String type)
			throws CategoryDoesNotExistException {
		/*
		 * TODO ke treba da se doimplementira za dadeniot tip da se kreira
		 * soodvetnata kategorija. Treba da procita od baza.
		 */

		if (type.equalsIgnoreCase("letters")) {
			return new CategoryLetters(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("shapes")) {
			return new CategoryShapes(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("numbers")) {
			return new CategoryNumbers(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("animals")) {
			return new CategoryAnimals(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("fruitsandvegetables")) {
			return new CategoryFruitsAndVegetables(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("weather")) {
			return new CategoryWeather(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("year")) {
			return new CategoryYear(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("day")) {
			return new CategoryDay(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("colorsandobjects")) {
			return new CategoryColorsAndObjects(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("prepositions")) {
			return new CategoryPrepositions(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("clothesandbodyparts")) {
			return new CategoryClothesAndBodyParts(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("emotions")) {
			return new CategoryEmotions(getCategoryName(type),
					getCategoryResource(type));
		}
		throw new CategoryDoesNotExistException(
				"Ne postoi kategorija za dadeniot tip");
	}

	/**
	 * Ovoj metod ke vraka resurs za tip na kategorija
	 * 
	 * @param type
	 *            tipot na kategorijata
	 * @return resurs do slika za kategorijata
	 */

	public String getCategoryResource(String type) {
		// TODO od baza da se napravi vcituvanje na resursot za dadenata
		// kategorija
		Cursor cursor = resolver.query(CategoryContentProvider.CONTENT_URI,
				new String[] { CategoryOpenHelper.COLUMN_RESOURCE },
				CategoryOpenHelper.COLUMN_TYPE + "=" + type, null, null);
		if (cursor.moveToFirst()) {
			return cursor.getString(cursor
					.getColumnIndex(CategoryOpenHelper.COLUMN_RESOURCE));
		}
		// Se vrakja null ako nema nikakov rezultat
		return null;
	}

	public String getCategoryName(String type) {
		// TODO od baza da se napravi vcituvanje na imeto za dadenata kategorija
		Cursor cursor = resolver.query(CategoryContentProvider.CONTENT_URI,
				new String[] { CategoryOpenHelper.COLUMN_NAME },
				CategoryOpenHelper.COLUMN_TYPE + "=" + type, null, null);
		if (cursor.moveToFirst()) {
			return cursor.getString(cursor
					.getColumnIndex(CategoryOpenHelper.COLUMN_NAME));
		}
		// Se vrakja null ako nema nikakov rezultat
		return null;
	}

	@Override
	public Iterator<String> getTypes() {
		/*
		 * TODO da se procitaat kateoriite od baza ili staticki vo lista da se
		 * dodadat kako sto imam vo HangmanCommandFactory getTypes() metodot
		 */
		Cursor cursor = resolver.query(CategoryContentProvider.CONTENT_URI,
				new String[] { CategoryOpenHelper.COLUMN_TYPE }, null, null,
				null);
		List<String> types = new ArrayList<String>();
		while (cursor.moveToNext()) {
			String type = cursor.getString(cursor
					.getColumnIndex(CategoryOpenHelper.COLUMN_TYPE));
			types.add(type);
		}
		return types.iterator();
	}

}
