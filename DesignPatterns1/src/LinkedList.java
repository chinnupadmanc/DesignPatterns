import java.util.AbstractSequentialList;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractSequentialList<E> {
	
	private Comparator<E> orderer;
	private Node headNode = new HeadNode();;
	private Node tailNode = new TailNode();
	private int size = 0;
	private int modificationCount = 0;;
	
	// No order strategy passed.
	public LinkedList() {
		orderer = null;
		headNode.next = tailNode;
		tailNode.prev = headNode;
	}
	
	// Order strategy passed.
	public LinkedList(Comparator<E> orderType)
	{
		orderer = orderType;
		headNode.next = tailNode;
		tailNode.prev = headNode;
	}
	 
	// Add a new node according to the strategy passed at the creation of LinkedList object. 
	// Strategy here defines by what order the linked list is ordered.
	// If no strategy was specified at the creation of LinkedList object, 
	// the new nodes will get added to the end of the list.
	@Override
	public boolean add(E data) {
		
		if(orderer == null) {
			addLast(data);
		}
		else {
			addByOrder(data);
		}
		
		size++;
		modificationCount++;

		return true;
	}

	// Add a new node at the end of list.
	private Node addLast(E data) {
		Node newNode = new RealNode(data);
		
		Node lastNode = tailNode.prev;
		newNode.prev = lastNode;
		newNode.next = tailNode;
		lastNode.next = newNode;
		tailNode.prev = newNode;
		
		return newNode;
	}

	// Add a new node according to the order strategy.
	private boolean addByOrder(E data) {
		Node currentNode = headNode;

		// Loop till the node before which the new node to be added.
		while(!currentNode.compare(data)) {
			currentNode = currentNode.next;
		}

		// Add new node before currentNode.
		addBefore(data, currentNode);
		
		return true;
	}

	// Add a new node before the node passed as the second argument.
	private Node addBefore(E data, Node nodeAfter) {
		Node newNode = new RealNode(data);

		Node nodeBefore = nodeAfter.prev;
		newNode.prev = nodeBefore;
		newNode.next = nodeAfter;
		nodeAfter.prev = newNode;
		nodeBefore.next = newNode;
		
		return newNode;
	}
	
	public boolean displayList()
    {
		Node currentNode = null;
		for(currentNode=headNode.next;currentNode.next!=null;currentNode=currentNode.next)
		{
			Student stud = (Student) currentNode.data;
			
			System.out.println(stud.getName());
		}	
		return true;
    }
	
	@Override
	public int size() {
		return size;
	}
		
	@Override
	public String toString() {
		Iterator<E> itor = iterator();

		if (!itor.hasNext())
			return "[]";

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append('[');
		while(itor.hasNext()) {
			stringBuilder.append(itor.next().toString());	
		}
		stringBuilder.append(']');

		return stringBuilder.toString();
	}

	public Object[] toArray() {		
		Iterator<E> itor = iterator();
		Object[] objArray = new Object[size];

		for (int i = 0; i < objArray.length; i++) {
			objArray[i] = itor.next();
		}

		return objArray;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	// Not implemented. Added to satisfy the parent class's constraints. 
	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Iterator class	
	private class LinkedListIterator implements Iterator<E> {

		private Node nextNode;
		private Node lastReturnedNode;
		private int currentModCount = modificationCount;
		 
		LinkedListIterator() {
			nextNode = headNode.next;
			Student s = (Student) nextNode.data;
			System.out.println(s.getName());
			lastReturnedNode = null;
		}

		@Override
		public boolean hasNext() {
			return nextNode.hasNext();
		}

		@Override
		public E next() {
			checkForConcurrentModification();
			
			if (!hasNext())
				throw new NoSuchElementException();
			
			lastReturnedNode = nextNode;
			nextNode = nextNode.next;
            return lastReturnedNode.data;
		}

		// Not implemented. Added to satisfy the parent class's constraints. 
		@Override
		public void remove() {
			// TODO Auto-generated method stub		
		}
		 
		final void checkForConcurrentModification() {
			if (modificationCount != currentModCount)
				throw new ConcurrentModificationException();
		}
		
	} // End of LinkedListIterator

	private abstract class Node {

		protected E data;
		protected Node next;
		protected Node prev;

		public Node(E data)
		{
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		
		public abstract boolean compare(E data);
		
		public abstract boolean hasNext();

	} // End of Node class
	
	private class RealNode extends Node {

		public RealNode(E data) {
			super(data);
		}
		
		@Override		
		public boolean compare(E data) {
			
			// This will enable the new Node to be inserted at the end of list,
			// if no strategy was explicitly passed at run time.
			if(orderer == null) {
				return false;			
			}
			
			if(orderer.compare(this.data, data) > 0 ) {
				return true;
			}
			return false;
		}
		
		@Override
		public boolean hasNext() {
			System.out.println("node");
			return true;
		}

	} // End of RealNode class

	private class HeadNode extends Node {

		public HeadNode() {
			super(null);
		}

		@Override
		public boolean compare(E data) {
			return false;
		}

		@Override
		public boolean hasNext() {
			System.out.println("head");
			return true;
		}
		
	} // End of HeadNode class
	
	private class TailNode extends Node {

		public TailNode() {
			super(null);
		}

		@Override
		public boolean compare(E data) {
			return true;
		}

		@Override
		public boolean hasNext() {
			System.out.println("tail");
			return false;
		}
		
	} // End of TailNode class
	
}
