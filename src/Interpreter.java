import java.util.HashMap;

public class Interpreter {

	Stack<String> stack;
	HashMap<String, Double> myVars;
	Arithmetic arithmetic;

	public Interpreter() {
		stack = new Stack<String>();
		myVars = new HashMap<>();

	}

	public void parse(String[] tokens) {
		// Loops through the stack until it finds a closing parenthesis
		for (int i = 0; i < tokens.length; i++) {
			stack.push(tokens[i]);
			if (tokens[i].equals(")"))
				interpret();

		}
	}

	public void interpret() {
		String tok;
		// This stack represents the current list with all the tokens to be evaluated
		Stack<String> callStack = new Stack<String>();
		arithmetic = new Arithmetic(myVars);
		tok = stack.pop(); /* This is the ) character */
		// It loops backward until it finds a opening parenthesis
		while (!(tok = stack.pop()).equals("(")) {

			callStack.push(tok);
		}
		call(callStack);
	}

	public void call(Stack<String> callStack) {
		String func = callStack.pop(); /* This is the operator or function */
		switch (func) {
		case "+":
			stack.push(String.valueOf(arithmetic.add(callStack)));
			break;
		case "-":
			stack.push(String.valueOf(arithmetic.subtract(callStack)));
			break;
		case "*":
			stack.push(String.valueOf(arithmetic.multiply(callStack)));
			break;
		case "/":
			stack.push(String.valueOf(arithmetic.divide(callStack)));
			break;
		case "setq":

			String var = callStack.pop();

			if (Arithmetic.isNumeric(callStack.peek())) {
				// This if is for assigning a variable to an existing variable
				myVars.put(var, Double.parseDouble(callStack.pop()));

			} else {
				myVars.put(var, myVars.get(callStack.pop()));
			}

			break;
		case "print":
			System.out.println("Var: " + callStack.peek() + " Value: " + myVars.get(callStack.pop()));
			break;
		default:
			System.out.println("Error");
			break;
		}
	}

}
