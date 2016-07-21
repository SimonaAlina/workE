package numbers;

import java.util.List;

public class PartialSolution {
	int start;
	int size;
	List<Integer> numbers;
	// List <Integer> primeNumebers;

	public PartialSolution(int start, int size, List<Integer> numbers) {
		this.start = start;
		this.size = size;
		this.numbers = numbers;
	}

	public String toString() {
		return numbers.subList(start, start + size).toString();
	}
}