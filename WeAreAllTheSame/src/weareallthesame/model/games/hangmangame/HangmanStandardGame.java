package weareallthesame.model.games.hangmangame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.view.games.hangmangame.HangmanStandardViewInterface;

public class HangmanStandardGame extends AbstractGame implements HangmanStandardInterface{
	
	private HangmanStandardViewInterface view;
	private String answer;
	private boolean gameOver;
	private List<Character> usedLetters;
	private List<Character> userAnswer;
	

	public HangmanStandardGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new HangmanStandardCommandFactory(this));
		if(view instanceof HangmanStandardViewInterface){
			this.view = (HangmanStandardViewInterface)view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setAnswer();
		init();
	}
	
	private void setAnswer(){
		answer = ItemFactory.getItem(this.getTags(), 1).next().getName(); 
		view.setAnswer(answer);
	}
	
	private void init(){
		gameOver = false;
		usedLetters = new ArrayList<Character>();
		userAnswer = new ArrayList<Character>();
		for(int i=0;i<=answer.length();++i){
			userAnswer.add('_');
		}
		view.setOrUpdateUsedLetters(usedLetters);
		view.setOrUpdateUserAnswer(userAnswer);
	}

	private static final long serialVersionUID = -2071852145847791543L;

	@Override
	public String getType() {
		return "HangmanStandard";
	}

	@Override
	public void chooseLetter(Character letter) throws GameOverException {
		if(gameOver){
			throw new GameOverException("Igrata zavrsi");
		}
		if(usedLetters.contains(letter)){
			view.usedLetter(letter);
			return;
		}
		if(answer.indexOf(letter.toString()) == -1){
			view.letterNotFound();
			usedLetters.add(letter);
			view.setOrUpdateUsedLetters(usedLetters);
			return;
		}
		for(int i=0;i<answer.length();++i){
			if(letter.equals(answer.charAt(i))){
				userAnswer.set(i, letter);
			}
			
		}
		usedLetters.add(letter);
		view.setOrUpdateUsedLetters(usedLetters);
		view.setOrUpdateUserAnswer(userAnswer);
		checkGameOver();
	}
	
	private void checkGameOver() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<userAnswer.size();++i){
			sb.append(userAnswer.get(i));
			if(userAnswer.get(i) == '_'){
				return;
			}
		}
		if(sb.toString().equals(answer)){
			gameOver = true;
			view.gameOver();
		}
	
	}

}
