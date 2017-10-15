package eg.edu.alexu.csd.datastructure.linkedList.cs22_72;

/**
 * Main class for polynomial solver for testing.
 * @author A2HP11
 *
 */
public class PolynomialMain {

	/**
	 * The main method.
	 * @param args argument for main.
	 */
	public static void main(final String[] args) {
		final MyPolynomialSolver app = new MyPolynomialSolver();
		final int[][] termsA = new int[][] {{1, 2}, {-2, 0}};
		app.setPolynomial('A', termsA);

		final int[][] termsB = new int[][] {{1, 2}, {2, 0}};
		app.setPolynomial('B', termsB);

		System.out.println(app.print('A'));
		// System.out.println(app.print('B'));

		app.subtract('A', 'A');
		System.out.println(app.print('R'));
		System.out.println(app.print('A'));

	}

}
