package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import weareallthesame.view.games.howmanygame.HowManyObjectsTextViewAdapter;
import weareallthesame.view.games.howmanygame.HowManyObjectsView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;

public class AdditionAndSubstractionSetsActivity extends Activity implements
		AdditionAndSubtractionSetsViewInterface {

	public static final int COLORANSWERS = Color.rgb(4, 180, 49);
	private ArrayList<String> answersString;
	private LinearLayout setOneLayout;
	private LinearLayout setTwoLayout;
	private GridView answersContainer;
	private TextView equalsSign, sign;
	private DisplayMetrics displayMetrics;
	private int width, height;
	private Item answer;
	private String signString;

	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_sets);

		getMetrics();
		initializeViews();
		openGame();

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void initializeViews() {

		setOneLayout = (LinearLayout) findViewById(R.id.addition_and_substraction_sets_one);
		setTwoLayout = (LinearLayout) findViewById(R.id.addition_and_substraction_sets_two);
		answersContainer = (GridView) findViewById(R.id.addition_and_substraction_sets_answers_container);
		equalsSign = (TextView) findViewById(R.id.addition_and_substraction_sets_equals_sign);
		sign = (TextView) findViewById(R.id.addition_and_substraction_sets_sign);
		LinearLayout.LayoutParams lp = new LayoutParams(
				LayoutParams.MATCH_PARENT, height / 4);
		setOneLayout.setLayoutParams(lp);
		setTwoLayout.setLayoutParams(lp);
		equalsSign.setText("=");
		equalsSign.setTextColor(COLORANSWERS);
		sign.setTextColor(COLORANSWERS);
		sign.setTextSize(30);
		equalsSign.setTextSize(30);
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

	@Override
	public void setNumbers(int numberOne, int numberTwo) {
		// TODO Auto-generated method stub

		int id = getResources().getIdentifier(
				answer.getResourceNames().get("picture"), "drawable",
				this.getPackageName());

		// R.drawable.limon
		Bitmap b = Bitmap.createScaledBitmap(
				BitmapFactory.decodeResource(getResources(), R.drawable.limon),
				100, 100, true);

		DrawSetsView view = new DrawSetsView(this, 5, width, height / 4, b);
		setOneLayout.addView(view);
		view = new DrawSetsView(this, 5, width, height / 4, b);
		setTwoLayout.addView(view);

	}

	@Override
	public void setOfferedAnswers(Set<Integer> answers) {
		// TODO Auto-generated method stuIterator<Integer> it =
		// offeredAnswers.iterator();
		answersString = new ArrayList<String>();
		Iterator<Integer> it = answers.iterator();
		while (it.hasNext()) {
			answersString.add(Integer.toString(it.next()));
		}
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		answersContainer
				.setAdapter(new AdditionAndSubstractionNumberTextViewAdapter(
						this, answersString, tf, width, height, COLORANSWERS));

		answersContainer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				TextView tx = (TextView) view;
				int number = Integer.parseInt((String) tx.getText());

				try {
					appInterface.executeCommand("ChooseNumber", number);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
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
	public void setItem(Item item) {
		// TODO Auto-generated method stub
		this.answer = item;
	}

	@Override
	public void setAdditionOperator(boolean addition) {
		// TODO Auto-generated method stub

		if (addition) {

			this.signString = "+";
			sign.setText(signString);
		}

		else {
			this.signString = "-";
			sign.setText(signString);
		}

	}

}
