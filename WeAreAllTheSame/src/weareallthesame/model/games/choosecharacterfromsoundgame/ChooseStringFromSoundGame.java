package weareallthesame.model.games.choosecharacterfromsoundgame;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.factories.ItemFactory;
import weareallthesame.factories.LetterFactory;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.choosecharacterfromsoundgame.ChooseStringFromSoundViewInterface;

public class ChooseStringFromSoundGame extends AbstractGame implements ChooseStringFromSoundInterface{
	
	private ChooseStringFromSoundViewInterface view;
	private Item answer;
	private Set<String> offeredAnswers;
	private boolean gameOver;
	private boolean letters;

	public ChooseStringFromSoundGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new ChooseStringFromSoundCommandFactory(this));
		if(view instanceof ChooseStringFromSoundViewInterface){
			this.view = (ChooseStringFromSoundViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setAnswer();
		setSubgame();
		init();
	}
	
	private void setSubgame(){
		Iterator<String> tags = this.getTags();
		while(tags.hasNext()){
			String tag = tags.next();
			if(tag.equalsIgnoreCase("letters")){
				this.letters = true;
			}
			else if(tag.equalsIgnoreCase("numbers")){
				this.letters = false;
			}
		}
	}
	
	private void init(){
		offeredAnswers.add(answer.getName());
		Random random = new Random();
		int numOfferedLetters = 0;
		while(numOfferedLetters < 5){
			numOfferedLetters = random.nextInt(10);
		}
		if(letters){
			while(offeredAnswers.size() <= numOfferedLetters){
				offeredAnswers.add(String.format("%c", LetterFactory.getDefaultLetter()));
			}
		}
		else{
			while(offeredAnswers.size() <= numOfferedLetters){
				offeredAnswers.add(String.format("%d", random.nextInt(101)));
			}
		}
		view.setOfferedAnswers(offeredAnswers);
	}
	
	private void setAnswer(){
		answer = ItemFactory.getItem(this.getTags(), 1).next();
		view.setAnswer(answer);
	}

	@Override
	public String getType() {
		return "ChooseStringFromSound";
	}

	@Override
	public void chooseAnswer(String str) throws CommandException, GameOverException {
		if(!offeredAnswers.contains(str)){
			throw new CommandException("Bukvata sto sakate da ja izberete ne e vo ponudenite");
		}
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(str.equals(answer.getName().charAt(0))){
			gameOver = true;
			view.gameOver();
		}
		else{
			view.wrongAnswer();
		}
	}

}
