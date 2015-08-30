package weareallthesame.model.games.classifyitemsgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import weareallthesame.factories.ItemFactory;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.ObjectDoesNotBelongInSetException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.items.Item;
import weareallthesame.view.games.classifyitemsgames.ClassifyItemsViewInterface;

public class ClassifyItemsGame extends AbstractGame implements ClassifyItemsInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3414685059342480636L;

	private ClassifyItemsViewInterface view;
	private Set<Item> offeredItems;
	private Map<String, Set<Item>> classSetMap;
	private Map<Item, String> itemClassMap;
	private boolean gameOver;
	
	public ClassifyItemsGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new ClassifyItemsCommandFactory(this));
		if(view instanceof ClassifyItemsViewInterface){
			this.view = (ClassifyItemsViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		init();
	}
	
	private void init(){
		offeredItems = new HashSet<Item>();
		classSetMap = new HashMap<String, Set<Item>>();
		itemClassMap = new HashMap<Item, String>();
		int sum = 15;
		gameOver = false;
		
		Iterator<String> tags = this.getTags();
		while(tags.hasNext()){
			String tag = tags.next();
			Random random = new Random();
			int numElements = random.nextInt(sum) + 1;
			sum = sum - numElements;
			List<String> setTags = new ArrayList<String>();
			setTags.add(tag);
			Iterator<Item> items = ItemFactory.getItem(setTags.iterator(), numElements);
			Set<Item> set = new HashSet<Item>();
			while(items.hasNext()){
				Item item = items.next();
				offeredItems.add(item);
				itemClassMap.put(item, tag);
			}
			classSetMap.put(tag, set);
		}
		
		view.setOrUpdateClassElements(classSetMap);
		view.setOrUpdate(offeredItems);
	}

	@Override
	public String getType() {
		return "ClassifyItems";
	}

	@Override
	public void classifyItem(Item item, String category) throws GameOverException, CommandException, ObjectDoesNotBelongInSetException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(!classSetMap.containsKey(category)){
			throw new CommandException("Kategorijata vo koja treba da se klasificira itemot ne postoi");
		}
		if(!offeredItems.contains(item)){
			throw new CommandException("Itemot sto treba da se klasificira ne e vo ponudenite");
		}
		if(!itemClassMap.get(item).equalsIgnoreCase(category)){
			view.wrongChoice();
			throw new ObjectDoesNotBelongInSetException();
		}
		Set<Item> set = classSetMap.get(category);
		set.add(item);
		offeredItems.remove(item);
		classSetMap.put(category, set);
		view.setOrUpdateClassElements(classSetMap);
		view.setOrUpdate(offeredItems);
		if(offeredItems.size() == 0){
			gameOver = true;
			view.gameOver();
		}
	}

}
