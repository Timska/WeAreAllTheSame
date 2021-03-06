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
import weareallthesame.model.exceptions.WrongAnswerException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.view.games.orderelementsgame.OrderElementsViewInterface;

public class OrderElementsGame extends AbstractGame implements OrderElementsInterface {

	private static final long serialVersionUID = 50780739530423282L;

	private OrderElementsViewInterface view;
	private Set<String> elements;
	private SimpleFactoryInterface factory;
	private List<String> orderedElements;
	private List<String> correctList;
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
	
	private void notifyView(){
		view.setElements(elements);
		view.setOrdered(orderedElements);
	}
	
	private void setFactory(){
		this.factory = SimpleFactory.getFactory(this.getTags(), 100);
	}
	
	private void init(){
		elements = new HashSet<String>();
		correctList = new ArrayList<String>();
		Random random = new Random();
		int numElements = 0;
		while(numElements < 4){
			numElements = random.nextInt(6) + 1;
		}
		while(elements.size() < numElements){
			String letter = factory.getDefault();
			if(!elements.contains(letter)){
				elements.add(letter);
				correctList.add(letter);
			}
			
		}
		
		for(int i=0;i<correctList.size();++i){
			for(int j=i+1;j<correctList.size();++j){
				System.out.println("Compare result " + factory.compare(correctList.get(i), correctList.get(j)));
				if(factory.compare(correctList.get(i), correctList.get(j)) > 0){
					String temp = correctList.get(i);
					System.out.println("Compare: " + temp + " " + correctList.get(j));
					correctList.set(i, correctList.get(j));
					correctList.set(j, temp);
				}
			}
		}
		
		for(int i=0;i<correctList.size();++i){
			System.out.println("Ordered " + correctList.get(i));
		}
		
		orderedElements = new ArrayList<String>();
		for(int i=0;i<elements.size();++i){
			orderedElements.add("");
		}

		
		notifyView();
	}

	@Override
	public String getType() {
		return "OrderElements";
	}
	
	private void checkCorrectOrder(){
		for(int i=0;i<orderedElements.size();++i){
			if(orderedElements.get(i).equals("")){
				return ;
			}
		}
		
		for(int i=1;i<orderedElements.size();++i){
			if(factory.compare(orderedElements.get(i-1), orderedElements.get(i)) > 0){
				view.wrongAnswer();
			}
		}
		gameOver = true;
		view.gameOver();
	}
	
	@Override
	public void setOnPosition(String element, int position) throws CommandException, GameOverException, WrongAnswerException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(!elements.contains(element)){
			throw new CommandException(String.format("Elementot sto sakate da go postavite na pozicija %d ne e vo ponudenite", position));
		}
		if(!orderedElements.get(position).equals("")){
			throw new CommandException(String.format("Na pozicijata %d veke e namesten drug element", position));
		}
		System.out.println("Bukvi: " + orderedElements.get(position) + " " + element);
		if(!correctList.get(position).equals(element)){
			throw new WrongAnswerException();
		}
		
		elements.remove(element);
		orderedElements.set(position, element);
		
		notifyView();
		
		checkCorrectOrder();
	}

	@Override
	public void removeFromPosition(int position, String element) throws GameOverException, CommandException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(position >= elements.size()){
			throw new CommandException(String.format("Maksimalnata pozicija od koja moze da se trgni element e %d", elements.size()));
		}
		if(orderedElements.get(position).equals("")){
			throw new CommandException(String.format("Na pozicijata %d nema namesteno element", position));
		}
		if(!orderedElements.get(position).equals(element)){
			throw new CommandException(String.format("Na pozicijata %d ne e namesten elementot %s", position, element));
		}
		
		elements.add(element);
		orderedElements.set(position, "");
		
		notifyView();
	}

	@Override
	public void changeElementPosition(int from, int to) throws GameOverException, CommandException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(from >= elements.size()){
			throw new CommandException(String.format("Maksimalnata pozicija od koja moze da se trgni element e %d", elements.size()));
		}
		if(to >= elements.size()){
			throw new CommandException(String.format("Maksimalnata pozicija od koja moze da se namesti element e %d", elements.size()));
		}
		if(orderedElements.get(from).equals("")){
			throw new CommandException(String.format("Na pozicijata %d nema namesteno element", from));
		}
		if(!orderedElements.get(to).equals("")){
			throw new CommandException(String.format("Na pozicijata %d veke e namesten drug element", to));
		}
		
		orderedElements.set(to, orderedElements.get(from));
		orderedElements.set(from, "");
		
		notifyView();
	}

}
