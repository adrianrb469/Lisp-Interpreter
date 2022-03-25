import java.util.HashMap;

public class Interpreter {

	Stack<String> stack;
	HashMap<String, Double> myVars;
	HashMap<String, Function> myFuncs = new HashMap<>();;
	Stack<String> args = new Stack<>();
	Stack<String> body = new Stack<>();
	Lexer lexer;
	Arithmetic arithmetic;
	Predicates predicate;

	public Interpreter() {
		stack = new Stack<String>();
		myVars = new HashMap<>();

		lexer = new Lexer();

	}

	public void parse(String[] tokens) {
		// Loops through the stack until it finds a closing parenthesis
		for (int i = 0; i < tokens.length; i++) {
			stack.push(tokens[i]);
			if (tokens[i].equals(")"))
				interpret();

		}
		stack = new Stack<>();
	}

	public void interpret() {
		String tok;
		// This stack represents the current list with all the tokens to be evaluated
		Stack<String> evalStack = new Stack<String>();
		arithmetic = new Arithmetic(myVars);
		predicate = new Predicates(myVars);
		tok = stack.pop();
		System.out.println("Stack in main loop " + stack.toString());
		// It loops backward until it finds an opening parenthesis

		while (!(tok = stack.pop()).equals("(")) {
			evalStack.push(tok);
		}
		eval(evalStack);
	}

	public void eval(Stack<String> evalStack) {
		System.out.println("evalStack " + evalStack);
		String func = evalStack.pop();
		switch (func) {
		case "defun":
			String funcName = evalStack.pop();

			String tok;
			while (!(tok = evalStack.peek()).equals("]")) {
				if (tok.equals("[")) {
					evalStack.pop();

				} else {
					args.push(evalStack.pop());

				}
			}
			evalStack.pop();
			while (!(evalStack.isEmpty())) {
				body.push(evalStack.pop());
			}
			Function function = new Function();
			function.setArgs(args);
			function.setBody(body);
			System.out.println("F in defun" + function.toString());
			myFuncs.put(funcName, function);
			break;
		case "setq":
			String var = evalStack.pop();
			if (Arithmetic.isNumeric(evalStack.peek())) {
				// This if is for assigning a variable to an existing variable
				myVars.put(var, Double.parseDouble(evalStack.pop()));

			} else {
				myVars.put(var, myVars.get(evalStack.pop()));
			}

			break;
		case "print":
			if (myVars.get(evalStack.peek()) == null) {
				System.out.println(evalStack.pop());
			} else {
				System.out.println("Var: " + evalStack.peek() + " Value: " + myVars.get(evalStack.pop()));
			}
			break;
		case "+":
			stack.push(String.valueOf(arithmetic.add(evalStack)));
			break;
		case "-":
			stack.push(String.valueOf(arithmetic.subtract(evalStack)));
			break;
		case "*":
			stack.push(String.valueOf(arithmetic.multiply(evalStack)));
			break;
		case "/":
			stack.push(String.valueOf(arithmetic.divide(evalStack)));
			break;
		case ">":
			stack.push(String.valueOf(predicate.greaterThan(evalStack)));
			break;
		case "<":
			stack.push(String.valueOf(predicate.lessThan(evalStack)));
			break;
		case "=":
			stack.push(String.valueOf(predicate.equalTo(evalStack)));
			break;
		default:
			if (!(myFuncs.get(func) == null)) {

				function = myFuncs.get(func);

				System.out.println("f Before " + function.toString());

				args = function.getArgs();

				body = function.getBody();
				Stack<String> bodyCopy = body;
				String[] arrayArgs = new String[args.count()];
				String[] arrayBody = new String[body.count()];
				arrayArgs = args.toStringArray();
				arrayBody = body.toStringArray();
				int n = 0;
				int j = 0;
				while (!(evalStack.count() == 0)) {

					myVars.put(arrayArgs[n], Double.parseDouble(evalStack.pop()));
					n++;
				}
				System.out.println("f After " + function.toString());

				Stack<String> expression = new Stack<>();
				while (j < arrayBody.length) {
					if (arrayBody[j].equals("[")) {
						expression.push("(");

					} else if (arrayBody[j].equals("]")) {
						expression.push(")");

					} else {
						
						expression.push(arrayBody[j]);
					}
					j++;

				}

				// function.setArgs(args);

				// function.setBody(body);
				System.out.println("f After " + function.toString());

				System.out.println(expression);
				parse(expression.toStringArray());
				stack = new Stack<>();

			} else if (!(myVars.get(func) == null)) {
				stack.push(String.valueOf(myVars.get(func)));
			} else if (arithmetic.isNumeric(func)) {
				stack.push(func);
			} else {
				System.out.println("Error");
			}

			break;
		}
	}

}
