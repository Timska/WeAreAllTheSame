package weareallthesame.view.games.orderelementsgame;

import java.util.ArrayList;
import java.util.Collections;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderElementsActivity extends Activity {

	private ArrayList<String> answers;
	private ArrayList<TextView> txtAnswers;
	private LinearLayout container;
	private DisplayMetrics displayMetrics;
	private int width,height;
	private ApplicationInterface appInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_elements);

		openGame();
		
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
		
		
		answers = new ArrayList<String>();
		answers.add("igor");
		answers.add("zorica");
		answers.add("marija");
		answers.add("aleksandra");
		answers.add("martin");

		txtAnswers = new ArrayList<TextView>();

		container = (LinearLayout) findViewById(R.id.order_elements_container);
		LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		container.setOrientation(LinearLayout.VERTICAL);
		layoutParams.setMargins(0, 5, 0, 5);

		setTextViews();
		addViewsTagsAndListeners(layoutParams);

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

	private void addViewsTagsAndListeners(LinearLayout.LayoutParams layPar) {
		for (int i = 0; i < answers.size(); ++i) {
			String tag = (String) txtAnswers.get(i).getTag();
			tag += " " + i;
			txtAnswers.get(i).setTag(tag);
			container.addView(txtAnswers.get(i),layPar);
			txtAnswers.get(i).setOnLongClickListener(new MyClickListener());
			txtAnswers.get(i).setOnDragListener(new MyDragListener());
		}
		
	}

	private void setTextViews() {
		for (int i = 0; i < answers.size(); ++i) {
			TextView tx = new TextView(getApplicationContext());
			tx.setText(answers.get(i));
			tx.setHeight(height/(answers.size()+2));
			tx.setGravity(Gravity.CENTER);
			tx.setTag(String.format("%d", i));
			tx.setTextColor(Color.BLACK);
			tx.setBackground(getGradientDrawable());

			txtAnswers.add(tx);

		}
		Collections.shuffle(txtAnswers);
	}

	private GradientDrawable getGradientDrawable() {

		// int i = colors.get(r.nextInt(colors.size()));
		int[] colorsInt = { Color.rgb(83, 249, 94), Color.rgb(255, 255, 102) };

		// int i = colors.get(r.nextInt(colors.size()));
		GradientDrawable gd = new GradientDrawable();
		gd.setOrientation(Orientation.LEFT_RIGHT);
		gd.setColors(colorsInt);
		// gd.setColor(i);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.RECTANGLE);
		// gd.setStroke(1, 0xFF000000);
		gd.setStroke(2, Color.BLACK, 5, 5);

		return gd;

	}

	private final class MyClickListener implements OnLongClickListener {

		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
			ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
			String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
			System.out.println(item.toString());
			ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
			DragShadowBuilder dsb = new View.DragShadowBuilder(v);

			v.startDrag(data, dsb, v, 0);
			v.setVisibility(View.INVISIBLE);

			return true;
		}

	}

	private final class MyDragListener implements OnDragListener {

		@Override
		public boolean onDrag(View receivingLayoutView, DragEvent event) {
			// TODO Auto-generated method stub

			View draggedTextView = (View) event.getLocalState();

			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				break;
			case DragEvent.ACTION_DRAG_LOCATION:
				break;
			case DragEvent.ACTION_DROP:

				String tag = (String) draggedTextView.getTag();
				String[] tagsDraggedTextView = tag.split(" ");
				String[] tagsReceivingTextView = ((String) receivingLayoutView
						.getTag()).split(" ");

				if (tagsDraggedTextView[0].equals(tagsReceivingTextView[1])) {

					TextView dropTarget = (TextView) receivingLayoutView;
					TextView draggedView = (TextView) draggedTextView;
					String targetText = (String) dropTarget.getText();
					dropTarget.setText(draggedView.getText());
					draggedView.setText(targetText);
					draggedView.setTag(tagsReceivingTextView[0] + " "
							+ tagsDraggedTextView[1]);
					dropTarget.setTag(tagsDraggedTextView[0] + " "
							+ tagsReceivingTextView[1]);
					draggedTextView.setVisibility(View.VISIBLE);
					return true;
				} else {
					draggedTextView.setVisibility(View.VISIBLE);
					return false;
				}

			case DragEvent.ACTION_DRAG_ENDED:

				if (!event.getResult()) {

					draggedTextView.setVisibility(View.VISIBLE);
				}
			default:
				break;
			}
			return true;
		}

	}

}
