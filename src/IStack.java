
public interface IStack<T> { // interfaz del stack

	void push(T value);
	
	T pop();
	
	T peek();
	
	int count();
	
	boolean isEmpty();
}
