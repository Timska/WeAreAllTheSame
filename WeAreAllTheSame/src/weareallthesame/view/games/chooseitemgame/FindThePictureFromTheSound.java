package weareallthesame.view.games.chooseitemgame;

import java.util.List;

import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FindThePictureFromTheSound extends Activity implements ChooseItemViewInterface{

	private String TAG="FindThePictureFromTheSound";
	private Button playSound;
	private SoundPool soundPool;
	private AudioManager audioManager;
	private int soundId;
	private MediaPlayer mMediaPlayer;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_the_picture_from_the_sound);
	
		/*audioManager=(AudioManager) getSystemService(AUDIO_SERVICE);
		playSound=(Button) findViewById(R.id.find_picture_from_sound_button_play);
		
		//playSound.setEnabled(false);
		soundPool=new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		
		soundId=soundPool.load(this,R.raw.slow_whoop_bubble_pop,1);
		
		soundPool.play(soundId, 2, 3, 1, 0, 1); */
		
		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(this, R.raw.slow_whoop_bubble_pop);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		//mMediaPlayer.setLooping(true);
		mMediaPlayer.start();
		
		
		playSound=(Button) findViewById(R.id.find_picture_from_sound_button_play);
		playSound.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mMediaPlayer.start();
			}
		});
		
		
	}

	
	

	@Override
	public void setAnswer(Item answer) {
		// TODO Auto-generated method stub
		
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
		
	}

}
