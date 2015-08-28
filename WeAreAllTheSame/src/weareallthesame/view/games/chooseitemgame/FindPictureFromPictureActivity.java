package weareallthesame.view.games.chooseitemgame;

import java.util.ArrayList;
import java.util.List;

import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
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
	private ArrayList<String> offeredImagesResources;
	private DisplayMetrics displayMetrics;
	private MediaPlayer mMediaPlayer;
	private int width,height;
	private GridView answersContainer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_picture_from_picture);
		
		getMetrics();
		getMediaPlayer();
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
	@Override
	public void setAnswer(Item answer) {
		// TODO Auto-generated method stub
		
	this.answer.setBackgroundResource(getResources().getIdentifier(answer.getResourceNames().get("picture"), "raw", this.getPackageName()));
		
	}

	@Override
	public void setOfferedAnswers(List<Item> offeredAnswers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wrongAnswer() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "Неточен одговор",
				Toast.LENGTH_SHORT).show();
	}
}
