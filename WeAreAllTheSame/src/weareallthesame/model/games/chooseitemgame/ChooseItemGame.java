package weareallthesame.model.games.chooseitemgame;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.chooseitemgame.ChooseItemViewInterface;

public class ChooseItemGame extends AbstractGame implements ChooseItemInterface{

	private static final long serialVersionUID = -774130802643683603L;

	private ChooseItemViewInterface view;
	private Item answer;
	private Set<Item> offeredAnswers;
	private boolean gameOver;
	
	public ChooseItemGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new ChooseItemCommandFactory(this));
		if(view instanceof ChooseItemViewInterface){
			this.view = (ChooseItemViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setAnswer();
		init();
		gameOver = false;
	}
	
	private void setAnswer(){
		answer = ItemFactory.getItem(this.getTags(), 1).next();
		view.setAnswer(answer);
	}
	
	private void init(){
		offeredAnswers = new HashSet<Item>();
		offeredAnswers.add(answer);
		Random random = new Random();
		int numOfferedAnswers = 0;
		while(numOfferedAnswers < 5){
			numOfferedAnswers = random.nextInt(10);
		}
		Iterator<Item> offeredItems = ItemFactory.getItem(this.getTags(), numOfferedAnswers - 1);
		while(offeredItems.hasNext()){
			Item item = offeredItems.next();
			if(!answer.getName().equals(item.getName())){
				offeredAnswers.add(item);
			}
		}
		
		view.setOfferedAnswers(offeredAnswers);
	}

	@Override
	public String getType() {
		return "ChooseItem";
	}

	@Override
	public void chooseAnswer(Item item) throws GameOverException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(item.getName().equals(answer.getName())){
			gameOver = true;
			view.gameOver();
		}
		else{
			view.wrongAnswer();
		}
	}

}
