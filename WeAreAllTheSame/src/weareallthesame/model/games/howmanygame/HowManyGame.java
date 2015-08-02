package weareallthesame.model.games.howmanygame;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.interfaces.ChooseNumberInterface;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.howmanygame.HowManyViewInterface;

public class HowManyGame extends AbstractGame implements ChooseNumberInterface{
	
	private static final long serialVersionUID = -3798076972351593038L;
	
	private HowManyViewInterface view;
	private Item item;
	private int howMany;
	private Set<Integer> offeredAnswers;
	private boolean gameOver;

	public HowManyGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new HowManyCommandFactory(this));
		if(view instanceof HowManyViewInterface){
			this.view = (HowManyViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setAnswer();
		init();
	}
	
	private void setAnswer(){
		item = ItemFactory.getItem(this.getTags(), 1).next();
		Random random = new Random();
		howMany = random.nextInt(20) + 1;
		view.setAnswer(item, howMany);
	}

	private void init(){
		offeredAnswers = new HashSet<Integer>();
		offeredAnswers.add(howMany);
		Random random = new Random();
		int numOfferedAnswers = 0;
		while(numOfferedAnswers < 5){
			numOfferedAnswers = random.nextInt(10);
		}
		while(offeredAnswers.size() < numOfferedAnswers){
			offeredAnswers.add(random.nextInt(30));
		}
		gameOver = false;
		view.setOfferedAnswers(offeredAnswers);
	}
	
	@Override
	public String getType() {
		return "HowMany";
	}

	@Override
	public void chooseNumber(int number) throws GameOverException, CommandException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(!offeredAnswers.contains(number)){
			throw new CommandException("Brojot sto go isprativte ne e vo ponudenite odgovori.");
		}
		if(number == howMany){
			gameOver = true;
			view.gameOver();
		}
		else{
			view.wrongAnswer();
		}
	}

}
