package weareallthesame.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.adapters.GamesAdapter;
import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.exceptions.CategoryNotChosenException;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class GameActivity extends Activity {

	private ApplicationInterface appInterface;
	private ListView gamesList;
	private GamesAdapter gameAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		appInterface = (ApplicationInterface) getIntent().getSerializableExtra("appInterface");
		gamesList = (ListView) findViewById(R.id.games_listView);
		
		try {
			Iterator<String> iterr = appInterface.getGamesFromOpenedCategory();
			List<String> games = new ArrayList<String>();
			while (iterr.hasNext()) {
				games.add(iterr.next());
			}
			gameAdapter = new GamesAdapter(this, games, appInterface);
		} catch (CategoryNotChosenException e) {
			e.printStackTrace();
		}
		gamesList.setAdapter(gameAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
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
	public void onBackPressed(){
		try {
			super.onBackPressed();
			appInterface.closeCategory();
		} catch (CategoryNotChosenException e) {
			e.printStackTrace();
		}
	}
}
