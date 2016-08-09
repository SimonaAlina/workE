package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.Comparator;

public class PenguinFun {

	public static <R> void main(String[] args) {
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
		
		/*
		 * java 8
		 */
//		int numberOfRaces = PenguinRace.values().length;
//		Comparator<Penguin> comp1 = (p1,p2) -> Double.compare(p1.getAge(), p2.getAge());
//		Comparator<Penguin> comp2 = (p1,p2) -> p1.getRace().toString().compareTo(p2.getRace().toString());
//		
//		Predicate<Penguin> p1 = p -> p.getAge() > 5;
//		Predicate<Penguin> p2 = p-> p.getRace().equals(PenguinRace.AFRICAN);
//		
//		List<Penguin> penguins = IntStream.rangeClosed(1,  10)
//				.mapToObj(i -> new Penguin("pingu-"+i, PenguinRace.values()[i% numberOfRaces], i))
//				.filter(p -> p.getAge() > 5) //p1.or(p2) sau: p -> {return p.getAge() > 5 && p.getRace.equals()}
//				.collect(Collectors.toList());
//		.count()
//		.map(p -> p.getAge()).reduce(0.0, (d1, d2) -> d1 + d2)
//		
//		.max(comp1.thenComparing(comp2)) => return Optional
//		
//		IntStream.range(0, 10).forEach(System.out::print);
//		
//		Collectors.joining(",");
//		.collect(Collectors.groupingBy(p -> p.getRace().toString()));
//		for (Penguin peng : penguins) {
//			System.out.println(peng.toString());
//		}
//		
//		List<Integer> l1 = Arrays.asList(1,2,3);
//		List<Integer> l2 = Arrays.asList(4,5,7);
//		List<List<Integer>> l3 = Arrays.asList(l1,l2);
//		
//		Function<List<Integer>, Stream> function = l -> l.stream();
//		l3.stream().flatMap((Function<? super List<Integer>, ? extends Stream<? extends R>>) function).forEach(System.out::print);
//		
		/*
		 * end java 8
		 */
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
		Entry<PenguinRace, List<Penguin>> me = null;
		while (i.hasNext()) {
			me = (Entry<PenguinRace, List<Penguin>>) i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue().toString());
		}
		
		/*
		 * Homework *
		 */
		Map<String, List<Penguin>> hmL = new HashMap<>();
		for(int nr = 0; nr < 100000; ++nr) {
			for (Penguin p : penguinList) {
				if(hmL.containsKey(p.getRace().toString())) {
					List<Penguin> newList = hmL.get(p.getRace().toString());
					newList.add(p);
					hmL.put(p.getRace().toString(), newList);
				} else {
					List<Penguin> newList = new ArrayList<>();
					newList.add(p);
					hmL.put(p.getRace().toString(), newList);
				}
			}
		}
		long start = System.currentTimeMillis();
		hmL.get("IMPERIAL");
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		//Hashtable<String, List<Penguin>> ht = new Hashtable<>();
	}

}
