package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import weareallthesame.view.games.choosecharacterfromsoundgame.CharactersTextViewAdapter;
import weareallthesame.view.games.choosecharacterfromsoundgame.MyClickListener;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class AdditionAndSubstractionNumbersActivity extends Activity implements
		AdditionAndSubtractionNumbersViewInterface {

	public static final int NUMBERSCOLOR = Color.rgb(255, 131, 99);
	public static final int SIGNCOLOR = Color.rgb(255, 251, 131);
	public static final int ANSWERSCOLOR = Color.rgb(232, 161, 139);

	private DisplayMetrics displayMetrics;
	private ArrayList<TextView> numbersAndSigns;
	private ArrayList<TextView> answers;
	private ArrayList<Integer> colors;
	private ArrayList<String> answersInt;
	private MediaPlayer mMediaPlayer;
	private Random r = new Random();
	private int width, height;
	private ApplicationInterface appInterface;
	private GridView answersContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_numbers);

		getMetrics();
		getMediaPlayer();

		numbersAndSigns = new ArrayList<TextView>();

		initializeViews();

		openGame();

		// setAnswers();

		setTextViews();
		// addAnswers();

		/*
		 * for (TextView tx : answers) { tx.setOnTouchListener(new
		 * MyClickListener()); }
		 */
		// numbersAndSigns.get(4).setOnDragListener(new MyDragListener());

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void getMediaPlayer() {

		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(this, R.raw.slow_whoop_bubble_pop);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

	}

	private void initializeViews() {

		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_additioner_one));
		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_sign));
		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_additioner_two));
		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_equals_sign));
		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_result));

		answersContainer = (GridView) findViewById(R.id.addition_and_substraction_numbers_answers_container);

	}

	private void openGame() {
		Intent intent = getIntent();
		String gameType = intent.getStringExtra("gameType");
		ArrayList<String> gameTags = intent.getStringArrayListExtra("gameTags");
		appInterface = (ApplicationInterface) intent
				.getSerializableExtra("appInterface");
		try {
			appInterface
					.openGame(
							gameType,
							gameTags.iterator(),
							this,
							this.getResources()
									.getString(
											R.string.addition_and_substraction_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setTextViews() {

		for (int i = 0; i < numbersAndSigns.size(); ++i) {

			TextView tx = numbersAndSigns.get(i);
			tx.setBackground(getGradientDrawable(NUMBERSCOLOR));
			tx.setHeight(height / 11);
			tx.setTextColor(SIGNCOLOR);
			tx.setTextSize(30);
		}
		numbersAndSigns.get(3).setText("=");
		numbersAndSigns.get(4).setBackground(getGradientDrawable(SIGNCOLOR));
		numbersAndSigns.get(4).setTextColor(NUMBERSCOLOR);

	}

	private GradientDrawable getGradientDrawable(int color) {

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(color);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.OVAL);
		gd.setStroke(2, Color.BLACK, 5, 5);
		return gd;

	}

	@Override
	public void setNumbers(int numberOne, int numberTwo) {
		// TODO Auto-generated method stub

		numbersAndSigns.get(0).setText(Integer.toString(numberOne));
		numbersAndSigns.get(2).setText(Integer.toString(numberTwo));
	}

	@Override
	public void setOfferedAnswers(Set<Integer> answers) {
		// TODO Auto-generated method stubso
		System.out.println(answers.size());
		Iterator<Integer> it = answers.iterator();
		answersInt = new ArrayList<String>();
		while (it.hasNext()) {
			answersInt.add(Integer.toString(it.next()));
		}

		int txtWidth = width / 4;
		int txtHeight = height / (answersInt.size() / 4 + 1);
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");

		answersContainer
				.setAdapter(new AdditionAndSubstractionNumberTextViewAdapter(
						this, answersInt, tf, txtWidth, txtHeight, NUMBERSCOLOR));

		answersContainer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				TextView tx = (TextView) view;
				int number = Integer.parseInt((String) tx.getText());
				System.out.println(number);

				try {
					appInterface.executeCommand("ChooseNumber", number);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		// answersContainer
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
	public void wrongAnswer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAdditionOperator(boolean addition) {
		// TODO Auto-generated method stub

		if (addition) {
			numbersAndSigns.get(1).setText("+");
		} else {
			numbersAndSigns.get(1).setText("-");
		}
	}

}
