import java.awt.Point;
import java.awt.geom.Point2D;

public class Turtle {

	private int degrees = 0;
	private float x = 0.00f;
	private float y = 0.00f;
	private boolean isPenUp = false;
	
	// Move the turtle distance units in the current direction and draw on the screen if the pen is down.
	public void move(int distance) {		
		float deltaX = 0.00f;
		float deltaY = 0.00f;
		float radians = (float) Math.PI * degrees / 180;
		deltaX = (float) Math.cos(radians) * distance;
		deltaY = (float) Math.sin(radians) * distance;
		
		System.out.println(deltaX);
		x = x + deltaX;
		y = y + deltaY;				
	}

	//Add “degrees” to the current heading of the turtle.
	public void turn(int turnDegrees) {
		degrees = degrees + turnDegrees;	 
	}
	
	//Lift the pen up.
	void penUp() {
		isPenUp = true;
	}
	
	// Put the pen down.
	void penDown() {
		isPenUp = false;
	}
	 
	// Return true if pen is up, false if the pen is down.
	boolean isPenUp() {
		return isPenUp;
	}
	 
	// Returns the current direction of the turtle.
	int direction() {
		return degrees;
	}
	 
	// Returns the current location of the turtle.
	Point2D location() {
		return new Point2D.Float(x,y);
	}
	 
}
