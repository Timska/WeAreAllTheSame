package weareallthesame.factories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.db.CategoryContentProvider;
import weareallthesame.db.CategoryOpenHelper;
import weareallthesame.exceptions.CategoryDoesNotExistException;
import weareallthesame.model.categories.AbstractCategory;
import weareallthesame.model.categories.LettersCategory;
import weareallthesame.model.categories.ShapesCategory;
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
			return new LettersCategory(getCategoryName(type),
					getCategoryResource(type));
		}
		if (type.equalsIgnoreCase("shapes")) {
			return new ShapesCategory(getCategoryName(type),
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
