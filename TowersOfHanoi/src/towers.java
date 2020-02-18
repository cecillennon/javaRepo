import java.util.Scanner;

public class towers {
	
	private static String indent = ""; //indentation of tracers
	
	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		Scanner conIn = new Scanner(System.in);
		
		//number of rings on starting peg
		int n;
		System.out.print("Input the number of rings: ");
		if(conIn.hasNextInt())
			n = conIn.nextInt();
		else{
			System.out.println("Error: you must enter an integer.");
			System.out.println("Terminating program.");
			return;
		}
		
		System.out.println("Towers of Hanoi with " + n + "rings\n");
		doTowers(n, 1, 2, 3);
	}
	
	public static void doTowers(int n, int startPeg, int auxPeg, int endPeg){
		
			if(n > 0){
				indent = indent + " ";
				
				
				
				System.out.println(indent + "Get ring " + n + " moved from peg " + startPeg
												+ " to peg " + endPeg);
				//move n-1 rings from starting peg to aux peg
				doTowers(n - 1, startPeg, endPeg, auxPeg);
				
				//move nth ring from starting peg to end peg
				System.out.println(indent + "Move ring " + n + " from peg " + startPeg
										+ " to peg " + endPeg);
				
				//move n-1 rings from auxiliary peg to ending peg
				doTowers(n - 1, auxPeg, startPeg, endPeg);
				
				indent = indent.substring(1);		

			}
	}

}
