import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/**
	 * @param args	
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String opt = "";
		String[] tokens;
		SyntaxScanner sc = new SyntaxScanner();
		Interpreter lisp = new Interpreter();
		
		do {
			opt = in.nextLine();
			
			if (!opt.equals("exit")) {
				lisp.parse(sc.tokenize(opt));
			}
			
		}while (!opt.equals("exit"));

	}
	

}
