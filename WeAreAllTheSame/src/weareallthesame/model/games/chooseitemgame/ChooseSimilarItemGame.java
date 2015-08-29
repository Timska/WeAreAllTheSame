package weareallthesame.model.games.chooseitemgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.chooseitemgame.ChooseItemViewInterface;

public class ChooseSimilarItemGame extends AbstractGame implements ChooseItemInterface {

	private static final long serialVersionUID = 7135424773486834920L;

	private ChooseItemViewInterface view;
	private Item answer;
	private Item correctItem;
	private Set<Item> offeredAnswers;
	private boolean gameOver;
	
	public ChooseSimilarItemGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new ChooseItemCommandFactory(this));
		if(view instanceof ChooseItemViewInterface){
			this.view = (ChooseItemViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		init();
		setAnswer();
		gameOver = false;
	}
	
	private void setAnswer(){
		List<String> answerTags = new ArrayList<String>();
		answerTags.add(correctItem.getName());
		answer = ItemFactory.getItem(answerTags.iterator(), 1).next();
		view.setAnswer(answer);
	}
	
	private void init(){
		offeredAnswers = new HashSet<Item>();
		correctItem = ItemFactory.getItem(this.getTags(), 1).next();
		offeredAnswers.add(correctItem);
		Random random = new Random();
		int numOfferedAnswers = 0;
		while(numOfferedAnswers < 5){
			numOfferedAnswers = random.nextInt(10);
		}
		Iterator<Item> offeredItems = ItemFactory.getItem(this.getTags(), numOfferedAnswers);
		while(offeredItems.hasNext()){
			offeredAnswers.add(offeredItems.next());
		}
		view.setOfferedAnswers(offeredAnswers);
	}

	@Override
	public String getType() {
		return "ChooseSimilarItem";
	}

	@Override
	public void chooseAnswer(Item item) throws GameOverException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(item.getName().equals(correctItem.getName())){
			gameOver = true;
			view.gameOver();
		}
		else{
			view.wrongAnswer();
		}
	}

}
