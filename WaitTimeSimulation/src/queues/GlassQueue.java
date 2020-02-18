package queues;

public class GlassQueue<T> extends ArrayUnbndQueue<T> {
	
	public GlassQueue(){
		super();
	}
	
	public GlassQueue(int origCap){
		super(origCap);
	}
	
	public int size(){
		//returns number of elements in queue
		return numElements;
	}
	
	public T peekFront(){
		//returns object at the front of this queue
		//if the queue is empty returns null
		return queue[front];
	}
	
	public T peekRear(){
		//returns object at the rear of this queue
		//if the queue is empty return null
		return queue[rear];
	}

}
