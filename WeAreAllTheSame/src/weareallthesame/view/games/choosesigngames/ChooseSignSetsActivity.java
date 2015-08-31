package weareallthesame.view.games.choosesigngames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.exceptions.GameNotOpenException;
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
import android.content.res.ColorStateList;
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

public class ChooseSignSetsActivity extends Activity implements
		ChooseSignBetweenSetsViewInterface {

	public static final int COLORANSWERS = Color.rgb(4, 180, 49);
	private ArrayList<String> answersString;
	private LinearLayout setOneLayout;
	private LinearLayout setTwoLayout;
	private GridView answersContainer;
	private TextView answerOne, answerTwo, answerThree, sign, txtResult;
	private DisplayMetrics displayMetrics;
	private int width, height;
	private Item itemOne, itemTwo;
	private int numberOne,numberTwo;
	private String signString;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_sign_sets);
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
		setOneLayout = (LinearLayout) findViewById(R.id.choose_sign_sets_set_one);
		setTwoLayout = (LinearLayout) findViewById(R.id.choose_sign_sets_set_two);
		answerOne = (TextView) findViewById(R.id.choose_sign_sets_answer_one);
		answerTwo = (TextView) findViewById(R.id.choose_sign_sets_answer_two);
		answerThree = (TextView) findViewById(R.id.choose_sign_sets_answer_three);
		sign = (TextView) findViewById(R.id.choose_sign_sets_sign);
		LinearLayout.LayoutParams lp = new LayoutParams(
				LayoutParams.MATCH_PARENT, height / 4);
		setOneLayout.setLayoutParams(lp);
		setTwoLayout.setLayoutParams(lp);
		sign.setBackground(getGradientDrawable(COLORANSWERS));
		sign.setWidth(width / 5);
		sign.setTextColor(Color.WHITE);
		sign.setTextSize(30);
		answerOne.setBackground(getGradientDrawable(COLORANSWERS));
		answerOne.setTextColor(Color.WHITE);
		answerOne.setWidth(width / 5);
		answerThree.setBackground(getGradientDrawable(COLORANSWERS));
		answerThree.setTextColor(Color.WHITE);
		answerTwo.setWidth(width / 5);
		answerTwo.setBackground(getGradientDrawable(COLORANSWERS));
		answerTwo.setTextColor(Color.WHITE);
		answerThree.setWidth(width / 5);

	}

	private void openGame() {
		Intent intent = getIntent();
		String gameType = intent.getStringExtra("gameType");
		ArrayList<String> gameTags = intent.getStringArrayListExtra("gameTags");
		appInterface = (ApplicationInterface) intent
				.getSerializableExtra("appInterface");
		try {
			appInterface.openGame(
					gameType,
					gameTags.iterator(),
					this,
					this.getResources().getString(
							R.string.choose_operator_numbers_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setNumbers(int numOne, int numTwo) {
		// TODO Auto-generated method stub
		this.numberOne=numOne;
		this.numberTwo=numTwo;
		

	}

	@Override
	public void setOfferedSigns(Set<Character> signs) {
		// TODO Auto-generated method stub
		Iterator<Character> it = signs.iterator();
		System.out.println(signs.size());
		answersString = new ArrayList<String>();
		while (it.hasNext()) {
			Character c = it.next();
			System.out.println(c);
			answersString.add(Character.toString(c));
		}
		answerOne.setText(answersString.get(0));
		answerTwo.setText(answersString.get(1));
		answerThree.setText(answersString.get(2));
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
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
		
		answerOne.setOnClickListener(new MyTouchListener());
		answerTwo.setOnClickListener(new MyTouchListener());
		answerThree.setOnClickListener(new MyTouchListener());

	}

	@Override
	public void gameOver() {
	
		Intent intent = new Intent(this, GameOverChoiceActivity.class);
		startActivityForResult(intent, 0);
		/*try {
			appInterface.exitGame();
		} catch (GameNotOpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */

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
	public void setItems(Item itemOne, Item itemTwo) {
		// TODO Auto-generated method stub
		this.itemOne = itemOne;
		this.itemTwo = itemTwo;
		
		int idOne = getResources().getIdentifier(itemOne.getResourceNames().get("picture"), "drawable",this.getPackageName());
		int idTwo = getResources().getIdentifier(itemTwo.getResourceNames().get("picture"), "drawable",this.getPackageName());
		
		Bitmap b = Bitmap.createScaledBitmap(
				BitmapFactory.decodeResource(getResources(), idOne),
				100, 100, true);

		DrawSetsView view = new DrawSetsView(this, 3, width, height / 4, b);
		setOneLayout.addView(view);
		view = new DrawSetsView(this, 3, width, height / 4, b);
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
				appInterface.executeCommand("ChooseSign", signString.charAt(0));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
