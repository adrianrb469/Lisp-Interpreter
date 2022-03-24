import java.util.HashMap;

public class Arithmetic {

	Stack<Double> operands;
	HashMap<String, Double> myVars;
	
	public Arithmetic(HashMap<String, Double> vars) {
		operands = new Stack<>();
		myVars = vars;
	}

	public double add(Stack<String> callStack) {
		double res = 0;
		System.out.println(callStack.toString());
		// This loops through all the elements from the call stack
		while (!callStack.isEmpty()) {
			if (isNumeric(callStack.peek())) {
				// Adds the operand to the stack
				operands.push(Double.parseDouble(callStack.pop()));
				// Performs the operation
				res += operands.pop();
			}else {
				operands.push(myVars.get(callStack.pop()));
				res += operands.pop();
			}
			
		}

		System.out.println("Answer is " + (res));
		return (res);
	}

	public double subtract(Stack<String> callStack) {
		double res = 0;
		System.out.println(callStack.toString());
		while (!callStack.isEmpty()) {
			if (isNumeric(callStack.peek())) {
				operands.push(Double.parseDouble(callStack.pop()));
				res -= operands.pop();
			}else {
				operands.push(myVars.get(callStack.pop()));
				res -= operands.pop();
			}
		}

		System.out.println("Answer is :" + (res));
		return (res);
	}

	public double multiply(Stack<String> callStack) {
		double res = 1;
		System.out.println(callStack.toString());
		while (!callStack.isEmpty()) {
			if (isNumeric(callStack.peek())) {
				operands.push(Double.parseDouble(callStack.pop()));
				res *= operands.pop();
			}else {
				operands.push(myVars.get(callStack.pop()));
				res *= operands.pop();
			}
		}

		System.out.println("Answer is " + (res));
		return (res);
	}

	public double divide(Stack<String> callStack) {
		double res = 1;
		int n = 0;
		System.out.println(callStack.toString());
		while (!callStack.isEmpty()) {
			// Division is a special case were the initial value needs to be the first of
			// the callStack
			operands.push(Double.parseDouble(callStack.pop()));
			if (n == 0) {
				res = operands.pop();
				n++;
			} else {
				res /= operands.pop();
			}

		}

		System.out.println("Answer is " + (res));
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
