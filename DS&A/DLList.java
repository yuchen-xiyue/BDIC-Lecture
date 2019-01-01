import java.awt.Point;
import java.awt.Rectangle;

interface Position {
	public Object element();
}

interface List {
	public Position first();

	public Position last();

	public Position before(Position p);

	public Position after(Position p);

	public Position insertBefore(Position p, Object d);

	public Position insertAfter(Position p, Object d);

	public Position insertFirst(Object d);

	public Position insertLast(Object d);

	public Object remove(Position p);

	public int size();

	public boolean isEmpty();

}

public class DLList implements List {
	private Node first;
	private Node last;
	private int size;

	public DLList() {
		size = 0;
	}

	public class Node implements Position {
		private Object element;
		Node pre;
		Node next;

		public Node(Object element) {
			this.element = element;
		}

		@Override
		public Object element() {
			return element;
		}
	}

	class Test {

		public void tester(DLList rectangles, DLList points) {
			Position p;

			p = rectangles.insertFirst(new Rectangle(0, 0, 1, 1));
			rectangles.print("Rectangles: ");
			rectangles.remove(p);
			rectangles.print("Rectangles: ");
			p = rectangles.insertLast(new Rectangle(0, 1, 5, 6));
			rectangles.print("Rectangles: ");
			rectangles.insertBefore(p, new Rectangle(1, 2, 7, 8));
			rectangles.print("Rectanglces: ");
			rectangles.insertAfter(p, new Rectangle(2, 3, 9, 10));
			rectangles.print("Rectangles: ");

			p = points.insertFirst(new Point(1, 1));
			points.print("Points: ");
			points.remove(p);
			points.print("Points: ");
			p = points.insertLast(new Point(0, 0));
			points.print("Points: ");
			points.insertBefore(p, new Point(2, 2));
			points.print("Points: ");
			points.insertAfter(p, new Point(3, 3));
			points.print("Points: ");

			for (Position rectangle = rectangles
					.first(); rectangle != null; rectangle = (Position) ((Node) rectangle).next) {
				for (Position point = points.first(); point != null; point = (Position) ((Node) point).next) {
					if (((Rectangle) rectangle.element()).contains((Point) point.element())) {
						System.out.println("Point " + point.element() + " in " + rectangle.element());
					} else {
						System.out.println("Point " + point.element() + " not in " + rectangle.element());
					}
				}

				System.out.println("");
			}
		}
	}

	@Override
	public Position first() {
		if (isEmpty())
			return null;
		return first;
	}

	@Override
	public Position last() {
		if (isEmpty())
			return null;
		return last;
	}

	@Override
	public Position before(Position p) {
		if (isEmpty() || p == first)
			return null;
		else
			return ((Node) p).pre;
	}

	@Override
	public Position after(Position p) {
		if (isEmpty() || p == last())
			return null;
		return ((Node) p).next;
	}

	@Override
	public Position insertBefore(Position p, Object d) {
		Node insert = new Node(d);
		if (p == first) {
			first = insert;
			insert.next = (Node) p;
			((Node) p).pre = insert;
		} else {
			insert.next = (Node) p;
			insert.pre = ((Node) p).pre;
			(insert.next).pre = insert;
			(insert.pre).next = insert;
		}

		size = size + 1;
		return insert;
	}

	@Override
	public Position insertAfter(Position p, Object d) {
		Node insert = new Node(d);
		if (((Node) p) == last) {
			last.next = insert;
			insert.pre = last;
			last = last.next;
		} else {
			insert.next = ((Node) p).next;
			insert.pre = (Node) p;
			(insert.next).pre = insert;
			(insert.pre).next = insert;
		}

		size = size + 1;
		return insert;
	}

	@Override
	public Position insertFirst(Object d) {
		Node insert = new Node(d);
		if (isEmpty()) {
			first = insert;
			last = insert;
		}

		else {
			insert.next = first;
			first = insert;
			insert.next.pre = insert;
		}

		size = size + 1;
		return insert;
	}

	@Override
	public Position insertLast(Object d) {
		Node insert = new Node(d);
		if (isEmpty()) {
			first = insert;
			last = insert;
		}

		else {
			insert.pre = ((Node) last());
			((Node) last()).next = insert;
			last = last.next;
		}

		size = size + 1;
		return insert;
	}

	@Override
	public Object remove(Position p) {
		Object value = p.element();
		if (p == first()) {
			first = ((Node) p).next;
			((Node) p).pre = null;
		} else if (p == last()) {
			last = last.pre;
			last.next = null;
		} else {
			((Node) before(p)).next = ((Node) p).next;
			((Node) p).next.pre = (Node) before(p);
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
		if (size == 0)
			return true;
		return false;
	}

	public void print(String string) {
		Node current = first;
		System.out.print(string);
		for (int i = 0; i < size; i++) {
			System.out.print("  " + current.element());
			current = current.next;
		}
		System.out.println("\n	Size: " + this.size() + "  empty: " + this.isEmpty() + "\n");
	}

	public static void main(String[] arg) {

		DLList rectangles = new DLList();
		DLList points = new DLList();
		Test test = (new DLList()).new Test();
		test.tester(rectangles, points);
	}

}
