import java.util.Hashtable;


public class Context {

	private Turtle turtleObj;
	
	Hashtable<String,Integer> values = new Hashtable<String,Integer>();

	public int getValue( String variableName ) {
		return values.get( variableName );
	}
	
	public void setValue( String variableName, Integer value ) {
		values.put( variableName, value ) ;
	}
	
	public void removeValue( String variableName, Integer value ) {
		values.remove(variableName, value ) ;
	}

	public Turtle getTurtleObj() {
		return turtleObj;
	}

	public void setTurtleObj(Turtle turtleObj) {
		this.turtleObj = turtleObj;
	}

	
}
