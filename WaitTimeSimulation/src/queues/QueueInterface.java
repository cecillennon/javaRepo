package queues;

public interface QueueInterface<T> {
	
	T dequeue() throws QueueUnderflowException;
	//throws queueunderflowexception if the queue is empty;
	//otherwise, removes front element from this queue and returns it
	
	boolean isEmpty();

}
