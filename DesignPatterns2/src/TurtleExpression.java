
public abstract class TurtleExpression {
	public abstract int evaluate(Context values);
	public void accept(TreeVisitor visitor) {};
}
