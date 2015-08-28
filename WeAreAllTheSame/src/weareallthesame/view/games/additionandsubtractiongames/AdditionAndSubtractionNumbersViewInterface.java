package weareallthesame.view.games.additionandsubtractiongames;

import java.io.Serializable;
import java.util.Set;

public interface AdditionAndSubtractionNumbersViewInterface extends Serializable {

	/**
	 * Ovoj metod se koristi za da se setiraat broevite koi se sobiraat ili odzemaat.
	 * @param numberOne
	 * @param numberTwo
	 */
	public void setNumbers(int numberOne, int numberTwo);
	
	/**
	 * So ovoj metod se setiraat ponudenite odgovori.
	 * @param answers
	 */
	public void setOfferedAnswers(Set<Integer> answers);
	
	/**
	 * So ovoj metod se izvestuva view-to deka igrata zavrsi.
	 */
	public void gameOver();
	
	/**
	 * So ovoj metod se izvestuva view-to deka korisnikot odgovoril pogresno.
	 */
	public void wrongAnswer();

	/**
	 * So ovoj metod se setira koj operator ke se koristi vo igrata.
	 * @param addition ako e true togas e sobiranje, ako e false togas e odzemanje
	 */
	public void setAdditionOperator(boolean addition);
}
