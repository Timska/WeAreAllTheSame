package weareallthesame.view.games.classifyitemsgames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClassifyTheElementsActivity extends Activity implements
		ClassifyItemsViewInterface {

	private final static int COLORGROUPONE = Color.rgb(247, 129, 129);
	private final static int COLORGROUPTWO = Color.rgb(129, 185, 248);
	private final static int COLOROFFEREDELEMENTS = Color.rgb(244, 236, 95);
	private ArrayList<String> elements;
	private ArrayList<String> elementsGroupOne;
	private ArrayList<String> elementsGroupTwo;
	private LinearLayout groupOne;
	private LinearLayout groupTwo;
	private GridView container;
	private ApplicationInterface appInterface;
	private DisplayMetrics displayMetrics;
	private int width, height;
	private String longestAnswer;
	private LinearLayout.LayoutParams params;
	private TextView groupOneDescription, groupTwoDescription;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify_the_elements);

		getMetrics();
		initializeViews();
		// elements = new ArrayList<String>();
		elementsGroupOne = new ArrayList<String>();
		elementsGroupTwo = new ArrayList<String>();
		openGame();

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void initializeViews() {
		container = (GridView) findViewById(R.id.classify_elements_container);
		groupOne = (LinearLayout) findViewById(R.id.classify_elements_group_one);
		groupTwo = (LinearLayout) findViewById(R.id.classify_elements_group_two);
		params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		params.setMargins(5, 5, 5, 5);
		groupOneDescription=(TextView) findViewById(R.id.classify_elements_group_one_description);
		groupTwoDescription=(TextView) findViewById(R.id.classify_elements_group_two_description);

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
							R.string.classify_elements_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setOrUpdate(Set<Item> offeredItems) {
		// TODO Auto-generated method stub

		elements = new ArrayList<String>();
		longestAnswer = "";
		Iterator<Item> it = offeredItems.iterator();
		while (it.hasNext()) {
			String text = it.next().getName();
			elements.add(text);
			if (text.length() > longestAnswer.length()) {
				longestAnswer = text;
			}
		}
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		int txtWidth = this.width / 3;
		int txtHeight = this.height / 10;

		container.setAdapter(new ClassifyItemsTextViewAdapter(this, elements,
				tf, txtWidth, txtHeight, COLOROFFEREDELEMENTS, longestAnswer));

		container
				.setOnItemLongClickListener((OnItemLongClickListener) new MyLongClickListener());
	}

	@Override
	public void setOrUpdateClassElements(Map<String, Set<Item>> classSetMap) {
		// TODO Auto-generated method stub
		System.out.println(classSetMap.size());
		Set<Entry<String, Set<Item>>> entryset = classSetMap.entrySet();
		Iterator<Entry<String, Set<Item>>> it = entryset.iterator();
		int i = 0;
		Set<Item> groupOneItems = null;
		Set<Item> groupTwoItems = null;
		String nameGroupOne = "";
		String nameGroupTwo = "";
		while (it.hasNext()) {
			if (i == 0) {
				Entry<String, Set<Item>> element = it.next();
				groupOneItems = element.getValue();
				nameGroupOne = element.getKey();

			} else {
				Entry<String, Set<Item>> element = it.next();
				groupTwoItems = element.getValue();
				nameGroupTwo = element.getKey();
			}
			++i;
		}

		groupOneDescription.setText(nameGroupOne);
		groupTwoDescription.setText(nameGroupTwo);
		groupOne.addView(createTextView(nameGroupOne, COLORGROUPONE), params);
		groupTwo.addView(createTextView(nameGroupTwo, COLORGROUPTWO), params);

		Iterator<Item> itemsOneIterator = groupOneItems.iterator();
		while (it.hasNext()) {
			String text = itemsOneIterator.next().getName();
			groupOne.addView(createTextView(text, COLORGROUPONE), params);
		}
		Iterator<Item> itemsTwoIterator = groupTwoItems.iterator();
		while (it.hasNext()) {
			String text = itemsTwoIterator.next().getName();
			groupOne.addView(createTextView(text, COLORGROUPTWO), params);
		}

	}

	@Override
	public void wrongChoice() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub

	}

	private TextView createTextView(String text, int color) {

		TextView tx = new TextView(this);
		tx.setTextColor(color);
		tx.setTag("Correct");
		return tx;

	}

	private class MyLongClickListener implements OnItemLongClickListener {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View v,
				int position, long id) {
			// TODO Auto-generated method stub

			ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
			String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
			System.out.println(item.toString());
			ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
			DragShadowBuilder dsb = new View.DragShadowBuilder(v);

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
				String tagDragged = (String) draggedTextView.getTag();
				try {
					appInterface.executeCommand("ChooseString",
							draggedTextView.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (tagDragged.equals("Correct")) {
					ViewGroup draggedImageViewParentLayout = (ViewGroup) draggedTextView
							.getParent();
					draggedImageViewParentLayout.removeView(draggedTextView);
					LinearLayout receiving = (LinearLayout) receivingLayoutView;
					receiving.addView(draggedImageViewParentLayout);
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
