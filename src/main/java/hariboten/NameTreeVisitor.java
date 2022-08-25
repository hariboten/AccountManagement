package hariboten;

import java.util.stream.IntStream;

class NameTreeVisitor implements EntityVisitor {

	private StringBuilder nameTree;
	private int depth;

	public NameTreeVisitor() {
		nameTree = new StringBuilder();
		depth = 0;
	}
	@Override
	public void visit(Entity entity) {
		nameTree.append(getNameWithIndent(entity, depth));
		depth++;
		entity.getChildren().forEach((child) -> child.accept(this));
		depth--;
	}

	public String toString() {
		return nameTree.toString();
	}

    public String getNameWithIndent(final Entity entity, final int depth) {
		return indent(depth)
			.append(entity.getType())
			.append(": ")
			.append(entity.getName())
			.append("\n")
			.toString();
    }
	
	private static StringBuilder indent(final int depth) {
		return IntStream.range(0, depth)
			.mapToObj((i) -> "  ")
			.collect(StringBuilder::new,
					StringBuilder::append,
					StringBuilder::append);
	}
	@Override
	public void visit(Role role) {
		role.getChildren().forEach((child) -> child.accept(this));
	}
}
