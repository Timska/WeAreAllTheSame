package weareallthesame.view.games.chooseitemgame;

import java.util.List;

import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import weareallthesame.view.R.id;
import weareallthesame.view.R.layout;
import weareallthesame.view.R.menu;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FindThePictureFromTheWordActivity extends Activity implements ChooseItemViewInterface {

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
