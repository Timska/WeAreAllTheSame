package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import weareallthesame.view.games.choosecharacterfromsoundgame.CharactersTextViewAdapter;
import weareallthesame.view.games.choosecharacterfromsoundgame.MyClickListener;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class AdditionAndSubstractionNumbersActivity extends Activity implements AdditionAndSubtractionNumbersViewInterface{

	public static final int NUMBERSCOLOR=Color.rgb(255,131,99);
	public static final int SIGNCOLOR=Color.rgb(255, 251, 131);
	public static final int ANSWERSCOLOR=Color.rgb(232, 161, 139);
	
	private DisplayMetrics displayMetrics;
	private ArrayList<TextView> numbersAndSigns;
	private ArrayList<TextView> answers;
	private ArrayList<Integer> colors;
	private ArrayList<String> answersInt;
	private MediaPlayer mMediaPlayer;
	private Random r = new Random();
	private int width, height;
	private ApplicationInterface appInterface;
	private GridView answersContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_numbers);

		openGame();

		getMetrics();
		getMediaPlayer();
		
		numbersAndSigns = new ArrayList<TextView>();

		initializeViews();

		colors = generateColors();

		//setAnswers();
		
		setTextViews();
		//addAnswers();

		/*for (TextView tx : answers) {
			tx.setOnTouchListener(new MyClickListener());
		}
*/
		//numbersAndSigns.get(4).setOnDragListener(new MyDragListener());

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

		
		answersContainer=(GridView) findViewById(R.id.addition_and_substraction_numbers_answers_container);
		
		
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
											R.string.addition_and_substraction_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setTextViews() {

		for (int i = 0; i < numbersAndSigns.size(); ++i) {

			TextView tx = numbersAndSigns.get(i);
			tx.setBackground(getGradientDrawable(NUMBERSCOLOR));
			tx.setHeight(height / 10);

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
		answersInt = new ArrayList<String>();
		answersInt.add("5");
		answersInt.add("+");
		answersInt.add("4");
		answersInt.add("=");
		answersInt.add("");

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
			tx.setTag(answersInt.get(i));
		}
		answers.get(2).setTag("Correct");
		Collections.shuffle(answers);

	}


	@Override
	public void setNumbers(int numberOne, int numberTwo) {
		// TODO Auto-generated method stub
		System.out.println("Number one"+numberOne+" Number two "+numberTwo);
		numbersAndSigns.get(0).setText(Integer.toString(numberOne));
		numbersAndSigns.get(2).setText(Integer.toString(numberTwo));
	}

	@Override
	public void setOfferedAnswers(Set<Integer> answers) {
		// TODO Auto-generated method stubso
		System.out.println(answers.size());
		Iterator<Integer> it=answers.iterator();
		answersInt=new ArrayList<String>();
		while(it.hasNext()){
			answersInt.add(Integer.toString(it.next()));
		}
		
		answersContainer.setAdapter(new AdditionAndSubstractionNumberTextViewAdapter(this,answersInt));
		
		int txtWidth = width / 4;
		int txtHeight = height / (answersInt.size() / 4 + 1);
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");

		//answersContainer.setAdapter(new CharactersTextViewAdapter(this,
			//	answersInt, tf, txtWidth, txtHeight));

		
		
		answersContainer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				TextView tx = (TextView) view;
				/*try {
					appInterface.executeCommand("ChooseString", tx.getText());
				} catch (Exception e) {
					e.printStackTrace();
				} */
				
				
				

			}
		});
		//answersContainer.setOnTouchListener(new MyClickListener());
		
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
		
	}

}
