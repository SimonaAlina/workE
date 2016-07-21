package words;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.RecursiveAction;

public class Worker extends RecursiveAction {

	private static final long serialVersionUID = 7670837473610420643L;

	private File file;
    private long mStart;
    private long mEnd;
    private HashMap<String, Integer> hm;
    
    

	public Worker(File f, long mStart, long mEnd) {
		super();
		this.file = f;
		this.mStart = mStart;
		this.mEnd = mEnd;
	}

	protected void computeDirectly() {
		
	}
	
	@Override
	protected void compute() {
		
	}

}
