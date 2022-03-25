import java.util.HashMap;

public class Predicates {

	Stack<Double> operands;
	HashMap<String, Double> myVars;
	Arithmetic arithmetic;
	
	public Predicates(HashMap<String, Double> vars) {
		operands = new Stack<>();
		myVars = vars;
		arithmetic = new Arithmetic(vars);
	}

	// x>y
	public boolean greaterThan(Stack<String> evalStack) {
		
		double x;
		double y;
		
		if(!arithmetic.isNumeric(evalStack.peek())) {
			x = myVars.get(evalStack.pop());
		}
		else {
			x = Double.parseDouble(evalStack.pop());
		}
		if(!arithmetic.isNumeric(evalStack.peek())) {
			y = myVars.get(evalStack.pop());
		}
		else {
			y = Double.parseDouble(evalStack.pop());
		}
		
		if (x > y) {
			System.out.println("True");
			return true;
		}else {
			System.out.println("False");
			return false;
		}
			

	}
	// x<y
	public boolean lessThan(Stack<String> evalStack) {

		double x;
		double y;
		
		if(!arithmetic.isNumeric(evalStack.peek())) {
			x = myVars.get(evalStack.pop());
		}
		else {
			x = Double.parseDouble(evalStack.pop());
		}
		if(!arithmetic.isNumeric(evalStack.peek())) {
			y = myVars.get(evalStack.pop());
		}
		else {
			y = Double.parseDouble(evalStack.pop());
		}
		
		if (x < y) {
			System.out.println("True");
			return true;
		}else {
			System.out.println("False");
			return false;
		}

	}
	
	public boolean equalTo(Stack<String> evalStack) {

		double x;
		double y;
		
		if(!arithmetic.isNumeric(evalStack.peek())) {
			x = myVars.get(evalStack.pop());
		}
		else {
			x = Double.parseDouble(evalStack.pop());
		}
		if(!arithmetic.isNumeric(evalStack.peek())) {
			y = myVars.get(evalStack.pop());
		}
		else {
			y = Double.parseDouble(evalStack.pop());
		}
		
		if (x == y) {
			System.out.println("True");
			return true;
		}else {
			System.out.println("False");
			return false;
		}

	}

}
