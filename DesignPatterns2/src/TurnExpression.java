
public class TurnExpression extends TurtleExpression {

	private TurtleExpression degreesExpression;

	public TurnExpression(TurtleExpression degrees) {
		this.degreesExpression = degrees;
	}
	
	public int evaluate(Context values) {	
		System.out.println("Turn Evaluate");
		Turtle turtleObj = values.getTurtleObj();
		int degrees = degreesExpression.evaluate(values);
		turtleObj.turn(degrees);
		return 1;
	}

	@Override
	public void accept(TreeVisitor visitor) {
		System.out.println("turn accept");
		//degreesExpression.accept(visitor);
		visitor.visitTurn(degreesExpression);
		
	}

}
