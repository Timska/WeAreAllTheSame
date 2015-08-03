package weareallthesame.view.games.chooseitemgame;

import java.util.List;

import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FindThePictureFromTheSound extends Activity implements ChooseItemViewInterface{

	private static final long serialVersionUID = -1366318460338234441L;

	private static final String TAG1="Answer1";
	private static final String TAG2="Answer2";
	private static final String TAG3="Answer3";
	private static final String TAG4="Answer4";
	private Button playSound;
	private MediaPlayer mMediaPlayer;
	private ImageView answer1;
	private ImageView answer2;
	private ImageView answer3;
	private ImageView answer4;
	private TextView dropPoint;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_the_picture_from_the_sound);
	
		
		
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
		
		answer1=(ImageView) findViewById(R.id.find_picture_from_sound_answerOne);
		answer2=(ImageView) findViewById(R.id.find_picture_from_sound_answerTwo);
		answer3=(ImageView) findViewById(R.id.find_picture_from_sound_answerThree);
		answer4=(ImageView) findViewById(R.id.find_picture_from_sound_answerFour);
		
		answer1.setTag(TAG1);
		answer2.setTag(TAG2);
		answer3.setTag(TAG3);
		answer4.setTag(TAG4);
		
		answer1.setOnLongClickListener(new MyClickListener());
		answer2.setOnLongClickListener(new MyClickListener());
		answer3.setOnLongClickListener(new MyClickListener());
		answer4.setOnLongClickListener(new MyClickListener());
		
		dropPoint=(TextView) findViewById(R.id.find_picture_from_sound_drop_place);
		dropPoint.setText("Donesi ja slikata ovde");
		dropPoint.setOnDragListener(new MyDragListener());
		
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
	private final class MyClickListener implements OnLongClickListener
	{
		
		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
			ClipData.Item item=new ClipData.Item((CharSequence) v.getTag());
			String [] mimeTypes={ClipDescription.MIMETYPE_TEXT_PLAIN};
			System.out.println(item.toString());
			ClipData data=new ClipData(v.getTag().toString(),mimeTypes,item);
			DragShadowBuilder dsb=new View.DragShadowBuilder(v);
			
			v.startDrag(data, dsb, v, 0);
			v.setVisibility(View.INVISIBLE);
			
			return true;
		}
		
	}
	private final class MyDragListener implements OnDragListener{

		
		@Override
		public boolean onDrag(View v, DragEvent event) {
			// TODO Auto-generated method stub
			
			switch(event.getAction()){
			case DragEvent.ACTION_DRAG_STARTED:
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				v.setBackgroundColor(R.color.red);
				break;
			case DragEvent.ACTION_DRAG_LOCATION:
				v.setBackgroundColor(R.color.yellow);
				break;
			case DragEvent.ACTION_DROP:
				if(v==findViewById(R.id.find_picture_from_sound_drop_place)){
					
					ClipData.Item item = event.getClipData().getItemAt(0);
					
					Context context=getApplicationContext();
					Toast.makeText(context, "Item dropped", Toast.LENGTH_LONG).show();
					
					
				}else{
					View view= (View) event.getLocalState();
					view.setVisibility(View.VISIBLE);
					Context context=getApplicationContext();
					Toast.makeText(context, "You can not drop the picture here", Toast.LENGTH_LONG).show();
					break;
				}
				break;
			case DragEvent.ACTION_DRAG_ENDED:
				v.setBackgroundColor(R.color.yellow);
			default:
				break;
			}
			return true;
		}
		
	}

}
