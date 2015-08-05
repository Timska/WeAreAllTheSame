package weareallthesame.model.categories;


public class CategoryLetters extends AbstractCategory{

	private static final long serialVersionUID = -3027040103395804396L;

	public CategoryLetters(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public String getType() {
		return "Letters";
	}

}
