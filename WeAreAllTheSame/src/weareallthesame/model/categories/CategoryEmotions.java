package weareallthesame.model.categories;


public class CategoryEmotions extends AbstractCategory {

	private static final long serialVersionUID = -4015771093813220699L;

	public CategoryEmotions(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public String getType() {
		return "Emotions";
	}
}
