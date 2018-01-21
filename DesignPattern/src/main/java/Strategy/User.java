package Strategy;

public class User {

	public static void main(String[] args) {
		Calculate cal = new Add();
		System.out.println(cal.calculate("12+88"));
		cal = new Minus();
		System.out.println(cal.calculate("12-88"));
	}

}
