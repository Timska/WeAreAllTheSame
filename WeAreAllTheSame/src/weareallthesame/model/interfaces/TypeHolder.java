package weareallthesame.model.interfaces;

import java.util.Iterator;

public interface TypeHolder {
	
	/**
	 * Gi dava tipovite na objekti od konkretniot type holder. Sekoj objekt si ima svoj tip i
	 * toj tip moze da se dobie preku {@link Typable#getType()} metodot.
	 * @return lista od tipovi na objekti.
	 */
	public Iterator<String> getTypes();
}
