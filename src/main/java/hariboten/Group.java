package hariboten;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

	private static StringBuilder indent(final int depth) {
		return IntStream.range(0, depth)
			.mapToObj((i) -> "  ")
			.collect(StringBuilder::new,
					StringBuilder::append,
					StringBuilder::append);
	}


    public String getNameTree(int depth) {
		StringBuilder groupName = indent(depth)
			.append("group: ")
			.append(name)
			.append("\n");

		return children.stream()
			.map((child) -> child.getNameTree(depth + 1))
			.collect(() -> {return groupName;},
					StringBuilder::append,
					StringBuilder::append)
			.toString();
	}
}
