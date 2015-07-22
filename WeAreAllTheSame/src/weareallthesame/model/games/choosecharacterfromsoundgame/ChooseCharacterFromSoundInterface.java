package weareallthesame.model.games.choosecharacterfromsoundgame;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface ChooseCharacterFromSoundInterface {

	public void chooseAnswer(String str) throws CommandException, GameOverException;
}
