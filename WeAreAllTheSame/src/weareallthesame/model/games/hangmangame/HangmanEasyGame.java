package weareallthesame.model.games.hangmangame;

import java.util.Iterator;
import java.util.Random;

import weareallthesame.model.exceptions.InvalidViewTypeException;

public class HangmanEasyGame extends HangmanGame{

	public HangmanEasyGame(Iterator<String> tags, Object view) throws InvalidViewTypeException {
		super(tags, view);
		addHelp();
	}
	
	private void addHelp(){
		String correctAnswer = this.getCorrectAnswer();
		Random random = new Random();
		for(int i=0;i<correctAnswer.length()/3;++i){
			int position = random.nextInt(this.getUserAnswer().size());
			this.getUserAnswer().set(position, correctAnswer.charAt(position));
		}
	}
	
	@Override
	public String getType(){
		return "HangmanEasy";
	}

}
