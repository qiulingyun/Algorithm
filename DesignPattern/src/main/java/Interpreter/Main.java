package Interpreter;

public class Main {
	public static void main(String[] args){
		int result = 0;
		result = new Plus().interpret(new Context(2, 6));
		System.out.println(result);
	}
}
