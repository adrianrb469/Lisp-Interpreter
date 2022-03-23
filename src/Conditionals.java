import java.util.HashMap;

public class Conditionals {

	Stack<Double> operands;
	HashMap<String, Double> myVars;
	Arithmetic arithmetic;
	
	public Conditionals(HashMap<String, Double> vars) {
		operands = new Stack<>();
		myVars = vars;
		arithmetic = new Arithmetic(vars);
	}

	// x>y
	public boolean greaterThan(Stack<String> callStack) {
		
		double x;
		double y;
		
		if(!arithmetic.isNumeric(callStack.peek())) {
			x = myVars.get(callStack.pop());
		}
		else {
			x = Double.parseDouble(callStack.pop());
		}
		if(!arithmetic.isNumeric(callStack.peek())) {
			y = myVars.get(callStack.pop());
		}
		else {
			y = Double.parseDouble(callStack.pop());
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
	public boolean lessThan(Stack<String> callStack) {

		double x;
		double y;
		
		if(!arithmetic.isNumeric(callStack.peek())) {
			x = myVars.get(callStack.pop());
		}
		else {
			x = Double.parseDouble(callStack.pop());
		}
		if(!arithmetic.isNumeric(callStack.peek())) {
			y = myVars.get(callStack.pop());
		}
		else {
			y = Double.parseDouble(callStack.pop());
		}
		
		if (x < y) {
			System.out.println("True");
			return true;
		}else {
			System.out.println("False");
			return false;
		}

	}
	
	public boolean equalTo(Stack<String> callStack) {

		double x;
		double y;
		
		if(!arithmetic.isNumeric(callStack.peek())) {
			x = myVars.get(callStack.pop());
		}
		else {
			x = Double.parseDouble(callStack.pop());
		}
		if(!arithmetic.isNumeric(callStack.peek())) {
			y = myVars.get(callStack.pop());
		}
		else {
			y = Double.parseDouble(callStack.pop());
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
