package exercices;

public class FlowControl {

	public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
		if (aSmile == bSmile)
			return true;
		return false;
	}

	public boolean parrotTrouble(boolean talking, int hour) {
		if (talking && (hour < 7 || hour > 20))
			return true;
		return false;
	}

	public boolean posNeg(int a, int b, boolean negative) {
		if(a == 0 || b == 0) {
			System.err.println("Enter values != 0");
			return false;
		}
		if (negative) {
			if (a * b > 0)
				return true;
		} else {
			if (a * b < 0)
				return true;
		}
		return false;
	}

	public String backAround(String str) {
		String substr = str.substring(str.length() - 1);
		return substr.concat(str).concat(substr);
	}

	public String everyNth(String str, int n) {
		String newStr = new String();
		char[] strCh = str.toCharArray();
		for (int i = 0; i < strCh.length; ++i) {
			if (i % n == 0)
				newStr = newStr + str.charAt(i);
		}
		return newStr;
	}

	public boolean scoresIncreasing(int[] scores) {
		for (int i = 1; i < scores.length; ++i) {
			if (scores[i] < scores[i - 1])
				return false;
		}
		return true;
	}

	public int sumHeights(int[] heights, int start, int end) {
		int sum = 0;
		for(int i = start; i < end; ++i)
			sum += Math.abs(heights[i] - heights[i+1]);
		return sum;
	}
}
