package dataType;

public class ArrayStack implements Stack {
	
	private int[] values;
	private int maxSize = 0;
	private int top = 0;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return maxSize;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(top == 0)
			return true;
		else
			return false;
	}

	@Override
	public Object top() {
		// TODO Auto-generated method stub
		return values[top - 1];
	}

	@Override
	public void push(Object obj) {
		// TODO Auto-generated method stub
		values[top] = (int)obj;
		top ++;
		
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		top --;
		return values[top];
	}

}
