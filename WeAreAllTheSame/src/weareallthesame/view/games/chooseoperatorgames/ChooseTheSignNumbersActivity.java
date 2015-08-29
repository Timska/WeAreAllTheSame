package weareallthesame.view.games.chooseoperatorgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class ChooseTheSignNumbersActivity extends Activity implements
		ChooseOperatorBetweenNumbersViewInterface {

	private static final int COLORNUMBERS = Color.rgb(162, 177, 235);
	private static final int COLORSIGNS = Color.rgb(249, 246, 63);

	private DisplayMetrics displayMetrics;
	private ArrayList<TextView> numbersAndSigns;
	private ArrayList<String> answersOperators;
	private MediaPlayer mMediaPlayer;
	private Random r = new Random();
	private int width, height;
	private ApplicationInterface appInterface;
	private GridView answersContainer;
	private int clickedNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_the_sign_numbers);

		openGame();

		getMetrics();
		getMediaPlayer();

		numbersAndSigns = new ArrayList<TextView>();

		initializeViews();

		openGame();

		setTextViews();

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void initializeViews() {
		numbersAndSigns
				.add((TextView) findViewById(R.id.choose_sign_numbers_element_one));
		numbersAndSigns
				.add((TextView) findViewById(R.id.choose_sign_numbers_sign));
		numbersAndSigns
				.add((TextView) findViewById(R.id.choose_sign_numbers_element_two));
		numbersAndSigns
				.add((TextView) findViewById(R.id.choose_sign_numbers_equals_sign));
		numbersAndSigns
				.add((TextView) findViewById(R.id.choose_sign_numbers_result));

	}

	private void getMediaPlayer() {

		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(this, R.raw.slow_whoop_bubble_pop);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

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

		for (int i = 0; i < numbersAndSigns.size(); ++i) {

			TextView tx = numbersAndSigns.get(i);
			tx.setBackground(getGradientDrawable(COLORNUMBERS));
			tx.setHeight(height / 11);
			tx.setTextColor(COLORSIGNS);
			tx.setTextSize(30);
		}
		numbersAndSigns.get(3).setText("=");
		numbersAndSigns.get(4).setBackground(getGradientDrawable(COLORSIGNS));
		numbersAndSigns.get(4).setTextColor(COLORNUMBERS);

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

			View draggedTextView = (View) event.getLocalState();

			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				//receivingLayoutView.setBackground(getGradientDrawable());
				break;
			case DragEvent.ACTION_DRAG_LOCATION:
				break;
			case DragEvent.ACTION_DROP:

				String tag = (String) draggedTextView.getTag();

				if (tag.equals("Correct")) {
					ViewGroup draggedImageViewParentLayout = (ViewGroup) draggedTextView
							.getParent();
					draggedImageViewParentLayout.removeView(draggedTextView);
					TextView dropTarget = (TextView) receivingLayoutView;
					TextView droppedView = (TextView) draggedTextView;
					dropTarget.setText(droppedView.getText());
					mMediaPlayer.start();
					draggedTextView.setVisibility(View.VISIBLE);
					return true;
				} else {
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

	@Override
	public void setOfferedOperators(Set<Character> operators) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void setNumbers(int numberOne, int numberTwo, int result) {
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
