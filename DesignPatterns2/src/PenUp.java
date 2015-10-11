public class PenUp extends TurtleCommand{

	private Context context;
	private Turtle turtleObj; 
	private boolean isPenUpBefore;

	public PenUp(Context context) {
		this.context = context;
	}

	@Override
	public void execute() {
		System.out.println("PenUp execute");
		turtleObj = context.getTurtleObj();
		isPenUpBefore = turtleObj.isPenUp();
		turtleObj.penUp();
	}

	@Override
	public void undo() {
		if(!isPenUpBefore) {
			turtleObj.penDown();		
		}

	}

}
