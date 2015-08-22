package weareallthesame.model.games.chooseoperatorgames;

import java.io.Serializable;

import weareallthesame.model.exceptions.GameOverException;

public interface ChooseOperatorInterface extends Serializable {

	public void chooseOperator(Character operator) throws GameOverException;
}
