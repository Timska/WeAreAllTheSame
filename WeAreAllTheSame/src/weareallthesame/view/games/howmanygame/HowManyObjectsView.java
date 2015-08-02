package weareallthesame.view.games.howmanygame;

import java.util.ArrayList;
import java.util.Set;

import weareallthesame.model.items.Item;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class HowManyObjectsView extends View implements HowManyViewInterface{

	private static final long serialVersionUID = 8469603708744698511L;

	private ArrayList<Item> items;
	private Paint paint;
	
	public HowManyObjectsView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		items=new ArrayList<Item>();
		paint=new Paint();
	}
	
	public HowManyObjectsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		items=new ArrayList<Item>();
		paint=new Paint();
		
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
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
