/************************************************************************
* Name: Charles Rummel                                               CSC 173
* Date: 10/23/2015                                             MP 3
*************************************************************************
* Statement: Approximate the integral of 1/(1+x^2) from a to b
* Specifications:
* Input - a and b, the limits of integration and n, the number of panels
* Output - message indicating method used (trapezoid or simpson)
*        - approximation to the integral
*        - relative error
************************************************************************/

import java.util.Scanner;                      // input methods

public class mp3
{
   public static void main(String[] args)
   {

  // all variables must be declared
   int n;
   double a = 0, b = 0;
   
   Scanner console = new Scanner(System.in);

   // 1) prompt and read left hand limit of integration

   // 2) prompt and read left hand limit of integration

   // 3) calculate known result for error analysis

   // 4) prompt and read the number of panels
   System.out.printf("Enter the number of panels ");
   n = console.nextInt();;

   // 5) determine panel width

   // 6) test parity
   if (n % 2 == 0)
     {
      // 7) display method
      System.out.printf("Using Simpson's method%n");
      // 8) initialize reduction to 0

      // 9) odd interior points

        // 10) increase odd sum by y

      // 11) even interior points

        //12) increase even sum by y

      // 13) calculate sum for Simpson

     }
     else
     {
      // 14) display method
      System.out.printf("Using Trapezoid%n ");

      // 15) initialize reduction at end points
      // 16) loop over all interior points

      // 17) increase sum by y

    // 18) factor in deltax

   }

 // 19) display result and error analysis

 }
}
