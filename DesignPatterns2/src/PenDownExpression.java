
public class PenDownExpression extends TurtleExpression {

	/*private Turtle turtleObj;

	public PenDownExpression(Turtle turtleObj) {
		this.turtleObj = turtleObj;
	}*/

	public int evaluate(Context values) {
		System.out.println("PenDown Evaluate");
		Turtle turtleObj = values.getTurtleObj();
		turtleObj.penDown();
		return 1;
	}

	@Override
	public void accept(TreeVisitor visitor) {
		System.out.println("pendown accept");
		visitor.visitPenDown();
		
	}



}
