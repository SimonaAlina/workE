package exercices;

import java.util.List;

public class Calculator {

	public Integer add(Integer a, Integer b) {
		Integer sum = 0;
		try {
			sum = new Integer(a + b);
		} catch (RuntimeException ex) {

		}
		return sum;
	}

	public Integer divide(Integer a, Integer b) {
		return new Integer(a / b);
	}

	public Integer average(List<Integer> lst) {
		Integer sum = new Integer(0);
		for (Integer in : lst) {
			sum = this.add(sum, in);
		}
		return this.divide(sum, lst.size());
	}

	public void testFinally() {
		int [] v = new int[10];
		int i = 10;
		try {
			System.out.println("try access v[10], then return");
			v[i] = 5;
			return;
		} catch(IndexOutOfBoundsException ex) {
			System.out.println("catch error");
		} finally{
			System.out.println("execute finally block");
		}
		System.out.println("After try-catch-finally");
	}
}
