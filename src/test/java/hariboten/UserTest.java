package hariboten;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	public void testGetNameTree() {
		var user = new User("name");
		var expected = """
			user: name
			""";
		assertEquals(expected, user.getNameTree(0));

		var indentByOne = """
			  user: name
			""";
		assertEquals(indentByOne, user.getNameTree(1));

		assertEquals(expected, user.getNameTree(-1));
	}

}
