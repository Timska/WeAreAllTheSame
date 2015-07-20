package weareallthesame.model.interfaces;

public interface Typable {

	/**
	 * Ovoj metod e povrzan so {@link TypeHolder} interfejsot, odnosno so
	 * {@link TypeHolder#getTypes()} metodot od koj se dobivaat tipovi od koi
	 * vusnost eden e dadeniot tip.
	 * 
	 * @return tip na objektot na koj e povikan ovoj metod.
	 */
	public String getType();
}
