//design a program to calculate the rms current I, the real
//power P, reactive power Q, apparent power S, power factor PF
//of the load


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Power 
{
	public static void main(String[] args) throws IOException
	{
		//declare constants
		final double CONV = Math.PI / 180;
		
		//declare variables
		double amps;  // current in the load (A)
		double p;  //real power of load (W)
		double pf;  //power factor of load
		double q;  //reactive power of the load (VA)
		double s;  //apparent power of the load (VAR)
		double theta; //impedance angle of the load (deg)
		double volts;  //Rms voltage of the power source (V)
		double z;  //magnitude of the load of impedance(ohms)
		String str;
		
		//create buffered reader
		BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
		
		//prompt user for the rms voltage
		System.out.print("Enter the rms voltage of the source: ");
		str = in1.readLine();
		volts = Double.parseDouble(str);
		
		//prompt user for the magnitude of impedance
		System.out.print("Enter magnitude of impedance (ohms): ");
		str = in1.readLine();
		z = Double.parseDouble(str);
		
		//prompt user for angle of impedance
		System.out.print("Enter the angle of impedance (deg): ");
		str = in1.readLine();
		theta = Double.parseDouble(str);
		
		//perform calculations
		amps = volts / z;  //Rms current
		p = volts * amps * Math.cos(theta * CONV);  //real power
		q = volts * amps * Math.sin(theta * CONV);  //reactive power
		s = volts *amps;  //apparent power
		pf = Math.cos(theta * CONV);  //power factor
		
		//write out the results
		System.out.println("Voltage = " + volts + " volts");
		System.out.println("Impedance = " + z + " ohms at " + theta + " degrees");
		System.out.println("Voltage = " + volts + " volts");
		System.out.println("Current = " + amps + " amps");
		System.out.println("Real Power = " + p + " W");
		System.out.println("Reactive Power = " + q + " VAR");
		System.out.println("Apparent Power = " + s + " VA");
		System.out.println("Power Factor = " + pf);
	}
}
