
public class NumarComplex {

	float im, re;

	public NumarComplex(float im, float re) {
		super();
		this.im = im;
		this.re = re;
	}

	public NumarComplex() {
	}

	public float getIn() {
		return im;
	}

	public void setIn(float im) {
		this.im = im;
	}

	public float getRe() {
		return re;
	}

	public void setRe(float re) {
		this.re = re;
	}

	public String toString() {
		return "(" + re + "," + im + "i)";
	}
}
