package weareallthesame.model.games.choosepicturefromwordgame;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.choosepicturefromwordgame.ChoosePictureFromWordViewInterface;

public class ChoosePictureFromWordGame extends AbstractGame implements ChoosePictureFromWordInterface{

	private ChoosePictureFromWordViewInterface view;
	private Item answer;
	private List<Item> offeredAnswers;
	private boolean gameOver;
	
	public ChoosePictureFromWordGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new ChoosePictureFromWordCommandFactory(this));
		if(view instanceof ChoosePictureFromWordInterface){
			this.view = (ChoosePictureFromWordViewInterface) view;
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
		offeredAnswers.add(answer);
		Random random = new Random();
		int numOfferedAnswers = 0;
		while(numOfferedAnswers < 5){
			numOfferedAnswers = random.nextInt(10);
		}
		Iterator<Item> offeredItems = ItemFactory.getItem(this.getTags(), numOfferedAnswers - 1);
		while(offeredItems.hasNext()){
			offeredAnswers.add(offeredItems.next());
		}
		view.setOfferedAnswers(offeredAnswers);
	}

	@Override
	public String getType() {
		return "ChoosePictureFromWord";
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
