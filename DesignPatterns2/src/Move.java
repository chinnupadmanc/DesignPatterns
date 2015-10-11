public class Move extends TurtleCommand {

	private Context context;
	private TurtleExpression distanceExpression;
	private Turtle turtleObj;
	private int distance;

	public Move(Context context, TurtleExpression distanceExpression) {
		this.context = context;
		this.distanceExpression = distanceExpression;
	}

	@Override
	public void execute() {
		System.out.println("Move execute");
		turtleObj = context.getTurtleObj();
		distance = distanceExpression.evaluate(context);
		turtleObj.move(distance);	
	}

	@Override
	public void undo() {
		System.out.println("Move undo");
		turtleObj.move(-distance);
	}

}
