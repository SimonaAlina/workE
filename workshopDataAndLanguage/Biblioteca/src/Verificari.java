
public class Verificari {
	public static boolean isDuplicate(Carte c1, Carte c2) {
		return c1.equals(c2) && c1.editura.equals(c2.editura) && c1.numarPagini == c2.numarPagini;
	}

	public static Carte getBookWithMorePages(Carte c1, Carte c2) {
		return (c1.numarPagini > c2.numarPagini) ? c1 : c2;
	}
}
