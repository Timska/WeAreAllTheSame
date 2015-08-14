package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Random;

import weareallthesame.view.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdditionAndSubstractionSetsActivity extends Activity {

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_sets);

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

}
