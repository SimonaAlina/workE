package exercices;

import java.util.List;

public class Calculator {

	public Integer add(Integer a, Integer b) {
		Integer sum = 0;
		try {
			sum = new Integer(a + b);
			if (sum >= Integer.MAX_VALUE)
				throw new OverflowException("OverflowException");
			if(sum <= Integer.MIN_VALUE)
				throw new UnderflowException("UnderflowException");
		} catch (OverflowException ex) {
			System.out.println("catch OverflowException");
		} catch(UnderflowException ex) {
			System.out.println("catch UnderflowException");
		}
		return sum;
	}

	public Integer divide(Integer a, Integer b) {
		if(b == 0)
			throw new IllegalArgumentException("Argument 'divisor' is 0");
		return new Integer(a / b);
	}

	public Integer average(List<Integer> lst) throws OverflowException {
		Integer sum = new Integer(0);
		for (Integer in : lst) {
			sum = this.add(sum, in);
		}
		return this.divide(sum, lst.size());
	}

	public void testFinally() {
		int[] v = new int[10];
		int i = 10;
		try {
			System.out.println("try access v[10], then return");
			v[i] = 5;
			return;
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("catch error");
		} finally {
			System.out.println("execute finally block");
		}
		System.out.println("After try-catch-finally");
	}
}

/*
 * extends RuntimeException -> unchecked;
 * extends Exception -> checked
 */
class OverflowException extends Exception {
	private static final long serialVersionUID = 1L;

	public OverflowException() {
		super();
	}

	public OverflowException(String s) {
		super(s);
	}
}

class UnderflowException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnderflowException() {
		super();
	}

	public UnderflowException(String s) {
		super(s);
	}
}