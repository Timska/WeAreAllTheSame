package weareallthesame.model.games.orderelementsgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import weareallthesame.factories.SimpleFactory;
import weareallthesame.factories.simplefactories.SimpleFactoryInterface;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.view.games.orderelementsgame.OrderElementsViewInterface;

public class OrderElementsGame extends AbstractGame implements OrderElementsInterface {

	private OrderElementsViewInterface view;
	private Set<String> elements;
	private SimpleFactoryInterface factory;
	private List<String> orderedElements;
	private boolean gameOver;
	
	public OrderElementsGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new OrderElementsCommandFactory(this));
		if(view instanceof OrderElementsViewInterface){
			this.view = (OrderElementsViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setFactory();
		init();
		gameOver = false;
	}
	
	private void setFactory(){
		this.factory = SimpleFactory.getFactory(this.getTags(), 100);
	}
	
	private void init(){
		elements = new HashSet<String>();
		Random random = new Random();
		int numElements = 0;
		while(numElements < 5){
			numElements = random.nextInt(10);
		}
		while(elements.size() < numElements){
			elements.add(factory.getDefault());
		}
		view.setElements(elements);
		
		orderedElements = new ArrayList<String>();
		for(int i=0;i<elements.size();++i){
			orderedElements.add("");
		}
		view.setOrdered(orderedElements);
	}

	@Override
	public String getType() {
		return "OrderElements";
	}

	@Override
	public void setOnPosition(String element, int position) throws CommandException, GameOverException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(position >= elements.size()){
			throw new CommandException(String.format("Maksimalnata pozicija na koja moze da se postavi element e %d", elements.size()));
		}
		if(!elements.contains(element)){
			throw new CommandException(String.format("Elementot sto sakate da go postavite na pozicija %d ne e vo ponudenite", position));
		}
		
		if(correctOrder()){
			
		}
	}
	
	private boolean correctOrder(){
		return false;
	}

}
