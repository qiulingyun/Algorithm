package Interpreter;

public class Minus implements Interpreter {

	public int interpret(Context context) {
		if(context == null){
			return 0;
		}
		return context.getLeft() - context.getRight();
	}

}
