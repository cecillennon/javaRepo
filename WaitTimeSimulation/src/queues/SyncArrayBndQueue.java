package queues;

public class SyncArrayBndQueue<T> implements BoundedQueueInterface<T> {
	
	protected final int DEFCAP = 100;  //default capacity
	protected T[] queue;  //array that holds queue elemtns
	protected int numElements = 0;  //number of elements in the queue
	protected int front = 0;  //index of front of queue
	protected int rear;  //index of rear of queue
	
	@SuppressWarnings("unchecked")
	public SyncArrayBndQueue(){
		
		queue = (T[]) new Object[DEFCAP];
		rear = DEFCAP - 1;
	}
	
	@SuppressWarnings("unchecked")
	public SyncArrayBndQueue(int maxSize){
		
		queue = (T[]) new Object[maxSize];
		rear = maxSize - 1;
	}
	
	public synchronized void enqueue(T element){
		//throws queueoverflowexception if this queue is full
		//othrwise adds element to rear of this queue
		if(isFull())
			throw new QueueOverflowException("Enqueue attempted on a full queue.");
		else{
			rear = (rear + 1) % queue.length;
			queue[rear] = element;
			numElements = numElements + 1;
		}
	}
		
		public synchronized T dequeue(){
			//throws queueunderflowexception if this queue is empty
			//otherwise it removes element from front and returns it
			if(isEmpty())
				throw new QueueUnderflowException("Dequeue attempted on an empty queue.");
			else{
				T toReturn = queue[front];
				queue[front] = null;
				front = (front + 1) % queue.length;
				numElements = numElements - 1;
				return toReturn;
			}
		
	}
		
		public synchronized boolean isEmpty(){
			//returns true if this queue is empty
			//otherwise it returns false
			return (numElements == 0);
		}
		
		public synchronized boolean isFull(){
			//returns true if this queue is full
			//otherwise returns false
			return(numElements == queue.length);
		}

}

