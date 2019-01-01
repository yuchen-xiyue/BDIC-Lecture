package dataType;

public class NodeStack implements Stack {
	private int size = 0;
	private Node top;
	public class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
		}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size == 0)
			return true;
		else
			return false;
	}

	@Override
	public Object top() {
		// TODO Auto-generated method stub
		return (int)(top.next.data);
	}

	@Override
	public void push(Object obj) {
		// TODO Auto-generated method stub
		Node node = new Node((int)obj);
		if(top.next == null) {
			top.next = node;
		}
		
		else {
			node.next = top.next;
			top.next = node;
		}
		
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		int value = top.next.data;
		top = top.next;
		return value;
	}

}
