package weareallthesame.model.games.choosesigngames;

import java.io.Serializable;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface ChooseSignInterface extends Serializable {

	public void chooseSign(Character sign) throws CommandException, GameOverException;
}
