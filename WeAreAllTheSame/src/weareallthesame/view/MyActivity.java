package weareallthesame.view;

import weareallthesame.view.games.additionandsubtractiongames.AdditionAndSubstractionNumbersActivity;
import weareallthesame.view.games.choosecharacterfromsoundgame.ChooseCharacterFromSoundActivity;
import weareallthesame.view.games.choosecharacterfromsoundgame.ChooseStringFromSoundViewInterface;
import weareallthesame.view.games.chooseoperatorgames.ChooseOperatorNumbersActivity;
import weareallthesame.view.games.choosesigngames.ChooseSignBetweenNumbers;
import weareallthesame.view.games.classifyitemsgames.ClassifyTheElementsActivity;
import weareallthesame.view.games.connectitemsgames.ConnectItemsActivity;
import weareallthesame.view.games.hangmangame.HangmanGameStandardActivity;
import weareallthesame.view.games.hangmangame.LettersListActivity;
import weareallthesame.view.games.howmanygame.HowManyObjectsActivity;
import weareallthesame.view.games.orderelementsgame.OrderElementsActivity;
import weareallthesame.view.games.questiongame.QuestionGameActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyActivity extends Activity {

	Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		
		
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent intent=new Intent(MyActivity.this, ChooseCharacterFromSoundActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
