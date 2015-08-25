package weareallthesame.view.games.hangmangame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HangmanGameActivity extends Activity implements
		HangmanViewInterface {

	private static final long serialVersionUID = 6373187583074782521L;

	private ArrayList<TextView> listLetters;
	private ArrayList<TextView> listSpaces;
	private ArrayList<Integer> colors;
	private TextView txtPicture;
	private LinearLayout layoutLetters;
	private LinearLayout layoutSpaces;
	private Random r = new Random();
	private String word = "AVION";
	private String spaces = "AV_O_";
	private DisplayMetrics displayMetrics;
	private int width, height;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hangman_game);

		openGame();
		
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

		listLetters = new ArrayList<TextView>();
		listSpaces = new ArrayList<TextView>();
		colors = generateColors();

		setTextViews(word, spaces);
		txtPicture=(TextView) findViewById(R.id.hangman_game_picture);
		txtPicture.setBackgroundColor(Color.RED);
		txtPicture.setText("Picture");
		
		layoutSpaces = (LinearLayout) findViewById(R.id.hangman_game_layout_spaces);
		layoutLetters = (LinearLayout) findViewById(R.id.hangman_game_layout_letters);

		LinearLayout.LayoutParams layoutParamsSpaces = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutSpaces.setOrientation(LinearLayout.VERTICAL);
		layoutParamsSpaces.setMargins(0, 5, 0, 5);

		LinearLayout.LayoutParams layoutParamsLetters = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParamsLetters.setMargins(5, 0, 5, 0);
		//layoutParamsLetters.gravity = Gravity.CENTER | Gravity.BOTTOM;

		for (int i = 0; i < listLetters.size(); ++i) {
			layoutSpaces.addView(listSpaces.get(i), layoutParamsSpaces);
			layoutLetters.addView(listLetters.get(i), layoutParamsLetters);

		}

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

	private void setTextViews(String word, String spaces) {

		for (int i = 0; i < word.length(); ++i) {

			TextView txLetter = new TextView(getApplicationContext());
	
			TextView txS = new TextView(getApplicationContext());

			txS.setBackground(getGradientDrawable());
			GradientDrawable gd=getGradientDrawable();
			gd.setShape(GradientDrawable.OVAL);
			txLetter.setBackground(gd);

			txLetter.setText(word.charAt(i) + " ");
			txS.setText(spaces.charAt(i) + " ");

			txLetter.setTextAppearance(getApplicationContext(),
					android.R.style.TextAppearance_Large);
			txS.setTextAppearance(getApplicationContext(),
					android.R.style.TextAppearance_Large);

			txLetter.setGravity(Gravity.CENTER);
			txS.setGravity(Gravity.CENTER);

			txLetter.setTextColor(Color.BLACK);
			txS.setTextColor(Color.BLACK);

			txLetter.setWidth(width / (spaces.length() + 1));
			txS.setWidth(width / 3);

			txLetter.setHeight(height / 10);
			txS.setHeight(height / 10);
			

			listLetters.add(txLetter);
			listSpaces.add(txS);
		}
		for(int k=0;k<listLetters.size();++k){
			System.out.println(listSpaces.get(k).getText());
		}

	}

	private ArrayList<Integer> generateColors() {

		ArrayList<Integer> colors = new ArrayList<Integer>();
		colors.add(Color.rgb(235, 77, 77));
		colors.add(Color.rgb(88, 243, 129));
		colors.add(Color.rgb(192, 142, 213));
		colors.add(Color.rgb(137, 170, 220));
		colors.add(Color.rgb(88, 243, 129));
		// colors.add(Color.rgb(244, 252, 244));
		colors.add(Color.rgb(255, 255, 102));

		return colors;
	}

	private GradientDrawable getGradientDrawable() {

		int i = colors.get(r.nextInt(colors.size()));
		GradientDrawable gd = new GradientDrawable();
		gd.setColor(i);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.RECTANGLE);
		// gd.setStroke(1, 0xFF000000);
		gd.setStroke(2, Color.BLACK, 5, 5);

		return gd;

	}
}
