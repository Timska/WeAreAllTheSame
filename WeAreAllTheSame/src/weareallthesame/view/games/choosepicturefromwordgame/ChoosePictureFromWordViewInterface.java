package weareallthesame.view.games.choosepicturefromwordgame;

import java.util.List;

import weareallthesame.model.items.Item;

public interface ChoosePictureFromWordViewInterface {

	public void setAnswer(Item answer);

	public void setOfferedAnswers(List<Item> offeredAnswers);
	
	public void gameOver();
	
	public void wrongAnswer();

}
