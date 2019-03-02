package Test.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RPNCalculator {

	private ArrayList<String> stack = new ArrayList<String>();
	private LinkedList<ArrayList<String>> history = new LinkedList<ArrayList<String>>();;
	private CalculationEngine engine = new CalculationEngine();

	class CalculationEngine {
		private List<String> operator2 = Arrays.asList("+", "-", "*", "/");
		private List<String> operator1 = Arrays.asList("sqrt");
		private List<String> action = Arrays.asList("undo", "clear");

		private boolean isValue(String str) {
			try {
				Double.valueOf(str);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

		private boolean isAction(String str) {
			return action.contains(str);
		}

		private boolean isOperator(String str) {
			ArrayList<String> all = new ArrayList<String>();
			all.addAll(operator1);
			all.addAll(operator2);
			return all.contains(str);
		}

		// return the wrong input index, -1 stand for correct
		public int validate(ArrayList<String> input) {
			int i = 0;
			for (String curr : input) {
				if (i == 0 && !isValue(curr) && !isAction(curr)) {
					return 0;
				} else if (i == 1 && !isValue(curr) && !isAction(curr) && !operator1.contains(curr)) {
					return 1;
				} else if (i > 1 && !isValue(curr) && !isAction(curr) && !isOperator(curr)) {
					return i;
				}
				i++;
			}
			return -1;
		}

		public int calculateOnce(ArrayList<String> base, String input, ArrayList<String> output) {
			ArrayList<String> baseAndin = new ArrayList<String>();
			baseAndin.addAll(base);
			baseAndin.add(input);
			int baseSize = base.size();

			int ret = validate(baseAndin);
			if (ret != -1) {
				return ret;
			}
			output.addAll(base);

			// do something for one input
			if (isValue(input)) {
				output.add(input);
			} else if (operator1.contains(input)) {
				List<String> vals = Arrays.asList(base.get(baseSize - 1));
				String answer = doOperation(input, vals);
				output.set(baseSize - 1, answer);
			} else if (operator2.contains(input)) {
				List<String> vals = Arrays.asList(base.get(baseSize - 2), base.get(baseSize - 1));
				String answer = doOperation(input, vals);
				output.set(baseSize - 2, answer); // set answer to val1
				output.remove(baseSize - 1); // don't needs val2 any more, it
												// has been operated
			} else if (action.contains(input)) {
				doAction(input, output);
				return -2;
			}

			return -1;
			// prevStack = input.clone();

		}

		private String doOperation(String operator, List<String> vals) {
			double tmp = 0d;
			switch (operator) {
			case "+":
				tmp = Double.valueOf(vals.get(0)) + Double.valueOf(vals.get(1));
				break;
			case "-":
				tmp = Double.valueOf(vals.get(0)) - Double.valueOf(vals.get(1));
				break;
			case "*":
				tmp = Double.valueOf(vals.get(0)) * Double.valueOf(vals.get(1));
				break;
			case "/":
				tmp = Double.valueOf(vals.get(0)) / Double.valueOf(vals.get(1));
				break;
			case "sqrt":
				tmp = Math.sqrt(Double.valueOf(vals.get(0)));
				break;
			default:
				break;
			}

			int t = (int) tmp;
			if (Double.compare(t, tmp) == 0) {
				return String.valueOf(t);
			} else {
				return String.valueOf(tmp);
			}

		}

		private boolean doAction(String action, ArrayList<String> output) {
			switch (action) {
			case "undo":
				output.clear();
				output.addAll(history.pop());
				if (history.isEmpty()) {
					history.add(new ArrayList<String>());
				}
				return false;
			case "clear":
				output.clear();
				break;
			default:
				break;
			}
			return true;
		}
	}
/**
 * calculation entrance
 * @param input: origin user input line
 */
	public void calculate(String input) {
		String[] inputs = input.trim().split(" ");
		for (String in : inputs) {
			ArrayList<String> output = new ArrayList<String>();
			/**
			 * do calculate once for a single input 
			 * code >= 0, error occur
			 * code == -1, success and make history
			 * code == -2, success with no history, now for "undo" operation
			 */
			int code = engine.calculateOnce(stack, in, output);
			if (code >= 0) {
				// error
				System.out.println( "operator " + in + " (position: " + (input.indexOf(" " + in) + 2) + "): insucient parameters");
				break;
			}else if (code == -2) {
				// success without history
				stack = output;
			}else {
				// success
				history.push(stack); // each input makes history
				stack = output;

			}
		}
		return;
	}

	public String getStackAsString() {
		String output = "Stack:";
		for (String st : stack) {
			output += " " + st;
		}
		return output;
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		RPNCalculator calculator = new RPNCalculator();
		while (true) {
			String input = sc.nextLine();
			calculator.calculate(input);
			System.out.println(calculator.getStackAsString());
		}
	}

}
