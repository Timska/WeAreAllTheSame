package weareallthesame.view.games.orderelementsgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import weareallthesame.view.games.hangmangame.HangmanGameTextViewAdapter;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderElementsActivity extends Activity implements
		OrderElementsViewInterface {

	private final static int COLOR = Color.rgb(255, 255, 102);
	private ArrayList<String> answers;
	private ArrayList<String> ordered;
	private ArrayList<TextView> txtAnswers;
	private LinearLayout container;
	private DisplayMetrics displayMetrics;
	private int width, height;
	private ApplicationInterface appInterface;
	private GridView answersContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_elements);

		getMetrics();

		/*
		 * answers = new ArrayList<String>(); answers.add("igor");
		 * answers.add("zorica"); answers.add("marija");
		 * answers.add("aleksandra"); answers.add("martin");
		 */

		txtAnswers = new ArrayList<TextView>();

		container = (LinearLayout) findViewById(R.id.order_elements_container);
		answersContainer = (GridView) findViewById(R.id.order_elements_answers_container);

		openGame();
		setTextViews();
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		container.setOrientation(LinearLayout.VERTICAL);
		layoutParams.setMargins(0, 5, 0, 5);
		addViewsTagsAndListeners(layoutParams);

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

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
							R.string.order_elements_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addViewsTagsAndListeners(LinearLayout.LayoutParams layPar) {
		for (int i = 0; i < answers.size(); ++i) {
			String tag = (String) txtAnswers.get(i).getTag();
			tag += " " + i;
			txtAnswers.get(i).setTag(tag);
			container.addView(txtAnswers.get(i), layPar);
			txtAnswers.get(i).setOnLongClickListener(new MyClickListener());
			txtAnswers.get(i).setOnDragListener(new MyDragListener());
		}

	}

	private void setTextViews() {
		for (int i = 0; i < answers.size(); ++i) {
			TextView tx = new TextView(getApplicationContext());
			tx.setText(answers.get(i));
			tx.setHeight(height / (answers.size() + 3));
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

	@Override
	public void setElements(Set<String> elements) {
		// System.out.println(elements.size());
		answers = new ArrayList<String>();
		Iterator<String> it = elements.iterator();
		while (it.hasNext()) {
			String answer = it.next();
			answers.add(answer);
		}
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		answersContainer.setAdapter(new  OrderElementsTextViewAdapter(this,
				answers, tf, COLOR));
		// Collections.sort(answers);
	}

	@Override
	public void setOrdered(List<String> orderedElements) {
		ordered = new ArrayList<String>();
		Iterator<String> it = orderedElements.iterator();
		while (it.hasNext()) {
			String answer = it.next();
			System.out.println(answer);
			ordered.add(answer);
		}

	}

	@Override
	public void wrongAnswer() {
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
}
