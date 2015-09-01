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
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FindThePictureFromTheWordActivity extends Activity implements
		ChooseItemViewInterface {

	private static final long serialVersionUID = -6326579880175037796L;

	public static final int COLORWORD = Color.rgb(93, 230, 81);
	private GridView answersContainer;
	private DisplayMetrics displayMetrics;
	private ApplicationInterface appInterface;
	private ArrayList<Integer> answerResources;
	private int width, height;
	private Item correctAnswer;
	private Item clickedItem;
	private ArrayList<Item> answers;
	private TextView txtWord;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_the_picture_from_the_word);

		getMetrics();
		initializeViews();
		openGame();
		setWord();

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void initializeViews() {
		answersContainer = (GridView) findViewById(R.id.find_picture_from_word_answers_container);
		txtWord = (TextView) findViewById(R.id.find_picture_from_word_word);
	}

	private void setWord() {

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(COLORWORD);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.RECTANGLE);
		gd.setStroke(2, Color.BLACK, 5, 5);
		txtWord.setHeight(height/10);
		txtWord.setBackground(gd);
		txtWord.setTextSize(30);
		
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
											R.string.find_picture_from_picture_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setAnswer(Item answer) {
		// TODO Auto-generated method stub

		correctAnswer = answer;
		String type = appInterface.getCurrentCategoryType();
		System.out.println(type);
		if (type.equals("Prepositions")) {
			String text="Глувчето е "+correctAnswer.getName()+" кутијата";
			txtWord.setText(text);
			txtWord.setTextSize(15);
			
		}
		else
		txtWord.setText(correctAnswer.getName());
	}

	@Override
	public void setOfferedAnswers(Set<Item> offeredAnswers) {
		// TODO Auto-generated method stub
		

		answerResources=new ArrayList<Integer>();
		answers=new ArrayList<Item>();
		System.out.println(offeredAnswers.size());
		Iterator<Item> it = offeredAnswers.iterator();
		while (it.hasNext()) {
			Item item = it.next();
			answerResources.add(getResources().getIdentifier(
					item.getResourceNames().get("picture"), "drawable",
					this.getPackageName()));
			answers.add(item);
		}
		int imgWidth = width / 3;
		int imgHeight = height / 10;
		answersContainer.setAdapter(new ChooseItemImageViewAdapter(this,
				answerResources, imgWidth, imgHeight));

		answersContainer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				clickedItem = answers.get(position);
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
