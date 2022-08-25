package hariboten;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class JsonVisitorTest {
	@Test
	public void testJsonWithNoChild() {
		var group = new Group("groupName");

		var expected = new JSONObject();
		expected.put("type", "group");
		expected.put("name", "groupName");
		expected.put("children", new JSONArray());

		var visitor = new JsonVisitor();
		group.accept(visitor);
		var res = visitor.build();
		assertEquals(expected.toString(), res.toString());
	}

	@Test
	public void testGetJsonWithAChild() {
		var group = new Group("groupName");
		var user = new User("userName");
		group.add(user);

		var userJson = new JSONObject()
			.put("type", "user")
			.put("name", "userName")
			.put("children", new JSONArray());

		var children = new JSONArray()
			.put(userJson);
		var expected = new JSONObject()
			.put("type", "group")
			.put("name", "groupName")
			.put("children", children);

		var visitor = new JsonVisitor();
		group.accept(visitor);
		var res = visitor.build();

		assertEquals(expected.toString(), res.toString());
		assertEquals(expected.toString(), res.toString());
	}
}
