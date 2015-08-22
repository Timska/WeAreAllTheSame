package weareallthesame.view.games.chooseoperatorgames;

import java.util.Set;

public interface ChooseOperatorBetweenNumbersViewInterface {

	/**
	 * So ovoj metod se setiraat ponudenite odgovori.
	 * @param operators operatorite koi moze da gi iskoristi
	 */
	public void setOfferedOperators(Set<Character> operators);

	/**
	 * So ovoj metod se setiraat broevite vrz koi se pravi nepoznatata operacija i rezultatot
	 * od taa operacija.
	 * @param numberOne prviot broj
	 * @param numberTwo vtoriot broj
	 * @param result rezultatot
	 */
	public void setNumbers(int numberOne, int numberTwo, int result);

	/**
	 * So ovoj metod se izvestuva view-to deka igrata zavrsi.
	 */
	public void gameOver();
	
	/**
	 * So ovoj metod se izvestuva view-to deka korisnikot odgovoril pogresno.
	 */
	public void wrongAnswer();
}
