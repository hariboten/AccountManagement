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

	public List<Entity> getChildren(){
		return entities;
	}

    public String getNameTree() {
		var visitor = new NameTreeVisitor();
		entities.forEach((child) -> {
			child.accept(visitor);
		});
		return visitor.toString();
    }

	public void accept(EntityVisitor visitor) {
		visitor.visit(this);
	}
}
