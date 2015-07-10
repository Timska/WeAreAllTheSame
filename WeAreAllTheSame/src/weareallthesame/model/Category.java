package weareallthesame.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String name;
	private List<Game> games;
	private int resourceId;
	
	public Category(){
		games = new ArrayList<Game>();
	}
	
	public Category(String name, int resourceId){
		this.name = name;
		games = new ArrayList<Game>();
		this.resourceId = resourceId;
	}
	
	public void addNewGame(Game g){
		games.add(g);
	}

	public String getName() {
		return name;
	}

	public int getResourceId() {
		return resourceId;
	}

	public List<Game> getGames() {
		return games;
	}
	
}
