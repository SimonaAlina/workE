package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class PenguinFun {

	public static void main(String[] args) {
		/*
		 * Task 1: list + hashSet
		 */
		PenguinHatchery generatePenguin = new PenguinHatchery();

		List<Penguin> penguinList = new ArrayList<>();
		for (int i = 0; i < 20; ++i) {
			penguinList.add(generatePenguin.hatchPenguin());
		}
		System.out.println("List: -------------------------");
		for (Penguin peng : penguinList) {
			System.out.println(peng.toString());
		}
		System.out.println("\nHashSet: -------------------------");
		Set<Penguin> penguinHashSet = new HashSet<>();
		for (int i = 0; i < 20; ++i) {
			penguinHashSet.add(generatePenguin.hatchPenguin());
		}
		for (Penguin peng : penguinHashSet) {
			System.out.println(peng.toString());
		}

		/*
		 * Task 2: sort
		 */
		System.out.println("\nSorted: -------------------------");
		Collections.sort(penguinList, new Comparator1());
		for (Penguin peng : penguinList) {
			System.out.println(peng.toString());
		}

		// Collections.sort(penguinHashSet, new Comparator1());

		Random rand = new Random();
		for (Penguin peng : penguinList) {
			peng.setMatingPartners(new ArrayList<>());
			int nr = rand.nextInt(3) + 1;
			for (int i = 0; i < nr; ++i) {
				peng.getMatingPartners().add(generatePenguin.hatchPenguin());
			}
		}
		System.out.println("\nSorted with mating parteners: ---------------");
		Collections.sort(penguinList, new Comparator2());
		for (Penguin peng : penguinList) {
			System.out.println(peng.toString());
		}

		/*
		 * Task 3: map
		 */
		System.out.println("\nMap: -------------------------\n");
		Map<PenguinRace, List<Penguin>> hm = new HashMap<>();
		for (Penguin p : penguinList) {
			if(hm.containsKey(p.getRace())) {
				List<Penguin> newList = hm.get(p.getRace());
				newList.add(p);
				hm.put(p.getRace(), newList);
			} else {
				List<Penguin> newList = new ArrayList<>();
				newList.add(p);
				hm.put(p.getRace(), newList);
			}
		}

		Set<?> set = hm.entrySet();
		Iterator<?> i = set.iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue().toString());
		}
	}

}
