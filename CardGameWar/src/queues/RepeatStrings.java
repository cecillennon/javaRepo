package queues;

import java.util.Scanner;

public class RepeatStrings {
	
	public static void main(String[] args){
		
		Scanner conIn = new Scanner(System.in);
		
		BoundedQueueInterface<String> queue;
		queue = new ArrayBndQueue<String>(3);
		
		String line;
		
		for(int i = 0; i <= 3; i++){
			System.out.println("Enter a line of text > ");
			line = conIn.nextLine();
			queue.enqueue(line);
		}
		
		System.out.println("\nOrder{ is: \n");
		while(!queue.isEmpty()){
			line = queue.dequeue();
			System.out.println(line);
		}
		
	}

}
