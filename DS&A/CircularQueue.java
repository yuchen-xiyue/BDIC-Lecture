interface QueueInterface {
	
	int size();
	
	boolean isEmpty();
	
	void enqueue(int data);
	
	int dequeue();
	
	int front();

}


public class CircularQueue implements QueueInterface{
	private int MaxSize;
	private int[] values;
	private int front;
	private int rear;
	private int size;
	CircularQueue(int MaxSize) {
		this.MaxSize = MaxSize;
		values = new int[MaxSize];
		front = 0;
		rear = 0;
		size = 0;
	}

	public void enqueue(int data) {
		if(this.size() >= MaxSize)
			System.out.println("OutOfBoundary");
		else {
			values[rear] = data;
			rear = (rear + 1)%MaxSize;
			size = size + 1;
		}
	}

	public int dequeue() {
		int temp = values[front];
		front = (front + 1)%MaxSize;
		size = size - 1;
		return temp;
	}

	public int front() {
		return values[front];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if(this.size() == 0)
			return true;
		else
			return false;
	}

	public String toString() {
		String string = "  Queue: ";
		for(int i = front; i != rear; i = (i + 1)%MaxSize) {
			string = string + values[i] +"   ";
		}
		return string;
	}
	
	
	static void QueueChecker(CircularQueue queue) {
		int error = 0;
		int[] testData = new int[10];
		
		for(int i = 0; i < testData.length; i++) {//Random test data
			testData[i] = (int) (Math.random()*10);
		}
		
		for(int i = 0; i < testData.length; i ++) {
			queue.enqueue(testData[i]);
			System.out.println("enqueue " + testData[i] +queue.toString());
			
		}
		
		for(int i = 0; i < testData.length; i ++) {
			if(testData[i] != queue.front()) {
				System.out.println(i + "Exception0");
				error ++;
			}
			if(testData[i] != queue.dequeue()) {
				System.out.println(i + "Exception1");
				error ++;
			}
			System.out.println("dequeue " + testData[i] +queue.toString());
			
		}
		
		if(!queue.isEmpty()) {
			System.out.println("Exception2");
			error ++;
		}
		if(error!=0)
			System.out.println("You have "+error+" error(s) in this Queue.");
		if(error==0)
			System.out.println("Successfully processed.");
	}
	
	public static void main(String[] arg) {
		CircularQueue circularQueue = new CircularQueue(11);
		
		QueueChecker(circularQueue);
	}
}

