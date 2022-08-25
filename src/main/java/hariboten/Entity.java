package hariboten;

import java.util.List;

interface Entity {
    String getNameTree(int depth);

	Id getId();

    String getName();

	String getType();

	void accept(EntityVisitor visitor);

	public List<Entity> getChildren();
}
