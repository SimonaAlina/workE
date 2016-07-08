import java.util.Random;

public class RandomStringGenerator {

	private int length;
	private char[] alphabet;

	public RandomStringGenerator(int length, String alphabet) {
		this.length = length;
		this.alphabet = alphabet.toCharArray();
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public char[] getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(char[] alphabet) {
		this.alphabet = alphabet;
	}

	public String next() {
		Random generator = new Random();
		char[] randString = new char[length];
		for (int i = 0; i < length; i++) {
			randString[i] = alphabet[generator.nextInt(alphabet.length)];
		}
		return new String(randString);
	}
}
