import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stats {
	
	public static void main(String[] args)throws IOException{
		
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
		System.out.println("Enter first value: ");
		str = in1.readLine();
		x = Double.parseDouble(str);
		
		//while loop to accumulate input values
		while(x >= 0){
			//accumulate sums
			++n;
			sumX += x;
			sumX2 += x * x;
			
			//read next value
			System.out.println("Enter next value: ");
			str = in1.readLine();
			x = Double.parseDouble(str);
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


