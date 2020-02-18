package queues;
import support.*;

public class LinkedUnbndQueue<T> implements UnboundedQueueInterface<T> {
	
	protected LLNode<T> front;  //reference to the front of this queue
	protected LLNode<T> rear;  //refernce to the rear of this node
	
	public LinkedUnbndQueue(){
		
		front = null;
		rear = null;
	}
	
	public void enqueue(T element){
		//adds element to rear of queue
		LLNode<T> newNode = new LLNode<T>(element);
		if(rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
	}
	
	@SuppressWarnings("unchecked")
	public T dequeue(){
		//throws queueunderflow exception if this queue is empty
		//otherwise removes front element from this queue and returns it
		if(isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else{
			T element;
			element = front.getInfo();
			front = front.getLink();
			if(front == null)
				rear = null;
			
		return element;
	}
	}
	
	public boolean isEmpty(){
		//returns true if queue is mepty, otherwise returns false
		if(front == null)
			return true;
		else
			return false;
	}
	


}
