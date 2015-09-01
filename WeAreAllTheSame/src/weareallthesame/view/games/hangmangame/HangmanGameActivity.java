package weareallthesame.view.games.hangmangame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import weareallthesame.view.games.chooseitemgame.ChooseItemTextViewAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class HangmanGameActivity extends Activity implements
		HangmanViewInterface {

	private static final long serialVersionUID = 6373187583074782521L;
	private static final int COLORSPACES = Color.rgb(192, 142, 213);

	private ArrayList<TextView> listLetters;
	private ArrayList<TextView> listSpaces;
	private TextView txtPicture;
	private LinearLayout layoutSpaces;
	private String spaces;
	private DisplayMetrics displayMetrics;
	private int width, height;
	private ApplicationInterface appInterface;
	private ArrayList<Character> answerString;
	LinearLayout.LayoutParams layoutParamsSpaces;
	private GridView answersContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hangman_game);

		getMetrics();
		initializeViews();
		openGame();

		// layoutParamsLetters.gravity = Gravity.CENTER | Gravity.BOTTOM;

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

	}

	private void initializeViews() {
		answersContainer = (GridView) findViewById(R.id.hangman_game_answers_container);
		listLetters = new ArrayList<TextView>();
		listSpaces = new ArrayList<TextView>();

		txtPicture = (TextView) findViewById(R.id.hangman_game_picture);
		txtPicture.setBackgroundColor(Color.RED);
		// txtPicture.setText("Picture");

		layoutSpaces = (LinearLayout) findViewById(R.id.hangman_game_layout_spaces);

		layoutParamsSpaces = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, height / 20);
		layoutSpaces.setOrientation(LinearLayout.VERTICAL);
		layoutParamsSpaces.setMargins(0, 2, 0, 2);

		LinearLayout.LayoutParams layoutParamsLetters = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParamsLetters.setMargins(5, 0, 5, 0);

	}

	private void openGame() {
		Intent intent = getIntent();
		String gameType = intent.getStringExtra("gameType");
		ArrayList<String> gameTags = intent.getStringArrayListExtra("gameTags");
		appInterface = (ApplicationInterface) intent
				.getSerializableExtra("appInterface");
		try {
			appInterface.openGame(
					gameType,
					gameTags.iterator(),
					this,
					this.getResources().getString(
							R.string.hangman_game_task_descrtiption));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void gameOver() {
		Intent intent = new Intent(this, GameOverChoiceActivity.class);
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				String result = data.getExtras().getString("result");
				if (result.equals("NEW")) {

					Intent intent = new Intent(this, this.getClass());
					try {
						intent.putExtra("gameType",
								appInterface.getCurrentGameType());
					} catch (Exception e) {
						e.printStackTrace();
					}
					intent.putStringArrayListExtra("gameTags",
							appInterface.getCurrentGameTags());
					intent.putExtra("appInterface", appInterface);

					try {
						appInterface.exitGame();
					} catch (Exception e) {
						e.printStackTrace();
					}

					startActivity(intent);

					finish();
				} else if (result.equals("BACK")) {
					try {
						appInterface.exitGame();
					} catch (Exception e) {
						e.printStackTrace();
					}
					finish();
				}
			}
		}
	}

	@Override
	public void setOrUpdateOfferedLettersAndUsedLetters(
			List<Character> allOfferedLetters, List<Boolean> usedLettersFlagged) {
		// TODO Auto-generated method stub
		// ako e true ne ja postavuvaj, ako e false, da

		answerString = new ArrayList<Character>();

		for (int i = 0; i < usedLettersFlagged.size(); ++i) {

			if (!usedLettersFlagged.get(i)) {
				System.out.println("Pecati");
				answerString.add(allOfferedLetters.get(i));
				System.out
						.println(Character.toString(allOfferedLetters.get(i)));
			}
		}
		System.out.println(answerString.size());
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		answersContainer.setAdapter(new HangmanGameTextViewAdapter(this,
				answerString, tf, COLORSPACES));

		/*
		 * answersContainer.setOnItemClickListener(new OnItemClickListener() {
		 * 
		 * @Override public void onItemClick(AdapterView<?> parent, View view,
		 * int position, long id) { // TODO Auto-generated method stub
		 * 
		 * Item clickedItem = items.get(position); try {
		 * appInterface.executeCommand("ChooseItem", clickedItem); } catch
		 * (Exception e) { e.printStackTrace(); }
		 * 
		 * } });
		 */
	}

	@Override
	public void setOrUpdateUserAnswer(List<Character> userAnswer) {
		// TODO Auto-generated method stub
		System.out.println("Inside");
		spaces = "";
		for (int i = 0; i < userAnswer.size(); ++i) {
			spaces += userAnswer.get(i);
		}
		System.out.println(spaces);
		setTextViews(spaces);
		for (int i = 0; i < listSpaces.size(); ++i) {
			layoutSpaces.addView(listSpaces.get(i), layoutParamsSpaces);
			// layoutLetters.addView(listLetters.get(i), layoutParamsLetters);

		}
	}

	@Override
	public void setAnswer(Item item) {
		// TODO Auto-generated method stub
		int id = getResources().getIdentifier(
				item.getResourceNames().get("picture"), "drawable",
				this.getPackageName());
		txtPicture.setBackgroundResource(id);

	}

	private void setTextViews(String spaces) {

		for (int i = 0; i < spaces.length(); ++i) {

			// TextView txLetter = new TextView(getApplicationContext());

			TextView txS = new TextView(getApplicationContext());

			txS.setBackground(getGradientDrawable(COLORSPACES));
			// GradientDrawable gd=getGradientDrawable();
			// gd.setShape(GradientDrawable.OVAL);
			// txLetter.setBackground(gd);

			// txLetter.setText(word.charAt(i) + " ");
			txS.setText(spaces.charAt(i) + " ");

			// txLetter.setTextAppearance(getApplicationContext(),
			// android.R.style.TextAppearance_Large);
			txS.setTextAppearance(getApplicationContext(),
					android.R.style.TextAppearance_Large);

			// txLetter.setGravity(Gravity.CENTER);
			txS.setGravity(Gravity.CENTER);

			// txLetter.setTextColor(Color.BLACK);
			txS.setTextColor(Color.BLACK);

			// txLetter.setWidth(width / (spaces.length() + 1));
			txS.setWidth(width / 3);

			// txLetter.setHeight(height / 10);
			txS.setHeight(height / (15));

			// listLetters.add(txLetter);
			listSpaces.add(txS);
		}
		for (int k = 0; k < listLetters.size(); ++k) {
			System.out.println(listSpaces.get(k).getText());
		}

	}

	private GradientDrawable getGradientDrawable(int color) {

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(color);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.RECTANGLE);
		// gd.setStroke(1, 0xFF000000);
		gd.setStroke(2, Color.BLACK, 5, 5);

		return gd;

	}
}
