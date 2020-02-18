public class Date
{
    protected int year;
    protected int month;
    protected int day;
    public static final int MINYEAR = 1582;
    
    //constructor
    public Date(int newMonth, int newDay, int newYear)
    {
        month = newMonth;
        day = newDay;
        year = newYear;
    }
    
    //observers
    public int getYear()
    {
        return year;
    }
    
    public int getMonth()
    {
        return month;
    }
    
    public int getDay()
    {
        return day;
    }
    
    /*public Date(int newMonth, int newDay, int newYear) throws DateOutOfBoundsException
    {
    	if((newMonth <= 0 || newMonth >= 12))
    		throw new DateOutOfBoundsException("month" + newMonth + "is out of range");
    	else 
    		month = newMonth;
    	
    	day = newDay;
    	
    	if (newYear < MINYEAR)
    		throw new DateOutOfBoundsException("year" + newYear + " is too early");
    	else
    		year = newYear;
    }
    */
   public int lilian()
    {
        /*computes number of days between 1/1/0 and this date as if no calendar reform
           took place, then subtracts 578100 so that 10/15/1582 is day 1 */
        
    //number of calculated days from 1/1/0 to 10/14/1582
    final int SUBDAYS = 578100;
        
    int numDays = 0;
        
    //add days in years
    numDays = year * 365;
        
    //add days in months
       if(month <= 2)
         numDays = numDays + (month-1) * 31;
       else
         numDays = numDays + ((month - 1) * 31) - ((4 * (month-1) + 27) / 10);
        
            
    //add days in the days
    numDays = numDays + day;
            
    //take care of leap years
    numDays = numDays + (year/4) - (year / 100) + (year / 400);
            
    //handle special case of leap year but not yet leap day
       if(month < 3)
        {
           if((year % 4) == 0) numDays = numDays - 1;
           if((year % 100) == 0) numDays = numDays + 1;
           if((year % 400) == 0) numDays = numDays - 1;
         }
            
    //subtract extra days up to 10/14/1582
    numDays = numDays - SUBDAYS;
        return numDays;
    }    
     public String toString()
    {
        return(month + "/" + day + "/" + year);
    }
  }
   