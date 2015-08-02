package weareallthesame.model.interfaces;

import java.io.Serializable;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface ChooseStringInterface extends Serializable {

	public void chooseAnswer(String str) throws CommandException, GameOverException;
}
