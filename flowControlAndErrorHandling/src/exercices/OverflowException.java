package exercices;

/*
* extends RuntimeException -> unchecked; (--runtime)
* extends Exception -> checked; (---compiler)
*/
public class OverflowException extends Exception {
	private static final long serialVersionUID = 1L;

	public OverflowException() {
		super();
	}

	public OverflowException(String s) {
		super(s);
	}
}
