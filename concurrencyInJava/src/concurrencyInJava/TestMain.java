package concurrencyInJava;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import numbers.PartialSolution;
import numbers.WorkPool;
import numbers.Worker;
import words.WorkPoolJF;

public class TestMain {

	static int len = 20000;
	static int chunck = 400;
	static int NT;
	static List<Integer> numbers;
	static List<Integer> result;

	public static void main(String[] args) {
		// create a list with random numbers
		Random r = new Random();
		numbers = new ArrayList<>();
		for (int i = 0; i < len; ++i) {
			numbers.add(r.nextInt(100));
		}
		// call workPool'method for execution actions -> return list
		NT = Runtime.getRuntime().availableProcessors();
		
		//primeNumbersWithThreads();
		//primeNumbersOneThread();
		percentageWords("");
	}

	public static void primeNumbersWithThreads() {
		int i;
		WorkPool wp = new WorkPool(NT);
		PartialSolution sol = null;
		Worker[] workers = new Worker[NT];

		long startTime = System.currentTimeMillis();
		for (i = 0; i + chunck < len; i += chunck) {
			sol = new PartialSolution(i, chunck, numbers);
			wp.putWork(sol);
		}
		if (i < len) {
			sol = new PartialSolution(i, len - i, numbers);
			wp.putWork(sol);
		}

		/* start workers */
		for (i = 0; i < NT; i++) {
			workers[i] = new Worker(wp);
			workers[i].start();
		}
		for (i = 0; i < NT; i++) {
			try {
				workers[i].join();
			} catch (InterruptedException ex) {
				Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		/* compute final list of prime numbers and print */
		result = wp.getResult();
		long endTime = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("Time: " + (endTime - startTime));
	}

	public static void primeNumbersOneThread() {
		int i, j;
		long startTime = System.currentTimeMillis();
		result = new ArrayList<>();
		for(i = 0; i < numbers.size(); ++i) {
			int nr = numbers.get(i);
			for(j = 2; j < Math.sqrt(nr); ++j)
				if(nr % j == 0)
					break;
			if(j >= Math.sqrt(nr))
				result.add(nr);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime));
	}

	public static void percentageWords(String fileName) {
		long startTime = System.currentTimeMillis();
		new WorkPoolJF().computePercentage(new File(fileName));
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time: " + (endTime - startTime));
	}
}
