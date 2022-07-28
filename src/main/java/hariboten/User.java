package hariboten;

import java.util.stream.IntStream;

class User implements Entity {
	private final String name;

	public User(String name) {
		this.name = name;
	}

    public String getNameTree(int depth) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			builder.append("  ");
		}
		builder.append("user: ")
			.append(name)
			.append("\n");
		return builder.toString();
    }
}
