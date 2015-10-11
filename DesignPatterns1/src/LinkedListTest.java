import static org.junit.Assert.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import org.junit.Test;


public class LinkedListTest {

	Scanner scan = new Scanner(System.in);
	String name;
	int redId;
	float gpa;
	
	Comparator<Student> orderType = new SortByName<>();
	LinkedList<Student> list = new LinkedList<>(orderType);
	
	@Test
	public void testAddE() {
		
		Student sudentObj1 = new Student("student1",11111, 3.6f);
		assertTrue(list.add(sudentObj1));
		
		Student sudentObj2 = new Student("student2",22222, 1.5f);
		assertTrue(list.add(sudentObj2));
		
		Student sudentObj3 = new Student("student3",33333, 1.2f);
		assertTrue(list.add(sudentObj3));
		
		assertTrue(list.displayList());
	}
	

	@Test
	public void testOnProbationFilter() {
		
		Student sudentObj1 = new Student("student1",11111, 3.6f);
		assertTrue(list.add(sudentObj1));
		
		Student sudentObj2 = new Student("student2",22222, 1.5f);
		assertTrue(list.add(sudentObj2));
		
		Student sudentObj3 = new Student("student3",33333, 1.2f);
		assertTrue(list.add(sudentObj3));
		
		Student student = null;
		Iterator<Student> iterator = list.iterator();
		OnProbationFilter<Student> filter = new OnProbationFilter<>(iterator);
		while(filter.hasNext()) {
			System.out.println("1");
			student = filter.next();
			System.out.println(student.getName());
		}
		System.out.println("2");
		assertEquals("Success", "student3", student.getName());

	}
}