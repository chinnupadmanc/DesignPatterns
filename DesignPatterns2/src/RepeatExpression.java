import java.util.ArrayList;

public class RepeatExpression extends TurtleExpression {

	private StatementsListExpression statementsList = new StatementsListExpression();	
	private ArrayList<TurtleExpression> repeatSteps = statementsList.getProgramSteps();
	
	private TurtleExpression repeatCount;
	private boolean isEnded = false;
	
	public RepeatExpression(TurtleExpression repeatCount) {
		this.repeatCount = repeatCount;
	}
	
	public void addToList(TurtleExpression te) {
		repeatSteps.add(te);
	}
	
	public boolean getIsEnded() {
		return isEnded;
	}
	
	public void setIsEnded(boolean endStatus) {
		isEnded = endStatus;
	}
	
	public ArrayList<TurtleExpression> getList() {
		return repeatSteps;
	}
	
	public int evaluate(Context values) {	
		System.out.println("repeat evaluate");
		int repeat = repeatCount.evaluate(values);
		for (int i=0; i<repeat; i++ ) {
			statementsList.evaluate(values);
		}		
		return 0;
	}

	@Override
	public void accept(TreeVisitor visitor) {
		System.out.println("repeat accept");
		visitor.visitRepeat(repeatCount);	
		int repeatIndex = visitor.getListSize();
		statementsList.accept(visitor);
		visitor.visitEnd(repeatIndex, repeatCount);	
	}

}
