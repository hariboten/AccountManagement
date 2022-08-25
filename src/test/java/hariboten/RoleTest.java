package hariboten;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoleTest {

	@Test
	public void testGetNameTree() {
		var expected = """
			user: user
			""";
		var role = new Role();
		var user = new User("user");
		role.add(user);
		assertEquals(expected, role.getNameTree());
	}

	@Test
	public void testGetNameTreeWithNoEntities() {
		var expected = """
			""";
		var role = new Role();
		assertEquals(expected, role.getNameTree());
	}

	@Test
	public void testComplecated() {
		var expected = """
			user: user1
			group: group1
			  user: user2
			  group: group3
			group: group2
			""";
		var role = new Role();
		var user1 = new User("user1");
		var group1 = new Group("group1");
		var user2 = new User("user2");
		var group2 = new Group("group2");
		var group3 = new Group("group3");

		role.add(user1);
		role.add(group1);
		role.add(group2);

		group1.add(user2);
		group1.add(group3);

		var visitor = new JsonVisitor();
		role.accept(visitor);
		System.err.println(visitor.build().toString());
		var nameTreeVisitor = new NameTreeVisitor();
		role.accept(nameTreeVisitor);
		assertEquals(expected, nameTreeVisitor.toString());
	}
}
