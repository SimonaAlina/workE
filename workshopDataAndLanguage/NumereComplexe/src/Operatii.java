
public class Operatii {

	public static NumarComplex sum(NumarComplex n1, NumarComplex n2) {
		return new NumarComplex(n1.re + n2.re, n1.im + n2.im);
	}

	public static NumarComplex multiply(NumarComplex n1, NumarComplex n2) {
		return new NumarComplex(n1.re * n2.re, n1.im * n2.im);
	}
}
