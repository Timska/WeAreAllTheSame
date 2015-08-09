package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.R.color;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.View;

public class AdditionAndSubstractionSetsView extends View  {

	private static final long serialVersionUID = 8469603708744698511L;

	private ArrayList<Bitmap> bitmapsSetOne;
	private ArrayList<Bitmap> bitmapsSetTwo;
	private ArrayList<Rect> boundsBitmapsSetOne;
	private ArrayList<Rect> boundsBitmapsSetTwo;
	private Random r = new Random();
	private int vWidth = 500, vHeight = 300;
	private Rect bounds;
	private Paint paint = new Paint();
	private int numberOfObjectsSetOne;
	private int numberOfObjectsSetTwo;
	private String sign;

	public AdditionAndSubstractionSetsView(Context context, int howManySetOne,int howManySetTwo,String sign, int width, int height) {
		super(context);
		// TODO Auto-generated constructor stubs
		bitmapsSetOne = new ArrayList<Bitmap>();
		bitmapsSetTwo = new ArrayList<Bitmap>();
		boundsBitmapsSetOne = new ArrayList<Rect>();
		boundsBitmapsSetTwo = new ArrayList<Rect>();
		numberOfObjectsSetOne=howManySetOne;
		numberOfObjectsSetTwo=howManySetTwo;
		vWidth=width;
		vHeight=height;
		this.sign=sign;
		addScaledBitmaps(bitmapsSetOne,numberOfObjectsSetOne);
		addScaledBitmaps(bitmapsSetTwo, numberOfObjectsSetTwo);
		addBitmaps(vWidth,vHeight/2,boundsBitmapsSetOne,bitmapsSetOne);
		addBitmaps(vWidth, vHeight, boundsBitmapsSetTwo, bitmapsSetTwo);
		paint.setStyle(Paint.Style.STROKE);
	}

	public AdditionAndSubstractionSetsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		bitmapsSetOne = new ArrayList<Bitmap>();
		bitmapsSetTwo = new ArrayList<Bitmap>();
		boundsBitmapsSetOne = new ArrayList<Rect>();
		boundsBitmapsSetTwo = new ArrayList<Rect>();

	
	
		paint.setStyle(Paint.Style.STROKE);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub

		super.onDraw(canvas);
		//canvas.onDraw(canvas);
		//canvas.drawColor(0, Mode.CLEAR);
		//canvas.drawColor(color.holo_red_light);
		for (int i = 0; i < numberOfObjectsSetOne; ++i) {
			//bounds = boundsBitmapsSetOne.get(i);
			//canvas.drawBitmap(bitmapsSetTwo.get(i), bounds.left, bounds.top, paint);
		}
		canvas.drawRect(0, vHeight/2,vWidth,vHeight/2+15,paint);
		//for (int i = 0; i < numberOfObjectsSetTwo; ++i) {
			//bounds = boundsBitmapsSetTwo.get(i);
			//canvas.drawBitmap(bitmapsSetTwo.get(i), bounds.left, bounds.top+vHeight/2, paint);
		//}
		
		
	}

	public int c = 0; // c is a counter of frames

	/*@Override
	public void draw(Canvas canvas) {
		c++;
		if (c >= 2 && c <= 4) { // change it to your own condition, the goal is
								// to draw it only two times(2 passes), every
								// time you need to "refresh" the screen
			canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);
		}
	} */

	private void drawSurface(Canvas canvas) {

		canvas.drawColor(color.holo_red_light, Mode.CLEAR);
		for (int i = 0; i < bitmapsSetOne.size(); ++i) {
			bounds = boundsBitmapsSetOne.get(i);
			canvas.drawBitmap(bitmapsSetOne.get(i), bounds.left, bounds.top, paint);
		}

	}

	private boolean isColiding(int x, int y, int width, int height,ArrayList<Rect> boundsRect) {

		for (Rect bounds : boundsRect) {

			if (bounds.left < x + width && bounds.left + bounds.width() > x
					&& bounds.top < y + height
					&& bounds.height() + bounds.top > y) {
				return true;
			}
		}
		return false;
	}

	private void addBitmaps(int width, int height,ArrayList<Rect> boundsRect, ArrayList<Bitmap> bitmaps) {

		int i = 0;
		while (boundsRect.size() < bitmaps.size()) {

			int x = r.nextInt(width - 110);
			int y = r.nextInt(height - 110);

			if (!isColiding(x, y, 110, 110,boundsRect)) {

				bounds = new Rect(x, y, x + 110, y + 110);
				boundsRect.add(bounds);

				++i;
			}

		}

	}

	private void addScaledBitmaps(ArrayList<Bitmap> bitmaps,int numberOfObjects) {

		int n = numberOfObjects;
		Bitmap b = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
				getResources(), R.drawable.piperka), 50, 50, true);

		for (int i = 0; i < n; ++i) {
			 bitmaps.add(b);
		}

	}

}
