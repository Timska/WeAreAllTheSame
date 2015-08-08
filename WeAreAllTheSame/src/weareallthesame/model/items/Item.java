package weareallthesame.model.items;

import java.io.Serializable;
import java.util.Map;

public class Item implements Serializable {
	
	private static final long serialVersionUID = 2451032560633009847L;
	
	private String name;
	private Map<String, String> resources;

	public Item(String name, Map<String, String> resources) {
		this.name = name;
		this.resources = resources;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getResourceNames() {
		return resources;
	}

}
