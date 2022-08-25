package hariboten;


import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;

class JsonVisitor implements EntityVisitor {
	private JSONObject root;
	private Optional<JSONArray> childrenOfParent;

	public JsonVisitor() {
		root = new JSONObject();
		childrenOfParent = Optional.empty();
	}

	@Override
	public String toString() {
		return root.toString();
	}

	public JSONObject build() {
		return root;
	}

	public void visit(Role role) {
		var children = ListToJson(role.getChildren());

		var json = new JSONObject()
			.put("type", "role")
			.put("children", children);

		childrenOfParent
			.map((list) -> list.put(json));
		root = json;
	}

	@Override
	public void visit(Entity entity) {
		var children = ListToJson(entity.getChildren());
		var json = new JSONObject()
			.put("type", entity.getType())
			.put("name", entity.getName())
			.put("children", children);

		root = childrenOfParent
			.map((list) -> list.put(json))
			.map((unuse) -> root)
			.orElse(json);
	}

	private JSONArray ListToJson(List<Entity> childrenList) {
		var children = new JSONArray();
		var parentPointer = childrenOfParent;
		childrenList.forEach((child) -> {
			childrenOfParent = Optional.of(children);
			child.accept(this);
		});
		childrenOfParent = parentPointer;
		return children;
	}
}
