
public class TestMain {

	public static void main(String[] args) {
		NumarComplex nr1 = new NumarComplex(2f, 3f);
		NumarComplex nr2 = new NumarComplex(4f, 2f);

		NumarComplex suma = new NumarComplex();
		suma = Operatii.sum(nr1, nr2);

		NumarComplex inmultire = new NumarComplex();
		inmultire = Operatii.multiply(nr1, nr2);

		System.out.println("Suma: " + nr1.toString() + " + " + nr2.toString() + " = " + suma);
		System.out.println("Inmultire: " + nr1.toString() + " * " + nr2.toString() + " = " + inmultire);
	}

}
