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
		
		// Este hace bucle con todos los elementos del Stack
		while (!evalStack.isEmpty()) {
			
			if (isNumeric(evalStack.peek())) {
				// agrega el operando al stackq
				operands.push(Double.parseDouble(evalStack.pop()));
				// Hace la operacion 
				res += operands.pop();
			}else {
				operands.push(myVars.get(evalStack.pop()));
				res += operands.pop();
			}
			
		}
		System.out.println("Result "+String.valueOf(res)); // Imprime los resultados 
		return (res);
	}

	public double subtract(Stack<String> evalStack) {
		double res = 0;
		int n = 0;
		while (!evalStack.isEmpty()) {// Este hace bucle con todos los elementos del Stack
			if (isNumeric(evalStack.peek())) {
				operands.push(Double.parseDouble(evalStack.pop()));
				if (n == 0) { //agrega los operandos al stack
					res = operands.pop();
					n++; // hace la operacion
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


		System.out.println("Answer is :" + (res)); //imprime resultados 

		return (res);
	}

	public double multiply(Stack<String> evalStack) {
		double res = 1;
		while (!evalStack.isEmpty()) { // el bucle patra el stack 
			if (isNumeric(evalStack.peek())) {
				operands.push(Double.parseDouble(evalStack.pop())); // agrega los operandos 
				res *= operands.pop(); // hace la operacion 
			}else {
				operands.push(myVars.get(evalStack.pop()));
				res *= operands.pop();
			}
		}
		System.out.println("Result "+String.valueOf(res)); // imprime los resultados 
		return (res);
	}

	public double divide(Stack<String> evalStack) {
		double res = 1;
		int n = 0;
		while (!evalStack.isEmpty()) { // el bucle patra el stack 
			if (isNumeric(evalStack.peek())) {
				operands.push(Double.parseDouble(evalStack.pop()));// agrega los operandos 
				if (n == 0) {// hace la operacion 
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
		System.out.println("Result "+String.valueOf(res)); //imprime los resultados 
		return (res);
	}
	
	public static boolean isNumeric(String strNum) { // revisa si es un numero lo que estará evaluando
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
