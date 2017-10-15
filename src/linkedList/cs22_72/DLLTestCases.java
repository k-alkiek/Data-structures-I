package eg.edu.alexu.csd.datastructure.linkedList.cs22_72;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for DLL.
 * @author H.
 *
 */
public class DLLTestCases {

	/**
	 * A constant we will use a lot.
	 */
	private static final int TEN = 10;
	/**
	 * A constant we will use a lot.
	 */
	private static final int FIVE = 5;
	/**
	 * A constant we will use a lot.
	 */
	private static final int NIGHTY_NINE = 99;
	/**
	 * A constant we will use just once.
	 */
	private static final int NINETEEN = 19;

	/**
	 * Testing.
	 */
	@Test
	public void addByIndexTest() {
		final DoublyLinkedList dlist = new DoublyLinkedList();
		for (int i = 0; i < TEN; i++) {
			dlist.add(i, i);
		}
		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected "
		+ i + ", found " + dlist.get(i), i, dlist.get(i));
		}

		// check head and tail
		Assert.assertEquals(dlist.getHead().getElement()
				, dlist.get(0));
		Assert.assertEquals(dlist.getTail().getElement()
				, dlist.get(dlist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void addTest() {
		final DoublyLinkedList dlist = new DoublyLinkedList();
		for (int i = 0; i < TEN; i++) {
			dlist.add(i);
		}
		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected "
		+ i + ", found "
		+ dlist.get(i), i, dlist.get(i));
		}

		// check head and tail
		Assert.assertEquals(dlist.getHead().getElement(),
				dlist.get(0));
		Assert.assertEquals(dlist.getTail().getElement(),
				dlist.get(dlist.size() - 1));
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
		final DoublyLinkedList dlist = new DoublyLinkedList();
		// fill the list with arbitrary values
		for (int i = 0; i < TEN; i++) {
			dlist.add(FIVE * i + 1);
		}
		// clear
		dlist.clear();
		// add 1,2,3,..
		for (int i = 0; i < TEN; i++) {
			dlist.add(i);
		}
		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected " + i + ", found "
		+ dlist.get(i), i, dlist.get(i));
		}

		// check head and tail
		Assert.assertEquals(dlist.getHead().getElement()
				, dlist.get(0));
		Assert.assertEquals(dlist.getTail().getElement()
				, dlist.get(dlist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void containsTest() {
		final DoublyLinkedList dlist = new DoublyLinkedList();
		final int x = NIGHTY_NINE;

		Assert.assertFalse(dlist.contains(x));
		for (int i = 0; i < TEN; i++) {
			dlist.add(i);
		}
		Assert.assertFalse(dlist.contains(x));

		dlist.add(FIVE, NIGHTY_NINE);
		Assert.assertTrue(dlist.contains(x));
		dlist.add(dlist.size(), x);
		Assert.assertTrue(dlist.contains(x));
		dlist.remove(FIVE);
		Assert.assertTrue(dlist.contains(x));
		dlist.remove(dlist.size() - 1);
		Assert.assertFalse(dlist.contains(x));

		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected " + i
					+ ", found "
		+ dlist.get(i), i, dlist.get(i));
		}

		// check head and tail
		Assert.assertEquals(dlist.getHead().getElement()
				, dlist.get(0));
		Assert.assertEquals(dlist.getTail().getElement(),
				dlist.get(dlist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void removeHeadTest() {
		final DoublyLinkedList dlist = new DoublyLinkedList();
		// fill the list 0,0,1,1,2,2,3,3...
		for (int i = 0; i < TEN; i++) {
			dlist.add(i);
		}
		dlist.remove(0);
		final int three = 3;
		Assert.assertEquals(dlist.getHead().getElement(), 1);
		Assert.assertEquals(1, dlist.get(0));
		Assert.assertEquals(2, dlist.get(1));
		Assert.assertEquals(three, dlist.get(2));
	}

	/**
	 * Testing.
	 */
	@Test
	public void removeTest() {
		final DoublyLinkedList dlist = new DoublyLinkedList();
		// fill the list 0,0,1,1,2,2,3,3...
		for (int i = 0; i < TEN; i++) {
			dlist.add(i);
			dlist.add(i);
		}
		for (int i = NINETEEN; i >= 0; i--) {
			// remove even elements
			if (i % 2 == 0) {
				dlist.remove(i);
			}
		}

		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected " + i + ", found "
		+ dlist.get(i), i, dlist.get(i));
		}

		// check head and tail
		Assert.assertEquals(dlist.getHead().getElement(),
				dlist.get(0));
		Assert.assertEquals(dlist.getTail().getElement(),
				dlist.get(dlist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void setTest() {
		final DoublyLinkedList dlist = new DoublyLinkedList();

		// fill the list with arbitrary values
		for (int i = 0; i < TEN; i++) {
			dlist.add(FIVE * i + 1);
		}
		// set list elements to 1,2,3,..
		for (int i = 0; i < TEN; i++) {
			dlist.set(i, i);
		}
		for (int i = 0; i < TEN; i++) {
			Assert.assertEquals("expected " + i + ", found "
		+ dlist.get(i), i, dlist.get(i));
		}

		// check head and tail
		Assert.assertEquals(dlist.getHead().getElement()
				, dlist.get(0));
		Assert.assertEquals(dlist.getTail().getElement()
				, dlist.get(dlist.size() - 1));
	}

	/**
	 * Testing.
	 */
	@Test
	public void sublistTest() {
		final DoublyLinkedList dlist = new DoublyLinkedList();

		for (int i = 0; i < TEN; i++) {
			dlist.add(i);
		}
		final DoublyLinkedList sublist =
				(DoublyLinkedList) dlist.sublist(2, 7);
		final int eight = 8;
		for (int i = 2; i < eight; i++) {
			Assert.assertEquals("expected " + i + ", found "
		+ sublist.get(i - 2), i, sublist.get(i - 2));
		}

		// check head and tail
		Assert.assertEquals(sublist.getHead().getElement(),
				sublist.get(0));
		Assert.assertEquals(sublist.getTail().getElement()
				, sublist.get(sublist.size() - 1));
		Assert.assertNull(sublist.getTail().getNext());
	}

}
