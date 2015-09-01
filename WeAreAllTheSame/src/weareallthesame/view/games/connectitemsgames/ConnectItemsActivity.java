package weareallthesame.view.games.connectitemsgames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectItemsActivity extends Activity implements
		ConnectItemAndResursViewInterface {

	private static final long serialVersionUID = 6373187583074782521L;
	private static final int COLOR = Color.rgb(88, 243, 129);
	private ArrayList<TextView> listWords;
	private ArrayList<ImageView> listImages;
	private LinearLayout layoutLetters;
	private LinearLayout layoutImages;
	private DisplayMetrics displayMetrics;
	private int width, height, counts = 0;
	private ApplicationInterface appInterface;
	private LinearLayout.LayoutParams layoutParamsSpaces, layoutParams;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_connect_items);

		getMetrics();
		initializeViews();
		openGame();

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

	}

	private void initializeViews() {
		listWords = new ArrayList<TextView>();
		listImages = new ArrayList<ImageView>();
		layoutLetters = (LinearLayout) findViewById(R.id.connect_items_layout_letters);
		layoutImages = (LinearLayout) findViewById(R.id.connect_items_layout_images);

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
							R.string.connect_items_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setTextViews(ArrayList<String> words) {

		for (int i = 0; i < words.size(); ++i) {

			TextView txL = new TextView(getApplicationContext());
			// TextView txS = new TextView(getApplicationContext());

			txL.setBackground(getGradientDrawable(COLOR));
			// txS.setBackground(getGradientDrawable());

			txL.setText(words.get(i));

			txL.setGravity(Gravity.CENTER);
			// .setGravity(Gravity.CENTER);

			txL.setTextColor(Color.BLACK);
			// txS.setTextColor(Color.BLACK);

			txL.setWidth(width / 4);
			// txS.setWidth(width / 4);

			txL.setHeight(height / 16);
			// txS.setHeight(height / 10);

			listWords.add(txL);
			// listImages.add(txS);
		}

	}

	private void setTextViewsBackgrounds(ArrayList<Item> items) {

		for (int i = 0; i < items.size(); ++i) {

			ImageView txL = new ImageView(getApplicationContext());
			// TextView txS = new TextView(getApplicationContext());

			txL.setBackground(getGradientDrawable(COLOR));
			// txS.setBackground(getGradientDrawable());

			int id = getResources().getIdentifier(
					items.get(i).getResourceNames().get("picture"), "drawable",
					this.getPackageName());
			txL.setScaleType(ImageView.ScaleType.FIT_CENTER);
			txL.setBackgroundResource(id);

			// txL.setGravity(Gravity.CENTER);
			// .setGravity(Gravity.CENTER);

			// txL.setTextColor(Color.BLACK);
			// txS.setTextColor(Color.BLACK);

			// txL.setWidth(width / 4);
			// txS.setWidth(width / 4);

			// txL.setHeight(height / 16);
			// txS.setHeight(height / 10);

			System.out.println("lalala");
			listImages.add(txL);
			// listImages.add(txS);
		}

	}

	private GradientDrawable getGradientDrawable(int color) {

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(color);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.OVAL);
		// gd.setStroke(1, 0xFF000000);
		gd.setStroke(2, Color.BLACK, 5, 5);

		return gd;

	}

	private class MyTouchListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			TextView view = (TextView) v;
			ViewGroup draggedImageViewParentLayout = (ViewGroup) view
					.getParent();
			if (counts == 0) {

				if (draggedImageViewParentLayout.equals(layoutLetters)) {

					// draggedImageViewParentLayout.removeView(view);
					view.setBackgroundColor(Color.BLUE);
					counts = 1;

				} else {
					Toast.makeText(getApplicationContext(),
							"Мора да кликнете на еден од зборовите.",
							Toast.LENGTH_SHORT).show();
				}

			} else if (counts == 1) {

				if (draggedImageViewParentLayout.equals(layoutImages)) {

					view.setBackgroundColor(Color.BLUE);
					counts = 0;
					// draggedImageViewParentLayout.removeView(view);
					// layoutLetters.removeView(firstItem);

				} else {
					Toast.makeText(getApplicationContext(),
							"Мора да кликнете на една од сликите.",
							Toast.LENGTH_SHORT).show();
				}

				// counts=0;
			}

		}

	}

	@Override
	public void initArrays(List<Item> items, List<String> strings) {
		// TODO Auto-generated method stub

		layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT, height
						/ (items.size() + 2));

		layoutParams.setMargins(width / 7, 10, width / 7, 0);
		layoutParams.gravity = Gravity.CENTER;

		layoutParams.setMargins(width / 7, 10, width / 7, 0);

		layoutParamsSpaces = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT, height
						/ (items.size() + 2));
		layoutParamsSpaces.setMargins(0, 10, width / 7, 0);
		setTextViews((ArrayList<String>) strings);
		setTextViewsBackgrounds((ArrayList<Item>) items);
		for (int i = 0; i < listWords.size(); ++i) {
			// listWords.get(i).setOnClickListener(new MyTouchListener());
			// listImages.get(i).setOnClickListener(new MyTouchListener());
			layoutLetters.addView(listWords.get(i), layoutParams);
			layoutImages.addView(listImages.get(i), layoutParamsSpaces);

		}

	}

	@Override
	public void initConnections(int[] connections) {
		// TODO Auto-generated method stub

	}

	@Override
	public void wrongAnswer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub

	}
}
