package hariboten;

import java.util.stream.IntStream;

class User implements Entity {
	private final String name;

	public User(String name) {
		this.name = name;
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
}
