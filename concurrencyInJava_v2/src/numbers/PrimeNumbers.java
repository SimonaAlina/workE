package numbers;

import demo.TestMain;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simona
 */
public class PrimeNumbers {

	public static int chunk;
	public static int listLen;
	public static List<Integer> numbers;
	public static List<Integer> primeNumbers;

	public static void processList(int NR_THREADS) {
		listLen = 100000;
		chunk = listLen / NR_THREADS;

		Random r = new Random();
		numbers = new ArrayList<>();
		for(int i = 0; i < listLen; ++i) {
			numbers.add(r.nextInt(100) + 1);
		}
		
		long startTime = System.currentTimeMillis();
		int start = 0;
		primeNumbers = new ArrayList<>();
		Worker[] wk = new Worker[NR_THREADS];
		for(int i = 0; i < NR_THREADS; ++i) {
			wk[i] = new Worker(start, start + chunk, numbers);
			wk[i].start();
			start += chunk;
		}
		for(int i = 0; i < NR_THREADS; ++i) {
			try {
				wk[i].join();
			} catch (InterruptedException ex) {
				Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		long endTime = System.currentTimeMillis();
		
		//System.out.println(primeNumbers.size() + " prime elements: " + primeNumbers);
		System.out.println("[Prime Elements] Time:" + (endTime - startTime) + " with " + NR_THREADS + " thread(s)");
	}

	public static void addPrimeNumber(int nr) {
		synchronized(primeNumbers) {
			primeNumbers.add(nr);
		}
	}
}
