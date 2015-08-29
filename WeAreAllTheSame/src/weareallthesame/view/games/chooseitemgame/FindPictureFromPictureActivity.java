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
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class FindPictureFromPictureActivity extends Activity implements ChooseItemViewInterface {

	
	private ImageView answer;
	private ArrayList<ImageView> offeredAnswersImages;
	private ArrayList<Integer> offeredImagesResources;
	private DisplayMetrics displayMetrics;
	private MediaPlayer mMediaPlayer;
	private int width,height;
	private GridView answersContainer;
	private ApplicationInterface appInterface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_picture_from_picture);
		
		getMetrics();
		getMediaPlayer();
		initializeViews();
		offeredImagesResources=new ArrayList<Integer>();
		offeredAnswersImages=new ArrayList<ImageView>();
		openGame();
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
		
		answersContainer=(GridView) findViewById(R.id.find_the_picture_from_the_picture_answers_container);
		answer=(ImageView) findViewById(R.id.find_picture_from_picture_picture);

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
											R.string.find_picture_from_picture_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setAnswer(Item answer) {
		// TODO Auto-generated method stub
		
	this.answer.setBackgroundResource(getResources().getIdentifier(answer.getResourceNames().get("picture"), "raw", this.getPackageName()));
		
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
		Toast.makeText(getApplicationContext(), "Неточен одговор",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setOfferedAnswers(Set<Item> offeredAnswers) {
		// TODO Auto-generated method stub
		Iterator<Item> it=offeredAnswers.iterator();
		while(it.hasNext()){
			offeredImagesResources.add(getResources().getIdentifier(it.next().getResourceNames().get("picture"), "raw", this.getPackageName()));
		}
		answersContainer.setAdapter(new ChooseItemImageViewAdapter(this,offeredImagesResources,width,height));
		
	}
}
