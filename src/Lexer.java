import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Lexer {

	Lexer() {

	}
	
	public String[] tokenize(String expression) {
		String tokens[];
		// Adds spaces if necessary before splitting
		expression = expression.replaceAll("[(]", "( " ).replaceAll("[)]", " )");
		// Split the lisp expression into tokens
		tokens = expression.split("\s");
		return tokens;
	
	}
}
