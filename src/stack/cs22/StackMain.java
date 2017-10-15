package eg.edu.alexu.csd.datastructure.stack.cs22;

import java.util.Scanner;

/**
 * @author Khaled
 *
 */
public class StackMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner mainMenunput = new Scanner(System.in);
		int mainMenuChoice = 0;
		boolean running = true;
		
		MyStack stack = new MyStack();
		
		while (running) {
			System.out.println("Please choose an action.");
			System.out.println("------------------------");
			System.out.println("1- Push"
							+ "\n2- Pop"
							+ "\n3- Peek"
							+ "\n4- Get size"
							+ "\n5- Check if empty"
							+ "\n6- Exit.");
			try {
				mainMenuChoice = Integer.parseInt(mainMenunput.nextLine());
			} catch (NumberFormatException e) {
				mainMenuChoice = 0;
			}
			
			switch (mainMenuChoice) {
			case (1):
				stack.push(getInput());
				break;
			case (2):
				try {
					System.out.println("Popped " + stack.pop());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case (3):
				try {
					System.out.println("Top = " + stack.peek());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case (4):
				System.out.println("Size = " + stack.size());
				break;
			case (5):
				System.out.println(stack.isEmpty());
				break;
			case (6):
				running = false;
				break;
			default:
				System.out.println("Wrong main menu input.");
			}
		}
		System.out.println("\nThank you for using our app !");
		mainMenunput.close();

	}
	
	private static Object getInput() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number:");
		int num = input.nextInt();
		//input.close();
		return num;
	}

}
