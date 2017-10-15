package eg.edu.alexu.csd.datastructure.hangman.cs22;

import java.util.Scanner;

/**
 * @author Khaled
 *
 */
public class Test {
	/**
	 * @param args
	 *
	 */
	public static void main(final String[] args) {

		final int maxGuesses = 3;
		MyHangman game = new MyHangman();
		String[] words = new String[] { "EGYPT" };
		game.setDictionary(words);
		game.setMaxWrongGuesses(new Integer(maxGuesses));
		// String ans = game.selectRandomSecretWord();
		Scanner reader = new Scanner(System.in);
		char c;
		System.out.println(game.getDisplayWord());

		while (true) {
			c = reader.next().charAt(0);
			System.out.println(game.guess(new Character(c)));
		}

	}

}
