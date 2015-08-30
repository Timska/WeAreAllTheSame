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
import android.view.View;
import android.view.View.DragShadowBuilder;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify_the_elements);

		getMetrics();
		initializeViews();
		elements = new ArrayList<String>();
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
				tf, txtWidth, txtHeight, COLORGROUPONE, longestAnswer));

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
		while (it.hasNext()) {
			if (i == 0) {
				groupOneItems = it.next().getValue();
			} else {
				groupTwoItems = it.next().getValue();
			}
		}
		Iterator<Item> itemsOneIterator = groupOneItems.iterator();
		while (it.hasNext()) {
			String text = itemsOneIterator.next().getName();
			groupOne.addView(createTextView(text), params);
		}
		Iterator<Item> itemsTwoIterator = groupTwoItems.iterator();
		while (it.hasNext()) {
			String text = itemsTwoIterator.next().getName();
			groupOne.addView(createTextView(text), params);
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

	private TextView createTextView(String text) {

		TextView tx = new TextView(this);
		tx.setTextColor(COLORGROUPONE);
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

}
