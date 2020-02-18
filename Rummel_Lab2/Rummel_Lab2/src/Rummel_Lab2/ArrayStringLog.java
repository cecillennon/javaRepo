package Rummel_Lab2;

public class ArrayStringLog implements StringLogInterface 
{
	protected String name;  //name of this log
	protected String[] log;  //array that holds log strings
	protected int lastIndex = -1; //index of last string in array
	
	public ArrayStringLog(String name, int maxSize)
	//precondition: max size > 0
	//
	//instantiates and returns reference to an empty ArrayStringLog
	//object with name "name" and room for maxSize strings
	{
		log = new String[maxSize];
		this.name = name;
	}
	
	public ArrayStringLog(String name)
	//instantiates and returns reference to an empty stringarraylog
	//object with name "name" and room for 100 strings
	{
		log = new String[100];
		this.name = name;
			
	}
	
	public void insert(String element)
	//precondition: this stringlog is not full
	//
	//places element into this stringlog
	{
		lastIndex++;
		log[lastIndex] = element;
	}
	
	public void clear()
	//makes this stringlog empty
	{
		for( int i = 0; i <= lastIndex; i++)
			log[i] = null;
		lastIndex= -1;
	}
	
	public boolean isFull()
	//returns true if this stringlog is full, otherwise returns false
	{
		if(lastIndex == (log.length - 1))
			return true;
		else
			return false;
	}
	
	public int size()
	//returns the number of strings in this stringlog
	{
		return (lastIndex + 1);
	}
	
	public String getName()
	//Returns name of this stringlog
	{
		return name;
	}
	
	public String toString()
	//returns nicely formatted string representing this stringlog
	{
		String logString = "Log: " + name + "\n\n";
		
		for(int i = 0; i <= lastIndex; i++)
			logString = logString + (i + 1) + ". " + log[i] + "\n";
		
		return logString;
	}
	
	public boolean contains(String element)
	//return true if element is in this stringlog
	//otherwise return false
	//ignore case difference when doing string comparisons
	{
		int location = 0;
		
		while(location <= lastIndex)
		{
			if(element.equalsIgnoreCase(log[location]))  //if theymatch
				return true;
			else
				location++;
		}
		return false;
		
		}

	
	}
			

