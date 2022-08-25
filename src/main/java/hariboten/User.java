package hariboten;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class User implements Entity {
	private final String name;
	private final Id id;

	public User(String name) {
		this.name = name;
		this.id = new Id();
		EntityRepository.getEntityRepository().addEntity(this);
	}

	public Id getId() {
		return id;
	}

	private static StringBuilder indent(final int depth) {
		return IntStream.range(0, depth)
			.mapToObj((i) -> "  ")
			.collect(StringBuilder::new,
					StringBuilder::append,
					StringBuilder::append);
	}

    public String getNameTree(final int depth) {
		return indent(depth)
			.append("user: ")
			.append(name)
			.append("\n")
			.toString();
    }



	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return "user";
	}

	@Override
	public void accept(EntityVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public List<Entity> getChildren() {
		return new ArrayList<Entity>();
	}
}
