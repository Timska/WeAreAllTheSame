package weareallthesame.model.categories;


public class CategoryYear extends AbstractCategory {

	private static final long serialVersionUID = 2272972546358959025L;

	public CategoryYear(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public String getType() {
		return "Year";
	}

}
