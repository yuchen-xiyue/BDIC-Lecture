import java.util.Iterator;

interface Map {
	public int size();

	public boolean isEmpty();

	public Object get(int k);

	public Object put(int k, Object v);

	public Object remove(int k);

	public Iterator entries();
}

public class ListMap implements Map {
	private DLList list;
	public class Entry {
		private int key;
		private Object value;

		public Entry(int k, Object v) {
			key = k;
			value = v;
		}

		public int key() {
			return key;
		}

		public Object value() {
			return value;
		}
	}
	
	public ListMap() {
		list = new DLList();
	}

	public Position find(int k) {
		Position p = list.first();
		for(int i = 0; i < list.size(); i ++) {
			if(((Entry)(p.element())).key == k) {
				return p;
				
			}
			
			p = list.after(p);
			
		}
		
		return null;
	}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Object get(int k) {
		Position p = find(k);
		if(p == null) {
			return null;
		}
		else {
			return ((Entry)p.element()).value();
		}
	}

	@Override
	public Object put(int k, Object v) {
		Position p = find(k);
		Entry e = new Entry(k, v);
		if(p == null) {
			list.insertLast(new Entry(k, v));
			p = list.last();
		}
		
		else {
			list.insertAfter(p, e);
			list.remove(p);
			p = list.after(p);
		}
		return ((Entry)p.element()).value();
	}

	@Override
	public Object remove(int k) {
		Position p = find(k);
		if(p == null) {
			return null;
		}
		else {
			list.remove(p);
			return ((Entry)p.element()).value();
		}
	}

	@Override
	public Iterator entries() {
		return (Iterator)list;
	}
	
	public void print() {
		Position p = list.first();
		for(int i = 0; i < list.size(); i ++) {
			System.out.println("key: " + ((Entry)p.element()).key + "  value: " + ((Entry)p.element()).value);
			p = list.after(p);
		}
		
		System.out.println("");
	}

	
	
	public static void main(String[]args) {
		ListMap lstmp = new ListMap();
			lstmp.put(0, new Integer(0));
			lstmp.print();
			
			lstmp.put(1, new String("one"));
			lstmp.put(2, new Character((char) 50));
			lstmp.put(65545, new String("Maximum"));
			lstmp.print();
			
			lstmp.remove(1);
			lstmp.print();
			
			System.out.println("get(65545): " + lstmp.get(65545));
			
			lstmp.put(2, new String("Replaced"));
			lstmp.print();
			System.out.println("get(2): " + lstmp.get(2));
	}
}
