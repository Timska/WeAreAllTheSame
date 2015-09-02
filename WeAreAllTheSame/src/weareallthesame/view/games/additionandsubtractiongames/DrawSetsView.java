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

public class DrawSetsView extends View {

	private static final long serialVersionUID = 8469603708744698511L;
	private static final int PICTURESIZE = 150;
	//private ArrayList<Bitmap> bitmaps;
	private ArrayList<Rect> boundsBitmaps;
	private Random r = new Random();
	private int vWidth, vHeight, howMany;
	private Rect bounds;
	private Paint paint = new Paint();
	private Bitmap bitmap;

	public DrawSetsView(Context context, int howMany, int width, int height,
			Bitmap bitmap) {
		super(context);
		// TODO Auto-generated constructor stub
		//bitmaps = new ArrayList<Bitmap>();
		boundsBitmaps = new ArrayList<Rect>();
		this.vHeight = height;
		this.vWidth = width - PICTURESIZE;
		this.howMany = howMany;
		this.bitmap = bitmap;
		addScaledBitmaps();

		addBitmaps();
		paint.setStyle(Paint.Style.STROKE);
	}

	public DrawSetsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//bitmaps = new ArrayList<Bitmap>();
		boundsBitmaps = new ArrayList<Rect>();

		addScaledBitmaps();
		addBitmaps();
		paint.setStyle(Paint.Style.STROKE);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub

		super.onDraw(canvas);
		// canvas.onDraw(canvas);
		// canvas.drawColor(0, Mode.CLEAR);
		// canvas.drawColor(color.holo_red_light);
		for (int i = 0; i < howMany; ++i) {
			bounds = boundsBitmaps.get(i);
			canvas.drawBitmap(bitmap, bounds.left, bounds.top, paint);
		}

	}

	public int c = 0; // c is a counter of frames

	/*
	 * @Override public void draw(Canvas canvas) { c++; if (c >= 2 && c <= 4) {
	 * // change it to your own condition, the goal is // to draw it only two
	 * times(2 passes), every // time you need to "refresh" the screen
	 * canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR); } }
	 */

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
		while (boundsBitmaps.size() < howMany) {

			int x = r.nextInt(vWidth - PICTURESIZE);
			int y = r.nextInt(vHeight - PICTURESIZE);

			if (!isColiding(x, y, PICTURESIZE, PICTURESIZE)) {

				bounds = new Rect(x, y, x + PICTURESIZE, y + PICTURESIZE);
				boundsBitmaps.add(bounds);

				++i;
			}

		}

	}

	private void addScaledBitmaps() {

		int n = howMany;

		

	}

}
