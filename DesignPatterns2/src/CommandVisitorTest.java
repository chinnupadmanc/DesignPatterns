import static org.junit.Assert.assertEquals;

import java.awt.geom.Point2D;
import java.util.ListIterator;

import org.junit.Test;


public class CommandVisitorTest {

	@Test
	public void testNoRepeat() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		CommandVisitor visitor = new CommandVisitor(context);	
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_NoRepeat.txt");
		programSteps.accept(visitor);
		
		DoublyLinkedList<TurtleCommand> commandList = visitor.getState();
		
		ListIterator<TurtleCommand> itor = commandList.listIterator(0);
		
		while(itor.hasNext()) {
			itor.next().execute();
		}
		
		assertEquals(22.99, turtleObj.location().getX(), 0.01);
		assertEquals(27.5, turtleObj.location().getY(), 0.01);	
	}
	
	@Test
	public void testWithVariable() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		CommandVisitor visitor = new CommandVisitor(context);	
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_WithVariable.txt");
		programSteps.accept(visitor);
		
		DoublyLinkedList<TurtleCommand> commandList = visitor.getState();
		
		ListIterator<TurtleCommand> itor = commandList.listIterator(0);
		
		while(itor.hasNext()) {
			itor.next().execute();
		}
		
		assertEquals(22.99, turtleObj.location().getX(), 0.01);
		assertEquals(27.5, turtleObj.location().getY(), 0.01);	
	}
	
	@Test
	public void testWithRepeat() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		CommandVisitor visitor = new CommandVisitor(context);	
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_Repeat.txt");
		programSteps.accept(visitor);
		
		DoublyLinkedList<TurtleCommand> commandList = visitor.getState();
		
		ListIterator<TurtleCommand> itor = commandList.listIterator(0);
		
		while(itor.hasNext()) {
			itor.next().execute();
		}
		
		
		assertEquals(30, turtleObj.location().getX(), 0.01);
		assertEquals(10, turtleObj.location().getY(), 0.01);	
	}
	
	@Test
	public void testWithNestedRepeat() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		CommandVisitor visitor = new CommandVisitor(context);	
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_NestedRepeat.txt");
		programSteps.accept(visitor);
		
		DoublyLinkedList<TurtleCommand> commandList = visitor.getState();
		
		ListIterator<TurtleCommand> itor = commandList.listIterator(0);
		
		while(itor.hasNext()) {
			itor.next().execute();
		}
		
		assertEquals(10, turtleObj.location().getX(), 0.01);
		assertEquals(20, turtleObj.location().getY(), 0.01);	
	}
	
	@Test
	public void testWithRepeatAndVariable() {
		
		Context context = new Context();
		Turtle turtleObj = new Turtle();
		context.setTurtleObj(turtleObj);
		CommandVisitor visitor = new CommandVisitor(context);	
		TurtleInterpreter turtleInterpreter = new TurtleInterpreter();
		StatementsListExpression programSteps = turtleInterpreter.parseProgram("C:/Users/chinnupadman/Desktop/TestFiles/Test_Repeat_Variable.txt");
		programSteps.accept(visitor);
		
		DoublyLinkedList<TurtleCommand> commandList = visitor.getState();
		
		ListIterator<TurtleCommand> itor = commandList.listIterator(0);
		
		while(itor.hasNext()) {
			itor.next().execute();
		}
		
		assertEquals(0, turtleObj.location().getX(), 0.01);
		assertEquals(10, turtleObj.location().getY(), 0.01);	
	}

}
