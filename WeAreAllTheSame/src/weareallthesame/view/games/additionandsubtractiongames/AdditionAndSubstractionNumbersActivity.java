package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import weareallthesame.view.R;
import weareallthesame.view.R.id;
import weareallthesame.view.R.layout;
import weareallthesame.view.R.menu;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdditionAndSubstractionNumbersActivity extends Activity {

	
	private DisplayMetrics displayMetrics;
	private ArrayList<Rect> boundsRect;
	private ArrayList<TextView> numbersAndSigns;
	private ArrayList<TextView> answers;
	private ArrayList<Integer> colors;
	private ArrayList<String> answersString;
	private MediaPlayer mMediaPlayer;
	private Random r = new Random();
	private Button playButton;
	private Animation animation;
	private LinearLayout linLayout;
	private TextView dropPlace;
	private int width, height, rWidth, rHeight;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_numbers);
		
		
		

		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

		

		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(this, R.raw.slow_whoop_bubble_pop);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		
		answers=new ArrayList<TextView>();
		boundsRect = new ArrayList<Rect>();
		numbersAndSigns = new ArrayList<TextView>();
		animation = AnimationUtils.loadAnimation(this,
				R.anim.choose_character_from_sound_animation_scaling);

		playButton = (Button) findViewById(R.id.choose_character_from_sound_play_buttons);
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_additioner_one));
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_sign));
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_additioner_two));
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_equals_sign));
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_result));
	
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_one));
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_two));
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_three));
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_four));
		
		colors = generateColors();
		
		
		setAnswers();
		
		setTextViews();
		addAnswers();
		
		for(TextView tx:answers){
			tx.setOnLongClickListener(new MyClickListener());
		}
		
		numbersAndSigns.get(4).setOnDragListener(new MyDragListener());
		
		
	}
	private void setTextViews() {

		for(int i=0;i<numbersAndSigns.size();++i){
			
			TextView tx=numbersAndSigns.get(i);
			tx.setBackground(getGradientDrawable());
			tx.setHeight(height/10);
			tx.setText(answersString.get(i));
			tx.setTag(answersString.get(i));
			
			
		}

	}

	

	
	private ArrayList<Integer> generateColors() {

		ArrayList<Integer> colors = new ArrayList<Integer>();
		colors.add(Color.rgb(235, 77, 77));
		colors.add(Color.rgb(88, 243, 129));
		colors.add(Color.rgb(192, 142, 213));
		colors.add(Color.rgb(137, 170, 220));
		colors.add(Color.rgb(88, 243, 129));
		// colors.add(Color.rgb(244, 252, 244));
		colors.add(Color.rgb(255, 255, 102));

		return colors;
	}

	private void setAnswers() {
		answersString = new ArrayList<String>();
		answersString.add("5");
		answersString.add("+");
		answersString.add("4");
		answersString.add("=");
		answersString.add("");

	}

	private GradientDrawable getGradientDrawable() {

		int i = colors.get(r.nextInt(colors.size()));
		GradientDrawable gd = new GradientDrawable();
		gd.setColor(i);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.OVAL);
		// gd.setStroke(1, 0xFF000000);
		gd.setStroke(2, Color.BLACK, 5, 5);

		return gd;

	}
	
	private void addAnswers(){
		
		for(int i=0;i<answers.size();++i){
			
			TextView tx=answers.get(i);
			GradientDrawable gd=getGradientDrawable();
			gd.setShape(GradientDrawable.RECTANGLE);
			tx.setBackground(gd);
			tx.setWidth(width/5);
			tx.setHeight(height/10);
			tx.setText("18");
			tx.setTag(answersString.get(i));
		}
		answers.get(2).setTag("Correct");
		Collections.shuffle(answers);
		
	}

	private final class MyClickListener implements OnLongClickListener {

		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
			ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
			String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
			System.out.println(item.toString());
			ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
			DragShadowBuilder dsb = new View.DragShadowBuilder(v);

			v.startDrag(data, dsb, v, 0);
			v.setVisibility(View.INVISIBLE);

			return true;
		}

	}
	private final class MyDragListener implements OnDragListener {

		@Override
		public boolean onDrag(View receivingLayoutView, DragEvent event) {
			// TODO Auto-generated method stub

			View draggedTextView = (View) event.getLocalState();

			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				receivingLayoutView.setBackground(getGradientDrawable());
				break;
			case DragEvent.ACTION_DRAG_LOCATION:
				break;
			case DragEvent.ACTION_DROP:
				
				String tag=(String) draggedTextView.getTag();
				
				if(tag.equals("Correct")){
					ViewGroup draggedImageViewParentLayout = (ViewGroup) draggedTextView
							.getParent();
					draggedImageViewParentLayout.removeView(draggedTextView);
					TextView dropTarget=(TextView) receivingLayoutView;
					TextView droppedView=(TextView) draggedTextView;
					dropTarget.setText(droppedView.getText());
					mMediaPlayer.start();
					draggedTextView.setVisibility(View.VISIBLE);
					return true;
				}
				else{
					draggedTextView.setVisibility(View.VISIBLE);
					return false;
				}
			
			case DragEvent.ACTION_DRAG_ENDED:

				if (!event.getResult()) {

					draggedTextView.setVisibility(View.VISIBLE);
				}
			default:
				break;
			}
			return true;
		}

	}
	
}
