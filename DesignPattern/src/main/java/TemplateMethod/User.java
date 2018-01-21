package TemplateMethod;

public class User {
	public static void main(String[] args){
		Calculate cal = new Add();
		System.out.println(cal.calculate("12+21", "\\+"));
		
	}
}
