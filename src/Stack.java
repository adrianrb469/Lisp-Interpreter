import java.util.ArrayList;

public class Stack<T> implements IStack<T> {

	private ArrayList<T> coreList;
	
	public Stack() {
		coreList = new ArrayList<T>();
	}
	
	public String state() {
		
		return coreList.toString();
		
	}
	
	@Override
	public void push(T value) {		
		coreList.add(0, value);
	}

	@Override
	public T pop() {
		return coreList.remove(0);
	}

	@Override
	public T peek() {
		return coreList.get(0);
	}

	@Override
	public int count() {
		return coreList.size();
	}

	@Override
	public boolean isEmpty() {		
		return coreList.isEmpty();
	}
	
	public String toString() {
		return coreList.toString();
	}

}
