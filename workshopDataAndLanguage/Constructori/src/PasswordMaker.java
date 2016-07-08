
public class PasswordMaker {
	private static final int MAGIC_NUMBER = 10;
	private static final String MAGIC_STRING = new RandomStringGenerator(30, "abcdefgh").next();

	private String firstName;
	private String lastName;
	private int age;

	PasswordMaker(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getPassword() {
		String str = new RandomStringGenerator(10, MAGIC_STRING).next();
		RandomStringGenerator generator = new RandomStringGenerator(MAGIC_NUMBER, str);

		String password = firstName.substring(firstName.length() - (age % 3));
		password = password.concat(generator.next());

		return password.concat(String.valueOf(age + lastName.length()));
	}
}
