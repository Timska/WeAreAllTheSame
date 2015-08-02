package weareallthesame.view.games.hangmangame;

import java.util.List;

import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HangmanGameActivity extends Activity implements HangmanViewInterface {

	private static final long serialVersionUID = 6373187583074782521L;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hangman_game);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hangman_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrUpdateOfferedLettersAndUsedLetters(
			List<Character> allOfferedLetters, List<Boolean> usedLettersFlagged) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrUpdateUserAnswer(List<Character> userAnswer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAnswer(Item item) {
		// TODO Auto-generated method stub
		
	}
}
