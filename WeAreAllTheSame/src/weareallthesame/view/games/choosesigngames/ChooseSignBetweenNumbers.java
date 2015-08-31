package weareallthesame.view.games.choosesigngames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseSignBetweenNumbers extends Activity implements
		ChooseSignBetweenNumbersViewInterface {

	private final static int COLORNUMBERS = Color.rgb(254, 154, 46);
	private final static int COLORSIGNS = Color.rgb(46, 255, 183);
	private DisplayMetrics displayMetrics;
	private ArrayList<TextView> numbersAndSigns;
	private ArrayList<TextView> answers;
	private ArrayList<Character> signsAnswers;
	private String operator;
	private MediaPlayer mMediaPlayer;
	private int width, height;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_sign_numbers);

		getMetrics();
		getMediaPlayer();
		answers = new ArrayList<TextView>();
		numbersAndSigns = new ArrayList<TextView>();
		initializeViews();
		openGame();
		setTextViews();

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
				.add((TextView) findViewById(R.id.choose_sign_numbers_smaller_bigger_element_one));
		numbersAndSigns
				.add((TextView) findViewById(R.id.choose_sign_numbers_smaller_bigger_sign));
		numbersAndSigns
				.add((TextView) findViewById(R.id.choose_sign_numbers_smaller_bigger_element_two));

		answers.add((TextView) findViewById(R.id.choose_sign_numbers_smaller_bigger_answer_one));
		answers.add((TextView) findViewById(R.id.choose_sign_numbers_smaller_bigger_answer_two));
		answers.add((TextView) findViewById(R.id.choose_sign_numbers_smaller_bigger_answer_three));
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
							R.string.choose_operator_numbers_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setTextViews() {

		for (int i = 0; i < numbersAndSigns.size(); ++i) {
			TextView tx = numbersAndSigns.get(i);
			tx.setBackground(getGradientDrawable(COLORNUMBERS));
			tx.setTextColor(COLORSIGNS);
			tx.setHeight(height / 10);

		}
		numbersAndSigns.get(1).setBackground(getGradientDrawable(COLORSIGNS));
		numbersAndSigns.get(1).setTextColor(COLORNUMBERS);
		for (int i = 0; i < answers.size(); ++i) {

			TextView tx = answers.get(i);
			tx.setBackground(getGradientDrawable(COLORSIGNS));
			tx.setTextColor(COLORNUMBERS);
			tx.setHeight(height / 10);
			tx.setWidth(width / 4);
		}

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
	public void setNumbers(int numOne, int numTwo) {
		// TODO Auto-generated method stub
		numbersAndSigns.get(0).setText(Integer.toString(numOne));
		numbersAndSigns.get(2).setText(Integer.toString(numTwo));
	}

	@Override
	public void setOfferedSigns(Set<Character> signs) {
		// TODO Auto-generated method stub
		signsAnswers = new ArrayList<Character>();
		Iterator<Character> it = signs.iterator();
		System.out.println(signs.size());
		while (it.hasNext()) {
			Character c = it.next();
			System.out.println("char " + c);
			signsAnswers.add(c);
		}
		System.out.println(signsAnswers.size());
		for (int i = 0; i < signsAnswers.size(); ++i) {
			answers.get(i).setText(Character.toString(signsAnswers.get(i)));
			answers.get(i).setOnClickListener(new MyTouchListener());
		}

	}

	@Override
	public void gameOver() {
		mMediaPlayer.start();
		numbersAndSigns.get(1).setBackground(getGradientDrawable(COLORNUMBERS));
		numbersAndSigns.get(1).setText(operator);
		numbersAndSigns.get(1).setTextColor(COLORSIGNS);
		mMediaPlayer.start();
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

		Toast.makeText(getApplicationContext(), "Неточен одговор",
				Toast.LENGTH_SHORT).show();

	}

	private final class MyTouchListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			TextView tx = (TextView) v;
			operator = (String) tx.getText();
			try {
				appInterface.executeCommand("ChooseSign", operator.charAt(0));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
