package eg.edu.alexu.csd.datastructure.queue.cs22;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author Khaled
 *
 */
public class MyQueueArray implements IQueue, IArrayBased {

	/**
	 * Max size of the array.
	 */
	private int maxSize;

	/**
	 *Array holding elements of the queue.
	 */
	private Object[] array;
	
	/**
	 * Holds the index of the element at the front.
	 */
	private int front;
	/**
	 * Holds the index of the element at the rear.
	 */
	private int rear;

	public MyQueueArray(int pMaxSize) {
		this.maxSize = pMaxSize + 1;
		this.array = new Object[maxSize];
		this.front = 0;
		this.rear = 0;
	}

	@Override
	public void enqueue(Object item) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Queue is full");
		}
		array[rear] = item;
		rear = (rear + 1) % maxSize;

	}

	@Override
	public Object dequeue() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Queue is Empty");
		}
		Object element = array[front];
		front = (front + 1) % maxSize;
		return element;
	}

	@Override
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;
	}

	/**
	 * Tests if the queue array is full.
	 */
	private boolean isFull() {
		if (front == (rear + 1) % maxSize) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return (maxSize + (rear - front)) % maxSize;
	}

}
