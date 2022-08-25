package hariboten;

interface EntityVisitor {

	void visit(Entity entity);
	void visit(Role role);
}
