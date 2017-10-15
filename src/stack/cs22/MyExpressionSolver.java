package eg.edu.alexu.csd.datastructure.stack.cs22;

import java.util.ArrayList;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * @author Khaled Barie
 *
 */
public class MyExpressionSolver implements IExpressionEvaluator {

	@Override
	public String infixToPostfix(String expression) {
		if (expression == null) {
			throw new RuntimeException("Null String");
		}
		if (expression.length() == 0) {
			throw new RuntimeException("Empty String");
		}
		if (!validParentheses(expression)) {
			throw new RuntimeException("Invalid expression");
		}
		if (!validOperators(expression)) {
			throw new RuntimeException("Invalid expression");
		}

		StringBuilder inExpression = new StringBuilder();
		StringBuilder postExpression = new StringBuilder();
		MyStack operations = new MyStack();

		// remove all spaces and put space-free string in inExpression
		Scanner scn = new Scanner(expression);
		while (scn.hasNext()) {
			inExpression.append(scn.next());
		}
		scn.close();

		for (int i = 0; i < inExpression.length(); i++) {
			char ch = inExpression.charAt(i);

			if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
				postExpression.append(ch);
				continue;
			}
			switch (ch) {
			case '+':
			case '-':
				try {
					char top1 = (char) operations.peek();
					while (top1 == '-' || top1 == '+' 
							|| top1 == '*' || top1 == '/') {
						postExpression.append((char) operations.pop());
						top1 = (char) operations.peek();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				operations.push(ch);
				break;
			case '*':
			case '/':
				try {
					char top2 = (char) operations.peek();
					while (top2 == '*' || top2 == '/') {
						postExpression.append((char) operations.pop());
						top2 = (char) operations.peek();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				operations.push(ch);
				break;
			case '(':
				operations.push(ch);
				break;
			case ')':
				while ((char) operations.peek() != '(') {
					postExpression.append((char) operations.pop());
				}
				operations.pop();
				break;
			default:

			}
		}

		while (!operations.isEmpty()) {
			postExpression.append(operations.pop());
		}

		StringBuilder stringToReturn = new StringBuilder();

		int i = 0;
		for (i = 0; i < postExpression.length() - 1; i++) {
			stringToReturn.append(postExpression.charAt(i));
			stringToReturn.append(' ');
		}
		stringToReturn.append(postExpression.charAt(i));

		return stringToReturn.toString();
	}

	@Override
	public int evaluate(String expression) {
		if (expression == null) {
			throw new RuntimeException("Null String");
		}
		if (expression.length() == 0) {
			throw new RuntimeException("Empty String");
		}

		MyStack numStack = new MyStack();

		ArrayList<String> ops = new ArrayList<String>();

		Scanner scn = new Scanner(expression);
		while (scn.hasNext()) {
			ops.add(scn.next());
		}
		scn.close();

		for (int i = 0; i < ops.size(); i++) {

			char ch;
			try {
				int numToPush = Integer.parseInt(ops.get(i));
				numStack.push(numToPush);
				continue;
			} catch (NumberFormatException e) {
				ch = ops.get(i).charAt(0);
			}

			int num2 = (int) numStack.pop();
			int num1 = (int) numStack.pop();

			switch (ch) {
			case '+':
				numStack.push(num1 + num2);
				break;
			case '-':
				numStack.push(num1 - num2);
				break;
			case '*':
				numStack.push(num1 * num2);
				break;
			case '/':
				numStack.push(num1 / num2);
				break;
			default:
				throw new RuntimeException("Invalid operand found");
			}

		}

		if (numStack.size() == 1) {
			return (int) numStack.pop();
		} else {
			return 0;
		}
	}

	/**
	 * Validates parentheses in the string.
	 * 
	 * @param expression
	 *            string to be validated
	 */
	private boolean validParentheses(String expression) {
		MyStack parenStack = new MyStack();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(') {
				parenStack.push('(');
			} else if (ch == ')') {
				try {
					parenStack.pop();
				} catch (Exception e) {
					return false;
				}
			}
		}

		if (parenStack.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Validates that no two operators come in a 
	 * row and that no operators are
	 * at the beginning or the end of the string.
	 * 
	 * @param expression
	 *            string to be validated
	 */
	private boolean validOperators(String expression) {
		StringBuilder inExpression = new StringBuilder();
		Scanner scn = new Scanner(expression);

		while (scn.hasNext()) {
			inExpression.append(scn.next());
		}
		scn.close();

		ArrayList<Character> ops = new ArrayList<Character>();
		ops.add('/');
		ops.add('+');
		ops.add('-');
		ops.add('*');

		if (inExpression.length() == 0) {
			return false;
		}
		if (ops.contains(inExpression.charAt(0))) {
			return false;
		}
		if (ops.contains(inExpression.charAt(inExpression.length() - 1))) {
			return false;
		}

		for (int i = 0; i < inExpression.length() - 1; i++) {
			if (ops.contains(inExpression.charAt(i))) {
				if (ops.contains(inExpression.charAt(i + 1))) {
					return false;
				}
			}
		}
		return true;
	}

}
