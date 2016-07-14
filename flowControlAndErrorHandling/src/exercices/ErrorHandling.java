package exercices;

public class ErrorHandling {

	public void testErrorOutOfMemoryError() throws OutOfMemoryError {
		/*
		 * try { throw new OutOfMemoryError(); } catch(OutOfMemoryError e){
		 * System.out.println("Catch OutOfMemoryError"); }
		 */
		System.out.println("Method which throw OutOfMemoryError");
	}

	public void testStackOverflowError() throws StackOverflowError {
		System.out.println("Method which throw StackOverflowError");
	}
}
