package eg.edu.alexu.csd.datastructure.stack.cs22;

import eg.edu.alexu.csd.datastructure.linkedList.cs22_72.SinglyLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 * @author Khaled
 *
 */
public class MyStack implements IStack {

	private SinglyLinkedList list;

	public MyStack() {
		this.list = new SinglyLinkedList();
	}

	@Override
	public void add(int index, Object element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		list.add(size() - index, element);
	}

	@Override
	public Object pop() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is empty");
		}

		Object element = list.get(0);
		list.remove(0);
		return element;
	}

	@Override
	public Object peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is empty");
		}
		return list.get(0);
	}

	@Override
	public void push(Object element) {
		list.add(0, element);
	}

	@Override
	public boolean isEmpty() {
		if (list.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return list.size();
	}

}
