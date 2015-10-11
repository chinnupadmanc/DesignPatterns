public class CommandVisitor extends TreeVisitor {
	
	private DoublyLinkedList<TurtleCommand> commandsList = new DoublyLinkedList<TurtleCommand>();
	private TurtleCommand argumentCommand;
	private Context context;
	
	public CommandVisitor(Context context) {
		this.context = context;
	}
	
	@Override
	public void visitPenUp() {
		TurtleCommand turtleCommand = new PenUp(context);
		commandsList.add(turtleCommand);
		
	}

	@Override
	public void visitPenDown() {
		TurtleCommand turtleCommand = new PenDown(context);
		commandsList.add(turtleCommand);
		
	}

	@Override
	public void visitMove(TurtleExpression te) {
		TurtleCommand turtleCommand = new Move(context, te);
		commandsList.add(turtleCommand);
	}

	@Override
	public void visitTurn(TurtleExpression te) {
		TurtleCommand turtleCommand = new Turn(context, te);
		commandsList.add(turtleCommand);
		
	}
	
	@Override
	public void visitAssignVariable(String name, int value) {
		TurtleCommand turtleCommand = new AssignVariable(context, name, value);
		commandsList.add(turtleCommand);
		
	}
	


	@Override
	public void visitRepeat(TurtleExpression te) {	
		TurtleCommand turtleCommand = new Repeat(context, te);
		commandsList.add(turtleCommand);
	}
	
	@Override
	public void visitEnd(int repeatIndex, TurtleExpression te) {
		TurtleCommand turtleCommand = new End(context, repeatIndex, te);
		commandsList.add(turtleCommand);
	}
	
	public TurtleCommand getArgumentCommand() {
		return argumentCommand;
	}

	public int getListSize() {
		return commandsList.size();
	}
	
	public DoublyLinkedList<TurtleCommand> getState() {
		return commandsList;
	}
	

}
