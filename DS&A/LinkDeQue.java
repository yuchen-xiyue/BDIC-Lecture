class EmptyDequeException extends RuntimeException {
}

interface Deque {
	public void addFirst(Object o);

	public void addLast(Object o);

	public Object removeFirst() throws EmptyDequeException;

	public Object removeLast() throws EmptyDequeException;

	public Object getFirst() throws EmptyDequeException;

	public Object getLast() throws EmptyDequeException;

	public int size();

	public boolean isEmpty();
}

class Test{
	public static void test(LinkDeQue linkDeQue) {
		linkDeQue.addFirst(0);
		linkDeQue.addLast(1);
		System.out.println(linkDeQue.getFirst());
		System.out.println(linkDeQue.getLast());
		System.out.println(linkDeQue.isEmpty());
		System.out.println(linkDeQue.size());
		linkDeQue.removeFirst();
		System.out.println(linkDeQue.isEmpty());
		System.out.println(linkDeQue.size());
		linkDeQue.removeLast();
		System.out.println(linkDeQue.isEmpty());
		System.out.println(linkDeQue.size());
	}
}
public class LinkDeQue implements Deque {
	private Node first;
	private Node last;
	private int size;

	public class Node implements Position {
		private Object element;
		Node next;
		Node previous;

		public Node(Object e) {
			this.element = e;
		}

		public Object element() {
			return element;
		}
	}

	@Override
	public void addFirst(Object o) {
		// TODO Auto-generated method stub
		Node insert = new Node(o);
		if (isEmpty()) {
			first = insert;
			last = insert;
		}

		else {
			first.previous = insert;
			insert.next = first;
			first = insert;
		}

		size = size + 1;

	}

	@Override
	public void addLast(Object o) {
		// TODO Auto-generated method stub
		Node insert = new Node(o);
		if (isEmpty()) {
			first = insert;
			last = insert;
		}

		else {
			insert.previous = last;
			last.next = insert;
			last = insert;
		}

		size = size + 1;
	}

	@Override
	public Object removeFirst() throws EmptyDequeException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyDequeException();
		} else if (size == 1) {
			Object value = first.element();
			first = null;
			last = null;
			size = size - 1;
			return value;
		} else {
			Object value = first.element();
			first = first.next;
			first.previous = null;
			size = size - 1;
			return value;
		}
	}

	@Override
	public Object removeLast() throws EmptyDequeException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyDequeException();
		} else if (size == 1) {
			Object value = last.element();
			first = null;
			last = null;
			size = size - 1;
			return value;
		} else {
			Object value = last.element();
			last = last.previous;
			last.next = null;
			size = size - 1;
			return value;
		}
	}

	@Override
	public Object getFirst() throws EmptyDequeException {
		// TODO Auto-generated method stub
		return first;
	}

	@Override
	public Object getLast() throws EmptyDequeException {
		// TODO Auto-generated method stub
		return last;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0)
			return true;
		else {
			return false;
		}
	}

	
	public static void main(String[]args) {
		LinkDeQue linkDeQue = new LinkDeQue();
		Test.test(linkDeQue);
	}
}
