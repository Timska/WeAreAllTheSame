package weareallthesame.view.games.choosecharacterfromsoundgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
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
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class ChooseCharacterFromSoundActivity extends Activity implements
		ChooseStringFromSoundViewInterface {

	public static final int TEXTVIEWCOLOR = Color.rgb(88, 243, 129);
	private DisplayMetrics displayMetrics;
	private ArrayList<Rect> boundsRect;
	private ArrayList<TextView> answers;
	private int width, height;
	private ArrayList<String> answersString;
	private MediaPlayer mMediaPlayer;
	private Random r = new Random();
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

		boundsRect = new ArrayList<Rect>();
		answers = new ArrayList<TextView>();
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

		// linLayout.setOnDragListener(new MyDragListener());
		// dropPlace.setOnDragListener(new MyDragListener());

	}

	public void playButtonOnClick(View v) {
		mMediaPlayer.start();
		setTextViews();
		playButton.startAnimation(animation);
	}

	private void setButtonSound() {

		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(this, R.raw.slow_whoop_bubble_pop);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		// mMediaPlayer.setLooping(true);
		mMediaPlayer.start();
	}

	private void initiliazeViews() {
		playButton = (Button) findViewById(R.id.choose_character_from_sound_play_buttons);
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_one));
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_two));
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_three));
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_four));
		dropPlace = (TextView) findViewById(R.id.choose_character_from_sound_drop_pool);

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void openGame() {
		// TODO Auto-generated method stub
		Intent intent = getIntent();
		String gameType = intent.getStringExtra("gameType");
		ArrayList<String> gameTags = intent.getStringArrayListExtra("gameTags");
		// intent.getSerializableExtra("");
		// ne se sekjavam toa so serializable so trebase da se izvade od
		// intentot
		// appInterface.openGame(gameType, gameTags.iterator(), this,
		// R.string.choose_character_from_sound_task_description);

	}

	private void setTextViews() {

		for (int i = 0; i < answers.size(); ++i) {
			answers.get(i).setWidth(width / 3);
			answers.get(i).setHeight(height / 8);
			answers.get(i).setBackground(getGradientDrawable(TEXTVIEWCOLOR));
			answers.get(i).setText(answersString.get(i));
		}

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

			View draggedImageView = (View) event.getLocalState();

			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				break;
			case DragEvent.ACTION_DRAG_LOCATION:
				break;
			case DragEvent.ACTION_DROP:
				switch (draggedImageView.getId()) {
				case R.id.choose_character_from_sound_answer_one:
					return false;
				case R.id.choose_character_from_sound_answer_two:
					ViewGroup draggedImageViewParentLayout = (ViewGroup) draggedImageView
							.getParent();
					draggedImageViewParentLayout.removeView(draggedImageView);
					LinearLayout bottomLinearLayout = (LinearLayout) receivingLayoutView;
					LayoutParams lp = new LayoutParams(Gravity.CENTER);
					bottomLinearLayout.setLayoutParams(findViewById(
							R.id.choose_character_from_sound_drop_pool)
							.getLayoutParams());
					bottomLinearLayout.addView(draggedImageView, lp);
					draggedImageView.setVisibility(View.VISIBLE);
					mMediaPlayer.start();
					return true;
				case R.id.choose_character_from_sound_answer_three:
					return false;
				case R.id.choose_character_from_sound_answer_four:
					return false;
				default:
					return false;
				}

			case DragEvent.ACTION_DRAG_ENDED:

				if (!event.getResult()) {

					draggedImageView.setVisibility(View.VISIBLE);
				}
			default:
				break;
			}
			return true;
		}

	}

	@Override
	public void setAnswer(Item item) {
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

	@Override
	public void setOfferedAnswers(Set<String> allOfferedLetters) {
		// TODO Auto-generated method stub

	}
}
