package words;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class WorkPoolJF {

	public static int processingLength;
	protected static HashMap<String, Integer> res;
	protected HashMap<String, Double> percentage;

	public HashMap<String, Double> computePercentage(File file) {
		res = new HashMap<>();
		percentage = new HashMap<>();
		long totalSize = file.length();

		Worker fb = new Worker(file, (long) 0, totalSize);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(fb);

		double nrWords = 0;
		for (Integer value : res.values()) {
		    nrWords += value;
		}
		for(Map.Entry<String, Integer> e : res.entrySet()){
			percentage.put(e.getKey(), e.getValue() * 100 / nrWords);
		}
		return percentage;
	}

	public synchronized static void addPartialResult(HashMap<String, Integer> map) {
		for(Map.Entry<String, Integer> e : map.entrySet())
			  if(!res.containsKey(e.getKey()))
			    res.put(e.getKey(), e.getValue());
			  else
				  res.put(e.getKey(), e.getValue() + res.get(e.getKey()));
	}
}
