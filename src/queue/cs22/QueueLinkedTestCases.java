package eg.edu.alexu.csd.datastructure.queue.cs22;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Khaled
 *
 */
public class QueueLinkedTestCases {

	static final int SIZE = 10;
	static final int LARGE = 1000;

	@Test
	public void myQueueLinkedTest() {
		final MyQueueLinked queue = new MyQueueLinked();

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

	@Test(expected = Exception.class)
	public void myQueueLinkedEmptyTest() {
		final MyQueueLinked queue = new MyQueueLinked();

		Assert.assertTrue("Expected empty queue", queue.isEmpty());
		queue.dequeue();
	}

	@Test
	public void myQueueLinkedSmallTest() {
		final MyQueueLinked queue = new MyQueueLinked();

		for (int i = 0; i < SIZE; i++) {
			queue.enqueue(i);
		}

		for (int i = 0; i < SIZE; i++) {
			Assert.assertEquals(i, queue.dequeue());
		}
	}

	@Test
	public void myQueueLinkedLargeTest() {
		final MyQueueLinked queue = new MyQueueLinked();

		for (int i = 0; i < LARGE; i++) {
			queue.enqueue(i);
		}

		for (int i = 0; i < LARGE; i++) {
			Assert.assertEquals(i, queue.dequeue());
		}
	}

}
