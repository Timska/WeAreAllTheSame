package weareallthesame.model.categories;


public class CategoryClothesAndBodyParts extends AbstractCategory {

	private static final long serialVersionUID = 690309054592405981L;

	public CategoryClothesAndBodyParts(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public String getType() {
		return "ClothesAndBodyParts";
	}
}
