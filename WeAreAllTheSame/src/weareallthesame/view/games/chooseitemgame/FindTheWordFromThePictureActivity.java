package weareallthesame.view.games.chooseitemgame;

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
import android.widget.ImageView;

public class FindTheWordFromThePictureActivity extends Activity implements
		ChooseItemViewInterface {

	private static final long serialVersionUID = -2816647589304154272L;

	public static final int COLORTEXTVIEWS = Color.rgb(131, 240, 246);
	private GridView answersContainer;
	private DisplayMetrics displayMetrics;
	private ApplicationInterface appInterface;
	private ArrayList<Integer> answerResources;
	private int width, height;
	private ArrayList<String> answers;
	private ImageView imgPicture;

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

		answers = new ArrayList<String>();
		Iterator<Item> it = offeredAnswers.iterator();
		while (it.hasNext()) {
			answers.add(it.next().getName());
		}

		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		int txtWidth = this.width / 3;
		int txtHeight = this.height / 10;
		

		answersContainer.setAdapter(new
		 ChooseItemTextViewAdapter(
		 this, answers, tf, txtWidth, txtHeight, COLORTEXTVIEWS));
		
		// answersContainer.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> parent, View view,
		// int position, long id) {
		// // TODO Auto-generated method stub
		// TextView tx = (TextView) view;
		// int number = Integer.parseInt((String) tx.getText());
		// numbersAndSigns.get(4).setText(Integer.toString(number));
		// System.out.println(number);
		// clickedNumber = number;
		//
		// try {
		// appInterface.executeCommand("ChooseNumber", number);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// }
		// });

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
