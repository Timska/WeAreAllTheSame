package weareallthesame.view.games.questiongame;

import java.util.ArrayList;
import java.util.Random;

import weareallthesame.view.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.TextView;

public class QuestionGameActivity extends Activity {

	private ArrayList<TextView> txtAnswers;
	private ArrayList<Integer> colors;
	private TextView txtQuestion;
	private String guestion;
	private Random r = new Random();
	private DisplayMetrics displayMetrics;
	private int width, height,w;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_game);

		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
		w=width/4;
		

		txtAnswers = new ArrayList<TextView>();
		txtAnswers.add((TextView) findViewById(R.id.question_game_answer_one));
		txtAnswers.add((TextView) findViewById(R.id.question_game_answer_two));
		txtAnswers.add((TextView) findViewById(R.id.question_game_answer_three));
		txtAnswers.add((TextView) findViewById(R.id.question_game_answer_four));

		colors = generateColors();
		txtQuestion = (TextView) findViewById(R.id.question_game_question);
		txtQuestion.setBackground(getGradientDrawable());
		txtQuestion.setText("Kako se vika bratot na Marija?");
		txtQuestion.setGravity(Gravity.CENTER);
		setAnswers();

	}

	private void setAnswers() {
		for (int i = 0; i < txtAnswers.size(); ++i) {
			TextView tx = txtAnswers.get(i);

			tx.setBackground(getGradientDrawable());
			tx.setText("Martin");
			//tx.setX(20);
			tx.setWidth(w);
			w+=(width/4);

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
		gd.setShape(GradientDrawable.RECTANGLE);
		// gd.setStroke(1, 0xFF000000);
		gd.setStroke(2, Color.BLACK, 5, 5);

		return gd;

	}

}
