package weareallthesame.model;

public class VisualItem extends Item {

	private int resourceId;
	
	public VisualItem(String name, Category category, int resourceId){
		super(name, category);
		this.resourceId = resourceId;
	}

	public int getResourceId() {
		return resourceId;
	}
	
}
