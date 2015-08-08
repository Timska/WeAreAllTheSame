package weareallthesame.view.games.howmanygame;

import java.util.ArrayList;
import java.util.Random;

import weareallthesame.view.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HowManyObjectsActivity extends Activity {

	private ArrayList<ImageView> objects;
	private ArrayList<Rect> rectBounds;
	private Random r=new Random();
	private DisplayMetrics displayMetrics;
	private int width,height;
	private LinearLayout container;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_how_many_objects);

		/*displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels; */
		
		
		/*objects = new ArrayList<ImageView>();
		//fillObjects();
		rectBounds=new ArrayList<Rect>();
		//addImageViews();
		
		//container = (LinearLayout) findViewById(R.id.how_many_objects_container);
		for(int i=0;i<objects.size();++i){
			//container.addView(objects.get(i));
		}
		*/
		
		

	}
	
	/*private void addImageViews(){
		
		int i=0;
		while(rectBounds.size()<objects.size()){
			
			int x=r.nextInt(width/2);
			int y=r.nextInt(height/3);
			
			int w=200;
			int h=200;
			
			if(!isColiding(x, y, w, h)){
				rectBounds.add(new Rect(x,y,x+w,y+h));
				objects.get(i).setX(x);
				objects.get(i).setY(y);
				++i;
			}
			
			
		}
		
		
		
		
		
	}
	

	private void fillObjects(){
		
		int n=r.nextInt(10)+1;
		int i=0;
		while(i<n){
			ImageView img=new ImageView(this);
			Bitmap b=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.piperka), 100, 100,true);
	
			//img.setBackgroundResource(b);
			objects.add(img);
		}
	
		
		
	}
	private boolean isColiding(int x, int y, int width, int height) {

		for (Rect bounds : rectBounds) {

			if (bounds.left < x + width && bounds.left + bounds.width() > x
					&& bounds.top < y + height
					&& bounds.height() + bounds.top > y) {
				return true;
			}
		}
		return false;
	}
	*/
}
