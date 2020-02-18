import support.*;  //Customer/CustomerGenerator
import queues.*;

public class Simulation {
	
	final int MAXTIME = Integer.MAX_VALUE;
	
	CustomerGenerator custGen;  //a customer generator
	float avgWaitTime = 0.0f;  //average wait time for most recent simulation
	
	public Simulation(int minIAT, int maxIAT, int minST, int maxST){
		custGen = new CustomerGenerator(minIAT, maxIAT, minST, maxST);
	}
	
	public float getAvgWaitTime(){
		return avgWaitTime;
	}
	
	public void simulate(int numQueues, int numCustomers){
		//preconditions: numQueues > 0
		//               numCustomers > 0
		//               no time generated during simulation is > MAXTIME
		//Siulates numCustomers customers entering and leaving the
		//a queueing system with numQueues queues
		//
		//the queues
		@SuppressWarnings("unchecked")
		GlassQueue<Customer>[] queues = new GlassQueue[numQueues];
		
		Customer nextCust;  //next customer from generator
		Customer cust;  //holds customer for temporary use
		
		int totWaitTime = 0; //total wait time
		int custInCount = 0;  //count of customers so far
		int custOutCount = 0;  //count of customers finished so far
		
		int nextArrTime = 0;  //next arrival time
		int nextDepTime;  //next departure time
		int nextQueue;   //index of queue for next departure
		
		int shortest;  //index of shortest queue
		int shortestSize;  //size of shortest queue
		Customer rearCust;  //customer at rear of shortest queue
		int finishTime;  //calculate finish time
		
		//instantiate the queues
		for(int i = 0; i < numQueues; i++)
			queues[i] = new GlassQueue<Customer>();
		
		//set customer generator and get first customer
		custGen.reset();
		nextCust = custGen.nextCustomer();
		
		while(custOutCount < numCustomers){  //while more customers to handle
			//get next arrival time
			if(custInCount != numCustomers)
				nextArrTime = nextCust.getArrivalTime();
			else
				nextArrTime = MAXTIME;
		
		
		//get next departure time and set next queue
		nextDepTime = MAXTIME;
		nextQueue = -1;
		for(int i = 0; i < numQueues; i++)
			if(queues[i].size() != 0){
				cust = queues[i].peekFront();
				if(cust.getFinishTime() < nextDepTime){
					nextDepTime = cust.getFinishTime();
					nextQueue = i;
				}
			}
		
		if(nextArrTime < nextDepTime){
			//handle customer arriving
			//determine shortest queue
			shortest = 0;
			shortestSize = queues[0].size();
			for(int i = 1; i < numQueues; i++){
				if(queues[i].size() < shortestSize){
					shortest = i;
					shortestSize = queues[i].size();
				}
			}
			
			//determine the finish time
			if(shortestSize == 0)
				finishTime = nextCust.getArrivalTime() + nextCust.getServiceTime();
			else{
				rearCust = queues[shortest].peekRear();
				finishTime = rearCust.getFinishTime() + nextCust.getServiceTime();
			}
			
			//set finish time and enqueue customer
			nextCust.setFinishTime(finishTime);
			queues[shortest].enqueue(nextCust);
			
			custInCount = custInCount + 1;
			
			//if needed get next customer to enqueue
			if(custInCount < numCustomers)
				nextCust = custGen.nextCustomer();
		}
		else{
			//handle customer leaving
			cust = queues[nextQueue].dequeue();
			totWaitTime = totWaitTime + cust.getWaitTime();
			custOutCount = custOutCount + 1;
		}
	}//end while loop
	
	avgWaitTime = totWaitTime / (float)numCustomers;
}
}

