package Strategy;

public class Add extends CalculateUtil implements Calculate {

	public int calculate(String input) {
		int[] num = splitApart(input, "\\+");
		return num[0] + num[1];
	}

}
