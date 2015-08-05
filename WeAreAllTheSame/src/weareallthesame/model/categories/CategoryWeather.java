package weareallthesame.model.categories;


public class CategoryWeather extends AbstractCategory {

	private static final long serialVersionUID = -7303740779773058343L;

	public CategoryWeather(String name, String resourceName) {
		super(name, resourceName);
	}

	@Override
	public String getType() {
		return "Weather";
	}

}
