package weareallthesame.model.games.hangmangame;

import weareallthesame.model.exceptions.GameOverException;

public interface HangmanStandardInterface {

	public void chooseLetter(Character letter) throws GameOverException;
}
