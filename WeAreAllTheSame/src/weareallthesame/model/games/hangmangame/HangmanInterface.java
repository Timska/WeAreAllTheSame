package weareallthesame.model.games.hangmangame;

import java.io.Serializable;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;


/**
 * Ovoj interfejs ke treba da go implementira/at hangman igrite
 * @author i5
 *
 */
public interface HangmanInterface extends Serializable {

	/**
	 * Ovoj metod zema edna od ponudenite bukvi i ja smestuva na dadena pozicija vo odgovorot
	 * @param positionFrom koja od ponudenite bukvi e izbrana
	 * @param positionTo na koja pozicija vo odgovorot da se smesti dadenata bukva
	 * @throws GameOverException ne moze da se povika metodot ako igrata e zavrsena
	 * @throws CommandException 
	 * 
	 */
	public void setLetter(int positionFrom, int positionTo) throws GameOverException, CommandException;
	
	/**
	 * Ovoj metod trga veke postavena bukva od odgovorot
	 * @param positionFrom pozicijata na koja se naoga bukvata vo odgovorot sto sakame da ja trgneme
	 * @param positionTo pozicijata na koja sme ja cuvale taa bukva pred da bide postavena
	 * @throws GameOverException ne moze da se povika metodot ako igrata e zavrsena
	 * @throws CommandException 
	 * 
	 */
	public void removeLetter(int positionFrom, int positionTo) throws GameOverException, CommandException;
}
