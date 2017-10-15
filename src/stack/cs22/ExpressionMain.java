package eg.edu.alexu.csd.datastructure.stack.cs22;

/**
 * @author Khaled
 *
 */
public class ExpressionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyExpressionSolver app = new MyExpressionSolver();
		String infix = app.infixToPostfix("(1 + 2) * 7");
		System.out.println(infix);
	}

}
