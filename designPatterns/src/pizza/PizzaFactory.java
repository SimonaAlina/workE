package pizza;

public class PizzaFactory {

	public static Pizza getPizza(PizzaType pt) {
		switch (pt) {
		case DELUXE:
			return new DeluxePizza();
		case HAMANDMUSHROOM:
			return new HamAnMushroomPizza();
		case PROSCIUTO:
			return new ProsciutoPizza();
		default:
			return null;
		}
	}
}
