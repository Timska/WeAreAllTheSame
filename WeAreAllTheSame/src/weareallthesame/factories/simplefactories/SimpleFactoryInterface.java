package weareallthesame.factories.simplefactories;

public interface SimpleFactoryInterface {

	/**
	 * So ovoj metod se dobiva objekt od tip T na odredena pozicija.
	 * @param position pozicijata na bukvata sto sakame da ja dobieme od 0 do 31 vo makedonskata azbuka, kade 0=A
	 * @return objektot na pozicijata definirana so parametarot position
	 */
	public String getOnPosition(int position);
	

	/**
	 * So ovoj metod se dobiva slucajno izbran objekt od tip T.
	 * @return slucajno izbraniot objekt
	 */
	public String getDefault();
	
	/**
	 * So ovoj metod se sporeduvaat dva objekti od tip T.
	 * @param o1 prviot objekt sto se sporeduva
	 * @param o2 vtoriot objekt sto se soreduva
	 * @return 0 ako dvata objekti se ednakvi, -1 ako prviot objekt e pred vtoriot,
	 * 1 ako vtoriot objekt e pred prviot
	 */
	public int compare(String o1, String o2);
}
