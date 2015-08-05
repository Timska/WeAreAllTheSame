package weareallthesame.model.categories;


public class CategoryColorsAndObjects extends AbstractCategory {

	private static final long serialVersionUID = -4235633052841795424L;

	public CategoryColorsAndObjects(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public String getType() {
		return "ColorsAndObjects";
	}

}
