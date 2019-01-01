package dataType;

public interface Stack {
	int size();
	
	boolean isEmpty();
	
	
	Object top();
	
	void push(Object obj);
	
	Object pop();
	
}
