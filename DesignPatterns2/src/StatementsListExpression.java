import java.util.ArrayList;
import java.util.Iterator;


public class StatementsListExpression extends TurtleExpression {

	ArrayList<TurtleExpression> programSteps = new ArrayList<TurtleExpression>();
	
	/*public StatementsListExpression(ArrayList<TurtleExpression> programSteps) {
		this.programSteps = programSteps;
	}*/

	public int evaluate(Context values) {	
		System.out.println("Statement List Evaluate");
		Iterator<TurtleExpression> iterator = programSteps.iterator();

		while(iterator.hasNext()) {
			iterator.next().evaluate(values);
		}
		
		return 1;
	}

	public void accept(TreeVisitor visitor) {	
		System.out.println("Statement List accept");
		Iterator<TurtleExpression> iterator = programSteps.iterator();

		while(iterator.hasNext()) {
			iterator.next().accept(visitor);
		}
		
	}

	
	public ArrayList<TurtleExpression> getProgramSteps() {
		return programSteps;
	}

	public void setProgramSteps(ArrayList<TurtleExpression> programSteps) {
		this.programSteps = programSteps;
	}

}
