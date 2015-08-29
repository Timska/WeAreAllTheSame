package weareallthesame.view.games.chooseitemgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.GameOverChoiceActivity;
import weareallthesame.view.R;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FindThePictureFromTheSoundActivity extends Activity implements
		ChooseItemViewInterface {

	private static final long serialVersionUID = -1366318460338234441L;

	private Button playSound;
	private GridView answersContainer;
	private MediaPlayer mMediaPlayer;
	private DisplayMetrics displayMetrics;
	private ApplicationInterface appInterface;
	private ArrayList<Integer> answerResources;
	private int width, height;
	private Item correctAnswer;
	private Item clickedItem;
	private ArrayList<Item> answers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_the_picture_from_the_sound);

		getMetrics();
		initializeViews();
		openGame();
		setButtonSound();

	}

	private void getMetrics() {
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;
	}

	private void setButtonSound() {
		mMediaPlayer = new MediaPlayer();
		mMediaPlayer = MediaPlayer.create(
				this,
				this.getResources().getIdentifier(
						correctAnswer.getResourceNames().get("sound"), "raw",
						this.getPackageName()));
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer.start();
	}

	private void initializeViews() {
		playSound = (Button) findViewById(R.id.find_picture_from_sound_button_play);
		answersContainer = (GridView) findViewById(R.id.find_picture_from_sound_answers_container);
	}

	public void onPlayButtonClick(View v) {
		mMediaPlayer.start();
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
							R.string.find_picture_from_sound_task_description));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setAnswer(Item answer) {
		// TODO Auto-generated method stub
		this.correctAnswer = answer;

		// mMediaPlayer = new MediaPlayer();
		// mMediaPlayer = MediaPlayer.create(
		// this,
		// this.getResources().getIdentifier(
		// answer.getResourceNames().get("sound"), "raw",
		// this.getPackageName()));
		// mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		// mMediaPlayer.start();

	}

	@Override
	public void setOfferedAnswers(List<Item> offeredAnswers) {
		// TODO Auto-generated method stub
		answerResources = new ArrayList<Integer>();
		answers=(ArrayList<Item>) offeredAnswers;
		Iterator<Item> it = offeredAnswers.iterator();
		while (it.hasNext()) {
			answerResources.add(getResources().getIdentifier(
					it.next().getResourceNames().get("picture"), "drawable",
					this.getPackageName()));
		}
		int imgWidth = width / 3;
		int imgHeight = height / (offeredAnswers.size() / 3 + 1);
		answersContainer.setAdapter(new ChooseItemImageViewAdapter(this,
				answerResources, imgWidth, imgHeight));

		answersContainer.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				TextView tx = (TextView) view;
				clickedItem = answers.get(position);
				try {
					appInterface.executeCommand("ChooseItem", clickedItem);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
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

	@Override
	public void wrongAnswer() {
		mMediaPlayer.start();
		Toast.makeText(getApplicationContext(), "Неточен одговор",
				Toast.LENGTH_SHORT).show();
	}

	// private final class MyClickListener implements OnLongClickListener {
	//
	// @Override
	// public boolean onLongClick(View v) {
	// // TODO Auto-generated method stub
	// ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
	// String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
	// System.out.println(item.toString());
	// ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
	// DragShadowBuilder dsb = new View.DragShadowBuilder(v);
	//
	// v.startDrag(data, dsb, v, 0);
	// v.setVisibility(View.INVISIBLE);
	//
	// return true;
	// }
	//
	// }

	// private final class MyDragListener implements OnDragListener {
	//
	// @Override
	// public boolean onDrag(View receivingLayoutView, DragEvent event) {
	// // TODO Auto-generated method stub
	//
	// View draggedImageView = (View) event.getLocalState();
	//
	// switch (event.getAction()) {
	// case DragEvent.ACTION_DRAG_STARTED:
	// receivingLayoutView.setBackgroundColor(R.color.red);
	// break;
	// case DragEvent.ACTION_DRAG_ENTERED:
	// receivingLayoutView.setBackgroundColor(R.color.red);
	// break;
	// case DragEvent.ACTION_DRAG_LOCATION:
	// receivingLayoutView.setBackgroundColor(R.color.red);
	// break;
	// case DragEvent.ACTION_DROP:
	// switch (draggedImageView.getId()) {
	// case R.id.find_picture_from_sound_answerOne:
	// return false;
	// case R.id.find_picture_from_sound_answerTwo:
	// ViewGroup draggedImageViewParentLayout = (ViewGroup) draggedImageView
	// .getParent();
	// draggedImageViewParentLayout.removeView(draggedImageView);
	// LinearLayout bottomLinearLayout = (LinearLayout) receivingLayoutView;
	// bottomLinearLayout.addView(draggedImageView);
	// draggedImageView.setVisibility(View.VISIBLE);
	// receivingLayoutView.setBackgroundColor(R.color.yellow);
	// return true;
	// case R.id.find_picture_from_sound_answerThree:
	// return false;
	// case R.id.find_picture_from_sound_answerFour:
	// return false;
	// default:
	// return false;
	// }
	//
	// case DragEvent.ACTION_DRAG_ENDED:
	// receivingLayoutView.setBackgroundColor(R.color.yellow);
	// if (!event.getResult()) {
	//
	// draggedImageView.setVisibility(View.VISIBLE);
	// }
	// default:
	// break;
	// }
	// return true;
	// }
	//
	// }

}
