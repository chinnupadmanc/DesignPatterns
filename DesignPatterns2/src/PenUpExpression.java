
public class PenUpExpression extends TurtleExpression {

	/*private Turtle turtleObj;

	public PenUpExpression(Turtle turtleObj) {
		this.turtleObj = turtleObj;
	}*/

	public int evaluate(Context values) {
		System.out.println("PenUp Evaluate");
		Turtle turtleObj = values.getTurtleObj();
		turtleObj.penUp();
		return 1;
	}

	@Override
	public void accept(TreeVisitor visitor) {
		System.out.println("penup accept");
		visitor.visitPenUp();
		
	}




}
