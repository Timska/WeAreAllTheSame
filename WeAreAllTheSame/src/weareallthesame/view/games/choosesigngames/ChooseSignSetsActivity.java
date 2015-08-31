package weareallthesame.view.games.choosesigngames;

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
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
	private TextView equalsSign, sign, txtResult;
	private DisplayMetrics displayMetrics;
	private int width, height;
	private Item itemOne, itemTwo;
	private String signString;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_sign_sets);
		getMetrics();
		initializeViews();
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
		answersContainer = (GridView) findViewById(R.id.choose_sign_sets_answers_container);
		sign = (TextView) findViewById(R.id.choose_sign_sets_sign);
		LinearLayout.LayoutParams lp = new LayoutParams(
				LayoutParams.MATCH_PARENT, height / 4);
		setOneLayout.setLayoutParams(lp);
		setTwoLayout.setLayoutParams(lp);
		sign.setTextColor(COLORANSWERS);
		sign.setTextSize(30);

	}

	@Override
	public void setNumbers(int numOne, int numTwo) {
		// TODO Auto-generated method stub
		Bitmap b = Bitmap.createScaledBitmap(
				BitmapFactory.decodeResource(getResources(), R.drawable.limon),
				100, 100, true);

		DrawSetsView view = new DrawSetsView(this, 5, width, height / 4, b);
		setOneLayout.addView(view);
		view = new DrawSetsView(this, 5, width, height / 4, b);
		setTwoLayout.addView(view);

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
	public void setItems(Item itemOne, Item itemTwo) {
		// TODO Auto-generated method stub
		this.itemOne = itemOne;
		this.itemTwo = itemTwo;

	}

}
