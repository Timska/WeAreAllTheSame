package weareallthesame.model.games.choosecharacterfromsoundgame;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.factories.ItemFactory;
import weareallthesame.factories.SimpleFactory;
import weareallthesame.factories.simplefactories.SimpleFactoryInterface;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.interfaces.ChooseStringInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.choosecharacterfromsoundgame.ChooseStringFromSoundViewInterface;

public class ChooseStringFromSoundGame extends AbstractGame implements ChooseStringInterface{
	
	private ChooseStringFromSoundViewInterface view;
	private Item answer;
	private Set<String> offeredAnswers;
	private boolean gameOver;
	
	public ChooseStringFromSoundGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException, MissingTagException {
		super(tags, question);
		this.setCommandFactory(new ChooseStringFromSoundCommandFactory(this));
		if(view instanceof ChooseStringFromSoundViewInterface){
			this.view = (ChooseStringFromSoundViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setAnswer();
		//setSubgame();
		init();
	}
	
	/*
	private void setSubgame() throws MissingTagException{
		Iterator<String> tags = this.getTags();
		boolean flag = false;
		while(tags.hasNext()){
			String tag = tags.next();
			if(tag.equalsIgnoreCase("letters")){
				this.letters = true;
				flag = true;
			}
			else if(tag.equalsIgnoreCase("numbers")){
				this.letters = false;
				flag = true;
			}
		}
		if(!flag){
			throw new MissingTagException("Nedostiga tag za definiranje na igrata");
		}
	}
	*/
	
	private void init(){
		offeredAnswers.add(answer.getName());
		Random random = new Random();
		int numOfferedLetters = 0;
		while(numOfferedLetters < 5){
			numOfferedLetters = random.nextInt(10);
		}
		
		SimpleFactoryInterface factory = SimpleFactory.getFactory(this.getTags(), 101);
		while(offeredAnswers.size() <= numOfferedLetters){
			offeredAnswers.add(factory.getDefault().toString());
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
			throw new CommandException("Vasiot izbor ne e del od ponudenite");
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
