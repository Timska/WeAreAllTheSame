package weareallthesame.view.games.chooseoperatorgames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import weareallthesame.view.R.id;
import weareallthesame.view.R.layout;
import weareallthesame.view.R.menu;
import weareallthesame.view.games.additionandsubtractiongames.AdditionAndSubstractionNumberTextViewAdapter;
import weareallthesame.view.games.additionandsubtractiongames.DrawSetsView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;

public class ChooseOperatorSetsActivity extends Activity implements
		ChooseOperatorBetweenSetsViewInterface {

	public static final int COLORANSWERS = Color.rgb(253, 185, 91);
	private ArrayList<String> answersString;
	private LinearLayout setOneLayout;
	private LinearLayout setTwoLayout;
	private GridView answersContainer;
	private TextView equalsSign, sign, txtResult;
	private DisplayMetrics displayMetrics;
	private int width, height;
	private Item answer;
	private int numberOne, numberTwo;
	private String signString;
	private TextView answerOne, answerTwo;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_operator_sets);

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

		setOneLayout = (LinearLayout) findViewById(R.id.choose_operator_sets_set_one);
		setTwoLayout = (LinearLayout) findViewById(R.id.choose_operator_sets_set_two);
		answerOne = (TextView) findViewById(R.id.choose_operator_sets_answer_one);
		answerTwo = (TextView) findViewById(R.id.choose_operator_sets_answer_two);
		// answersContainer = (GridView)
		// findViewById(R.id.choose_operator_sets_answers_container);
		equalsSign = (TextView) findViewById(R.id.choose_operator_sets_equals_sign);
		sign = (TextView) findViewById(R.id.choose_operator_sets_sign);
		txtResult = (TextView) findViewById(R.id.choose_operator_sets_result);
		LinearLayout.LayoutParams lp = new LayoutParams(
				LayoutParams.MATCH_PARENT, height / 4);
		setOneLayout.setLayoutParams(lp);
		setTwoLayout.setLayoutParams(lp);
		equalsSign.setBackground(getGradientDrawable(COLORANSWERS));
		equalsSign.setText("=");
		equalsSign.setWidth(width / 5);
		equalsSign.setTextColor(Color.WHITE);
		equalsSign.setTextSize(30);
		sign.setBackground(getGradientDrawable(COLORANSWERS));
		sign.setTextColor(Color.WHITE);
		sign.setWidth(width / 5);
		sign.setTextSize(30);
		sign.setText("?");
		answerOne.setBackground(getGradientDrawable(COLORANSWERS));
		answerOne.setTextColor(Color.WHITE);
		answerOne.setWidth(width / 5);
		answerOne.setTextSize(30);
		answerTwo.setBackground(getGradientDrawable(COLORANSWERS));
		answerTwo.setTextColor(Color.WHITE);
		answerTwo.setWidth(width / 5);
		answerTwo.setTextSize(30);

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
	public void setOfferedOperators(Set<Character> operators) {
		// TODO Auto-generated method stub

		Iterator<Character> it = operators.iterator();
		System.out.println(operators.size());
		answersString = new ArrayList<String>();
		while (it.hasNext()) {
			Character c = it.next();
			System.out.println(c);
			answersString.add(Character.toString(c));
		}
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		answerOne.setText(answersString.get(0));
		answerTwo.setText(answersString.get(1));
		answerOne.setOnClickListener(new MyTouchListener());
		answerTwo.setOnClickListener(new MyTouchListener());
		/*
		 * answersContainer .setAdapter(new
		 * AdditionAndSubstractionNumberTextViewAdapter( this, answersString,
		 * tf, width, height, COLORANSWERS));
		 * 
		 * answersContainer.setOnItemClickListener(new OnItemClickListener() {
		 * 
		 * @Override public void onItemClick(AdapterView<?> parent, View view,
		 * int position, long id) { // TODO Auto-generated method stub TextView
		 * tx = (TextView) view; int number = Integer.parseInt((String)
		 * tx.getText());
		 * 
		 * try { appInterface.executeCommand("ChooseNumber", number); } catch
		 * (Exception e) { e.printStackTrace(); }
		 * 
		 * } });
		 */
	}

	@Override
	public void setNumbers(int numberOne, int numberTwo, int result) {
		// TODO Auto-generated method stub

		this.numberOne = numberOne;
		this.numberTwo = numberTwo;

		txtResult.setBackground(getGradientDrawable(COLORANSWERS));
		txtResult.setTextColor(Color.WHITE);
		txtResult.setText(Integer.toString(result));
		txtResult.setWidth(width / 5);

	}

	@Override
	public void gameOver() {
		txtResult.setText(signString);
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

		int idOne = getResources().getIdentifier(
				item.getResourceNames().get("picture"), "drawable",
				this.getPackageName());
		Bitmap b = Bitmap.createScaledBitmap(
				BitmapFactory.decodeResource(getResources(), idOne), 100, 100,
				true);

		DrawSetsView view = new DrawSetsView(this, numberOne, width,
				height / 4, b);
		setOneLayout.addView(view);
		view = new DrawSetsView(this, numberTwo, width, height / 4, b);
		setTwoLayout.addView(view);
	}

	private GradientDrawable getGradientDrawable(int color) {

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(color);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.RECTANGLE);
		gd.setStroke(2, Color.BLACK, 5, 5);
		return gd;

	}

	private final class MyTouchListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			TextView tx = (TextView) v;
			signString = (String) tx.getText();
			try {
				appInterface.executeCommand("ChooseOperator",
						signString.charAt(0));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
