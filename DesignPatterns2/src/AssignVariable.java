
public class AssignVariable extends TurtleCommand {

	private Context context;
	private String name;
	private int value;
	
	public AssignVariable(Context context, String name, int value) {
		this.context = context;
		this.name = name;
		this.value = value;
	}

	@Override
	public void execute() {
		System.out.println("Assign execute");
		context.setValue(name, value);		
	}

	@Override
	public void undo() {
		context.removeValue(name, value);
	}


}
