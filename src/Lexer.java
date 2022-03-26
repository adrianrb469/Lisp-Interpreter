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
		expression = expression.replaceAll("[(]", "( ").replaceAll("[)]", " )").replaceAll("[\\[]", "[ ").replaceAll("[\\]]", " ]");
		
		// Split the lisp expression into tokens
		tokens = expression.trim().split(" ");
		
		List<String> tokenList = new LinkedList<>(Arrays.asList(tokens));
		ListIterator<String> iter = tokenList.listIterator();
		
		Stack<String> tokenStack = new Stack<>();
		
		// Removes unnecesary tokens from the token list
		while(iter.hasNext()){
		    if(iter.next().equals(" ")){
		        iter.remove();
		    }
		
		}
		//System.out.println(tokenList.toString());
		String[] tks = new String[tokenList.size()];
		tokenList.toArray(tks);
		
		return tks;
		

	}
}
