package queues;

public class ArrayBndQueue<T> implements BoundedQueueInterface<T> {
	
	protected final int DEFCAP = 100;  //default capacity
	protected T[] queue;  //array that holds queue elements
	protected int numElements = 0;  //number of elements in queue
	protected int front = 0;  //index of front of queue
	protected int rear;  //index of rear of queue
	
	public ArrayBndQueue(){
		queue = (T[]) new Object[DEFCAP];
		rear = DEFCAP - 1;
	}
	
	public ArrayBndQueue(int maxSize){
		queue = (T[]) new Object[maxSize];
		rear = maxSize - 1;
	}
	
	public void enqueue(T element){
		//throws queueoverflowexception if this queue is full
		//otherwise adds element to rear of this queue
		if(isFull())
			throw new QueueOverflowException("Enqueue attempted on a full queue.");
		else{
			rear = (rear + 1) % queue.length;
			queue[rear] = element;
			numElements = numElements + 1;
		}
		}
		
		public T dequeue(){
			//throws queueunderflowexception if this queue is empty
			//otherwise, removes front element from this queue and returns it
			if(isEmpty())
				throw new QueueUnderflowException("Dequeue attempted on empty queue.");
			else{
				T toReturn = queue[front];
				queue[front] = null;
				front = (front + 1) % queue.length;
				numElements = numElements - 1;
				return toReturn;
				
			}
		}
		
		public boolean isEmpty(){
			//returns trueif queue is empty, otherwise false
		return(numElements == 0);
		}
		
		public boolean isFull(){
			//returns true if queue is full, otherwisefalse
			return(numElements == queue.length);
		}

	
	
	
}
