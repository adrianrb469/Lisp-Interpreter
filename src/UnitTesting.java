import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;


public class UnitTesting {
	
	HashMap<String, Double> vars = new HashMap<>();
	
	/**
	 * Test method for Arithmetic add method
	 */
	@Test
	void addExpression() {
		
		vars.put("x", 5.0);
		vars.put("y", 0.5);
		Arithmetic ari = new Arithmetic(vars);
		Stack<String> testStack = new Stack<>();
		testStack.push("5");
		testStack.push("10");
		testStack.push("20");
		testStack.push("x");
		testStack.push("y");
		assertEquals(40.5,ari.add(testStack));
		
	}
	
	/**
	 * Test method for Arithmetic subtract method
	 */
	@Test
	void subtractExpression() {
		
		vars.put("x", 5.0);
		vars.put("z", 0.5);
		Arithmetic ari = new Arithmetic(vars);
		Stack<String> testStack = new Stack<>();
		testStack.push("5");
		testStack.push("10");
		testStack.push("z");
		testStack.push("20");
		testStack.push("x");
		assertEquals(-30.5,ari.subtract(testStack));
		
	}
	
	/**
	 * Test method for Arithmetic multiply method
	 */
	@Test
	void multiplyExpression() {
		
		vars.put("x", 1.0);
		vars.put("z", 9.0);
		Arithmetic ari = new Arithmetic(vars);
		Stack<String> testStack = new Stack<>();
		testStack.push("5");
		testStack.push("z");
		testStack.push("x");
		assertEquals(45.0,ari.multiply(testStack));
		testStack.push("0");
		assertEquals(0,ari.multiply(testStack));
		
	}
	
	/**
	 * Test method for Arithmetic divide method
	 */
	@Test
	void divideExpression() {
		
		vars.put("x", 100.0);
		Arithmetic ari = new Arithmetic(vars);
		Stack<String> testStack = new Stack<>();
		testStack.push("x");
		testStack.push("x");
		testStack.push("100");
		assertEquals(0.01,ari.divide(testStack));
		
	}
	
	/**
	 * Test method for predicate greaterThan 
	 */
	@Test
	void greaterThanExpression() {
		
		vars.put("x", 100.0);
		vars.put("y", 10.0);
		Predicates p = new Predicates(vars);
		Stack<String> testStack = new Stack<>();
		testStack.push("y");
		testStack.push("x");
		assertEquals(true,p.greaterThan(testStack));
		
	}
	/**
	 * Test method for predicate lessThan
	 */
	@Test
	void lessThanExpression() {
		
		vars.put("x", 100.0);
		vars.put("y", 10.0);
		Predicates p = new Predicates(vars);
		Stack<String> testStack = new Stack<>();
		testStack.push("y");
		testStack.push("x");
		assertEquals(false,p.lessThan(testStack));
		
	}
	
	/**
	 * Test method for predicate equalTo
	 */
	@Test
	void equalToExpression() {
		
		vars.put("x", 100.0);
		vars.put("y", 100.0);
		Predicates p = new Predicates(vars);
		Stack<String> testStack = new Stack<>();
		testStack.push("y");
		testStack.push("x");
		assertEquals(true,p.equalTo(testStack));
		
	}
	
	
	
}
