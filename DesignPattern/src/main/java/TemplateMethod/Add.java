package TemplateMethod;

public class Add extends Calculate {

	@Override
	public int calculate(int[] num) {
		
		return num[0] + num[1];
	}

}
