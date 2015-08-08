package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;
import java.util.Random;

import weareallthesame.view.R;
import weareallthesame.view.R.id;
import weareallthesame.view.R.layout;
import weareallthesame.view.R.menu;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdditionAndSubstractionNumbersActivity extends Activity {

	
	private DisplayMetrics displayMetrics;
	private ArrayList<Rect> boundsRect;
	private ArrayList<TextView> numbersAndSigns;
	private ArrayList<TextView> answers;
	private ArrayList<Integer> colors;
	private ArrayList<String> answersString;
	private MediaPlayer mMediaPlayer;
	private Random r = new Random();
	private Button playButton;
	private Animation animation;
	private LinearLayout linLayout;
	private TextView dropPlace;
	private int width, height, rWidth, rHeight;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_numbers);
		
		
		

		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

		
		answers=new ArrayList<TextView>();
		boundsRect = new ArrayList<Rect>();
		numbersAndSigns = new ArrayList<TextView>();
		animation = AnimationUtils.loadAnimation(this,
				R.anim.choose_character_from_sound_animation_scaling);

		playButton = (Button) findViewById(R.id.choose_character_from_sound_play_buttons);
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_additioner_one));
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_sign));
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_additioner_two));
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_equals_sign));
		numbersAndSigns.add((TextView) findViewById(R.id.addition_and_substraction_numbers_result));
	
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_one));
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_two));
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_three));
		answers.add((TextView) findViewById(R.id.addition_and_substraction_numbers_answer_four));
		
		
		
		
		setAnswers();
		colors = generateColors();
		setTextViews();
		addAnswers();
		
		
		
	}
	private void setTextViews() {

		for(int i=0;i<numbersAndSigns.size();++i){
			
			TextView tx=numbersAndSigns.get(i);
			tx.setBackground(getGradientDrawable());
			tx.setHeight(height/10);
			tx.setText(answersString.get(i));
			
			
		}

	}

	private void setButton() {

		int w = width / 3;
		int h = height / 4;
		playButton.setX(w);
		playButton.setY(h);
		Rect rect = new Rect(w, h, w + 200, h + 200);
		boundsRect.add(rect);
	}

	private boolean isColiding(int x, int y, int width, int height) {

		for (Rect bounds : boundsRect) {

			if (bounds.left < x + width && bounds.left + bounds.width() > x
					&& bounds.top < y + height
					&& bounds.height() + bounds.top > y) {
				return true;
			}
		}
		return false;
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

	private void setAnswers() {
		answersString = new ArrayList<String>();
		answersString.add("5");
		answersString.add("+");
		answersString.add("4");
		answersString.add("=");
		answersString.add("9");

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
	
	private void addAnswers(){
		
		for(int i=0;i<answers.size();++i){
			
			TextView tx=answers.get(i);
			GradientDrawable gd=getGradientDrawable();
			gd.setShape(GradientDrawable.RECTANGLE);
			tx.setBackground(gd);
			tx.setWidth(width/5);
			tx.setHeight(height/10);
			tx.setText("18");
		}
	}


}
