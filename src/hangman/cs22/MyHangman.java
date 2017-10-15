package eg.edu.alexu.csd.datastructure.hangman.cs22;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
import java.util.Random;

/**
 * @author Khaled
 *
 */

public class MyHangman implements IHangman {
	/**
	 * @param words
	 *
	 */
	private String[] words;
	private String secretWord;
	private String displayWord = new String();
	private Integer wrongGuesses = new Integer(0);
	private Integer maxWrongGuesses;

	@Override
	public void setDictionary(final String[] pWords) {
		this.words = pWords;
	}

	private void setSecretWord(String pSecretWord) {
		this.secretWord = pSecretWord;
	}

	private void setDisplayWord(String pDisplayWord) {
		this.displayWord = pDisplayWord;
	}

	@Override
	public String selectRandomSecretWord() {
		try {
			Random rand = new Random();

			int secretWordIndex;
			if (words.length > 0) {
				secretWordIndex = rand.nextInt(words.length);
				String secretWordToSet = new String(words[secretWordIndex]);
				setSecretWord(secretWordToSet);
			} else {
				secretWord = null;
			}

		} catch (NullPointerException e) {
			secretWord = null;
		}

		if (secretWord != null) {
			setInitialDisplayWord();
		}
		return secretWord;
	}

	/**
	 * Initializes the display word
	 * with dashes.
	 */
	public void setInitialDisplayWord() {
		for (int i = 0; i < secretWord.length(); i++) {
			displayWord = new String(displayWord.concat("-"));
		}
	}

	private boolean charsEqual(char x, char y) {
		if (Character.toLowerCase(x) == Character.toLowerCase(y)) {
			return true;
		}
		return false;
	}

	private boolean charInSecretWord(Character c) {
		for (int i = 0; i < secretWord.length(); i++) {
			if (charsEqual(secretWord.charAt(i), c.charValue())) {
				return true;
			}
		}
		return false;
	}

	private String replaceChar(String str, int index, char replace) {
		if (str == null) {
			return str;
		} else if (index < 0 || index >= str.length()) {
			return str;
		}
		char[] chars = str.toCharArray();
		chars[index] = replace;
		return String.valueOf(chars);
	}

	private void replaceCharInDisplayWord(Character c) {
		for (int i = 0; i < secretWord.length(); i++) {

			if (charsEqual(secretWord.charAt(i), c.charValue())) {
				char charRep = secretWord.charAt(i);
				displayWord = replaceChar(displayWord, i, charRep);
			}
		}
	}

	@Override
	public String guess(Character c) {

		if (displayWord.equals(secretWord)) {
			return null;
		}

		if (c == null) {
			setDisplayWord(null);
			return displayWord;
		}

		if (charInSecretWord(c)) {
			replaceCharInDisplayWord(c);
		} else {
			wrongGuesses = new Integer(wrongGuesses.intValue() + 1);
		}
		if (wrongGuesses.intValue() >= maxWrongGuesses.intValue()) {
			setDisplayWord(null);
			return displayWord;
		}

		return displayWord;
	}

	public String getDisplayWord() {
		return displayWord;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if (max == null) {
			this.maxWrongGuesses = new Integer(0);
		} else {
			this.maxWrongGuesses = max;
		}
	}

}
