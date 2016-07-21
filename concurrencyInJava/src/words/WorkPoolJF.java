package words;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class WorkPoolJF {

	protected static int processingLength;

	public HashMap<String, Integer> computePercentage(File file) {
		int processors = Runtime.getRuntime().availableProcessors();
		
		long totalSize = file.length();
		Worker fb = new Worker(file, (long)0, totalSize);

		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(fb);
		
		//
		HashMap<String, Integer> hm = new HashMap<>();
		return hm;
	}
}
