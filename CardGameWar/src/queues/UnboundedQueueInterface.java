package queues;

public interface UnboundedQueueInterface<T> extends QueueInterface<T> {
	
	void enqueue(T element);
	//adds element to the rear of this queue

}
