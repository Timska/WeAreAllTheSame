package weareallthesame.view.games.chooseitemgame;

import java.util.List;

import weareallthesame.model.items.Item;
import weareallthesame.view.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class FindTheWordFromThePictureActivity extends Activity implements ChooseItemViewInterface {

	private static final long serialVersionUID = -2816647589304154272L;

	private Item answers;
	
	private Button answerOne;
	private Button answerTwo;
	private Button answerThree;
	private Button answerFour;
	
	private ImageView picture;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_the_word_from_the_picture);
	
	
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
