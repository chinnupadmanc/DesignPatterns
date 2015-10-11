import java.util.Iterator;
import java.util.NoSuchElementException;

public class OnProbationFilter<E> {

	private Iterator<E> list;
	private Student student;
	
	public OnProbationFilter(Iterator<E> input) {
		list = input;
	}
	
	// Returns true if there are more students on probation.
	public boolean hasNext() {
		while(list.hasNext()) {
			student = (Student) list.next();
			System.out.println(student.getGpa());
			if (student.getGpa() < 2.85f) {
				return true;
			}
		}
		return false;
	}
	
	// Returns the next student element who is on probation.
	public Student next() {
		if (!hasNext())
			throw new NoSuchElementException();
		
		return student;
	}
}
