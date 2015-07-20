package weareallthesame.model.categories;

import java.util.ArrayList;
import java.util.List;

import weareallthesame.model.games.Game;

public class Category {

	private String name;
	private List<Game> games;
	private int pictureResourceId;

	public Category() {
		games = new ArrayList<Game>();
	}

	public Category(String name, int resourceId) {
		this.name = name;
		games = new ArrayList<Game>();
		this.pictureResourceId = resourceId;
	}

	public void addNewGame(Game g) {
		games.add(g);
	}

	public String getName() {
		return name;
	}

	public int getResourceId() {
		return pictureResourceId;
	}

	public List<Game> getGames() {
		return games;
	}

}
