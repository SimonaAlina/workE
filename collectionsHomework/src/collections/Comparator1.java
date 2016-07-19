package collections;

import java.util.Comparator;

public class Comparator1 implements Comparator<Penguin> {

	@Override
	public int compare(Penguin p1, Penguin p2) {
		int result = p1.getRace().toString().compareTo(p2.getRace().toString());
		if(result == 0) {
			return p1.getAge() < p2.getAge() ? -1 : p1.getAge() == p2.getAge() ? 0 : 1;
		}
		return result;
	}

	
}
