package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.R;
import weareallthesame.view.games.choosecharacterfromsoundgame.MyClickListener;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

public class AdditionAndSubstractionNumbersActivity extends Activity implements AdditionAndSubtractionNumbersViewInterface{

	public static final int NUMBERSCOLOR=Color.rgb(207,194,101);
	public static final int SIGNCOLOR=Color.rgb(232, 161, 139);
	public static final int ANSWERSCOLOR=Color.rgb(232, 161, 139);
	
	private DisplayMetrics displayMetrics;
	private ArrayList<TextView> numbersAndSigns;
	private ArrayList<TextView> answers;
	private ArrayList<Integer> colors;
	private ArrayList<String> answersString;
	private MediaPlayer mMediaPlayer;
	private Random r = new Random();
	private int width, height;
	private ApplicationInterface appInterface;
	private GridView txtContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_numbers);

		openGame();

		getMetrics();
		getMediaPlayer();
		answers = new ArrayList<TextView>();
		numbersAndSigns = new ArrayList<TextView>();

		initializeViews();

		colors = generateColors();

		setAnswers();
		txtContainer.setAdapter(new AdditionAndSubstractionNumberTextViewAdapter(this,answersString));
		setTextViews();
		//addAnswers();

		for (TextView tx : answers) {
			tx.setOnTouchListener(new MyClickListener());
		}

		numbersAndSigns.get(4).setOnDragListener(new MyDragListener());

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
		
		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_additioner_one));
		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_sign));
		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_additioner_two));
		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_equals_sign));
		numbersAndSigns
				.add((TextView) findViewById(R.id.addition_and_substraction_numbers_result));

		
		txtContainer=(GridView) findViewById(R.id.addition_and_substraction_numbers_answers_container);
		
		
		/*answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_one));
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_two));
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_three));
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_four));
	
	*/
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
			tx.setBackground(getGradientDrawable(NUMBERSCOLOR));
			tx.setHeight(height / 10);
			tx.setText(answersString.get(i));
			tx.setTag(answersString.get(i));

		}
		numbersAndSigns.get(4).setBackground(getGradientDrawable(SIGNCOLOR));

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

	private GradientDrawable getGradientDrawable(int color) {

		
		GradientDrawable gd = new GradientDrawable();
		gd.setColor(color);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.OVAL);
		// gd.setStroke(1, 0xFF000000);
		gd.setStroke(2, Color.BLACK, 5, 5);
		return gd;

	}

	private void addAnswers() {

		for (int i = 0; i < answers.size(); ++i) {

			TextView tx = answers.get(i);
			GradientDrawable gd = getGradientDrawable(ANSWERSCOLOR);
			gd.setShape(GradientDrawable.RECTANGLE);
			tx.setBackground(gd);
			tx.setWidth(width / 5);
			tx.setHeight(height / 10);
			tx.setText("18");
			tx.setTag(answersString.get(i));
		}
		answers.get(2).setTag("Correct");
		Collections.shuffle(answers);

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
	public void setNumbers(int numberOne, int numberTwo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOfferedAnswers(Set<Integer> answers) {
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
