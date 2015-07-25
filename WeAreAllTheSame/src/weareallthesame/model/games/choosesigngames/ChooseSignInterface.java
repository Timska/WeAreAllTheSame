package weareallthesame.model.games.choosesigngames;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface ChooseSignInterface {

	public void chooseSign(Character sign) throws CommandException, GameOverException;
}
