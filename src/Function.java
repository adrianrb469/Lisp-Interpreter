
public class Function {

	Stack<String> args = new Stack<>();
	Stack<String> body = new Stack<>();

	public Function() {

	}
	public Function(Stack<String> args, Stack<String> body) {
		this.args = args;
		this.body = body;
	}
	public Stack<String> getBody() {
		return body;
	}

	public void setBody(Stack<String> body) {
		this.body = body;
	}

	public Stack<String> getArgs() {
		return args;
	}

	public void setArgs(Stack<String> args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "Function {args=" + args.toString() + ", body=" + body.toString() + "}";
	}

}
