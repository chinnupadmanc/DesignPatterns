public class Repeat extends TurtleCommand {

	private Context context;
	private TurtleExpression repeatCountExpression;

	public Repeat(Context context, TurtleExpression repeatCountExpression) {
		this.context = context;
		this.repeatCountExpression = repeatCountExpression;
	}


	@Override
	public void execute() {
		int repeatCount = repeatCountExpression.evaluate(context);
		System.out.println("repeat execute");
	}

	@Override
	public void undo() {
	}

}
