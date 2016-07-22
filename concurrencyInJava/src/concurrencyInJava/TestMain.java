package concurrencyInJava;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import numbers.PartialSolution;
import numbers.WorkPool;
import numbers.Worker;
import words.WorkPoolJF;

public class TestMain {

	static int listLen = 20000;
	static int chunckNr = 400;
	static int NT;
	static List<Integer> numbers;
	static List<Integer> primeNumbers;
	static Map<String, Double> percentage;

	public static void main(String[] args) {
		// create a list with random numbers
		Random r = new Random();
		numbers = new ArrayList<>();
		for (int i = 0; i < listLen; ++i) {
			numbers.add(r.nextInt(100));
		}
		// number of threads
		NT = Runtime.getRuntime().availableProcessors();
		
		//primeNumbersWithThreads();
		//primeNumbersOneThread();
		percentageWords("D:/workspace/workE/concurrencyInJava/file.txt");
	}

	public static void primeNumbersWithThreads() {
		int i;
		WorkPool wp = new WorkPool(NT);
		PartialSolution sol = null;
		Worker[] workers = new Worker[NT];

		long startTime = System.currentTimeMillis();
		for (i = 0; i + chunckNr < listLen; i += chunckNr) {
			sol = new PartialSolution(i, chunckNr, numbers);
			wp.putWork(sol);
		}
		if (i < listLen) {
			sol = new PartialSolution(i, listLen - i, numbers);
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
		primeNumbers = wp.getResult();
		long endTime = System.currentTimeMillis();
		System.out.println(primeNumbers);
		System.out.println("Time: " + (endTime - startTime));
	}

	public static void primeNumbersOneThread() {
		int i, j;
		long startTime = System.currentTimeMillis();
		primeNumbers = new ArrayList<>();
		for(i = 0; i < numbers.size(); ++i) {
			int nr = numbers.get(i);
			for(j = 2; j < Math.sqrt(nr); ++j)
				if(nr % j == 0)
					break;
			if(j >= Math.sqrt(nr))
				primeNumbers.add(nr);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime));
	}

	public static void percentageWords(String fileName) {
		percentage = new HashMap<>();
		WorkPoolJF.processingLength = 200;
		
		long startTime = System.currentTimeMillis();
		percentage = new WorkPoolJF().computePercentage(new File(fileName));
		long endTime = System.currentTimeMillis();
		
		//write into a file
		writeInFile("D:/workspace/workE/concurrencyInJava/output_file.txt", percentage);
		System.out.println("Time: " + (endTime - startTime) + "; Size: " + percentage.size());
		System.out.println(percentage);
	}
	
	public static void writeInFile(String filename, Map<String, Double> hm) {
		FileWriter f = null;
		PrintWriter file = null;
		StringBuffer output = new StringBuffer();
		String line = null;

		try {

			f = new FileWriter(filename);
			file = new PrintWriter(f);
			for(Map.Entry<String, Double> e : hm.entrySet()) {
				line = new String();
				line = line.concat(e.getKey());
				line = line.concat(";");

				double value = e.getValue();
				DecimalFormat df = new DecimalFormat("0.0000");
				DecimalFormatSymbols dfs = new DecimalFormatSymbols();
				dfs.setDecimalSeparator(',');
				df.setDecimalFormatSymbols(dfs);
				df.setRoundingMode(RoundingMode.DOWN);
				line = line.concat(df.format(value) + "\n");

				output = output.insert(0, line);
			}
			file.print(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
		file.close();
	}
}
