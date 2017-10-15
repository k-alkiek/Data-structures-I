package eg.edu.alexu.csd.datastructure.queue.cs22;

import eg.edu.alexu.csd.datastructure.linkedList.cs22_72.DoublyLinkedList;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author Khaled
 *
 */
public class MyQueueLinked implements IQueue, ILinkedBased {

	/**
	 * Linked list that stores the elements.
	 */
	private DoublyLinkedList list;

	public MyQueueLinked() {
		list = new DoublyLinkedList();
	}

	@Override
	public void enqueue(Object item) {
		list.add(item);
	}

	@Override
	public Object dequeue() {
		Object item = list.get(0);
		list.remove(0);
		return item;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

}
