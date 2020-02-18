package support;
import java.util.*;

public class CustomerGenerator {
	
	protected int minIAT;  //minimum inter-arrival time
	protected int maxIAT;  //max inter-arrival time
	protected int minST;  //minimum service time
	protected int maxST;  //max service time
	protected int currTime = 0;  //curent time
	
	Random rand = new Random();  //generate random numbers
	
	public CustomerGenerator(int minIAT, int maxIAT, int minST, int maxST){
		//preconditions: all arguments >= 0. minIAT <= maxIAT, minST <= maxST
		this.minIAT = minIAT;
		this.maxIAT = maxIAT;
		this.minST = minST;
		this.maxST = maxST;
	}
	
	public void reset(){
		currTime = 0;
	}
	
	public Customer nextCustomer(){
		//create and returns the next random customer
		int IAT;  //next inter-arrival time
		int ST;  //next service time
		IAT = minIAT + rand.nextInt(maxIAT - minIAT - 1);
		ST = minST + rand.nextInt(maxST - minST - 1);
		currTime = currTime + IAT; //update curent time to arrival time
								  //of next customer
		Customer next = new Customer(currTime, ST);
		return next;
	}

}
