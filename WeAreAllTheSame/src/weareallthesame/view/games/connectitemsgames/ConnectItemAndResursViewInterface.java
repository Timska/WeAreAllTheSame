package weareallthesame.view.games.connectitemsgames;

import java.io.Serializable;
import java.util.List;

import weareallthesame.model.items.Item;

public interface ConnectItemAndResursViewInterface extends Serializable {

	
	/**
	 * So ovoj metod se setiraat dvete listi cii elementi treba da se povrzuvaat.
	 * @param items itemi
	 * @param strings stringovi
	 */
	public void initArrays(List<Item> items, List<String> strings);

	/**
	 * So ovoj metod se kazuva koj element od ednata lista e povrzan so koj element od drugata lista.
	 * @param connections konekciite pomegu listite, connections[i] oznacuva deka i-tiot element od
	 * prvata lista e povrzan so elementot na pozicija connections[i] vo vtorata lista
	 */
	public void initConnections(int[] connections);

	/**
	 * So ovoj metod se izvestuva view-to deka korisnikot odgovoril pogresno.
	 */
	public void wrongAnswer();

	/**
	 * So ovoj metod se izvestuva view-to deka igrata zavrsi.
	 */
	public void gameOver();

}
