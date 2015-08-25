package weareallthesame.view.games.hangmangame;

import java.util.ArrayList;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class HangmanGameStandardActivity extends Activity {

	private LinearLayout wordWithEmptySpaces;
	private ArrayList<TextView> txtWordWithEmptySpaces;
	private String word = "M_r_ja";
	private DisplayMetrics displayMetrics;
	private int width, height;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hangman_game_standard);

		openGame();
		
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

		wordWithEmptySpaces = (LinearLayout) findViewById(R.id.hangman_game_standard_layout_word_with_empty_letters);
		LinearLayout.LayoutParams layParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		wordWithEmptySpaces.setOrientation(LinearLayout.VERTICAL);
		layParams.setMargins(0, 5, 0, 5);

		addTextViews(layParams);

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

	private void addTextViews(LayoutParams layParams) {

		txtWordWithEmptySpaces = new ArrayList<TextView>();
		for (int i = 0; i < word.length(); ++i) {
			TextView tx = new TextView(getApplicationContext());
			tx.setBackground(getGradientDrawable());
			tx.setText(word.charAt(i) + " ");
			tx.setWidth(width / 3);
			tx.setHeight(height / 10);
			tx.setGravity(Gravity.CENTER);
			tx.setTextColor(Color.BLACK);
			tx.setTextSize(50);
			txtWordWithEmptySpaces.add(tx);
			wordWithEmptySpaces.addView(tx, layParams);
		}

	}

	private GradientDrawable getGradientDrawable() {

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(Color.rgb(225, 125, 105));
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.RECTANGLE);
		// gd.setStroke(1, 0xFF000000);
		gd.setStroke(2, Color.BLACK, 5, 5);
		return gd;
	}
	
	public void onClickChooseLetter(View view){
		
		Intent intent=new Intent(HangmanGameStandardActivity.this, LettersListActivity.class);
		startActivity(intent);
		
	}

}
