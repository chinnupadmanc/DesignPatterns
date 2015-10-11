
public class PenDown extends TurtleCommand{

	private Context context;
	private Turtle turtleObj; 
	private boolean isPenUpBefore;

	public PenDown(Context context) {
		this.context = context;
	} 

	@Override
	public void execute() {
		System.out.println("PenDown execute");
		turtleObj = context.getTurtleObj();
		isPenUpBefore = turtleObj.isPenUp();
		turtleObj.penDown();
	}

	@Override
	public void undo() {
		if(isPenUpBefore) {
			turtleObj.penUp();			
		}
	}


}
