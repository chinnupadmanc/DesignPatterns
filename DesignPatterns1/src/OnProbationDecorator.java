import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OnProbationDecorator<E> extends ListDecorator<E> {

	private AbstractSequentialList<E> decoratedList;
	private Student student;
	Iterator<E> decoratedListIterator;
	
	public OnProbationDecorator(AbstractSequentialList<E> list) {
		super(list);
		decoratedList = list;
		decoratedListIterator = decoratedList.iterator();
	}
	
	@Override
	public Iterator<E> iterator() {
		return new OnProbationIterator();
	}
	
	private class OnProbationIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			while(decoratedListIterator.hasNext()) {
				student = (Student) decoratedListIterator.next();
				System.out.println(student.getGpa());
				if (student.getGpa() < 2.85f) {
					return true;
				}
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();

			return (E) student;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}	
	}

	@Override
	public String toString() {
		Iterator<E> onProbationIterator = this.iterator();
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("]");		
		
		while(onProbationIterator.hasNext()) {
			stringBuilder.append(onProbationIterator.next().toString());
		}
		
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	public Object[] toArray() {
		Iterator<E> onProbationIterator = this.iterator();	
		Object[] objArray = new Object[size()];

		for (int i = 0; i < objArray.length; i++) {
			if(!onProbationIterator.hasNext()) {
				break;
			}
			objArray[i] = onProbationIterator.next();
		}

		return objArray;
	}
}

