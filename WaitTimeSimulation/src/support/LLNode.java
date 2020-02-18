package support;


public class LLNode<T> {
	private LLNode link;
	private T info;
	
	public LLNode(T info){
		this.info = info;
		link = null;
	}
	
	public void setInfo(T info){
		//sets info of this node
		this.info = info;
	}
	
	public T getInfo(){
		//returns info of this llnode
		return info;
	}
	
	public void setLink(LLNode link){
		//sets link of this node
		this.link = link;
	}
	
	public LLNode getLink(){
		//returns link of this node
		return link;
	}
	
	

}
