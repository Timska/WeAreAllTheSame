package weareallthesame.model.categories;


public class CategoryAnimals extends AbstractCategory {

	private static final long serialVersionUID = -8026836090450261866L;

	public CategoryAnimals(String name, String resourceName) {
		super(name, resourceName);
	}
	
	@Override
	public String getType() {
		return "Animals";
	}

}
