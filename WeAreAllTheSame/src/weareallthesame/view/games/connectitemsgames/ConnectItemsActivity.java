package weareallthesame.view.games.connectitemsgames;

import java.util.ArrayList;
import java.util.List;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
	private ArrayList<Item> items;
	private ArrayList<String> strings;
	private LinearLayout layoutLetters;
	private LinearLayout layoutImages;
	private DisplayMetrics displayMetrics;
	private int width, height, counts = 0;
	private ApplicationInterface appInterface;
	private LinearLayout.LayoutParams layoutParamsSpaces, layoutParams;
	private int to, from;
	private Animation animation;

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
		animation = AnimationUtils.loadAnimation(this,
				R.anim.choose_character_from_sound_animation_scaling);

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

		listWords = new ArrayList<TextView>();
		for (int i = 0; i < words.size(); ++i) {

			TextView txL = new TextView(getApplicationContext());
			// TextView txS = new TextView(getApplicationContext());

			txL.setBackground(getGradientDrawable(COLOR, true));
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

		listImages = new ArrayList<ImageView>();
		for (int i = 0; i < items.size(); ++i) {

			ImageView txL = new ImageView(getApplicationContext());
			// TextView txS = new TextView(getApplicationContext());

			txL.setBackground(getGradientDrawable(COLOR, true));
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

	private GradientDrawable getGradientDrawable(int color, boolean dashed) {

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(color);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.OVAL);
		// gd.setStroke(1, 0xFF000000);
		if(dashed){
			gd.setStroke(2, Color.BLACK, 5, 5);
		}
		else{
			gd.setStroke(3, Color.BLACK);
		}
		
		return gd;

	}

	private class MyTouchListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			ViewGroup draggedImageViewParentLayout = (ViewGroup) v.getParent();
			if (counts == 0) {

				if (draggedImageViewParentLayout.equals(layoutLetters)) {
					TextView view = (TextView) v;
					to = listWords.indexOf(view);
					//draggedImageViewParentLayout.removeView(view);
					view.setBackground(getGradientDrawable(COLOR, false));
					
					//view.startAnimation(animation);
					counts = 1;

				} else {
					Toast.makeText(getApplicationContext(),
							"Мора да кликнете на еден од зборовите.",
							Toast.LENGTH_SHORT).show();
					// from=-1;
				}

			} else if (counts == 1) {

				if (draggedImageViewParentLayout.equals(layoutImages)) {
					ImageView view = (ImageView) v;
					//view.setBackgroundColor(Color.BLUE);
					counts = 0;
					from = listImages.indexOf(view);
					//view.startAnimation(animation);
					try {
						System.out.println("indeksi"+to+" "+from);
						appInterface.executeCommand("AddConnection",
								from, to);
					} catch (Exception e) {
						listWords.get(to).setBackground(getGradientDrawable(COLOR, true));
						
						e.printStackTrace();
					}
					 //draggedImageViewParentLayout.removeView(view);
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

		this.items = (ArrayList<Item>) items;
		this.strings = (ArrayList<String>) strings;
		layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT, height
						/ (15));

		layoutParams.setMargins(width / 7, 10, width / 7, 0);
		layoutParams.gravity = Gravity.CENTER;

		layoutParams.setMargins(width / 7, 10, width / 7, 0);

		layoutParamsSpaces = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT, height
						/ (items.size() + 3));
		layoutParamsSpaces.setMargins(0, 10, width / 7, 0);
		setTextViews((ArrayList<String>) strings);
		setTextViewsBackgrounds((ArrayList<Item>) items);
		
		layoutLetters.removeAllViewsInLayout();
		layoutImages.removeAllViewsInLayout();
		for (int i = 0; i < listWords.size(); ++i) {
			listWords.get(i).setOnClickListener(new MyTouchListener());
			listImages.get(i).setOnClickListener(new MyTouchListener());
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

		Toast.makeText(getApplicationContext(), "Неточен одговор",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void gameOver() {

		Intent intent = new Intent(this, GameOverChoiceActivity.class);
		startActivityForResult(intent, 0);
		/*
		 * try { appInterface.exitGame(); } catch (GameNotOpenException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

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
