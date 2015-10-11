
public abstract class TreeVisitor {
	public abstract void visitPenUp();
	public abstract void visitPenDown();
	public abstract void visitMove(TurtleExpression te);
	public abstract void visitTurn(TurtleExpression te);
	public abstract void visitAssignVariable(String name, int value);
	public abstract void visitRepeat(TurtleExpression te);
	public abstract void visitEnd(int repeatIndex, TurtleExpression te);

	public abstract int getListSize();
	//public abstract  TurtleCommand getArgumentCommand();
	
}
