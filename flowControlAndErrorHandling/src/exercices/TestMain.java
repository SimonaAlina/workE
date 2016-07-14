package exercices;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		FlowControl f = new FlowControl();
		System.out.println(f.monkeyTrouble(true, true));
		System.out.println(f.monkeyTrouble(false, false));
		System.out.println(f.monkeyTrouble(true, false));
		System.out.println();

		System.out.println(f.parrotTrouble(true, 6));
		System.out.println(f.parrotTrouble(true, 7));
		System.out.println(f.parrotTrouble(false, 6));
		System.out.println();

		System.out.println(f.posNeg(1, -1, false));
		System.out.println(f.posNeg(-1, 1, false));
		System.out.println(f.posNeg(1, 1, false));
		System.out.println(f.posNeg(-4, -5, true));
		System.out.println();

		System.out.println(f.backAround("cat"));
		System.out.println(f.backAround("Hello"));
		System.out.println(f.backAround("a"));
		System.out.println();

		System.out.println(f.everyNth("Miracle", 2));
		System.out.println(f.everyNth("abcdefg", 2));
		System.out.println(f.everyNth("abcdefg", 3));
		System.out.println();

		int[] scores1 = { 1, 3, 4 };
		System.out.println(f.scoresIncreasing(scores1));
		int[] scores2 = { 1, 3, 2 };
		System.out.println(f.scoresIncreasing(scores2));
		int[] scores3 = { 1, 1, 4 };
		System.out.println(f.scoresIncreasing(scores3));
		System.out.println();

		System.out.println(f.sumHeights(new int[] { 5, 3, 6, 7, 2 }, 2, 4));
		System.out.println(f.sumHeights(new int[] { 5, 3, 6, 7, 2 }, 0, 1));
		System.out.println(f.sumHeights(new int[] { 5, 3, 6, 7, 2 }, 0, 4));
		System.out.println();

		ErrorHandling e = new ErrorHandling();
		try {
			e.testErrorOutOfMemoryError();
		} catch (OutOfMemoryError ex) {
			System.out.println("Catch - Method which throw OutOfMemoryError");
		}
		try {
			e.testStackOverflowError();
		} catch (StackOverflowError ex) {
			System.out.println("Catch - Method which throw StackOverflowError");
		}
		System.out.println("Continue running after catch errors\n");
		
		Calculator c = new Calculator();
		c.add(1024*1024, 1024*1024);
		//c.divide(10, 0);
		//c.average(Arrays.asList(1,2,3));
		c.testFinally();
	}

}
