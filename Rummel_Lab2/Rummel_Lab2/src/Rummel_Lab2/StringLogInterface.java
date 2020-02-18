package Rummel_Lab2;

public interface StringLogInterface 
{
	void insert(String element);
	//precondition : this stringlog is not full
	//
	//places element into this stringlog
	
	boolean isFull();
	//returns true f stringlog is full. otherwise returns false
	
	int size();
	//returns number of elements in stringlog
	
	boolean contains(String element);
	//returns true if element is in the stringlog
	//otherwise returns false
	//ignores case differences when doing string comparison
	
	void clear();
	//makes this stringlog empty
	
	String getName();
	//return name of the stgringlog
	
	String toString();
	//returns nicely formatted string representing all the contents of stringlog

}
