package weareallthesame.view.games.chooseitemgame;

import java.util.List;

import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class FindTheWordFromThePictureActivity extends Activity implements ChooseItemViewInterface {

	
	private Button answerOne;
	private Button answerTwo;
	private Button answerThree;
	private Button answerFour;
	
	private ImageView picture;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_the_word_from_the_picture);
	
		answerOne=(Button) findViewById(R.id.answer_one_find_word_from_letter);
		answerTwo=(Button) findViewById(R.id.answer_two_find_word_from_letter);
		answerThree=(Button) findViewById(R.id.answer_three_find_word_from_letter);
		answerFour=(Button) findViewById(R.id.answer_four_find_word_from_letter);
	}

	@Override
	public void setAnswer(Item answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOfferedAnswers(List<Item> offeredAnswers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wrongAnswer() {
		// TODO Auto-generated method stub
		
	}
}
