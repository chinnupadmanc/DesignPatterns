public class Turn extends TurtleCommand {

	private Context context;
	private TurtleExpression degreesExpression;
	private Turtle turtleObj;
	private int degrees;
	
	public Turn(Context context, TurtleExpression degreesExpression) {
		this.context = context;
		this.degreesExpression = degreesExpression;
	}

	@Override
	public void execute() {
		System.out.println("Turn execute");
		turtleObj = context.getTurtleObj();
		degrees = degreesExpression.evaluate(context);
		turtleObj.turn(degrees);		
	}

	@Override
	public void undo() {
		turtleObj.turn(-degrees);		
	}


}
