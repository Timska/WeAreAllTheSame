package weareallthesame.model;

public abstract class Item {

	private Category category;
	private String name;
	
	public Item(){
		
	}
	
	public Item(String name, Category category){
		this.name = name;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}
	
	
}
