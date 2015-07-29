package weareallthesame.model.games.connectitemsgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.connectitemsgames.ConnectItemAndResursViewInterface;

public class ConnectItemAndResursGame extends AbstractGame implements ConnectItemsInterface{

	private ConnectItemAndResursViewInterface view;
	private List<Item> items;
	private List<String> strings;
	private int[] connectionsFrom;
	private int[] connectionsTo;
	private boolean gameOver;
	
	public ConnectItemAndResursGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new ConnectItemsCommandFactory(this));
		if(view instanceof ConnectItemAndResursViewInterface){
			this.view = (ConnectItemAndResursViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		init();
	}
	
	private void init(){
		items = new ArrayList<Item>();
		strings = new ArrayList<String>();
		Random random = new Random();
		int numberOfItems = random.nextInt(10);
		while(numberOfItems < 5){
			numberOfItems = random.nextInt(10);
		}
		Iterator<Item> it = ItemFactory.getItem(this.getTags(), numberOfItems);
		while(it.hasNext()){
			Item item = it.next();
			items.add(item);
			strings.add(item.getName());
		}
		Collections.shuffle(items);
		Collections.shuffle(strings);
		connectionsFrom = new int[items.size()];
		connectionsTo = new int[items.size()];
		for(int i=0;i<connectionsFrom.length;++i){
			connectionsFrom[i] = -1;
			connectionsTo[i] = -1;
		}
		gameOver = false;
		view.initArrays(items, strings);
		view.initConnections(connectionsFrom);
	}

	@Override
	public String getType() {
		return "ConnectItemAndResurs";
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
			if(!items.get(i).getName().equalsIgnoreCase(strings.get(connectionsFrom[i]))){
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
