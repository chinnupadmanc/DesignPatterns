import java.util.Comparator;

public class SortByName<E> implements Comparator<E>{

	@Override
	public int compare(E obj1, E obj2) {
		Student currentStudent = (Student)obj1;
		Student newStudent = (Student)obj1;
		return currentStudent.getName().compareToIgnoreCase(newStudent.getName());
	}
	
}
