package hariboten;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GroupTest {

	@Test
	public void testGetNameTreeNoChild() {
		var expected = """
			group: name
			""";
		var group = new Group("name");
		assertEquals(expected, group.getNameTree(0));

		var indentByOne = """
			  group: name
			""";
		assertEquals(indentByOne, group.getNameTree(1));

		assertEquals(expected, group.getNameTree(-1));
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
		assertEquals(expected, group.getNameTree(0));
	}
}
