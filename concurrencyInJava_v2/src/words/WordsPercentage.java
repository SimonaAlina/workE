package words;

import demo.TestMain;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simona
 */
public class WordsPercentage {

	public static long chunk;
	public static HashMap<String, Integer> res;
	public static HashMap<String, Double> percentage;

	public static void processFile(int NR_THREADS, File readFile, String writeFile) {
		int i;
		long totalSize = readFile.length();
		chunk = totalSize / NR_THREADS;
		res = new HashMap<>();

		long startTime = System.currentTimeMillis();

		long start = 0;
		Worker[] wk = new Worker[NR_THREADS];
		for(i = 0; i < NR_THREADS - 1; ++i) {
			wk[i] = new Worker(readFile, start, start + chunk);
			wk[i].start();
			start += chunk;
		}
		wk[i] = new Worker(readFile, start, totalSize);
		wk[i].start();
		for(i = 0; i < NR_THREADS; ++i) {
			try {
				wk[i].join();
			} catch (InterruptedException ex) {
				Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		long endTime = System.currentTimeMillis();

		System.out.println("[Words Frequency]Time:" + (endTime - startTime) + " with " + NR_THREADS + " thread(s)");

		double nrWords = 0;
		for(Integer value : res.values()) {
			nrWords += value;
		}
		percentage = new HashMap<>();
		for(Map.Entry<String, Integer> e : res.entrySet()) {
			percentage.put(e.getKey(), e.getValue() * 100 / nrWords);
		}
		writeInFile(writeFile, percentage);
	}

	public static void addPartialResult(HashMap<String, Integer> map) {
		synchronized(res) {
			map.entrySet().stream().forEach((e) -> {
				if(!res.containsKey(e.getKey())) {
					res.put(e.getKey(), e.getValue());
				} else {
					res.put(e.getKey(), e.getValue() + res.get(e.getKey()));
				}
			});
		}
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
		}
		file.close();
	}
}
