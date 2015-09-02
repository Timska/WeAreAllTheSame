package weareallthesame.model.games.hangmangame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.ItemFactory;
import weareallthesame.factories.SimpleFactory;
import weareallthesame.factories.simplefactories.SimpleFactoryInterface;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.WrongAnswerException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.hangmangame.HangmanViewInterface;

public class HangmanGame extends AbstractGame implements HangmanInterface {

	private static final long serialVersionUID = -6299102336837945770L;

	private static final int numberOfOfferedLetters = 10;
	private Item answer;
	private List<Character> offeredLetters;
	private List<Character> userAnswer;
	//private List<Boolean> offeredLettersUsed;
	private boolean gameOver;
	private HangmanViewInterface view;
	
	public HangmanGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException{
		super(tags, question);
		this.setCommandFactory(new HangmanCommandFactory(this));
		if(view instanceof HangmanViewInterface){
			this.view = (HangmanViewInterface)view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setAnswer();
		init();
	}
	
	private void setAnswer(){
		List<String> itemTags = new ArrayList<String>();
		itemTags.add(this.getTags().next());
		boolean start = true;
		while(start || answer.getName().length() > 8){
			start = false;
			answer = ItemFactory.getItem(itemTags.iterator(), 1).next(); 
		}
		view.setAnswer(answer);
	}
	
	private void init(){
		offeredLetters = new ArrayList<Character>();
		for(int i=0;i<numberOfOfferedLetters;++i){
			if(i < answer.getName().length()){
				offeredLetters.add(Character.toUpperCase(answer.getName().charAt(i)));
			}
			else{
				offeredLetters.add(addRandomLetter());
			}
		}
		Collections.shuffle(offeredLetters);
		
		userAnswer = new ArrayList<Character>();
		for(int i=0;i<answer.getName().length();++i){
			userAnswer.add('_');
		}
		
		gameOver = false;
		
		updateView();
	}
	
	private Character addRandomLetter(){
		SimpleFactoryInterface factory = SimpleFactory.getFactory(this.getTags(), 31);
		return factory.getDefault().charAt(0);
	}
	
	@Override
	public String getType() {
		return "Hangman";
	}
	
	private void updateView(){
		view.setOrUpdateOfferedLetters(offeredLetters);
		view.setOrUpdateUserAnswer(userAnswer);
	}

	public void setLetter(int positionFrom, int positionTo) throws GameOverException, CommandException, WrongAnswerException{
		if(gameOver){
			throw new GameOverException("Igrata zavrsi");
		}
		System.out.println("Bukvi " + offeredLetters.get(positionFrom) + " " + answer.getName().charAt(positionTo));
		if(!offeredLetters.get(positionFrom).toString().equalsIgnoreCase(String.format("%c", answer.getName().charAt(positionTo)))){
			throw new WrongAnswerException();
		}
		
		userAnswer.set(positionTo, offeredLetters.get(positionFrom));
		offeredLetters.remove(positionFrom);
		//offeredLettersUsed.set(positionFrom, true);
		
		updateView();
		
		checkGameOver();
	}
	
	public void removeLetter(int positionFrom, int positionTo) throws GameOverException, CommandException {
		if(gameOver){
			throw new GameOverException("Igrata zavrsi");
		}
		if(userAnswer.get(positionFrom).equals(Character.valueOf('_'))){
			throw new CommandException(String.format("Nema postaveno bukva na pozicija %d za da se trgne", positionFrom));
		}
		
		userAnswer.set(positionFrom, Character.valueOf('_'));
		
		updateView();
	}
	
	private void checkGameOver() throws CommandException{
		StringBuilder sb = new StringBuilder();
		boolean wrongAnswer = true;
		for(int i=0;i<userAnswer.size();++i){
			sb.append(userAnswer.get(i));
			if(userAnswer.get(i) == '_'){
				wrongAnswer = false;
			}
		}
		if(sb.toString().equalsIgnoreCase(answer.getName())){
			wrongAnswer = false;
			gameOver = true;
			view.gameOver();
		}
		
		if(wrongAnswer){
			throw new CommandException("Pogresen odgovor");
		}
	}

	public String getCorrectAnswer() {
		return answer.getName();
	}

	public List<Character> getUserAnswer() {
		return userAnswer;
	}

	public HangmanViewInterface getView() {
		return view;
	}
	
	
}
