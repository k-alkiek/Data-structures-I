package eg.edu.alexu.csd.datastructure.linkedList.cs22_72;

/**
 * Polynomial term class.
 * @author A2HP11
 *
 */
public class PolyTerm implements Comparable<PolyTerm> {
	/**
	 * Coefficient of the term.
	 */
	private int coeff;
	/**
	 * Exponent of the term.
	 */
	private int exponent;

	/**
	 * Constructor.
	 * @param coeffIn input.
	 * @param exponentIn input.
	 */
	public PolyTerm(final int coeffIn, final int exponentIn) {
		if (exponent < 0) {
			throw new RuntimeException();
		}
		this.coeff = coeffIn;
		this.exponent = exponentIn;
	}

	@Override
	public int compareTo(final PolyTerm polyTerm) {
		if (exponent < polyTerm.exponent) {
			return 1;
		}
		if (exponent > polyTerm.exponent) {
			return -1;
		}
		if (exponent == polyTerm.exponent) {
			if (coeff < polyTerm.coeff) {
				return -1;
			}
			if (coeff > polyTerm.coeff) {
				return 1;
			}

		}
		return 0;
	}

	/**
	 * Getter.
	 * @return coefficient of the term.
	 */
	public int getCoeff() {
		return coeff;
	}

	/**
	 * Getter.
	 * @return exponent of the term.
	 */
	public int getExponent() {
		return exponent;
	}

	/**
	 * Setter.
	 * @param coeffI	input.
	 */
	public void setCoeff(final int coeffI) {
		this.coeff = coeffI;
	}

	/**
	 * Setter.
	 * @param exponentI	input.
	 */
	public void setExponent(final int exponentI) {
		this.exponent = exponentI;
	}

}
