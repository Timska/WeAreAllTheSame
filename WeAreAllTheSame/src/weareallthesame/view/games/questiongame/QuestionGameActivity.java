package weareallthesame.view.games.questiongame;

import java.util.ArrayList;
import java.util.Random;

import weareallthesame.view.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

public class QuestionGameActivity extends Activity {

	private ArrayList<TextView> txtAnswers;
	private ArrayList<Integer> colors;
	private TextView txtQuestion;
	private TextView txtAnswer;
	private String guestion;
	private Random r = new Random();
	private DisplayMetrics displayMetrics;
	private int width, height,w;
	private MediaPlayer mMediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_game);

		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
		w=width/4;
		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(this, R.raw.slow_whoop_bubble_pop);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		txtAnswer=(TextView) findViewById(R.id.question_game_answer);
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
		
		txtAnswer.setBackground(getGradientDrawable());
		txtAnswer.setOnDragListener(new MyDragListener());
		
		for(int i=0;i<txtAnswers.size();++i){
			txtAnswers.get(i).setOnLongClickListener(new MyClickListener());
		}

	}

	private void setAnswers() {
		for (int i = 0; i < txtAnswers.size(); ++i) {
			TextView tx = txtAnswers.get(i);

			tx.setBackground(getGradientDrawable());
			tx.setText("Martin");
			tx.setTag("Incorrect");
			tx.setWidth(w);
			w+=(width/4);

		}
		txtAnswers.get(0).setTag("Correct");
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
				receivingLayoutView.setBackground(getGradientDrawable());
				break;
			case DragEvent.ACTION_DRAG_LOCATION:
				break;
			case DragEvent.ACTION_DROP:

				String tag = (String) draggedTextView.getTag();

				if (tag.equals("Correct")) {
					ViewGroup draggedImageViewParentLayout = (ViewGroup) draggedTextView
							.getParent();
					draggedImageViewParentLayout.removeView(draggedTextView);
					TextView dropTarget = (TextView) receivingLayoutView;
					TextView droppedView = (TextView) draggedTextView;
					dropTarget.setText(droppedView.getText());
					mMediaPlayer.start();
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
