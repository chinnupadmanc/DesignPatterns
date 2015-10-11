
public class MoveExpression extends TurtleExpression {

	//private Turtle turtleObj;
	private TurtleExpression distanceExpression;

	//public MoveExpression(Turtle turtleObj, TurtleExpression distance) {
	//this.turtleObj = turtleObj;
	public MoveExpression(TurtleExpression distance) {
		this.distanceExpression = distance;
	}

	public int evaluate(Context values) {	
		System.out.println("Move Evaluate");
		Turtle turtleObj = values.getTurtleObj();
		int distance = distanceExpression.evaluate(values);
		//int distance = distanceExpression.getValue();
		turtleObj.move(distance);
		return 0;
	}

	public void accept(TreeVisitor visitor) {	
		System.out.println("Move accept");
		//distanceExpression.accept(visitor);
		visitor.visitMove(distanceExpression);		
	}


}
