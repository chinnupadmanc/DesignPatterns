import java.util.AbstractSequentialList;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> extends AbstractSequentialList<E> {


	private Node headNode = new HeadNode();;
	private Node tailNode = new TailNode();
	private int size = 0;
	private int modCount = 0;;

	// No order strategy passed.
	public DoublyLinkedList() {

		headNode.next = tailNode;
		tailNode.prev = headNode;
	}

	/* Add a new node according to the strategy passed at the creation of 
	 * LinkedList object. Strategy here defines by what order the linked list is ordered. 
	 * If no strategy was specified at the creation of LinkedList object, 
	 * the new nodes will get added to the end of the list. */
	@Override
	public boolean add(E data) {

		addLast(data);
		
		//System.out.println("inside add " + data);


		size++;
		modCount++;

		return true;
	}

	// Add a new node at the end of list.
	private Node addLast(E data) {
		Node newNode = new RealNode(data);

		System.out.println("data" + data);
		System.out.println("node" + newNode);
		Node lastNode = tailNode.prev;
		newNode.prev = lastNode;
		newNode.next = tailNode;
		lastNode.next = newNode;
		tailNode.prev = newNode;

		return newNode;
	}


	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		return (E) getNode(index).data;
	}

	private Node getNode(int index) {

		Node currentNode = headNode;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
			//System.out.println("getNode Node " + currentNode);
			//System.out.println("getNode data " + currentNode.data);
		}

		return currentNode;
	}

	@Override
	public int size() {
		return size;
	}


	@Override
	public ListIterator<E> listIterator(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return new LinkedListIterator();
	}

	// Iterator class	
	private class LinkedListIterator implements ListIterator<E> {

		private Node nextNode;
		private Node lastReturnedNode = null;
		private int nextIndex;
		private int currentModCount = modCount;

		LinkedListIterator() {
			nextNode = getNode(1);
			nextIndex = 1;      	
		}

		@Override
		public void add(E arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean hasNext() {
			return nextIndex < size;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			System.out.println("inside next" + lastReturnedNode);
			checkForConcurrentModification();

			if (!hasNext())
				throw new NoSuchElementException();

			int status = -1;

			if(lastReturnedNode != null) {
				System.out.println("lastReturnedNode != null");
				status = lastReturnedNode.getData().getState();
			}

			if(status > 0) {
				System.out.println("status != 0");
				int move = nextIndex - status;
				for(int i=0;i<move;i++){
					nextNode = nextNode.prev;
					nextIndex--;
				}
			}
			else if(status==0)
			{
				System.out.println("status == 0");
				nextNode = nextNode.next;
				nextIndex++;
			}
			else {
				System.out.println("status == -1");
				nextNode = getNode(1);
				nextIndex = 1;
			}

			lastReturnedNode = nextNode;
			System.out.println(lastReturnedNode);
			return (E) lastReturnedNode.data;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void set(E arg0) {
			// TODO Auto-generated method stub

		}

		final void checkForConcurrentModification() {
			if (modCount != currentModCount)
				throw new ConcurrentModificationException();
		}

	} // End of LinkedListIterator

	private abstract class Node {

		protected TurtleCommand data;
		protected Node next;
		protected Node prev;

		public Node(E data)
		{
			this.data = (TurtleCommand) data;
			this.next = null;
			this.prev = null;
		}


		public abstract boolean hasNext();

		public TurtleCommand getData() {
			return data;
		}

	} // End of Node class

	private class RealNode extends Node {

		public RealNode(E data) {
			super(data);
		}


		@Override
		public boolean hasNext() {
			return true;
		}

	} // End of RealNode class

	private class HeadNode extends Node {

		public HeadNode() {
			super(null);
		}



		@Override
		public boolean hasNext() {
			return true;
		}

	} // End of HeadNode class

	private class TailNode extends Node {

		public TailNode() {
			super(null);
		}



		@Override
		public boolean hasNext() {
			return false;
		}

	} // End of TailNode class

}
