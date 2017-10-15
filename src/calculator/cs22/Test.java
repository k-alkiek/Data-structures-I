package eg.edu.alexu.csd.datastructure.calculator.cs22;

import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**
 * @author Khaled
 *
 */
public class Test {	
	/**
	 * Main method.
	 * @param args main parameter.
	 */
	public static void main(final String[] args) {
		ICalculator calc = new MyCalculator();
		Scanner input = new Scanner(System.in);

		int x;
		int y;
		x = input.nextInt();
		y = input.nextInt();

		System.out.println(calc.add(x, y));
		System.out.println(calc.divide(x, y));

		input.close();
	}

}
