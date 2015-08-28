package weareallthesame.view.games.choosecharacterfromsoundgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class ChooseCharacterFromSoundActivity extends Activity implements
		ChooseStringFromSoundViewInterface {

	/**
	 * Activity za igra vo koja korisnikot bira znak vrz osnova na dadeniot zvuk
	 *
	 */
	private static final long serialVersionUID = -7323382117223325759L;
	public static final int TEXTVIEWCOLOR = Color.rgb(88, 243, 129);
	public static final int DROPPLACECOLOR = Color.rgb(107, 205, 237);
	public static final String CORRECT = "Correct";
	public static final String WRONG = "Wrong";
	private DisplayMetrics displayMetrics;
	private int width, height;
	private Item correctAnswer;
	private ArrayList<String> answersString;
	private MediaPlayer mMediaPlayer;
	private Button playButton;
	private Animation animation;
	private ApplicationInterface appInterface;
	private GridView answersContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_character_from_sound);

		getMetrics();

		answersString = new ArrayList<String>();
		animation = AnimationUtils.loadAnimation(this,
				R.anim.choose_character_from_sound_animation_scaling);

		initiliazeViews();

		openGame();

		setButtonSound();

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void initiliazeViews() {
		playButton = (Button) findViewById(R.id.choose_character_from_sound_play_buttons);
		answersContainer = (GridView) findViewById(R.id.choose_character_from_sound_answers_container);
	}

	private void setButtonSound() {

		mMediaPlayer = new MediaPlayer();
		System.out.println(correctAnswer.getResourceNames().get("sound"));
		mMediaPlayer = MediaPlayer.create(
				this,
				this.getResources().getIdentifier(
						correctAnswer.getResourceNames().get("sound"), "raw",
						this.getPackageName()));
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer.start();
	}

	public void playButtonOnClick(View v) {
		mMediaPlayer.start();
		playButton.startAnimation(animation);
	}

	private void openGame() {
		Intent intent = this.getIntent();
		String gameType = intent.getExtras().getString("gameType");
		System.out.println(gameType);
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

	@Override
	public void setAnswer(Item item) {
		this.correctAnswer = item;
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
		mMediaPlayer.start();
		Toast.makeText(getApplicationContext(), "Неточен одговор",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setOfferedAnswers(Set<String> allOfferedLetters) {

		System.out.println("Vo offered answers");

		Iterator<String> it = allOfferedLetters.iterator();
		while (it.hasNext()) {
			answersString.add(it.next());
		}

		int txtWidth = width / 4;
		int txtHeight = height / (answersString.size() / 4 + 1);
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");

		answersContainer.setAdapter(new CharactersTextViewAdapter(this,
				answersString, tf, txtWidth, txtHeight));

		answersContainer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				TextView tx = (TextView) view;
				try {
					appInterface.executeCommand("ChooseString", tx.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}
}
