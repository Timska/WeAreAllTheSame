package weareallthesame.model.interfaces;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;

public interface ChooseStringInterface {

	public void chooseAnswer(String str) throws CommandException, GameOverException;
}
