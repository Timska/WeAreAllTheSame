package weareallthesame.view.games.chooseoperatorgames;

import java.util.ArrayList;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import weareallthesame.view.R.id;
import weareallthesame.view.R.layout;
import weareallthesame.view.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class ChooseOperatorSetsActivity extends Activity implements
		ChooseOperatorBetweenSetsViewInterface {

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
		setContentView(R.layout.activity_choose_operator_sets);

		getMetrics();
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
		answersContainer = (GridView) findViewById(R.id.choose_operator_sets_answers_container);
		equalsSign=findViewById(R.id.choose_operator_sets_equals_sign);
		sign = (TextView) findViewById(R.id.choose_operator_sets_sign);
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

	@Override
	public void setItem(Item item) {
		// TODO Auto-generated method stub

	}
}
