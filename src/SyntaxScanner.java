import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SyntaxScanner {

	SyntaxScanner() {

	}

	public String[] tokenize(String expression) {

		String tokens[];
		// Split the lisp expression into tokens
		tokens = expression.split("((?=[[)]])|(?<=[(])|(?=[(])|(?=[\s]))");
		List<String> tokenList = new LinkedList<>(Arrays.asList(tokens));
		ListIterator<String> iter = tokenList.listIterator();
		
		// Removes unnecesary tokens from the token list
		while(iter.hasNext()){
		    if(iter.next().equals(" ")){
		        iter.remove();
		    }
		}
		System.out.println(tokenList.toString());
		String[] tks = new String[tokenList.size()];
		tokenList.toArray(tks);
		return tks;
	}
}
