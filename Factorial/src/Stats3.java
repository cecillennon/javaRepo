import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stats3 {
	
	public static void main(String[] args)throws IOException{
		
		int i;  //loop index
		int n = 0;  //number of input samples
		double stdDev = 0;  //the standard deviation of the input samples
		String str;
		double sumX = 0; //sum of the input values
		double sumX2 = 0;  //the sum of the squares of input values
		double x = 0;  //input data value
		double xBar = 0; //average of the input samples
		
		//create buffered reader
		BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
		
		//get first input value
		System.out.println("Enter the number of points: ");
		str = in1.readLine();
		n = Integer.parseInt(str);
		
		//check for enough input data
		if(n < 2)
			System.out.println("Atleast 2 values must be entered!");
		else{
					
		//loop to read input values
			for(i = 1; i <= n; i++){
			//read values
		    System.out.println("Enter Number: ");
			str = in1.readLine();
			x = Double.parseDouble(str);
			
			//accumulate sums
			sumX += x;
			sumX2 += x * x;			
		}
		
		//calculate mean and standard deviation
		xBar = sumX / n;
		stdDev = Math.sqrt((n * sumX2 - sumX * sumX) / (n * (n - 1)));
		
		//tell user
		System.out.println("The mean of this data set is: " + xBar);
		System.out.println("The standard deviation is: " + stdDev);
		System.out.println("The number of data points is: " + n);
		}
	}
}


