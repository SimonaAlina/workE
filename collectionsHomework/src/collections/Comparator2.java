package collections;

import java.util.Comparator;
import java.util.List;

public class Comparator2 implements Comparator<Penguin> {

	@Override
	public int compare(Penguin p1, Penguin p2) {
		int result1 = p1.getMatingPartners().size() - p2.getMatingPartners().size();
		int result2;
		if (result1 == 0) {
			double av1 = averageAge(p1.getMatingPartners());
			double av2 = averageAge(p2.getMatingPartners());
			result2 = av1 < av2 ? -1 : av1 == av2 ? 0 : 1;
			if (result2 == 0)
				return p1.getName().compareToIgnoreCase(p2.getName());
			else
				return result2;
		}
		return result1;
	}

	public double averageAge(List<Penguin> listPenguin) {
		double sum = 0;
		for(Penguin p : listPenguin)
			sum += p.getAge();
		return sum/listPenguin.size();
	}

}
