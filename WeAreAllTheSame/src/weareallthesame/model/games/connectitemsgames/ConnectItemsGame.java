package weareallthesame.model.games.connectitemsgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.connectitemsgames.ConnectItemsViewInterface;

public class ConnectItemsGame extends AbstractGame implements ConnectItemsInterface {

	private static final long serialVersionUID = -8343474527306541230L;

	private ConnectItemsViewInterface view;
	private List<Item> itemsOne;
	private List<Item> itemsTwo;
	private Map<String, String> correctMapping;
	private int[] connectionsFrom;
	private int[] connectionsTo;
	private boolean gameOver;
	
	public ConnectItemsGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new ConnectItemsCommandFactory(this));
		if(view instanceof ConnectItemsViewInterface){
			this.view = (ConnectItemsViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		init();
	}
	
	private void init(){
		itemsOne = new ArrayList<Item>();
		itemsTwo = new ArrayList<Item>();
		correctMapping = new HashMap<String, String>();
		Random random = new Random();
		int numberOfItems = random.nextInt(10);
		while(numberOfItems < 4){
			numberOfItems = random.nextInt(6) + 1;
		}
		Iterator<Item> it = ItemFactory.getItem(this.getTags(), numberOfItems);
		while(it.hasNext()){
			Item itemOne = it.next();
			itemsOne.add(itemOne);
			List<String> list = new ArrayList<String>();
			list.add(itemOne.getName());
			Item itemTwo = ItemFactory.getItem(list.iterator(), 1).next();
			itemsTwo.add(itemTwo);
			correctMapping.put(itemOne.getName(), itemTwo.getName());
		}
		Collections.shuffle(itemsOne);
		Collections.shuffle(itemsTwo);
		connectionsFrom = new int[itemsOne.size()];
		connectionsTo = new int[itemsOne.size()];
		for(int i=0;i<connectionsFrom.length;++i){
			connectionsFrom[i] = -1;
			connectionsTo[i] = -1;
		}
		gameOver = false;
		
		view.initArrays(itemsOne, itemsTwo);
		view.initConnections(connectionsFrom);
	}

	@Override
	public String getType() {
		return "ConnectItems";
	}

	@Override
	public void addConnection(int positionOne, int positionTwo) throws GameOverException, CommandException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(positionOne >= connectionsFrom.length || positionTwo >= connectionsFrom.length){
			throw new CommandException("Poziciite treba da se pomali od " + connectionsFrom.length);
		}
		if(connectionsFrom[positionOne] != -1){
			connectionsTo[connectionsFrom[positionOne]] = -1;
		}
		if(connectionsTo[positionTwo] != -1){
			connectionsFrom[connectionsTo[positionTwo]] = -1;
		}
		connectionsFrom[positionOne] = positionTwo;
		connectionsTo[positionTwo] = positionOne;
		view.initConnections(connectionsFrom);
		checkAnswer();
	}
	
	private void checkAnswer(){
		for(int i=0;i<connectionsFrom.length;++i){
			if(connectionsFrom[i] == -1){
				return;
			}
		}
		for(int i=0;i<connectionsFrom.length;++i){
			if(!correctMapping.get(itemsOne.get(i).getName()).equalsIgnoreCase(itemsTwo.get(connectionsFrom[i]).getName())){
				view.wrongAnswer();
				return;
			}
		}
		gameOver = true;
		view.gameOver();
	}

	@Override
	public void removeConnection(int positionOne, int positionTwo) throws GameOverException, CommandException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(positionOne >= connectionsFrom.length || positionTwo >= connectionsFrom.length){
			throw new CommandException("Poziciite treba da se pomali od " + connectionsFrom.length);
		}
		if(connectionsFrom[positionOne] != positionTwo){
			throw new CommandException(String.format("Ne postoi vrska pomegu elementite so indeksi %d %d", positionOne, positionTwo));
		}
		
		connectionsFrom[positionOne] = -1;
		connectionsTo[positionTwo] = -1;
		
		view.initConnections(connectionsFrom);
	}


}
