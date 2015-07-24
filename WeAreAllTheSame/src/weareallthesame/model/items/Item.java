package weareallthesame.model.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Item {

	private String name;
	private List<String> resourceNames;

	public Item(String name, Iterator<String> resourceNames) {
		this.name = name;
		this.resourceNames = new ArrayList<String>();
		while (resourceNames.hasNext()) {
			this.resourceNames.add(resourceNames.next());
		}
	}

	public String getName() {
		return name;
	}

	public Iterator<String> getResourceNames() {
		return resourceNames.iterator();
	}

}
