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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class OrderElementsActivity extends Activity implements
		OrderElementsViewInterface {

	private final static int COLORBLUE = Color.rgb(127, 185, 229);
	private final static int COLORGREEN = Color.rgb(89, 230, 127);
	private ArrayList<String> answers;
	private ArrayList<String> ordered;
	private ArrayList<TextView> txtAnswers;
	private LinearLayout container;
	private DisplayMetrics displayMetrics;
	private int width, height;
	private ApplicationInterface appInterface;
	private GridView answersContainer;
	private LinearLayout.LayoutParams layoutParams;
	private int positionFrom;
	private String clickedText;

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

		initializeViews();
		openGame();
		
		// addViewsTagsAndListeners(layoutParams);

	}

	private void initializeViews(){
		txtAnswers = new ArrayList<TextView>();

		container = (LinearLayout) findViewById(R.id.order_elements_layout);
		answersContainer = (GridView) findViewById(R.id.order_elements_answers_container);

		layoutParams = new LinearLayout.LayoutParams(
				width/3,
				height/15);
		layoutParams.gravity=Gravity.CENTER;
		container.setOrientation(LinearLayout.VERTICAL);
		layoutParams.setMargins(0, 5, 0, 5);
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



	private GradientDrawable getGradientDrawable(int color) {

		// int i = colors.get(r.nextInt(colors.size()));

		// int i = colors.get(r.nextInt(colors.size()));
		GradientDrawable gd = new GradientDrawable();
		//gd.setOrientation(Orientation.LEFT_RIGHT);
		gd.setColor(color);
		// gd.setColor(i);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.RECTANGLE);
		// gd.setStroke(1, 0xFF000000);
		gd.setStroke(2, Color.BLACK, 5, 5);

		return gd;

	}

	private class MyLongClickListener implements OnItemLongClickListener {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View v,
				int position, long id) {
			// TODO Auto-generated method stub
			positionFrom = position;
			ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
			String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
			System.out.println(item.toString());
			ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
			DragShadowBuilder dsb = new View.DragShadowBuilder(v);
			clickedText=(String) ((TextView)v).getText();
			v.startDrag(data, dsb, v, 0);
			v.setVisibility(View.INVISIBLE);
			return false;
		}

	}

	private class MyDragListener implements OnDragListener {

		@Override
		public boolean onDrag(View receivingLayoutView, DragEvent event) {
			// TODO Auto-generated method stub

			TextView draggedTextView = (TextView) event.getLocalState();

			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				break;
			case DragEvent.ACTION_DRAG_LOCATION:
				break;
			case DragEvent.ACTION_DROP:
				TextView tx = (TextView) receivingLayoutView;
				int index=txtAnswers.indexOf(tx);
				//String text = (String) draggedTextView.getText();
				try {
					
					appInterface.executeCommand("SetElementOnPosition",
							index, clickedText);
				
					
					//tx.setText(text);
					return true;
					//return true;

				} catch (Exception e) {
					draggedTextView.setVisibility(View.VISIBLE);
					Toast.makeText(getApplicationContext(), "Неточен одговор",
							Toast.LENGTH_SHORT).show();
					e.printStackTrace();
					return false;
					// }
				}
				
				// tx.setText(Character.toString(value));

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


	private void setTextViews(int num) {
		for (int i = 0; i < num; ++i) {
			TextView tx = new TextView(getApplicationContext());
			tx.setHeight(height / (12));
			tx.setGravity(Gravity.CENTER);
			tx.setText("-");
			tx.setTag(String.format("%d", i));
			tx.setTextColor(Color.BLACK);
			tx.setBackground(getGradientDrawable(COLORGREEN));
			txtAnswers.add(tx);
			container.addView(tx, layoutParams);

		}

		// Collections.shuffle(txtAnswers);
	}
	private void setTextViews(ArrayList<String> answers) {
		for (int i = 0; i < answers.size(); ++i) {
			TextView tx = new TextView(getApplicationContext());
			tx.setHeight(height / (12));
			tx.setGravity(Gravity.CENTER);
			tx.setText(answers.get(i));
			tx.setTextSize(30);
			tx.setTag(String.format("%d", i));
			tx.setTextColor(COLORBLUE);
			tx.setBackground(getGradientDrawable(COLORGREEN));
			txtAnswers.add(tx);
			container.addView(tx, layoutParams);

		}

		// Collections.shuffle(txtAnswers);
	}

	@Override
	public void setElements(Set<String> elements) {
		// System.out.println(elements.size());
		setTextViews(elements.size());
		answers = new ArrayList<String>();
		Iterator<String> it = elements.iterator();
		while (it.hasNext()) {
			String answer = it.next();
			answers.add(answer);
		}
	
		
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		answersContainer.setAdapter(new OrderElementsTextViewAdapter(this,
			answers, tf, COLORBLUE));
		 Collections.sort(answers);
		 answersContainer.setOnItemLongClickListener(new MyLongClickListener());
		
	}

	@Override
	public void setOrdered(List<String> orderedElements) {
		ordered = new ArrayList<String>();
		txtAnswers=new ArrayList<TextView>();
		container.removeAllViewsInLayout();
		Iterator<String> it = orderedElements.iterator();
		while (it.hasNext()) {
			String answer = it.next();
			System.out.println(answer);
			ordered.add(answer);
		}
		setTextViews(ordered);
		for(int i=0;i<txtAnswers.size();++i){
			txtAnswers.get(i).setOnDragListener(new MyDragListener());
		}

	}

	@Override
	public void wrongAnswer() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "Неточен одговор",
				Toast.LENGTH_SHORT).show();

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
