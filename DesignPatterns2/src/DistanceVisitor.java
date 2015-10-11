import java.util.Stack;


public class DistanceVisitor extends TreeVisitor {
	
	private int distanceTravelled;
	private Context context;
	private Stack<Integer> stack = new Stack<Integer>();
	
	public DistanceVisitor(Context context) {
		this.context = context;
	}

	@Override
	public void visitPenUp() {		
	}

	@Override
	public void visitPenDown() {	
	}


	public int getState() {
		return distanceTravelled;
	}

	@Override
	public int getListSize() {
		return 0;
	}

	@Override
	public void visitMove(TurtleExpression te) {
		int curretnDistance = te.evaluate(context);
		distanceTravelled = distanceTravelled + Math.abs(curretnDistance);
	}

	@Override
	public void visitTurn(TurtleExpression te) {
		
	}

	@Override
	public void visitAssignVariable(String name, int value) {
		context.setValue(name, value);	
	}

	@Override
	public void visitRepeat(TurtleExpression te) {
		stack.push(distanceTravelled);
	}

	@Override
	public void visitEnd(int repeatIndex, TurtleExpression te) {
		int repeatCount = te.evaluate(context);
		int prevDistance = (int) stack.pop();
		distanceTravelled = prevDistance + (distanceTravelled - prevDistance) * repeatCount;	
	}




}
