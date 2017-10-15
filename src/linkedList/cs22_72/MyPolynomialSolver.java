package eg.edu.alexu.csd.datastructure.linkedList.cs22_72;

import java.util.HashMap;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 * Polynomial solver.
 * @author A2HP11
 *
 */
public class MyPolynomialSolver implements IPolynomialSolver {

	/**
	 * Hashmap containing the lists corresponding to characters.
	 */
	HashMap<Character, DoublyLinkedList> polynomials =
			new HashMap<Character, DoublyLinkedList>();

	/**
	 * Constructor.
	 */
	public MyPolynomialSolver() {
		polynomials.put('A', null);
		polynomials.put('B', null);
		polynomials.put('C', null);
		polynomials.put('R', null);
	}

	@Override
	public int[][] add(final char poly1, final char poly2) {
		if (!isValidChar(poly1) || !isValidChar(poly2)) {
			throw new RuntimeException("Invalid"
					+ "polynomial variable.");
		}

		final DoublyLinkedList polyOne = polynomials.get(poly1);
		final DoublyLinkedList polyTwo = polynomials.get(poly2);

		if (polyOne == null || polyTwo == null) {
			throw new RuntimeException("Invalid"
					+ "polynomial variable.");
		}

		final DoublyLinkedList polyAns =
				auxAdd(polyOne, polyTwo);

		final int[][] arrayToReturn = new int[polyAns.size()][2];

		for (int i = 0; i < polyAns.size(); i++) {
			final PolyTerm term = (PolyTerm) polyAns.get(i);
			arrayToReturn[i][0] = term.getCoeff();
			arrayToReturn[i][1] = term.getExponent();
		}

		clearPolynomial('R');
		setPolynomial('R', arrayToReturn);
		return arrayToReturn;
	}

	/**.
	 * Takes 2 linked list polynomials and returns
	 * a linked list of their sum
	 * used as an auxiliary function for the add,
	 * subtract and multiply methods
	 *
	 * @param polyOne
	 *            reference to the first polynomial
	 * @param polyTwo
	 *            reference to the second polynomial
	 * @return a DLL add.
	 */
	private DoublyLinkedList auxAdd(final DoublyLinkedList polyOne,
			final DoublyLinkedList polyTwo) {

		if (polyOne == null || polyTwo == null) {
			throw new RuntimeException("Invalid"
					+ "Polynomial Variable");
		}

		final DoublyLinkedList polyAns = new DoublyLinkedList();

		int i = 0;
		int j = 0;
		while (i < polyOne.size() && j < polyTwo.size()) {
			final PolyTerm term1 = (PolyTerm) polyOne.get(i);
			final PolyTerm term2 = (PolyTerm) polyTwo.get(j);

			final PolyTerm termToAdd = new PolyTerm(0, 0);

			if (term1.getExponent() > term2.getExponent()) {
				termToAdd.setCoeff(term1.getCoeff());
				termToAdd.setExponent(term1.getExponent());
				polyAns.add(termToAdd);
				i++;
			} else if (term1.getExponent() < term2.getExponent()) {
				termToAdd.setCoeff(term2.getCoeff());
				termToAdd.setExponent(term2.getExponent());
				polyAns.add(termToAdd);
				j++;
			} else {
				if (term1.getCoeff() + term2.getCoeff() == 0) {
					i++;
					j++;
					// they cancel each other
					// so we just skip them
				} else {
					termToAdd.setCoeff(term1.getCoeff()
							+ term2.getCoeff());
				termToAdd.setExponent(term1.getExponent());
					polyAns.add(termToAdd);
					i++;
					j++;
				}
			}
		}

		while (i < polyOne.size()) {
			final PolyTerm termToAdd = new PolyTerm(0, 0);
			final PolyTerm term1 =
					(PolyTerm) polyOne.get(i);
			termToAdd.setCoeff(term1.getCoeff());
			termToAdd.setExponent(
					term1.getExponent());
			polyAns.add(termToAdd);
			i++;
		}
		while (j < polyTwo.size()) {
			final PolyTerm termToAdd = new PolyTerm(0, 0);
			final PolyTerm term2 =
					(PolyTerm) polyTwo.get(j);
			termToAdd.setCoeff(term2.getCoeff());
			termToAdd.setExponent(term2.getExponent());
			polyAns.add(termToAdd);
			j++;
		}

		return polyAns;
	}

