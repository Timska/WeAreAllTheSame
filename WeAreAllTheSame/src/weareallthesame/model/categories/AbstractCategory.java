package weareallthesame.model.categories;

public abstract class AbstractCategory implements CategoryInterface{

	private String name;
	private String resourceName;
	
	public AbstractCategory(String name, String resourceName) {
		super();
		this.name = name;
		this.resourceName = resourceName;
	}

	public String getName() {
		return name;
	}

	public String getResourceName() {
		return resourceName;
	}

}
