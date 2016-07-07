import java.util.Scanner;

public class Test {

	private static Scanner s;

	public static void main(String[] args) {

		s = new Scanner(System.in);
		String titlu = s.nextLine();
		String autor = s.nextLine();
		String editura = s.nextLine();
		int nrPagini = s.nextInt();
		Carte c = new Carte(titlu, autor, editura, nrPagini);
		System.out.println(c.toString());
	}

}
