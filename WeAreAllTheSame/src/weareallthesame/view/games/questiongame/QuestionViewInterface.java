package weareallthesame.view.games.questiongame;

import java.io.Serializable;
import java.util.Set;


public interface QuestionViewInterface extends Serializable {

	/**
	 * So ovoj metdo se setira prasanjeto na igrata.
	 * @param question prasanjaeto na igrata
	 */
	public void setQuestion(String question);

	/**
	 * So ovoj metod se setiraat ponudenite odgovori vo igrata.
	 * @param offeredAnswers ponudenite odgovori na postavenoto prasanje
	 */
	public void setOfferedAnswers(Set<String> offeredAnswers);

	/**
	 * So ovoj metod se izvestuva view-to deka igrata zavrsi.
	 */
	public void gameOver();

	/**
	 * So ovoj metod se izvestuva view-to deka korisnikot odgovoril pogresno
	 */
	public void wrongAnswer();
}
