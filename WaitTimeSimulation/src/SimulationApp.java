import queues.*;
import support.*;

import java.util.*;

public class SimulationApp {
	
	public static void main(String[] args){
		
		Scanner conIn = new Scanner(System.in);
		
		int minIAT;  //minimum inter-arrival time
		int maxIAT;  //max inter-arrival time
		int minST;  //min service time
		int maxST;  //max service time
		int numQueues;  //number of queues
		int numCust;  //number of customers
		
		String skip;  //skip end of line after reading an integer
		String more = null;  //used to skip or continue processing
		
		//get customer information
		System.out.println("Enter minimum inter-arrival time: ");
		minIAT = conIn.nextInt();
		System.out.println("Enter maximum inter-arrival time: ");
		maxIAT = conIn.nextInt();
		System.out.println("Enter minimum service time: ");
		minST = conIn.nextInt();
		System.out.println("Enter maximum service time: ");
		maxST = conIn.nextInt();
		
		//create object to perform simlaiton
		Simulation sim = new Simulation(minIAT, maxIAT, minST, maxST);
		
		do{
			//get next simulation instance to proceed
			System.out.println("Enter number of queues: ");
			numQueues = conIn.nextInt();
			System.out.println("Enter number of customers: ");
			numCust = conIn.nextInt();
			skip = conIn.nextLine();  //skip end of line
			
			//run simulation and output average waiting time
			sim.simulate(numQueues, numCust);
			System.out.println("Average waiting time is " + sim.getAvgWaitTime());
			
			//determine if there is another simulaiton instance to process
			System.out.println("Want to run another simulaiton? (Y = Yes): ");
			more = conIn.nextLine();
			System.out.println();
		}
		while(more.equalsIgnoreCase("y"));
		
		System.out.println("Program completed!");
			
			
		}
		
	

}
