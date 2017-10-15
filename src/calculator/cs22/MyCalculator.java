package eg.edu.alexu.csd.datastructure.calculator.cs22;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**
 * @author Khaled
 *
 */
public class MyCalculator implements ICalculator {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public float divide(int x, int y) {
		return (float) x / y;
	}

}
