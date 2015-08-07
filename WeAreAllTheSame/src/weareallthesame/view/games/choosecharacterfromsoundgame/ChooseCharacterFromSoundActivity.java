package weareallthesame.view.games.choosecharacterfromsoundgame;

import java.util.ArrayList;
import java.util.Random;

import weareallthesame.view.R;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
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
public class ChooseCharacterFromSoundActivity extends Activity {

	private DisplayMetrics displayMetrics;
	private ArrayList<Rect> boundsRect;
	private ArrayList<TextView> answers;
	private int width, height, rWidth, rHeight;
	private ArrayList<Integer> colors;
	private ArrayList<String> answersString;
	private MediaPlayer mMediaPlayer;
	private Random r = new Random();
	private Button playButton;
	private Animation animation;
	private LinearLayout linLayout;
	private TextView dropPlace;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_character_from_sound);

		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

		boundsRect = new ArrayList<Rect>();
		answers = new ArrayList<TextView>();
		animation = AnimationUtils.loadAnimation(this,
				R.anim.choose_character_from_sound_animation_scaling);

		playButton = (Button) findViewById(R.id.choose_character_from_sound_play_buttons);
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_one));
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_two));
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_three));
		answers.add((TextView) findViewById(R.id.choose_character_from_sound_answer_four));
		linLayout = (LinearLayout) findViewById(R.id.choose_character_from_sound_drop_pool);

		
		setButton();
		setAnswers();
		colors = generateColors();
		setTextViews();

		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(this, R.raw.slow_whoop_bubble_pop);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		// mMediaPlayer.setLooping(true);
		mMediaPlayer.start();

		playButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mMediaPlayer.start();
				boundsRect.clear();
				setButton();
				setTextViews();

				playButton.startAnimation(animation);
			}
		});

		for (int i = 0; i < answers.size(); ++i) {
			answers.get(i).setTag(i + " ");
			answers.get(i).setOnLongClickListener(new MyClickListener());
		}

		linLayout.setOnDragListener(new MyDragListener());
		//dropPlace.setOnDragListener(new MyDragListener());
		
	}

	private void setTextViews() {

		rHeight = width;
		rWidth = height / 2;

		int i = 0;

		while (boundsRect.size() < answers.size() + 1) {

			Paint paint = answers.get(i).getPaint();
			answers.get(i).setText(answersString.get(i));
			int textWidth = (int) paint.measureText(answersString.get(i)) + 60;
			int textHeight = height / 10;
			int x = r.nextInt(rWidth - textWidth);
			int y = r.nextInt(rHeight - textHeight);
			if (!isColiding(x, y, textWidth, textHeight)) {

				boundsRect.add(new Rect(x, y, x + textWidth, y + textHeight));
				answers.get(i).setX(x);
				answers.get(i).setY(y);
				answers.get(i).setBackground(getGradientDrawable());
				++i;
			}

		}

	}

	private void setButton() {

		int w = width / 3;
		int h = height / 4;
		playButton.setX(w);
		playButton.setY(h);
		Rect rect = new Rect(w, h, w + 200, h + 200);
		boundsRect.add(rect);
	}

	private boolean isColiding(int x, int y, int width, int height) {

		for (Rect bounds : boundsRect) {

			if (bounds.left < x + width && bounds.left + bounds.width() > x
					&& bounds.top < y + height
					&& bounds.height() + bounds.top > y) {
				return true;
			}
		}
		return false;
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
		answersString.add("I");
		answersString.add("A");
		answersString.add("M");
		answersString.add("Z");

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
					LayoutParams lp=new LayoutParams(Gravity.CENTER);
					bottomLinearLayout.setLayoutParams(findViewById(R.id.choose_character_from_sound_drop_pool).getLayoutParams());
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
}
