package weareallthesame.model;

public class CombinedItem extends Item {

	private int soundResourceId;
	private int visualResourceId;

	public CombinedItem(String name, Category category, int soundResourceId, int visualResourceId) {
		super(name, category);
		this.soundResourceId = soundResourceId;
		this.visualResourceId = visualResourceId;
	}

	public int getSoundResourceId() {
		return soundResourceId;
	}

	public int getVisualResourceId() {
		return visualResourceId;
	}

}
