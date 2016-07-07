import java.util.Scanner;

public class Test {

	private static Scanner s;

	public static void main(String[] args) {

		s = new Scanner(System.in);
		System.out.print("Introduceti titlu: ");
		String titlu = s.nextLine();
		System.out.print("Introduceti autorul: ");
		String autor = s.nextLine();
		System.out.print("Introduceti editura: ");
		String editura = s.nextLine();
		System.out.print("Introduceti nr de pagini: ");
		int nrPagini = s.nextInt();
		while (nrPagini <= 0) {
			System.out.println("Introduceti un numar mai mare ca zero");
			nrPagini = s.nextInt();
		}
		Carte c1 = new Carte(titlu, autor, editura, nrPagini);
		System.out.println(c1.toString() + "\n");

		Carte c2 = new Carte("Java8", "Scott Selikoff", "New World", 330);

		System.out.println(Verificari.isDuplicate(c1, c2) == true ? "Duplicate\n" : "Not Duplicate\n");
		System.out.println(Verificari.getBookWithMorePages(c1, c2).toString());
	}

}
