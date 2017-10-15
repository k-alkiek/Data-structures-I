package eg.edu.alexu.csd.datastructure.queue.cs22;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Khaled
 *
 */
public class QueueArrayTestCases {

	static final int SIZE = 10;

	@Test
	public void myQueueArrayTest() {
		final MyQueueArray queue = new MyQueueArray(SIZE);

		Assert.assertEquals(0, queue.size());
		Assert.assertTrue("Expected empty queue", queue.isEmpty());

		queue.enqueue('a');
		queue.enqueue('b');
		queue.enqueue('c');

		Assert.assertEquals(3, queue.size());
		Assert.assertEquals('a', queue.dequeue());
		Assert.assertEquals('b', queue.dequeue());
		Assert.assertEquals('c', queue.dequeue());
		Assert.assertEquals(0, queue.size());
		Assert.assertTrue(queue.isEmpty());

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void myQueueArrayEmptyTest() {
		final MyQueueArray queue = new MyQueueArray(SIZE);

		Assert.assertTrue("Expected empty queue", queue.isEmpty());
		queue.dequeue();
	}

	@Test
	public void myQueueArrayFullTest() {
		final MyQueueArray queue = new MyQueueArray(SIZE);

		for (int i = 0; i < SIZE; i++) {
			queue.enqueue(i);
		}

		for (int i = 0; i < SIZE; i++) {
			Assert.assertEquals(i, queue.dequeue());
		}
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void myQueueArrayFullTest2() {
		final MyQueueArray queue = new MyQueueArray(SIZE);

		for (int i = 0; i < SIZE; i++) {
			queue.enqueue(i);
		}

		queue.enqueue(0);
	}

}
