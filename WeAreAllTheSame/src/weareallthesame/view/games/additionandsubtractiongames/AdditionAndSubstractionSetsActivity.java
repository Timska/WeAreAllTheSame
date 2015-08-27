package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdditionAndSubstractionSetsActivity extends Activity implements AdditionAndSubtractionSetsViewInterface {

	public static final int IMAGEWIDTH = 100;
	private ArrayList<TextView> setOne;
	private ArrayList<TextView> setTwo;
	private ArrayList<Rect> boundsSetOne;
	private ArrayList<Rect> boundsSetTwo;
	private LinearLayout linLayout;
	private LinearLayout setOneLayout;
	private LinearLayout setTwoLayout;
	private Random r = new Random();
	private DisplayMetrics displayMetrics;
	private int width, height;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_sets);

		openGame();
		
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

		setOneLayout = (LinearLayout) findViewById(R.id.addition_and_substraction_sets_one);
		setTwoLayout = (LinearLayout) findViewById(R.id.addition_and_substraction_sets_two);

		setOne = new ArrayList<TextView>();
		setTwo = new ArrayList<TextView>();
		
		boundsSetOne=new ArrayList<Rect>();
		boundsSetTwo=new ArrayList<Rect>();
		
		setTextViews(4, 3);

	}
	
	private void openGame() {
		Intent intent = getIntent();
		String gameType = intent.getStringExtra("gameType");
		ArrayList<String> gameTags = intent.getStringArrayListExtra("gameTags");
		appInterface = (ApplicationInterface) intent.getSerializableExtra("appInterface");
		try{
			appInterface.openGame(gameType, gameTags.iterator(), this, this.getResources().getString(R.string.choose_character_from_sound_task_description));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void setTextViews(int n,int m){
		addTextViews(setOne, n, boundsSetOne);
		addTextViews(setTwo,m,boundsSetTwo);
		
		for(int i=0;i<n;++i){
			setOneLayout.addView(setOne.get(i));
		}
		for(int i=0;i<m;++i){
			setTwoLayout.addView(setTwo.get(i));
		}
	}

	private boolean isColiding(int x, int y, int width, int height,
			ArrayList<Rect> boundsSet) {

		for (Rect bounds : boundsSet) {

			if (bounds.left < x + width && bounds.left + bounds.width() > x
					&& bounds.top < y + height
					&& bounds.height() + bounds.top > y) {
				return true;
			}
		}
		return false;
	}

	private void addTextViews(ArrayList<TextView> set, int n,
			ArrayList<Rect> boundsSet) {

		int i = 0;
		while (set.size() < n) {

			int x = r.nextInt(width / 4 - IMAGEWIDTH);
			int y = r.nextInt(height / 4 - IMAGEWIDTH);

			if (!isColiding(x, y, IMAGEWIDTH, IMAGEWIDTH, boundsSet)) {

				Rect bounds = new Rect(x, y, x + IMAGEWIDTH, y + IMAGEWIDTH);
				boundsSet.add(bounds);
				TextView tx = new TextView(getApplicationContext());
				tx.setBackgroundResource(R.drawable.kajsija);
				tx.setX(x);
				tx.setY(y);
				set.add(tx);
				++i;
			}

		}

	}

	public Drawable resizeImage(int id) {
		BitmapDrawable bd = (BitmapDrawable) this.getResources()
				.getDrawable(id);
		Bitmap bMap = BitmapFactory.decodeResource(getResources(), id);
		Bitmap scaled = bMap.createScaledBitmap(bMap, 100, 100, false);
		return new BitmapDrawable(getResources(), scaled);
	}

	@Override
	public void setNumbers(int numberOne, int numberTwo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOfferedAnswers(Set<Integer> answers) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void setItem(Item item) {
		// TODO Auto-generated method stub
		
	}

}
