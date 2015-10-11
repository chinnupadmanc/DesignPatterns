import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Test;


public class TurtleInterpreterTest {


	@Test
	public void testNoRepeat() {

		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);		
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_NoRepeat.txt");

		programSteps.evaluate(context);
		
		assertEquals(22.99, turtleObj.location().getX(), 0.01);
		assertEquals(27.5, turtleObj.location().getY(), 0.01);	
	}

	@Test
	public void testWithVariable() {

		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);	
		TurtleInterpreter p = new TurtleInterpreter();
		StatementsListExpression programSteps = p.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_WithVariable.txt");

		programSteps.evaluate(context);
		
		assertEquals(22.99, turtleObj.location().getX(), 0.01);
		assertEquals(27.5, turtleObj.location().getY(), 0.01);
	}

	@Test
	public void testWithRepeat() {

		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);	
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();

		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_Repeat.txt");

		programSteps.evaluate(context);

		assertEquals(30, turtleObj.location().getX(), 0.01);
		assertEquals(10, turtleObj.location().getY(), 0.01);
	}

	@Test
	public void testWithNestedRepeat() {

		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);	
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_NestedRepeat.txt");

		programSteps.evaluate(context);

		assertEquals(10, turtleObj.location().getX(), 0.01);
		assertEquals(20, turtleObj.location().getY(), 0.01);		
	}

	@Test
	public void testWithRepeatAndVariable() {

		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);	
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_Repeat_Variable.txt");

		programSteps.evaluate(context);

		assertEquals(0, turtleObj.location().getX(), 0.01);
		assertEquals(10, turtleObj.location().getY(), 0.01);			
	}


}
