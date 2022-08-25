package hariboten;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VisitorTest {
	@Test
	public void testGetNameTreeNoChild() {
		var expected = """
			group: name
			""";
		var group = new Group("name");

		var visitor = new NameTreeVisitor();
		group.accept(visitor);
		assertEquals(expected, visitor.toString());
	}

	@Test
	public void testGetNameTreeWithAChild() {
		var expected = """
			group: group
			  user: user
			""";
		var group = new Group("group");
		var user = new User("user");
		group.add(user);

		var visitor = new NameTreeVisitor();
		group.accept(visitor);
		assertEquals(expected, visitor.toString());
	}
}
