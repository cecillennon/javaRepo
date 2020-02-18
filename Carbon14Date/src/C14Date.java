//to calculate the age of an organic sample from the percentage
//of the original carbon 14 remaining in the sample


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class C14Date 
{
	public static void main(String[] args) throws IOException
	{
		//declare constants
		final double LAMDA = 0.00012097;  //C14 decay constant (1/year)
		
		//declare variables
		double age;  //age of the sample (years)
		double percent;  //percentage of carbon 14 remaining
		double ratio;  //ratio of the C-14 remaining at the time
					   //of the measurement to the original amount
					  //of C-14
		String str;  //input string
		
		//create buffered reader
		BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
		
		//prompt user for the percentage of C-14 remaining
		System.out.print("Enter the percentage of Carbon 14 remaining: ");
		str = in1.readLine();
		percent = Double.parseDouble(str);
		
		//perform calculations
		ratio = percent / 100;  //convert to ratio
		age = (-1.0 / LAMDA) * Math.log(ratio);  //get age in years
		
		//tell the user about the age of the sample
		System.out.println("The age of thesample is " + age + " years.");
	}

}
