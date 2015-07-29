package weareallthesame.view.games.chooseitemgame;

import java.util.List;

import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class FindThePictureFromTheWordActivity extends Activity implements ChooseItemViewInterface {

	private Item answer; 
	private Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_the_picture_from_the_word);
	}

	@Override
	public void setAnswer(Item answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOfferedAnswers(List<Item> offeredAnswers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wrongAnswer() {
		// TODO Auto-generated method stub
		
	}

	
}
