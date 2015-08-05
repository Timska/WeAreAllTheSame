package weareallthesame.model.categories;


public class CategoryPrepositions extends AbstractCategory {

	private static final long serialVersionUID = -4245111031195344108L;

	public CategoryPrepositions(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public String getType() {
		return "Prepositions";
	}
}
