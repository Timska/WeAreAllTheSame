package weareallthesame.view.games.hangmangame;

import java.util.List;

public interface HangmanStandardViewInterface {

	/**
	 * So ovoj metod se setira zborot koj treba da se pogodi vo besilka.
	 * @param answer zborot koj treba da se pogodi
	 */
	public void setAnswer(String answer);

	/**
	 * So ovoj metod se setiraat bukvite koi gi ima izbrano korisnikot.
	 * @param usedLetters bukvite koi dotogas gi ima izbrano korisnikot bez razlika dali
	 * bile del od zborot ili ne
	 */
	public void setOrUpdateUsedLetters(List<Character> usedLetters);
	
	/**
	 * So ovoj metod se setira odgovorot na korisnikot.
	 * @param userAnswer lista od karakteri koja pokazuva dali na dadena pozicija ima pogodeno
	 * bukva ili ne.
	 */
	public void setOrUpdateUserAnswer(List<Character> userAnswer);

	/**
	 * So ovoj metod se izvestuva korisnikot deka izbranata bukva ja ima prehodno iskoristeno.
	 * @param letter bukvata sto e iskoristena
	 */
	public void usedLetter(Character letter);

	/**
	 * So ovoj metod se izvestuva korisnikot deka bukvata sto ja izbral ja nema vo odgovorot.
	 */
	public void letterNotFound();

	/**
	 * So ovoj metod se izvestuva korisnikot deka igrata zavrsi.
	 */
	public void gameOver();
}
