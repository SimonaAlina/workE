package exercices;

public class ErrorHandling {

	public void testErrorOutOfMemoryError() {
		final int SIZE = 2 * 1024 * 1024 * 256;
		int[] v = new int[SIZE];
			for (int i = 0; i < v.length; ++i)
				v[i] = 10;
		System.out.println("In method which throw OutOfMemoryError");
	}

	public void testStackOverflowError() {
		testStackOverflowError();
		System.out.println("In method which throw StackOverflowError");
	}
}
