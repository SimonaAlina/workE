
public class TestMain {

	public static void main(String[] args) {
		RandomStringGenerator gen = new RandomStringGenerator(10, "abcdefgh");
		System.out.println("Random String: " + gen.next());

		PasswordMaker pass = new PasswordMaker("Simona", "Roboiu", 23);
		System.out.println("Password: " + pass.getPassword());
	}

}
