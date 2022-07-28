package hariboten;

import java.util.ArrayList;
import java.util.List;

class Group implements Entity{
	private List<Entity> children;
	private final String name;

	public Group(String name) {
		this.name = name;
		this.children = new ArrayList<Entity>();
	}

	public void add(Entity toAdd) {
		children.add(toAdd);
	}

    public String getNameTree(int depth) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			builder.append("  ");
		}
		builder.append("group: ")
			.append(name)
			.append("\n");
		for (Entity child : children) {
			builder
				.append(child.getNameTree(depth + 1));
		}
		return builder.toString();
    }

}
