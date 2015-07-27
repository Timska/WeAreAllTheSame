package weareallthesame.model.games.hangmangame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weareallthesame.factories.ItemFactory;
import weareallthesame.factories.SimpleFactory;
import weareallthesame.factories.simplefactories.SimpleFactoryInterface;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.hangmangame.HangmanViewInterface;

public class HangmanGame extends AbstractGame implements HangmanInterface {

	private static final int numberOfOfferedLetters = 20;
	private Item answer;
	private List<Character> offeredLetters;
	private List<Character> userAnswer;
	private List<Boolean> offeredLettersUsed;
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
		answer = ItemFactory.getItem(this.getTags(), 1).next(); 
		view.setAnswer(answer);
	}
	
	private void init(){
		offeredLetters = new ArrayList<Character>();
		offeredLettersUsed = new ArrayList<Boolean>();
		for(int i=0;i<numberOfOfferedLetters;++i){
			if(i < answer.getName().length()){
				offeredLetters.add(Character.toUpperCase(answer.getName().charAt(i)));
			}
			else{
				offeredLetters.add(addRandomLetter());
			}
			offeredLettersUsed.add(false);
		}
		
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
		view.setOrUpdateOfferedLettersAndUsedLetters(offeredLetters, offeredLettersUsed);
		view.setOrUpdateUserAnswer(userAnswer);
	}

	public void setLetter(int positionFrom, int positionTo) throws GameOverException, CommandException{
		if(gameOver){
			throw new GameOverException("Igrata zavrsi");
		}
		if(offeredLettersUsed.get(positionFrom)){
			throw new CommandException(String.format("Ponudenata bukva %c na pozicija %d veke e iskoristena.",offeredLetters.get(positionFrom), positionFrom));
		}
		userAnswer.set(positionTo, offeredLetters.get(positionFrom));
		offeredLettersUsed.set(positionFrom, true);
		
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
		if(!offeredLettersUsed.get(positionTo)){
			throw new CommandException(String.format("Bukvata %c sto treba da se trgne od odgovorot i da se vrati vo ponudenite na pozicija %d ne e voopsto zemena od ponudenite.", userAnswer.get(positionFrom), positionTo));
		}
		userAnswer.set(positionFrom, Character.valueOf('_'));
		offeredLettersUsed.set(positionTo, false);
		
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
		if(sb.toString().equals(answer.getName())){
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
	
	
}
