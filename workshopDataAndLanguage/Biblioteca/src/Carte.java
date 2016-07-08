
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (titlu == null) {
			if (other.titlu != null)
				return false;
		} else if (!titlu.equals(other.titlu))
			return false;
		return true;
	}

	public String toString() {
		return "Detalii carte:" + "\nTitlu: " + titlu.toUpperCase() + "\nAutor:  " + autor + "\nEditura: " + editura.toLowerCase() + "\nNr pagini: "
				+ numarPagini;
	}
}
