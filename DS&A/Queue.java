package dataType;

public interface Queue {
	public void enqueue(Object element);
	
	public int deueue();
	
	public int front();
	
	public int size();
	
	public boolean isEmpty();
	
}
