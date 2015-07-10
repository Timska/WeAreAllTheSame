package weareallthesame.model;

public class SoundItem extends Item {

	private int resourceId;

	public SoundItem(String name, Category category, int resourceId) {
		super(name, category);
		this.resourceId = resourceId;
	}

	public int getResourceId() {
		return resourceId;
	}

}
