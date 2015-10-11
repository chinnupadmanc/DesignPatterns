public abstract class TurtleCommand {
	
	public abstract void execute();
	public abstract void undo();	
	
	public int getState() {
		return 0;
	}
	
}
