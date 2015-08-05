package weareallthesame.model.categories;


public class CategoryShapes extends AbstractCategory{

	private static final long serialVersionUID = 6110816817295728504L;

	public CategoryShapes(String name, String resourceName) {
		super(name, resourceName);
	}
	
	@Override
	public String getType() {
		return "Shapes";
	}

}
