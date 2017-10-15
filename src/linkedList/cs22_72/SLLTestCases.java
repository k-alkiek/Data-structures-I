package eg.edu.alexu.csd.datastructure.linkedList.cs22_72;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for SLL.
 * @author A2HP11
 *
 */
public class SLLTestCases {

	/**
	 * A constant we are going to use a lot.
	 */
	private static final int TEN = 10;
	/**
	 * A constant we will use just once.
	 */
	private static final int NINETEEN = 19;
	/**
	 * A constant we will use a lot.
	 */
	private static final int NIGHTY_NINE = 99;
	/**
	 * A constant we will use a lot.
	 */
	private static final int FIVE = 5;

	/**
	 * Testing.
	 */
	@Test
	public void addByIndexTest() {
		final SinglyLinkedList slist = new SinglyLinkedList();
		for (int i = 0; i < TEN; i++) {
			slist.add(i, i);
		}
		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected " + i + ", found "
		+ slist.get(i), i, slist.get(i));
		}

		// check head and tail
		Assert.assertEquals(slist.getHead().getElement()
				, slist.get(0));
		Assert.assertEquals(slist.getTail().getElement()
				, slist.get(slist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void addTest() {
		final SinglyLinkedList slist = new SinglyLinkedList();
		for (int i = 0; i < TEN; i++) {
			slist.add(i);
		}
		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected " + i + ", found "
		+ slist.get(i), i, slist.get(i));
		}

		// check head and tail
		Assert.assertEquals(slist.getHead().getElement()
				, slist.get(0));
		Assert.assertEquals(slist.getTail().getElement()
				, slist.get(slist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void buildArrayTest() {
		final DoublyLinkedList dlist = new DoublyLinkedList();

		for (int i = 0; i < TEN; i++) {
			dlist.add(i);
		}
		final Object[] arr = {0, 1, 2, 3, 4, FIVE, 6, 7, 8, 9};
		Assert.assertArrayEquals(arr, dlist.buildArray());

	}

	/**
	 * Testing.
	 */
	@Test
	public void clearTest() {
		final SinglyLinkedList slist = new SinglyLinkedList();
		// fill the list with arbitrary values
		for (int i = 0; i < TEN; i++) {
			slist.add(FIVE * i + 1);
		}
		// clear
		slist.clear();
		// add 1,2,3,..
		for (int i = 0; i < TEN; i++) {
			slist.add(i);
		}
		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected " + i
					+ ", found "
					+ slist.get(i), i, slist.get(i));
		}

		// check head and tail
		Assert.assertEquals(slist.getHead().getElement()
				, slist.get(0));
		Assert.assertEquals(slist.getTail().getElement()
				, slist.get(slist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void containsTest() {
		final SinglyLinkedList slist =
				new SinglyLinkedList();
		final int x = NIGHTY_NINE;

		Assert.assertFalse(slist.contains(x));
		for (int i = 0; i < TEN; i++) {
			slist.add(i);
		}
		Assert.assertFalse(slist.contains(x));
		final int five = FIVE;
		slist.add(five, x);
		Assert.assertTrue(slist.contains(x));
		slist.add(slist.size(), NIGHTY_NINE);
		Assert.assertTrue(slist.contains(x));
		slist.remove(FIVE);
		Assert.assertTrue(slist.contains(x));
		slist.remove(slist.size() - 1);
		Assert.assertFalse(slist.contains(x));

		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected "
			+ i + ", found "
			+ slist.get(i), i, slist.get(i));
		}

		// check head and tail
		Assert.assertEquals(slist.getHead().getElement()
				, slist.get(0));
		Assert.assertEquals(slist.getTail().getElement()
				, slist.get(slist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void removeHeadTest() {
		final SinglyLinkedList slist = new SinglyLinkedList();
		// fill the list 0,0,1,1,2,2,3,3...
		for (int i = 0; i < TEN; i++) {
			slist.add(i);
		}
		slist.remove(0);
		final int three = 3;
		Assert.assertEquals(slist.getHead().getElement(), 1);
		Assert.assertEquals(1, slist.get(0));
		Assert.assertEquals(2, slist.get(1));
		Assert.assertEquals(three, slist.get(2));
	}

	/**
	 * Testing.
	 */
	@Test
	public void removeTest() {
		final SinglyLinkedList slist = new SinglyLinkedList();
		// fill the list 0,0,1,1,2,2,3,3...
		for (int i = 0; i < TEN; i++) {
			slist.add(i);
			slist.add(i);
		}
		for (int i = NINETEEN; i >= 0; i--) {
			// remove even elements
			if (i % 2 == 0) {
				slist.remove(i);
			}
		}

		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected " + i
					+ ", found "
					+ slist.get(i), i, slist.get(i));
		}

		// check head and tail
		Assert.assertEquals(slist.getHead().getElement()
				, slist.get(0));
		Assert.assertEquals(slist.getTail().getElement()
				, slist.get(slist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void setTest() {
		final SinglyLinkedList slist = new SinglyLinkedList();

		// fill the list with arbitrary values
		for (int i = 0; i < TEN; i++) {
			slist.add(FIVE * i + 1);
		}
		// set list elements to 1,2,3,..
		for (int i = 0; i < TEN; i++) {
			slist.set(i, i);
		}
		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected " + i
					+ ", found "
					+ slist.get(i), i, slist.get(i));
		}

		// check head and tail
		Assert.assertEquals(slist.getHead().getElement()
				, slist.get(0));
		Assert.assertEquals(slist.getTail().getElement()
				, slist.get(slist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void sublistTest() {
		final SinglyLinkedList slist = new SinglyLinkedList();

		for (int i = 0; i < TEN; i++) {
			slist.add(i);
		}
		final SinglyLinkedList sublist =
				(SinglyLinkedList) slist.sublist(2, 7);
		final int eight = 8;
		for (int i = 2; i < eight; i++) {
			Assert.assertEquals("expected "
		+ i + ", found "
		+ sublist.get(i - 2), i, sublist.get(i - 2));
		}

		// check head and tail
		Assert.assertEquals(sublist.getHead().getElement()
				, sublist.get(0));
		Assert.assertEquals(sublist.getTail().getElement()
				, sublist.get(sublist.size() - 1));
		Assert.assertNull(sublist.getTail().getNext());
	}

}
