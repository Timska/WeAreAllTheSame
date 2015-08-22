package weareallthesame.view.games.connectitemsgames;

import java.util.ArrayList;
import java.util.Random;

import weareallthesame.view.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectItemsActivity extends Activity {

	private static final long serialVersionUID = 6373187583074782521L;

	private ArrayList<TextView> listLetters;
	private ArrayList<TextView> listImages;
	private ArrayList<Integer> colors;
	private LinearLayout layoutLetters;
	private LinearLayout layoutImages;
	private Random r = new Random();
	private String word = "AVION";
	private String spaces = "AV_O_";
	private DisplayMetrics displayMetrics;
	private int width, height, counts = 0;
	private TextView firstItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_connect_items);

		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

		listLetters = new ArrayList<TextView>();
		listImages = new ArrayList<TextView>();
		colors = generateColors();

		setTextViews(word, spaces);

		layoutLetters = (LinearLayout) findViewById(R.id.connect_items_layout_letters);
		layoutImages = (LinearLayout) findViewById(R.id.connect_items_layout_images);

		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		layoutParams.setMargins(width / 7, 10, width / 7, 0);
		layoutParams.gravity = Gravity.CENTER;

		LinearLayout.LayoutParams layoutParamsSpaces = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(width / 7, 10, width / 7, 0);

		layoutParamsSpaces.setMargins(0, 10, width / 7, 0);

		for (int i = 0; i < listLetters.size(); ++i) {
			listLetters.get(i).setOnClickListener(new MyTouchListener());
			listImages.get(i).setOnClickListener(new MyTouchListener());
			layoutLetters.addView(listLetters.get(i), layoutParams);
			layoutImages.addView(listImages.get(i), layoutParamsSpaces);

		}

	}

	private void setTextViews(String word, String spaces) {

		for (int i = 0; i < word.length(); ++i) {

			TextView txL = new TextView(getApplicationContext());
			TextView txS = new TextView(getApplicationContext());

			txL.setBackground(getGradientDrawable());
			txS.setBackground(getGradientDrawable());

			txL.setText(word.charAt(i) + " ");
			txS.setText(spaces.charAt(i) + " ");

			txL.setTextAppearance(getApplicationContext(),
					android.R.style.TextAppearance_Large);
			txS.setTextAppearance(getApplicationContext(),
					android.R.style.TextAppearance_Large);

			txL.setGravity(Gravity.CENTER);
			txS.setGravity(Gravity.CENTER);

			txL.setTextColor(Color.BLACK);
			txS.setTextColor(Color.BLACK);

			txL.setWidth(width / 4);
			txS.setWidth(width / 4);

			txL.setHeight(height / 10);
			txS.setHeight(height / 10);

			listLetters.add(txL);
			listImages.add(txS);
		}

	}

	private ArrayList<Integer> generateColors() {

		ArrayList<Integer> colors = new ArrayList<Integer>();
		colors.add(Color.rgb(235, 77, 77));
		colors.add(Color.rgb(88, 243, 129));
		colors.add(Color.rgb(192, 142, 213));
		colors.add(Color.rgb(137, 170, 220));
		colors.add(Color.rgb(88, 243, 129));
		// colors.add(Color.rgb(244, 252, 244));
		colors.add(Color.rgb(255, 255, 102));

		return colors;
	}

	private GradientDrawable getGradientDrawable() {

		int i = colors.get(r.nextInt(colors.size()));
		GradientDrawable gd = new GradientDrawable();
		gd.setColor(i);
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
			ViewGroup draggedImageViewParentLayout = (ViewGroup) view.getParent();
			if (counts == 0) {
				
				if (draggedImageViewParentLayout.equals(layoutLetters)) {

					// draggedImageViewParentLayout.removeView(view);
					view.setBackgroundColor(Color.BLUE);
					counts = 1;
					firstItem = view;
				} else {
					Toast.makeText(getApplicationContext(),
							"Мора да кликнете на еден од зборовите.",
							Toast.LENGTH_SHORT).show();
				}
				

			} else if (counts == 1) {

				if (draggedImageViewParentLayout.equals(layoutImages)) {

					
					view.setBackgroundColor(Color.BLUE);
					counts = 0;
					//draggedImageViewParentLayout.removeView(view);
					//layoutLetters.removeView(firstItem);
					
					
					
				} else {
					Toast.makeText(getApplicationContext(),
							"Мора да кликнете на една од сликите.",
							Toast.LENGTH_SHORT).show();
				}

				// counts=0;
			}

		}

	}
}
