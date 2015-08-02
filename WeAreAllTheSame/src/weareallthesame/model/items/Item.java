package weareallthesame.model.items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Item implements Serializable {
	
	private static final long serialVersionUID = 2451032560633009847L;
	
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
