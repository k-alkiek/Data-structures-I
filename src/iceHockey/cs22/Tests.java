package eg.edu.alexu.csd.datastructure.iceHockey.cs22;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.awt.Point;
import org.junit.Test;
import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/**
 * @author Khaled
 *
 */
public class Tests {

	MyPlayersFinder test = new MyPlayersFinder();

	@Test
	public void test1() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = new String[] { "33JUBU33", "3U3O4433", 
				"O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" };
		int team = 3;
		int threshold = 16;

		int[][] expected = { { 4, 5 }, { 13, 9 }, { 14, 2 } };
		Point[] result = iceHockey.findPlayers(photo, team, threshold);

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i][0], result[i].x);
			assertEquals(expected[i][1], result[i].y);
		}
		boolean found = false;
		if (expected.length == result.length) {
			found = true;
		}
		assertTrue("All points found", found);
	}

	@Test
	public void test2() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = new String[] { "44444H44S4", "K444K4L444", 
				"4LJ44T44XH", "444O4Vif 44", "44C4D4U444",
				"4V4Y4KB4M4", "G4W4HP4O4W", "4444ZDQ4S4", 
				"4BR4Y4A444", "4G4V4T4444" };
		int team = 4;
		int threshold = 16;

		int[][] expected = { { 3, 8 }, { 4, 16 }, { 5, 4 }, { 16, 3 }, 
				{ 16, 17 }, { 17, 9 } };
		Point[] result = iceHockey.findPlayers(photo, team, threshold);

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i][0], result[i].x);
			assertEquals(expected[i][1], result[i].y);
		}

		boolean found = false;
		if (expected.length == result.length) {
			found = true;
		}
		assertTrue("All points found", found);
	}

	@Test
	public void test3() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = new String[] { "8D88888J8L8E888", 
				"88NKMG8N8E8JI88", "888NS8EU88HN8EO", 
				"LUQ888A8TH8OIH8", "888QJ88R8SG88TY", 
				"88ZQV88B88OUZ8O", "FQ88WF8Q8GG88B8", 
				"8S888HGSB8FT8S8", "8MX88D88888T8K8", 
				"8S8A88MGVDG8XK8", "M88S8B8I8M88J8N", 
				"8W88X88ZT8KA8I8", "88SQGB8I8J88W88", 
				"U88H8NI8CZB88B8", "8PK8H8T8888TQR8" };
		int team = 8;
		int threshold = 9;

		int[][] expected = { { 1, 17 }, { 3, 3 }, { 3, 10 }, { 3, 25 }, 
				{ 5, 21 }, { 8, 17 }, { 9, 2 }, { 10, 9 }, 
				{ 12, 23 }, { 17, 16 }, { 18, 3 }, { 18, 11 }, { 18, 28 }, 
				{ 22, 20 }, { 23, 26 }, { 24, 15 }, 
				{ 27, 2 }, { 28, 26 }, { 29, 16 } };
		Point[] result = iceHockey.findPlayers(photo, team, threshold);

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i][0], result[i].x);
			assertEquals(expected[i][1], result[i].y);
		}

		boolean found = false;
		if (expected.length == result.length) {
			found = true;
		}
		assertTrue("All points found", found);
	}

	@Test
	public void test4() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = new String[] { "11111", "1AAA1", "1A1A1", 
				"1AAA1", "11111" };
		int team = 1;
		int threshold = 3;

		int[][] expected = { { 5, 5 }, { 5, 5 } };
		Point[] result = iceHockey.findPlayers(photo, team, threshold);

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i][0], result[i].x);
			assertEquals(expected[i][1], result[i].y);
		}
		boolean found = false;
		if (expected.length == result.length) {
			found = true;
		}
		assertTrue("All points found", found);
	}

	@Test
	public void testEmpty() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = new String[] { "11111", "1AAA1", "1A1A1", 
				"1AAA1", "11111" };
		int team = 2;
		int threshold = 3;

		int[][] expected = {};
		Point[] result = iceHockey.findPlayers(photo, team, threshold);

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i][0], result[i].x);
			assertEquals(expected[i][1], result[i].y);
		}
		boolean found = false;
		if (expected.length == result.length) {
			found = true;
		}
		assertTrue("All points found", found);
	}

}
