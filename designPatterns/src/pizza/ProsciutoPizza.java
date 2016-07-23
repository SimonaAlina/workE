package pizza;

public class ProsciutoPizza extends Pizza {

	@Override
	public void generatePizza() {
		type = "Prosciuto pizza";
		dressing = true;
		weight = 230;
	}

}
