package weareallthesame.model.categories;


public class CategoryNumbers extends AbstractCategory {

	private static final long serialVersionUID = -8977897324894763392L;

	public CategoryNumbers(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public String getType() {
		return "Numbers";
	}

}
