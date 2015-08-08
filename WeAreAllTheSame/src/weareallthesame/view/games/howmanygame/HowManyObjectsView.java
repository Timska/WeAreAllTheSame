package weareallthesame.view.games.howmanygame;

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

public class HowManyObjectsView extends View implements HowManyViewInterface {

	private static final long serialVersionUID = 8469603708744698511L;

	private ArrayList<Bitmap> bitmaps;
	private ArrayList<Rect> boundsBitmaps;
	private Random r = new Random();
	private DisplayMetrics displayMetrics;
	private int vWidth = 500, vHeight = 300;
	private Rect bounds;
	private Paint paint = new Paint();
	private SurfaceHolder surfaceHolder;

	public HowManyObjectsView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		bitmaps = new ArrayList<Bitmap>();
		boundsBitmaps = new ArrayList<Rect>();

		addScaledBitmaps();
		addBitmaps();
		paint.setStyle(Paint.Style.STROKE);
	}

	public HowManyObjectsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		bitmaps = new ArrayList<Bitmap>();
		boundsBitmaps = new ArrayList<Rect>();

		addScaledBitmaps();
		addBitmaps();
		paint.setStyle(Paint.Style.STROKE);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub

		super.onDraw(canvas);
		//canvas.onDraw(canvas);
		//canvas.drawColor(0, Mode.CLEAR);
		//canvas.drawColor(color.holo_red_light);
		for (int i = 0; i < bitmaps.size(); ++i) {
			bounds = boundsBitmaps.get(i);
			canvas.drawBitmap(bitmaps.get(i), bounds.left, bounds.top, paint);
		}
		
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
		for (int i = 0; i < bitmaps.size(); ++i) {
			bounds = boundsBitmaps.get(i);
			canvas.drawBitmap(bitmaps.get(i), bounds.left, bounds.top, paint);
		}

	}

	private boolean isColiding(int x, int y, int width, int height) {

		for (Rect bounds : boundsBitmaps) {

			if (bounds.left < x + width && bounds.left + bounds.width() > x
					&& bounds.top < y + height
					&& bounds.height() + bounds.top > y) {
				return true;
			}
		}
		return false;
	}

	private void addBitmaps() {

		int i = 0;
		while (boundsBitmaps.size() < bitmaps.size()) {

			int x = r.nextInt(vWidth - 110);
			int y = r.nextInt(vHeight - 110);

			if (!isColiding(x, y, 110, 110)) {

				bounds = new Rect(x, y, x + 110, y + 110);
				boundsBitmaps.add(bounds);

				++i;
			}

		}

	}

	private void addScaledBitmaps() {

		int n = r.nextInt(10) + 1;
		Bitmap b = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
				getResources(), R.drawable.piperka), 100, 100, true);

		for (int i = 0; i < n; ++i) {
			bitmaps.add(b);
		}

	}

	@Override
	public void setAnswer(Item item, int howMany) {
		// TODO Auto-generated method stub

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

}
