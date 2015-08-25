package weareallthesame.view.games.classifyitemsgames;

import java.util.ArrayList;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClassifyTheElementsActivity extends Activity {

	private ArrayList<TextView> elements;
	private ArrayList<String> elementsGroupOne;
	private ArrayList<String> elementsGroupTwo;
	private LinearLayout groupOne;
	private LinearLayout groupTwo;
	private GridView container;
	private ApplicationInterface appInterface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify_the_elements);
		
		openGame();
		
		elements=new ArrayList<TextView>();
		elementsGroupOne=new ArrayList<String>();
		elementsGroupTwo=new ArrayList<String>();
		
		container=(GridView) findViewById(R.id.classify_elements_container);
		groupOne=(LinearLayout) findViewById(R.id.classify_elements_group_one);
		groupTwo=(LinearLayout) findViewById(R.id.classify_elements_group_two);
		
	}

	private void openGame() {
		Intent intent = getIntent();
		String gameType = intent.getStringExtra("gameType");
		ArrayList<String> gameTags = intent.getStringArrayListExtra("gameTags");
		appInterface = (ApplicationInterface) intent.getSerializableExtra("appInterface");
		try{
			appInterface.openGame(gameType, gameTags.iterator(), this, this.getResources().getString(R.string.choose_character_from_sound_task_description));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
