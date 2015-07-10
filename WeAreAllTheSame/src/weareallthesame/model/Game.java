package weareallthesame.model;

public abstract class Game {

	private String name;
	
	public Game(){
		
	}
	
	public Game(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
