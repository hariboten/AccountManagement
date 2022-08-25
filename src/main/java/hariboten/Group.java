package hariboten;

import java.util.List;
import java.util.stream.IntStream;

class Group implements Entity{
	private final String name;
	private final Id id;

	public List<Entity> getChildren() {
		return GroupMember.getGroupMember().getMember(this.getId());
	}
	public Group(String name) {
		this.name = name;
		this.id = new Id();
		EntityRepository.getEntityRepository().addEntity(this);
	}

	public Id getId() {
		return this.id;
	}

	public void add(Entity toAdd) {
		GroupMember.getGroupMember().addRelation(this.getId(), toAdd.getId());
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

		return getChildren().stream()
			.map((child) -> child.getNameTree(depth + 1))
			.collect(() -> {return groupName;},
					StringBuilder::append,
					StringBuilder::append)
			.toString();
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getType() {
		return "group";
	}
	@Override
	public void accept(EntityVisitor visitor) {
		visitor.visit(this);
	}
}
