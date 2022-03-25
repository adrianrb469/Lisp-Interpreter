
import java.util.Scanner;

public class Main {

	/**
	 * @param args	
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String line = "";
		Lexer lexer = new Lexer();
		Interpreter lisp = new Interpreter();
		
		do {
			line = in.nextLine();
			if (!line.equals("exit")) {
				lisp.parse(lexer.tokenize(line));
			}
			
		}while (!line.equals("exit"));

	}
	

}
