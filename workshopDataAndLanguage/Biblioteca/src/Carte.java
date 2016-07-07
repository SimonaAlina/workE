
public class Carte {
	String titlu;
	String autor;
	String editura;
	int numarPagini;

	public Carte(String titlu, String autor, String editura, int numarPagini) {
		super();
		this.titlu = titlu;
		this.autor = autor;
		this.editura = editura;
		this.numarPagini = numarPagini;
	}

	public Carte() {

	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditura() {
		return editura;
	}

	public void setEditura(String editura) {
		this.editura = editura;
	}

	public int getNumarPagini() {
		return numarPagini;
	}

	public void setNumarPagini(int numarPagini) {
		this.numarPagini = numarPagini;
	}

	public boolean equals(Carte c) {
		if (this.autor.equals(c.getAutor()) && this.titlu.equals(c.getTitlu()))
			return true;
		return false;
	}

	public String toString() {
		return "Detalii carte:" + "\nTitlu: " + titlu + "\nAutor:  " + autor + "\nEditura: " + editura + "\nNr pagini: "
				+ numarPagini;
	}
}
