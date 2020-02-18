
public class recurse {
	
	public static void main(String[] args){
		
		private static int factorial(int n){
			
			int retValue;
			
			System.out.println(indent + "Enter factorial " + n);
			indent = indent + " ";
			
			if(n == 0)
				return 1;
			else
				retValue = (n * factorial (n - 1));
			indent = indent.substring(2);
			System.out.println(indent + "Return " + retValue);
			
		}
		
	}

}
