package weareallthesame.view.games.chooseitemgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FindThePictureFromTheSoundActivity extends Activity implements
		ChooseItemViewInterface {

	private static final long serialVersionUID = -1366318460338234441L;

	private Button playSound;
	private GridView answersContainer;
	private MediaPlayer mMediaPlayer;
	private DisplayMetrics displayMetrics;
	private ApplicationInterface appInterface;
	private ArrayList<Integer> answerResources;
	private int width, height;
	private Item correctAnswer;
	private Item clickedItem;
	private ArrayList<Item> answers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_the_picture_from_the_sound);

		getMetrics();
		initializeViews();
		openGame();
		setButtonSound();

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void setButtonSound() {
		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(
				this,
				this.getResources().getIdentifier(
						correctAnswer.getResourceNames().get("sound"), "raw",
						this.getPackageName()));
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer.setOnPreparedListener(new OnPreparedListener() {
			
			@Override
			public void onPrepared(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mp.start();
			}
			
		});
		
	}

	private void initializeViews() {
		playSound = (Button) findViewById(R.id.find_picture_from_sound_button_play);
		answersContainer = (GridView) findViewById(R.id.find_picture_from_sound_answers_container);
	}

	public void onPlayButtonClick(View v) {
		mMediaPlayer.start();
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
							R.string.find_picture_from_sound_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setAnswer(Item answer) {
		// TODO Auto-generated method stub
		this.correctAnswer = answer;

		// mMediaPlayer = new MediaPlayer();
		// mMediaPlayer = MediaPlayer.create(
		// this,
		// this.getResources().getIdentifier(
		// answer.getResourceNames().get("sound"), "raw",
		// this.getPackageName()));
		// mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		// mMediaPlayer.start();

	}

	@Override
	public void setOfferedAnswers(Set<Item> offeredAnswers) {
		// TODO Auto-generated method stub
		answerResources = new ArrayList<Integer>();
		answers = new ArrayList<Item>();
		Iterator<Item> it = offeredAnswers.iterator();
		while (it.hasNext()) {
			Item item = it.next();
			answerResources.add(getResources().getIdentifier(
					item.getResourceNames().get("picture"), "drawable",
					this.getPackageName()));
			answers.add(item);
		}
		int imgWidth = width / 3;
		int imgHeight = height / (offeredAnswers.size() / 3 + 1);
		answersContainer.setAdapter(new ChooseItemImageViewAdapter(this,
				answerResources, imgWidth, imgHeight));

		answersContainer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				clickedItem = answers.get(position);
				try {
					appInterface.executeCommand("ChooseItem", clickedItem);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	@Override
	public void gameOver() {
		mMediaPlayer.release();
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
		Toast.makeText(getApplicationContext(), "Неточен одговор",
				Toast.LENGTH_SHORT).show();
	}



}
