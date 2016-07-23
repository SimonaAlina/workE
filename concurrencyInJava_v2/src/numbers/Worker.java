package numbers;

import java.util.List;

/**
 *
 * @author Simona
 */
public class Worker extends Thread {

	protected int start;
	protected int end;
	protected List<Integer> numbers;

	public Worker(int s, int e, List<Integer> nr) {
		this.start = s;
		this.end = e;
		this.numbers = nr;
	}

	@Override
	public void run() {
		for(int i = start; i < end; i++) {
			int nr = numbers.get(i);
			if(isPrime(nr)) {
				PrimeNumbers.addPrimeNumber(nr);
			}
		}
	}

	boolean isPrime(int n) {
		if(n == 1)
			return false;
		if(n == 2) 
			return true;
		for(int i = 2; i <= Math.sqrt(n); ++i) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
