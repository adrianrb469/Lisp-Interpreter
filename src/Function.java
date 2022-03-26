
public class Function { // nuestra clase de funciones

	Stack<String> args = new Stack<>();
	Stack<String> body = new Stack<>();

	public Function() {

	}
	public Function(Stack<String> args, Stack<String> body) { //constructor simple
		this.args = args;
		this.body = body;
	}
	public Stack<String> getBody() { // getter del body 
		return body;
	}

	public void setBody(Stack<String> body) { // setter del body 
		this.body = body;
	}

	public Stack<String> getArgs() { // getter del args
		return args;
	}

	public void setArgs(Stack<String> args) { // setter del args
		this.args = args;
	}

	@Override
	public String toString() {
		return "Function {args=" + args.toString() + ", body=" + body.toString() + "}"; //devuelve la funcion 
	}

}
