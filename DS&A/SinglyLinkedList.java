interface Position {
	public int element();
}

interface List {
	public Position first();
	public Position last();
	public Position before(Position p);
	public Position after(Position p);
	public Position insertBefore(Position p, int d);
	public Position insertAfter(Position p, int d);
	public Position insertFirst(int d);
	public Position insertLast(int d);
	public int remove(Position p);
	public int size();
	public boolean isEmpty();

}

class test {
	
	public static void tester(SinglyLinkedList singlyLinkedList) {
		Position p;
		p = singlyLinkedList.insertFirst(0);
		singlyLinkedList.print("insertFirst(0):   ");
		
		System.out.print("delete "+singlyLinkedList.remove(p)+ " is:    ");
		singlyLinkedList.print("  ");
		
		singlyLinkedList.insertFirst(1);
		singlyLinkedList.print("insertFirst(1):   ");
		p = singlyLinkedList.insertLast(2);
		singlyLinkedList.print("insertLast(2):    ");
		
		singlyLinkedList.insertAfter(p, 3);
		singlyLinkedList.print("insertAfter(2,3): ");
		singlyLinkedList.insertBefore(p, 4);
		singlyLinkedList.print("insertBefore(2,4):");
		
		System.out.print("before "+p.element()+ " is ");
		p = singlyLinkedList.before(p);
		singlyLinkedList.print(p.element()+":    ");
		System.out.print("before "+p.element()+ " is ");
		p = singlyLinkedList.before(p);
		singlyLinkedList.print(p.element()+":    ");
		System.out.print("after "+p.element()+ " is ");
		p = singlyLinkedList.after(p);
		singlyLinkedList.print(p.element()+":     ");

		System.out.print("delete "+singlyLinkedList.remove(p)+ " is:    ");
		singlyLinkedList.print("  ");
		
		
	}
}

public class SinglyLinkedList implements List {
	private Node first;
	private int size;
	
	public SinglyLinkedList() {
		size = 0;
	}
	
	class Node implements Position {
		private int element;
		Node next;
		
		public Node(int element) {
			this.element = element;
		}
		@Override
		public int element() {
			return element;
		}
		
	}
	@Override
	public Position first() {
		if(isEmpty())
			return null;
		return first;
	}

	@Override
	public Position last() {
		if(isEmpty())
			return null;
		Node last = first;
		while(last.next != null) 
			last = last.next;
		return last;
	}

	@Override
	public Position before(Position p) {
		if(isEmpty() || p == first)
			return null;
		Node before = first;
		while(before.next != null && p != before.next) 
			before = before.next;
		return before;
	}

	@Override
	public Position after(Position p) {
		if(p == last())
			return null;
		Node after = ((Node)p).next;
		return after;
	}

	@Override
	public Position insertBefore(Position p, int d) {
		Node insert = new Node(d);
		if(isEmpty() || p == first) {
			first = insert;
			insert.next = (Node)p;
		}
		else {
			((Node)before(p)).next = insert;
			insert.next = (Node)p;
		}
		
		size = size + 1;
		return insert;
	}

	@Override
	public Position insertAfter(Position p, int d) {
		Node insert = new Node(d);
		if(((Node)p).next == null) {
			((Node)p).next = insert;
		}
		else {
			insert.next = ((Node)p).next;
			((Node)p).next = insert;
		}

		size = size + 1;
		return insert;
	}

	@Override
	public Position insertFirst(int d) {
		Node insert = new Node(d);
		if(isEmpty()) {
			first = insert;
		}
		
		else {
			insert.next = first;
			first = insert;
		}

		size = size + 1;
		return insert;
	}

	@Override
	public Position insertLast(int d) {
		Node insert = new Node(d);
		if(isEmpty()) {
			first = insert;
		}
		
		else {
			((Node)last()).next = insert;
		}

		size = size + 1;
		return insert;
	}

	@Override
	public int remove(Position p) {
		int value = p.element();
		if(p == first()) {
			first = ((Node)p).next;
		}
		else if(p == last()) {
			((Node)last()).next = null;
		}
		else {
			((Node)before(p)).next = ((Node)p).next;
		}
		
		size = size - 1;
		return value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	public void print(String string) {
		Node current = first;
		System.out.print(string);
		for(int i = 0; i < size; i ++) {
			System.out.print("  " +current.element());
			current = current.next;
		}
		System.out.println("\n	Size: "+ this.size() + "  empty: " + this.isEmpty() + "\n");
	}
	
	public static void main(String[] arg) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		test.tester(singlyLinkedList);
	}
}
