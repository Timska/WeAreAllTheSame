package weareallthesame.view.games.choosecharacterfromsoundgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class ChooseCharacterFromSoundActivity extends Activity implements
		ChooseStringFromSoundViewInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7323382117223325759L;
	public static final int TEXTVIEWCOLOR = Color.rgb(88, 243, 129);
	public static final int DROPPLACECOLOR=Color.rgb(107, 205, 237);
	public static final String CORRECT="Correct";
	public static final String WRONG="Wrong";
	private DisplayMetrics displayMetrics;
	private ArrayList<TextView> answers;
	private int width, height;
	private Item correctAnswer;
	private ArrayList<String> answersString;
	private MediaPlayer mMediaPlayer;
	private Button playButton;
	private Animation animation;
	private TextView dropPlace;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_character_from_sound);

		openGame();
		getMetrics();

		answers = new ArrayList<TextView>();
		answersString = new ArrayList<String>();
		animation = AnimationUtils.loadAnimation(this,
				R.anim.choose_character_from_sound_animation_scaling);

		initiliazeViews();
		setButtonSound();

		setAnswers();
		setTextViews();

		for (int i = 0; i < answers.size(); ++i) {
			answers.get(i).setTag(i + " ");
			answers.get(i).setOnLongClickListener(new MyClickListener());
		}
	
		answers.get(2).setTag(CORRECT);
		dropPlace.setOnDragListener(new MyDragListener(mMediaPlayer));

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void initiliazeViews() {
		playButton = (Button) findViewById(R.id.choose_character_from_sound_play_buttons);
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_one));
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_two));
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_three));
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_four));
		dropPlace = (TextView) findViewById(R.id.choose_character_from_sound_drop_pool);

	}

	private void setButtonSound() {

		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(this, R.raw.slow_whoop_bubble_pop);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer.start();
	}

	public void playButtonOnClick(View v) {
		mMediaPlayer.start();
		setTextViews();
		playButton.startAnimation(animation);
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
											R.string.choose_character_from_sound_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setTextViews() {

		for (int i = 0; i < answers.size(); ++i) {
			answers.get(i).setWidth(width / 3);
			answers.get(i).setHeight(height / 8);
			answers.get(i).setBackground(getGradientDrawable(TEXTVIEWCOLOR));
			answers.get(i).setText(answersString.get(i));
		}

		GradientDrawable gd=getGradientDrawable(DROPPLACECOLOR);
		gd.setShape(GradientDrawable.RECTANGLE);
		dropPlace.setBackground(gd);
		dropPlace.setText(getResources().getString(R.string.drop_place_description));
		
	}

	private void setAnswers() {
		answersString = new ArrayList<String>();
		answersString.add("I");
		answersString.add("A");
		answersString.add("M");
		answersString.add("Z");

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
	public void setAnswer(Item item) {
		// TODO Auto-generated method stub
		this.correctAnswer=item;
		
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wrongAnswer() {
		// TODO Auto-generated method stub

		Toast.makeText(getApplicationContext(), "Неточен одговор", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setOfferedAnswers(Set<String> allOfferedLetters) {
		// TODO Auto-generated method stub
		Iterator<String> it = allOfferedLetters.iterator();
		while (it.hasNext()) {
			answersString.add(it.next());
		}
		int indexOfCorrectAnswer=answersString.indexOf(correctAnswer.getName());
		
		for (int i = 0; i < answers.size(); ++i) {
			answers.get(i).setWidth(width / 3);
			answers.get(i).setHeight(height / 8);
			answers.get(i).setBackground(getGradientDrawable(TEXTVIEWCOLOR));
			answers.get(i).setText(answersString.get(i));
			answers.get(i).setTag(WRONG);
		}
		answers.get(indexOfCorrectAnswer).setTag(CORRECT);
	}
}
