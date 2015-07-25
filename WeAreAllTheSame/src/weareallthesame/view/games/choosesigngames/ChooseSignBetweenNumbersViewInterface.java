package weareallthesame.view.games.choosesigngames;

import java.util.Set;

public interface ChooseSignBetweenNumbersViewInterface {

	/**
	 * So ovoj metod se setiraat broevite koi se sporeduvaat.
	 * @param numOne
	 * @param numTwo
	 */
	public void setNumbers(int numOne, int numTwo);
	
	/**
	 * So ovoj metod se setiraat ponudenite znaci.
	 * @param signs
	 */
	public void setOfferedSigns(Set<Character> signs);
	
	/**
	 * So ovoj metod se izvestuva view-to deka igrata zavrsi.
	 */
	public void gameOver();
	
	/**
	 * So ovoj metod se izvestuva view-to deka korisnikot odgovoril pogresno.
	 */
	public void wrongAnswer();
}
