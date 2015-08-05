package weareallthesame.model.categories;


public class CategoryFruitsAndVegetables extends AbstractCategory {

	private static final long serialVersionUID = 3671742414334563571L;

	public CategoryFruitsAndVegetables(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public String getType() {
		return "FruitsAndVegetables";
	}

}
