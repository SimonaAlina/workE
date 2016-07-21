package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Thread worker class
 */
public class Worker extends Thread {
	WorkPool wp;

	public Worker(WorkPool workpool) {
		this.wp = workpool;
	}

	boolean isPrime(Integer nr) {
		if (nr == 2)
			return true;
		for (int i = 2; i < Math.sqrt(nr); i++)
			if (nr % i == 0)
				return false;
		return true;
	}

	void processPartialSolution(PartialSolution ps) {
		int start = ps.start;
		int end = start + ps.size;
		List<Integer> res = new ArrayList<>();
		for (int i = start; i < end; ++i) {
			int nr = ps.numbers.get(i);
			if (isPrime(nr))
				res.add(nr);
		}
		wp.addPartialResult(res);
	}

	public void run() {
		System.out.println("Thread-ul worker " + this.getName() + " a pornit...");
		while (true) {
			PartialSolution ps = wp.getWork();
			if (ps == null)
				break;
			processPartialSolution(ps);
		}
		System.out.println("Thread-ul worker " + this.getName() + " s-a terminat...");
	}
}