public class End extends TurtleCommand {
	
	private Context context;
	private int repeatIndex;
	private TurtleExpression repeatCountExpression;
	private int countOfRepeats = 0;
	private int nextIndex;
	
	public End(Context context, int repeatIndex, TurtleExpression repeatCountExpression) {
		this.context = context;
		this.repeatIndex = repeatIndex;
		this.repeatCountExpression = repeatCountExpression;
	}

	@Override
	public void execute() {
		int repeatCount = repeatCountExpression.evaluate(context);
		System.out.println("repeatCount: " + repeatCount);
		System.out.println("countOfRepeats: "+ countOfRepeats);
		System.out.println("end execute");
		countOfRepeats++;
		if (countOfRepeats < repeatCount )
		{
			nextIndex = repeatIndex;
			System.out.println("nextIndex: " + nextIndex);
		}
		else 
		{
			nextIndex = 0;
		}
	}

	@Override
	public void undo() {		
	}

	@Override
	public int getState() {
		return nextIndex;
	}
	
	

}
