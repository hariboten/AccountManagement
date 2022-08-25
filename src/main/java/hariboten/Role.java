package hariboten;

import java.util.ArrayList;
import java.util.List;

class Role {
	private List<Entity> entities;

	public Role() {
		this.entities = new ArrayList<Entity>();
	}

	public void add(Entity toAdd) {
		entities.add(toAdd);
	}

    public String getNameTree() {
		return entities.stream()
			.map((entitiy) -> entitiy.getNameTree(0))
			.collect(StringBuilder::new,
					StringBuilder::append,
					StringBuilder::append)
			.toString();
    }
	
}
