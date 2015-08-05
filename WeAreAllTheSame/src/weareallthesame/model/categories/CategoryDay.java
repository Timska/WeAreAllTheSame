package weareallthesame.model.categories;


public class CategoryDay extends AbstractCategory {

	private static final long serialVersionUID = 4776213003140725529L;

	public CategoryDay(String name, String resourceName) {
		super(name, resourceName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		return "Day";
	}

}
