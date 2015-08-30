package weareallthesame.view.games.howmanygame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HowManyObjectsActivity extends Activity implements HowManyViewInterface{

	private ArrayList<ImageView> objects;
	private ArrayList<Rect> rectBounds;
	private Random r = new Random();
	private DisplayMetrics displayMetrics;
	private int width, height;
	private LinearLayout container;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_how_many_objects);

		getMetrics();

		openGame();

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

	}
	private void initializeViews(){
		container=(LinearLayout) findViewById(R.id.how_many_objects_container);
		
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
		HowManyObjectsView view=new HowManyObjectsView(this, howMany, width, height/3, getResources().getIdentifier(item.getResourceNames().get("picture"), "drawable", this.getPackageName()));
		container.addView(view);
	}

	@Override
	public void setOfferedAnswers(Set<Integer> offeredAnswers) {
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

	/*
	 * private void addImageViews(){
	 * 
	 * int i=0; while(rectBounds.size()<objects.size()){
	 * 
	 * int x=r.nextInt(width/2); int y=r.nextInt(height/3);
	 * 
	 * int w=200; int h=200;
	 * 
	 * if(!isColiding(x, y, w, h)){ rectBounds.add(new Rect(x,y,x+w,y+h));
	 * objects.get(i).setX(x); objects.get(i).setY(y); ++i; }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * private void fillObjects(){
	 * 
	 * int n=r.nextInt(10)+1; int i=0; while(i<n){ ImageView img=new
	 * ImageView(this); Bitmap
	 * b=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
	 * R.drawable.piperka), 100, 100,true);
	 * 
	 * //img.setBackgroundResource(b); objects.add(img); }
	 * 
	 * 
	 * 
	 * } private boolean isColiding(int x, int y, int width, int height) {
	 * 
	 * for (Rect bounds : rectBounds) {
	 * 
	 * if (bounds.left < x + width && bounds.left + bounds.width() > x &&
	 * bounds.top < y + height && bounds.height() + bounds.top > y) { return
	 * true; } } return false; }
	 */
}
