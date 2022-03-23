
public interface IStack<T> {

	void push(T value);
	
	T pop();
	
	T peek();
	
	int count();
	
	boolean isEmpty();
}
