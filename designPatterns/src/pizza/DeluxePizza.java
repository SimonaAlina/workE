package pizza;

public class DeluxePizza extends Pizza {

	@Override
	public void generatePizza() {
		type = "Deluxe pizza";
		dressing = true;
		weight = 200;
	}

}
