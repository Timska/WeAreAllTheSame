package weareallthesame.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GameOverChoiceActivity extends Activity {

	private Button btnNewGame;
	private Button btnGoBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_over_choice);
		
		init();
	}
	
	public void init(){
		btnNewGame = (Button) findViewById(R.id.new_game_button);
		btnNewGame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent resutlIntent = new Intent();
				resutlIntent.putExtra("result", "NEW");
				setResult(RESULT_OK, resutlIntent);
				finish();
			}
		});
		
		btnGoBack = (Button) this.findViewById(R.id.go_back_button);
		btnGoBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent resutlIntent = new Intent();
				resutlIntent.putExtra("result", "BACK");
				setResult(RESULT_OK, resutlIntent);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_over_choice, menu);
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
