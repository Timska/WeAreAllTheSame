package weareallthesame.model.games.hangmangame;

import java.util.Iterator;
import java.util.Random;

import weareallthesame.model.exceptions.InvalidViewTypeException;

public class HangmanEasyGame extends HangmanGame{

	private static final long serialVersionUID = 2196939800450141217L;

	public HangmanEasyGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, view, question);
		addHelp();
	}
	
	private void addHelp(){
		String correctAnswer = this.getCorrectAnswer();
		Random random = new Random();
		for(int i=0;i<Math.round(correctAnswer.length()/3.0);++i){
			int position = random.nextInt(correctAnswer.length());
			this.getUserAnswer().set(position, correctAnswer.charAt(position));
		}
		super.getView().setOrUpdateUserAnswer(this.getUserAnswer());
	}
	
	@Override
	public String getType(){
		return "HangmanEasy";
	}

}
