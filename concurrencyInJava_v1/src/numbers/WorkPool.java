package numbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WorkPool {
	// nr total de thread-uri worker
	int nThreads;
	// nr de thread-uri worker care sunt blocate asteptand un task
	int nWaiting = 0;
	// daca s-a terminat complet rezolvarea problemei
	public boolean ready = false;

	LinkedList<PartialSolution> tasks = new LinkedList<PartialSolution>();

	List<Integer> result = new ArrayList<>();

	public WorkPool(int nThreads) {
		this.nThreads = nThreads;
	}

	public synchronized PartialSolution getWork() {
		if (tasks.size() == 0) {
			nWaiting++;
			if (nWaiting == nThreads) {
				ready = true;
				notifyAll();
				return null;
			} else {
				while (!ready && tasks.size() == 0) {
					try {
						this.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (ready)
					return null;
				nWaiting--;
			}
		}
		return tasks.remove();
	}

	public synchronized void putWork(PartialSolution sp) {
		System.out.println("WorkPool - adaugare task: " + sp);
		tasks.add(sp);
		this.notify();
	}

	synchronized void addPartialResult(List<Integer> res) {
		result.addAll(res);
	}

	public List<Integer> getResult() {
		return result;
	}

	public void setResult(List<Integer> result) {
		this.result = result;
	}
}