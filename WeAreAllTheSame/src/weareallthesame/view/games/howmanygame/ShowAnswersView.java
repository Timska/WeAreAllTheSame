package weareallthesame.view.games.howmanygame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import weareallthesame.model.items.Item;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class ShowAnswersView extends SurfaceView implements
		SurfaceHolder.Callback {

	private ArrayList<String> lstAnswers;
	private ArrayList<ShapeDrawable> lstDrawables;
	private TextPaint txtPaint = makeTextPaint();
	private Rect bounds = new Rect();
	int x, y, width, height;
	int vWidth, vHeight;
	private Random r = new Random();
	private SurfaceHolder surfaceHolder;
	private ShapeDrawable sd;
	private ArrayList<Integer> colors = generateColors();

	public ShowAnswersView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub

		lstAnswers = new ArrayList<String>();
		lstDrawables = new ArrayList<ShapeDrawable>();
		fillAnswers();
		surfaceHolder = getHolder();
		surfaceHolder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		addShapes();
		Canvas canvas = null;
		canvas = surfaceHolder.lockCanvas();
		if (null != canvas) {
			drawSurface(canvas);
			surfaceHolder.unlockCanvasAndPost(canvas);
		}

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	private void drawSurface(Canvas canvas) {

		canvas.drawColor(Color.rgb(244, 252, 244));

		for (int k = 0; k < lstDrawables.size(); ++k) {

			sd = lstDrawables.get(k);
			sd.draw(canvas);
			bounds = sd.getBounds();
			canvas.drawText(lstAnswers.get(k), bounds.centerX(),
					bounds.centerY(), txtPaint);

		}

	}

	private void addShapes() {

		int i = 0;
		Shape shape;

		while (i < lstAnswers.size()) {

			shape = new OvalShape();

			width = (int) txtPaint.measureText(lstAnswers.get(i)) + 30;
			height = 100;

			x = r.nextInt(getWidth() - width);

			y = r.nextInt(getHeight() - height);

			if (!isColiding(x, y, width, height)) {

				ShapeDrawable sd = new ShapeDrawable(shape);
				sd.setBounds(x, y, x + width, y + height);

				int index = r.nextInt(colors.size());
				sd.getPaint().setColor(colors.get(index));
				
				sd.getPaint().setTextAlign(Align.CENTER);
				lstDrawables.add(sd);
				++i;

			}

		}

	}

	private boolean isColiding(int x, int y, int width, int height) {

		for (ShapeDrawable sd : lstDrawables) {

			bounds = sd.getBounds();
			if (bounds.left < x + width && bounds.left + bounds.width() > x
					&& bounds.top < y + height
					&& bounds.height() + bounds.top > y) {
				return true;
			}
		}
		return false;
	}

	private boolean isHitted(int x, int y) {

		for (int k = 0; k < lstDrawables.size(); ++k) {

			bounds = lstDrawables.get(k).getBounds();
			if (bounds.contains(x, y)) {
				if (lstAnswers.get(k).equals("ma")) {
					Toast.makeText(getContext(), "Точен одговор!",
							Toast.LENGTH_SHORT).show();
					return true;
				} else {
					Toast.makeText(getContext(), "Неточен одговор. ",
							Toast.LENGTH_SHORT).show();
					return false;
				}

			}
		}

		return false;
	}

	public void fillAnswers() {

		lstAnswers.add("eden");
		lstAnswers.add("dva");
		lstAnswers.add("tri");
		lstAnswers.add("cetiri");

	}

	private TextPaint makeTextPaint() {

		TextPaint p = new TextPaint();
		p.setTypeface(Typeface.create("Helvetica", Typeface.BOLD_ITALIC));
		p.setTextSize(40);
		p.setTextAlign(Align.CENTER);
		return p;
	}

	private ArrayList<Integer> generateColors() {

		ArrayList<Integer> colors = new ArrayList<Integer>();
		colors.add(Color.rgb(235, 77, 77));
		colors.add(Color.rgb(88, 243, 129));
		colors.add(Color.rgb(192, 142, 213));
		colors.add(Color.rgb(137, 170, 220));
		colors.add(Color.rgb(88, 243, 129));

		return colors;
	}



	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		int xposition = (int) event.getX();
		int yposition = (int) event.getY();

		return isHitted(xposition, yposition);
	}
	
	
 

}
