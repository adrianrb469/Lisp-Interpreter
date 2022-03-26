import java.util.HashMap;

public class Interpreter { //clase de interprete, hace la mayor parte del trabajo 

	Stack<String> stack;
	HashMap<String, Double> myVars; // intancia de variables y constructores
	HashMap<String, Function> myFuncs = new HashMap<>();;
	Stack<String> args = new Stack<>();
	Stack<String> body = new Stack<>();
	Lexer lexer;
	Arithmetic arithmetic;
	Predicates predicate;

	public Interpreter() { // crea el stack, el hashmap y el constuctor de los tokens
		stack = new Stack<String>();
		myVars = new HashMap<>();
		lexer = new Lexer();

	}

	public void parse(String[] tokens) {
		// Busca los parentesis que cierran en el satck
		for (int i = 0; i < tokens.length; i++) {
			stack.push(tokens[i]);
			if (tokens[i].equals(")"))
				interpret();

		}
		stack = new Stack<>();
	}

	public void interpret() {
		String tok;
		// Este es el stack con todos los tokens evaluados
		Stack<String> evalStack = new Stack<String>();
		arithmetic = new Arithmetic(myVars);
		predicate = new Predicates(myVars);
		tok = stack.pop();
		// Este va en bucle reverso hasta que encuentra el parentesis que abre

		while (!(tok = stack.pop()).equals("(")) {
			evalStack.push(tok);
		}
		eval(evalStack);
	}

	public void eval(Stack<String> evalStack) {
		
		String func = evalStack.pop();
		switch (func) {
		case "defun":
			System.out.println(func);
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

			myFuncs.put(funcName, new Function(args, body));
			args = new Stack<>();
			body = new Stack<>();
			System.out.println("F in defun" + myFuncs.get(funcName).toString()); // nos devuelve el nombre de la funcion para ingresar datos 

			break;
		case "setq":
			String var = evalStack.pop();
			if (Arithmetic.isNumeric(evalStack.peek())) {
				// Esta es para asignar a una variable otra ya existente 
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
				// System.out.println(evalStack.toString());

				Function function1 = myFuncs.get(func);

				// System.out.println("f Before " + function1.toString());

				args = function1.getArgs();

				body = function1.getBody();
				// Stack<String> bodyCopy = body;
				String[] arrayArgs = new String[args.count()];
				String[] arrayBody = new String[body.count()];
				HashMap<String, String> tempVars = new HashMap<>();
				arrayArgs = args.toStringArray();
				arrayBody = body.toStringArray();
				int n = 0;
				int j = 0;
				while (n < arrayArgs.length) {

					tempVars.put(arrayArgs[n], evalStack.pop());
					n++;
				}
				// System.out.println("f After " + function.toString());

				Stack<String> expression = new Stack<>();
				while (j < arrayBody.length) {
					if (arrayBody[j].equals("[")) {
						expression.push("(");

					} else if (arrayBody[j].equals("]")) {
						expression.push(")");

					} else {
						if (!(tempVars.get(arrayBody[j]) == null)) {
							expression.push(tempVars.get(arrayBody[j]));
						} else if (!(myVars.get(arrayBody[j]) == null)) {
							expression.push(String.valueOf(myVars.get(arrayBody[j])));
						} else {
							expression.push(arrayBody[j]);
						}

					}
					j++;

				}
				args = new Stack<>();
				body = new Stack<>();
				// function.setArgs(args);

				// function.setBody(body);
				// System.out.println("f After " + function.toString());

				// System.out.println(expression);
				tempVars.clear();
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
