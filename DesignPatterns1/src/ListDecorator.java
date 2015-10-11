import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class ListDecorator<E> extends AbstractSequentialList<E>  {

	protected AbstractSequentialList<E> decoratedList;
	
	public ListDecorator(AbstractSequentialList<E> list) {
		decoratedList = list;
	}
	
	@Override
	public ListIterator<E> listIterator(int index) {
		return decoratedList.listIterator(index);
	}

	@Override
	public int size() {
		return  decoratedList.size();
	}

}
