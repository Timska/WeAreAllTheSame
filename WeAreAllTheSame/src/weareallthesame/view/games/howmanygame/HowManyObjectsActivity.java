package weareallthesame.view.games.howmanygame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
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
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		this.answerContainer = null;
		this.answers = null;
		this.container = null;
		this.displayMetrics = null;
		this.linLayout = null;
		this.tf = null;
	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

	}

	private void initializeViews() {
		// container = (GridView) findViewById(R.id.how_many_objects_container);
		answerContainer = (GridView) findViewById(R.id.how_many_objects_answer_container);
		linLayout = (LinearLayout) findViewById(R.id.how_many_objects_linea_layout_container);
		LinearLayout.LayoutParams lp = new LayoutParams(
				LayoutParams.MATCH_PARENT, height / 2);
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
		HowManyObjectsView view = new HowManyObjectsView(this, howMany, width,
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
		answerContainer.setOnItemClickListener(new OnItemClickListener() {

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

}
