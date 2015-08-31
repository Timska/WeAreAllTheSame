package weareallthesame.view.games.howmanygame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class HowManyObjectsActivity extends Activity implements
		HowManyViewInterface {

	private final static int COLORGROUPONE = Color.rgb(247, 129, 129);
	private DisplayMetrics displayMetrics;
	private int width, height;
	private GridView container, answerContainer;
	private ApplicationInterface appInterface;
	private ArrayList<String> answers;
	private LinearLayout linLayout;
	private Typeface tf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_how_many_objects);

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
		//container = (GridView) findViewById(R.id.how_many_objects_container);
		answerContainer = (GridView) findViewById(R.id.how_many_objects_answer_container);
		linLayout=(LinearLayout)findViewById(R.id.how_many_objects_linea_layout_container);
		LinearLayout.LayoutParams lp=new LayoutParams(LayoutParams.MATCH_PARENT,height/2);
		linLayout.setLayoutParams(lp);
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
							R.string.how_many_objects_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setAnswer(Item item, int howMany) {
		// TODO Auto-generated method stub
		System.out.println(getResources().getIdentifier(
				item.getResourceNames().get("picture"), "drawable",
				this.getPackageName()));
		HowManyObjectsView view = new HowManyObjectsView(this, 5, width,
				height / 2, getResources().getIdentifier(
						item.getResourceNames().get("picture"), "drawable",
						this.getPackageName()));
		linLayout.addView(view);

		/*
		 * int i = 0; ArrayList<Integer> offeredImagesResources = new
		 * ArrayList<Integer>(); while (i < 5) {
		 * offeredImagesResources.add(getResources().getIdentifier(
		 * item.getResourceNames().get("picture"), "raw",
		 * 
		 * this.getPackageName())); }
		 * 
		 * container.setAdapter(new ChooseItemImageViewAdapter(this,
		 * 
		 * offeredImagesResources, width, height));
		 */
	}

	@Override
	public void setOfferedAnswers(Set<Integer> offeredAnswers) {
		// TODO Auto-generated method stub
		Iterator<Integer> it = offeredAnswers.iterator();
		answers = new ArrayList<String>();
		while (it.hasNext()) {
			answers.add(Integer.toString(it.next()));
		}
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		answerContainer.setAdapter(new HowManyObjectsTextViewAdapter(this,
				answers, tf, width, height, COLORGROUPONE));

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
