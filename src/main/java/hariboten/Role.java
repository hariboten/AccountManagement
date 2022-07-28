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
		StringBuilder builder = new StringBuilder();
		for (Entity child : entities) {
			builder
				.append(child.getNameTree(0));
		}
		return builder.toString();
    }
	
}
