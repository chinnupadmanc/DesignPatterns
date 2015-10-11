public class VariableExpression extends TurtleExpression{

	private String name;
	
	public VariableExpression( String name ) {
		this.name = name;
	}
	
	public int evaluate(Context values ) {
		System.out.println("Variable Evaluate");
		return values.getValue(name);
	}

}
