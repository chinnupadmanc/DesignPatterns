import static org.junit.Assert.assertEquals;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;


public class DistanceVisitorTest {

	@Test
	public void testNoRepeat() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		DistanceVisitor visitor = new DistanceVisitor(context);		
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_NoRepeat.txt");
		programSteps.accept(visitor);
		
		int distanceTravelled = visitor.getState();
		
		assertEquals(45, distanceTravelled);		
	}
	
	@Test
	public void testWithVariable() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		DistanceVisitor visitor = new DistanceVisitor(context);		
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_WithVariable.txt");
		programSteps.accept(visitor);
		
		int distanceTravelled = visitor.getState();
		
		assertEquals(45, distanceTravelled);		
	}
	
	@Test
	public void testWithRepeat() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		DistanceVisitor visitor = new DistanceVisitor(context);		
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_Repeat.txt");
		programSteps.accept(visitor);
		
		int distanceTravelled = visitor.getState();
		
		assertEquals(120, distanceTravelled);		
	}
	
	@Test
	public void testWithNestedRepeat() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		DistanceVisitor visitor = new DistanceVisitor(context);		
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_NestedRepeat.txt");
		programSteps.accept(visitor);
		
		int distanceTravelled = visitor.getState();
		
		assertEquals(130, distanceTravelled);		
	}
	
	@Test
	public void testWithRepeatAndVariable() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		DistanceVisitor visitor = new DistanceVisitor(context);		
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_Repeat_Variable.txt");
		programSteps.accept(visitor);
		
		int distanceTravelled = visitor.getState();
		
		assertEquals(30, distanceTravelled);		
	}

}
