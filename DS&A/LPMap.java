
public class LPMap {
	private Entry[] array;
	private int size;
	private final Entry AVAILABLE = new Entry(0, 0);

	public LPMap(int size) {
		array = new Entry[size];
		this.size = 0;
	}

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

	public int hashFunction(int k) {
		return (k % array.length);
	}

	public int find(int k) {
		int i = hashFunction(k);
		int p = 0;

		while (p != array.length) {
			Entry c = array[i];

			if (c == null)
				return -1;

			else if (c.key() == k) {
				return i;
			}

			else {
				i = (i + 1) % array.length;
				p++;
			}

		}
		return -1;
	}
	
	public Object get(int k) {
		int i = hashFunction(k);
		int p = 0;

		while (p != array.length) {
			Entry c = array[i];

			if (c == null)
				return null;

			else if (c.key() == k) {
				return c.value();
			}

			else {
				i = (i + 1) % array.length;
				p++;
			}

		}
		return null;
	}

	public Object put(int k, Object v) {
		int h = hashFunction(k);
		int p = 0;
		int available = -1;

		while (p < array.length) {
			Entry e = array[h];
			if (e == null) {
				if (available > -1) {
					array[available] = new Entry(k, v);
					size = size + 1;
				}

				else {
					array[h] = new Entry(k, v);
					size = size + 1;
				}

				return null;
			}

			if (e == AVAILABLE && available == -1)
				available = h;
			else if (e.key() == k) {
				Object temp = e.value();
				array[h] = new Entry(k, v);
				return temp;
			}

			h = (h + 1) % array.length;
			p = p + 1;
		}
		if (available > -1 && array[available] != AVAILABLE) {
			array[available] = new Entry(k, v);
			size = size + 1;
		}
			return null;
	}
	
	public Object remove(int k) {
		int h = hashFunction(k);
		int p = 0;
		
		while(p < array.length) {
			Entry e = array[h];
			
			if(e == null) 
				return null;
			if(e.key() == k) {
				Object temp = e.value();
				array[h] = AVAILABLE;
				size = size - 1;
				return temp;
			}

			h = (h + 1) % array.length;
			p = p + 1;
		}
		
		return null;
	}

}
