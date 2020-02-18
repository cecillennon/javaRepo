package queues;

public interface BoundedQueueInterface<T> extends QueueInterface<T>{
	
	void enqueue(T element) throws QueueOverflowException;
	//throws queueue overflowexception if the queue is full
	//otherwise, adds element to the rear of this queue
	
	boolean isFull();
	//returns true if this queue is full,otherwise returns false

}
