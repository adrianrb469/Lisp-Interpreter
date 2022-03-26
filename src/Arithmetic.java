import java.util.HashMap;

public class Arithmetic {

	Stack<Double> operands;
	HashMap<String, Double> myVars;
	
	public Arithmetic(HashMap<String, Double> vars) {
		operands = new Stack<>();
		myVars = vars;
	}

	public double add(Stack<String> evalStack) {
		double res = 0;
		
		// This loops through all the elements from the call stack
		while (!evalStack.isEmpty()) {
			//System.out.println(evalStack.toString());
			if (isNumeric(evalStack.peek())) {
				// Adds the operand to the stack
				operands.push(Double.parseDouble(evalStack.pop()));
				// Performs the operation
				res += operands.pop();
			}else {
				operands.push(myVars.get(evalStack.pop()));
				res += operands.pop();
			}
			
		}
		System.out.println("Result "+String.valueOf(res));
		return (res);
	}

	public double subtract(Stack<String> evalStack) {
		double res = 0;
		int n = 0;
		while (!evalStack.isEmpty()) {
			if (isNumeric(evalStack.peek())) {
				operands.push(Double.parseDouble(evalStack.pop()));
				if (n == 0) {
					res = operands.pop();
					n++;
				} else {
					res -= operands.pop();
				}
			}else {
				operands.push(myVars.get(evalStack.pop()));
				if (n == 0) {
					res = operands.pop();
					n++;
				} else {
					res -= operands.pop();
				}
			}
		}
		System.out.println("Result "+String.valueOf(res));
		return (res);
	}

	public double multiply(Stack<String> evalStack) {
		double res = 1;
		while (!evalStack.isEmpty()) {
			if (isNumeric(evalStack.peek())) {
				operands.push(Double.parseDouble(evalStack.pop()));
				res *= operands.pop();
			}else {
				operands.push(myVars.get(evalStack.pop()));
				res *= operands.pop();
			}
		}
		System.out.println("Result "+String.valueOf(res));
		return (res);
	}

	public double divide(Stack<String> evalStack) {
		double res = 1;
		int n = 0;
		while (!evalStack.isEmpty()) {
			if (isNumeric(evalStack.peek())) {
				operands.push(Double.parseDouble(evalStack.pop()));
				if (n == 0) {
					res = operands.pop();
					n++;
				} else {
					res /= operands.pop();
				}
			}else {
				operands.push(myVars.get(evalStack.pop()));
				if (n == 0) {
					res = operands.pop();
					n++;
				} else {
					res /= operands.pop();
				}
			}
		}
		System.out.println("Result "+String.valueOf(res));
		return (res);
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    
	    return true;
	}
	
}
