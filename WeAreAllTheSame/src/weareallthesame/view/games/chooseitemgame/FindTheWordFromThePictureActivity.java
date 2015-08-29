package weareallthesame.view.games.chooseitemgame;

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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FindTheWordFromThePictureActivity extends Activity implements
		ChooseItemViewInterface {

	private static final long serialVersionUID = -2816647589304154272L;

	public static final int COLORTEXTVIEWS = Color.rgb(155, 61, 176);
	private GridView answersContainer;
	private DisplayMetrics displayMetrics;
	private ApplicationInterface appInterface;
	private int width, height;
	private ArrayList<String> answers;
	private ArrayList<Item> items;
	private ImageView imgPicture;
	private String longestString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_the_word_from_the_picture);

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

		answersContainer = (GridView) findViewById(R.id.find_word_from_picture_answers_container);
		imgPicture = (ImageView) findViewById(R.id.find_word_from_picture_picture);
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

	@Override
	public void setAnswer(Item answer) {
		// TODO Auto-generated method stub
		imgPicture.setBackgroundResource(getResources().getIdentifier(
				answer.getResourceNames().get("picture"), "drawable",
				this.getPackageName()));
	}

	@Override
	public void setOfferedAnswers(Set<Item> offeredAnswers) {
		// TODO Auto-generated method stub

		longestString = "";
		answers = new ArrayList<String>();
		items = new ArrayList<Item>();
		Iterator<Item> it = offeredAnswers.iterator();
		while (it.hasNext()) {
			Item item = it.next();
			items.add(item);
			String text = item.getName();
			answers.add(text);

			if (text.length() > longestString.length()) {
				longestString = text;
			}
		}

		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		int txtWidth = this.width / 3;
		int txtHeight = this.height / 10;

		answersContainer
				.setAdapter(new ChooseItemTextViewAdapter(this, answers, tf,
						txtWidth, txtHeight, COLORTEXTVIEWS, longestString));

		answersContainer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				Item clickedItem = items.get(position);
				try {
					appInterface.executeCommand("ChooseItem", clickedItem);
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

		Toast.makeText(getApplicationContext(), "Неточен одговор",
				Toast.LENGTH_SHORT).show();
	}
}
