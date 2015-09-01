package weareallthesame.view.games.classifyitemsgames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.nfc.cardemulation.OffHostApduService;
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
import android.widget.Toast;

public class ClassifyTheElementsActivity extends Activity implements
		ClassifyItemsViewInterface {

	private final static int COLORGROUPONE = Color.rgb(247, 129, 129);
	private final static int COLORGROUPTWO = Color.rgb(129, 185, 248);
	private final static int COLOROFFEREDELEMENTS = Color.rgb(244, 236, 95);
	private ArrayList<Item> answers;
	private ArrayList<String> elements;
	private ArrayList<String> elementsGroupOne;
	private ArrayList<String> elementsGroupTwo;
	private GridView container, containerGroupOne, containerGroupTwo;
	private ApplicationInterface appInterface;
	private DisplayMetrics displayMetrics;
	private int width, height;
	private String longestAnswer;
	private GridView.LayoutParams params;
	private TextView groupOneDescription, groupTwoDescription;
	private Typeface tf;
	private Item clickedItem;
	private String categoryOne, categoryTwo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify_the_elements);

		getMetrics();
		initializeViews();
		 elements = new ArrayList<String>();
		elementsGroupOne = new ArrayList<String>();
		elementsGroupTwo = new ArrayList<String>();
		tf = Typeface.createFromAsset(getAssets(), "fonts/amerika_.ttf");
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
		containerGroupOne = (GridView) findViewById(R.id.classify_elements_group_one_container);
		containerGroupTwo = (GridView) findViewById(R.id.classify_elements_group_two_container);
		ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
		layoutParams.height = height / 7; // this is in pixels
		container.setLayoutParams(layoutParams);
		containerGroupOne.setLayoutParams(layoutParams);
		containerGroupTwo.setLayoutParams(layoutParams);
		container.setBackground(getGradientDrawable(COLOROFFEREDELEMENTS));
		containerGroupOne.setBackground(getGradientDrawable(COLORGROUPONE));
		containerGroupTwo.setBackground(getGradientDrawable(COLORGROUPTWO));
		groupOneDescription = (TextView) findViewById(R.id.classify_elements_group_one_description);
		groupTwoDescription = (TextView) findViewById(R.id.classify_elements_group_two_description);

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

		answers = new ArrayList<Item>();
		elements = new ArrayList<String>();
		longestAnswer = "";
		Iterator<Item> it = offeredItems.iterator();
		while (it.hasNext()) {

			Item item = it.next();
			answers.add(item);
			String text = item.getName();
			elements.add(text);
			if (text.length() > longestAnswer.length()) {
				longestAnswer = text;
			}
		}

		int txtWidth = this.width / 3;
		int txtHeight = this.height / 10;
		System.out.println("djhfkfhs"+elements.size());

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
				i=1;

			} else {
				Entry<String, Set<Item>> element = it.next();
				groupTwoItems = element.getValue();
				nameGroupTwo = element.getKey();
				i=0;
			}
			
		}

		groupOneDescription.setText(nameGroupOne);
		groupTwoDescription.setText(nameGroupTwo);

		// System.out.println(elements.size());

		longestAnswer = "";
		Iterator<Item> itemsOneIterator = groupOneItems.iterator();
		while (it.hasNext()) {

			String text = itemsOneIterator.next().getName();
			elementsGroupOne.add(text);
			elements.add(text);
			if (text.length() > longestAnswer.length()) {
				longestAnswer = text;
			}
		}
		System.out.println(elementsGroupOne.size()+"Elements one size");
		containerGroupOne.setAdapter(new ClassifyItemsTextViewAdapter(this,
				elementsGroupOne, tf, 0, 0, COLORGROUPONE, longestAnswer));
		longestAnswer = "";

		Iterator<Item> itemsTwoIterator = groupTwoItems.iterator();
		while (it.hasNext()) {
			String text = itemsTwoIterator.next().getName();
			elementsGroupOne.add(text);
			elements.add(text);
			if (text.length() > longestAnswer.length()) {
				longestAnswer = text;
			}

		}
		containerGroupTwo.setAdapter(new ClassifyItemsTextViewAdapter(this,
				elementsGroupTwo, tf, 0, 0, COLORGROUPTWO, longestAnswer));

		System.out.println("Elements" + elements.size());
		containerGroupOne.setOnDragListener(new MyDragListener(
				containerGroupOne, elements, elementsGroupOne, longestAnswer,
				COLORGROUPONE, nameGroupOne));
		containerGroupTwo.setOnDragListener(new MyDragListener(
				containerGroupTwo, elements, elementsGroupTwo, longestAnswer,
				COLORGROUPTWO, nameGroupTwo));

	}

	@Override
	public void wrongChoice() {
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
			clickedItem = answers.get(position);
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

		GridView containerTo;
		ArrayList<String> listFrom = new ArrayList<String>();
		ArrayList<String> listTo = new ArrayList<String>();
		String longestString;
		String category;
		int color;

		public MyDragListener(GridView containerTo, ArrayList<String> listFrom,
				ArrayList<String> listTo, String longest, int color,
				String category) {
			this.containerTo = containerTo;
			this.listFrom = listFrom;
			this.listTo = listTo;
			this.longestString = longest;
			this.color = color;
			this.category = category;
		}

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
				try {
					appInterface.executeCommand("classifyitem", clickedItem,
							category);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					// if(e instanceof ObjectDoesNotBelongInSetException){
					draggedTextView.setVisibility(View.VISIBLE);
					return false;
					// }
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

	private GradientDrawable getGradientDrawable(int color) {

		GradientDrawable gd = new GradientDrawable();
		// gd.setColor(color);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.RECTANGLE);
		gd.setStroke(2, color, 5, 5);
		return gd;

	}

}
