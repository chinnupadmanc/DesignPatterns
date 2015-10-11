public class AssignExpression extends TurtleExpression{

	private String name;
	private int value;
	
	public AssignExpression(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public int evaluate(Context values) {
		System.out.println("assign Evaluate");
		values.setValue(name, value);
		return 0;
	}

	@Override
	public void accept(TreeVisitor visitor) {
		System.out.println("assign accept");
		visitor.visitAssignVariable(name, value);			
	}
}
