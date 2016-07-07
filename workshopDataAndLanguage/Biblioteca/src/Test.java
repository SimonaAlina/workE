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
		while(nrPagini == 0){
			System.out.println("Introduceti un numar diferit de zero");
			nrPagini = s.nextInt();
		}
		Carte c = new Carte(titlu, autor, editura, nrPagini);
		System.out.println(c.toString());
	}

}