	@Override
	public void clearPolynomial(final char poly) {
		if (!isValidCharOrR(poly)) {
			throw new RuntimeException("Invalid"
					+ "polynomial variable.");
		}

		polynomials.put(poly, null);

	}

	@Override
	public float evaluatePolynomial(final char poly
			, final float value) {
		if (!isValidCharOrR(poly)) {
			throw new RuntimeException("Invalid"
					+ "polynomial variable.");
		}

		final DoublyLinkedList polynomial =
				polynomials.get(poly);
		final Object[] polyArray =
				polynomial.buildArray();

		float result = 0;

		for (final Object element : polyArray) {
			final PolyTerm polyTerm =
					(PolyTerm) element;
			final int coeff = polyTerm.getCoeff();
			final int exponent =
					polyTerm.getExponent();
			result += coeff * Math.pow(value, exponent);
		}

		return result;
	}

	/**
	 * Checks whether the character is valid.
	 * @param c input character.
	 * @return true if it is valid and false otherwise.
	 */
	private boolean isValidChar(final char c) {
		if (c == 'A' || c == 'B' || c == 'C') {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the character is valid.
	 * A/B/C/R.
	 * @param c	input character.
	 * @return	true if it is valid and false otherwise.
	 */
	private boolean isValidCharOrR(final char c) {
		if (c == 'A' || c == 'B' || c == 'C' || c == 'R') {
			return true;
		}
		return false;
	}

	@Override
	public int[][] multiply(final char poly1, final char poly2) {
		if (!isValidChar(poly1) || !isValidChar(poly2)) {
			throw new RuntimeException("Invalid"
					+ "Polynomial Variable");
		}

		final DoublyLinkedList polyOne =
				polynomials.get(poly1);
		final DoublyLinkedList polyTwo =
				polynomials.get(poly2);

		if (polyOne == null || polyTwo == null) {
			throw new RuntimeException("Invalid"
					+ "Polynomial Variable");
		}

		final DoublyLinkedList[] polys =
				new DoublyLinkedList[polyOne.size()];

		for (int i = 0; i < polyOne.size(); i++) {
			final PolyTerm polyOneTerm =
					(PolyTerm) polyOne.get(i);
			final DoublyLinkedList poly =
					new DoublyLinkedList();

			for (int j = 0; j < polyTwo.size(); j++) {
				final PolyTerm polyTwoTerm =
						(PolyTerm) polyTwo.get(j);

				final int newCoeff =
						polyOneTerm.getCoeff()
						* polyTwoTerm.getCoeff();
				final int newExp =
						polyOneTerm.getExponent()
						+ polyTwoTerm.getExponent();
				final PolyTerm termToAdd =
						new PolyTerm(newCoeff, newExp);
				poly.add(termToAdd);
			}

			polys[i] = poly;
		}

		DoublyLinkedList polyAns =
				new DoublyLinkedList();

		if (polyOne.size() == 1) {
			polyAns = polys[0];
		} else {
			polyAns = auxAdd(polys[0], polys[1]);
			for (int i = 2; i < polyOne.size(); i++) {
				polyAns = auxAdd(polyAns, polys[i]);
			}
		}

		final int[][] arrayToReturn =
				new int[polyAns.size()][2];

		for (int i = 0; i < polyAns.size(); i++) {
			final PolyTerm term = (PolyTerm) polyAns.get(i);
			arrayToReturn[i][0] = term.getCoeff();
			arrayToReturn[i][1] = term.getExponent();
		}

		clearPolynomial('R');
		setPolynomial('R', arrayToReturn);
		return arrayToReturn;
	}

	@Override
	public String print(final char poly) {
		if (!isValidCharOrR(poly)) {
			throw new RuntimeException("Invalid"
					+ "Polynomial variable.");
		}

		final DoublyLinkedList polynomial =
				polynomials.get(poly);

		if (polynomial == null) {
			return null;
		}

		final StringBuilder polyString = new StringBuilder();

		for (int i = 0; i < polynomial.size(); i++) {
			final PolyTerm polyTerm =
					(PolyTerm) polynomial.get(i);
			final int coeff = polyTerm.getCoeff();
			final int exponent = polyTerm.getExponent();

			if (coeff < 0) { // if coeff is negative
				polyString.append('-');
			} else {
				if (i != 0) { // don't type '+'
					// if it is the first term
					polyString.append('+');
				}
			}

			if (Math.abs(coeff) != 1) {
				polyString.append(Math.abs(coeff));
			}

			if (exponent != 0) {
				polyString.append("x");
				if (exponent > 1) {
					polyString.append("^" + exponent);
				}
			}

		}
		return polyString.toString();
	}

	@Override
	public void setPolynomial(final char poly
			, final int[][] terms) {
		if (!isValidCharOrR(poly)) {
			throw new RuntimeException("Invalid"
					+ "polynomial variable.");
		}

		// DoublyLinkedList polynomial = polynomials.get(poly);
		if (polynomials.get(poly) != null) {
			throw new RuntimeException("Polynomial not empty."
					+ "Clear it first.");
		}
		if (terms == null) {
			throw new RuntimeException("Invalid"
					+ "polynomial terms.");
		}

		final DoublyLinkedList polynomial =
				new DoublyLinkedList();

		for (int i = 0; i < terms.length - 1; i++) {
			final int exp1 = terms[i][1];
			final int exp2 = terms[i + 1][1];
			if (exp1 <= exp2) {
				throw new RuntimeException("Invalid"
						+ "polynomial term order.");
			}
		}

		for (final int[] term : terms) {
			final int coeff = term[0];
			final int exponent = term[1];

			if (exponent < 0) {
				throw new RuntimeException("Exponents"
						+ " cannot be negative.");
			}

			final PolyTerm polyTerm =
					new PolyTerm(coeff, exponent);
			polynomial.add(polyTerm);
		}

		polynomials.put(poly, polynomial);
	}

	@Override
	public int[][] subtract(final char poly1, final char poly2) {
		if (!isValidChar(poly1) || !isValidChar(poly2)) {
			throw new RuntimeException("Invalid"
					+ "polynomial variable.");
		}

		final DoublyLinkedList polyOne =
				polynomials.get(poly1);
		final DoublyLinkedList polyTwoRef =
				polynomials.get(poly2);

		if (polyOne == null || polyTwoRef == null) {
			throw new RuntimeException("Invalid"
					+ "polynomial variable.");
		}

		// We're manipulating polyTwo by multiplying it with -1
		// we need
		// to clone it
		final DoublyLinkedList polyTwo = new DoublyLinkedList();
		for (int i = 0; i < polyTwoRef.size(); i++) {
			final PolyTerm oldTerm = (PolyTerm) polyTwoRef.get(i);
			final PolyTerm newTerm =
					new PolyTerm(oldTerm.getCoeff()
					, oldTerm.getExponent());
			polyTwo.add(newTerm);
		}

		// same as adding two polynomials
		// but inverting the sign of the second
		// polynomial
		for (int i = 0; i < polyTwo.size(); i++) {
			final PolyTerm term = (PolyTerm) polyTwo.get(i);
			term.setCoeff(0 - term.getCoeff());
		}

		final DoublyLinkedList polyAns =
				auxAdd(polyOne, polyTwo);

		int[][] arrayToReturn = new int[polyAns.size()][2];

		for (int i = 0; i < polyAns.size(); i++) {
			final PolyTerm term = (PolyTerm) polyAns.get(i);
			arrayToReturn[i][0] = term.getCoeff();
			arrayToReturn[i][1] = term.getExponent();
		}

		clearPolynomial('R');
		if (arrayToReturn.length == 0) {
			arrayToReturn = new int[][] {{0, 0}};
		}
		setPolynomial('R', arrayToReturn);
		return arrayToReturn;

	}

}
