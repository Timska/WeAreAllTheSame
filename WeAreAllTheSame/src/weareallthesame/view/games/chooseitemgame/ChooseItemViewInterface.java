package weareallthesame.view.games.chooseitemgame;

import java.util.List;

import weareallthesame.model.items.Item;

public interface ChooseItemViewInterface {

	public void setAnswer(Item answer);

	public void setOfferedAnswers(List<Item> offeredAnswers);
	
	public void gameOver();
	
	public void wrongAnswer();

}
