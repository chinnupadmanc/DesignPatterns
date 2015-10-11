public class ConstantExpression extends TurtleExpression {

	private int value;
	
	public ConstantExpression( int value ) {
		this.value = value;
	}
	
	public int evaluate(Context values ) {
		System.out.println("constant evaluate");
		return value;
	}

}
