
public class TestMain {

	public static void main(String[] args) {
		EndavaStack<Integer> es = new EndavaStack<Integer>(10);
		es.push(20);
		es.push(30);

		System.out.println(es.toString());
		System.out.println(es.pop());
		System.out.println(es.size());

		EndavaStack<Integer> esM = new EndavaStack<Integer>(1, 2, 3, 4, 9, 8, 7, 5);
		System.out.println(esM.toString());
		System.out.println(esM.maxElement());
	}

}
