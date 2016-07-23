package demo;

import java.io.File;
import numbers.PrimeNumbers;
import words.WordsPercentage;

/**
 *
 * @author Simona
 */
public class TestMain {

	public static int NR_THREADS;
	
	public static void main(String[] args) {

		NR_THREADS = Runtime.getRuntime().availableProcessors();

		// ex 1
		//NR_THREADS = 1;
		PrimeNumbers.processList(NR_THREADS);
		
		//ex 2
		//NR_THREADS = 2;
		File f = new File("D:/workspace/workE/concurrencyInJava_v2/file.txt");
		String wf = "D:/workspace/workE/concurrencyInJava_v2/output_file.txt";
		WordsPercentage.processFile(NR_THREADS, f, wf);
	}
}
