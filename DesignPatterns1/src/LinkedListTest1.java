import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Scanner;

import org.junit.Test;


public class LinkedListTest1 {

	Scanner scan = new Scanner(System.in);
	String name;
	int redId;
	float gpa;
	
	Comparator<Student> orderType = new SortByName<>();
	LinkedList<Student> list = new LinkedList<>(orderType);
	
	@Test
	public void testToString() {
		Student sudentObj1 = new Student("student1",11111, 3.6f);
		assertTrue(list.add(sudentObj1));
		
		Student sudentObj2 = new Student("student2",22222, 1.5f);
		assertTrue(list.add(sudentObj2));
		
		Student sudentObj3 = new Student("student3",33333, 1.2f);
		assertTrue(list.add(sudentObj3));
		
		String str = list.toString();
		System.out.println(str);
		
		assertTrue(list.displayList());
	}

}
