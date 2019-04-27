class Calculate {
	
	/* Returns the Max product of Sub Array
	 * Taken Assumption sub array product always positive.
	 * With initial Value of product as 1.
	 *  */
	public int maxProductOfSubarry(int[] array) {
		
		int len = array.length; //Calculate Size of Array.
		int maxProd = 1; //End Max product result of continuous Sub Array
		int currentMax = 1; // Max positive product at current position
		int currentMin = 1; // Min Negative product at current position
		
		/* Traverse the Array.
        currentMax default is always 1.
        CurrentMax to be calculated as positive product with array[i] or will be 1.
        CurrentMin to be calculated as negative product with array[i] or will be 1.
        */
		 for (int i = 0; i < len; i++) 
	        { 
	            /* If array[i] is positive, store currentMax. */ 
	           	/* currentMin will be only updated if its negative */
	            if (array[i] > 0) 
	            { 
	            	currentMax = currentMax * array[i]; 
	            	currentMin = minNumber (currentMin * array[i], 1); 
	            } 
	  
	            /* If array[i] is 0. Bring CurrentMax and CurrentMin to default value
	             * as 1. Because product of array Continues it doesn't end.
	             * Array can be defined after 0 also.
	               Output is always greater than or equal to 1. */
	            else if (array[i] == 0) 
	            { 
	            	currentMax = 1; 
	            	currentMin = 1; 
	            } 
	  
	            /* If array[i] is negative.
	               currentMax can either be 1 or positive. 
	               currentMin can either be 1 or negative. 
	               So, currentMin will always be previous currentMax multiplied by array[i]. 
	                currentMax will be 1 or 
	                currentMin(if negative) * array[i] will give larger positive product.
	                */
	            else
	            { 
	                int prevMax = currentMax; 
	                currentMax = maxNumber(currentMin * array[i], 1); 
	                currentMin = prevMax * array[i]; 
	            } 
	  
	            // Max product Check 
	            if (maxProd <  currentMax) 
	            	maxProd  =  currentMax; 
	        } 
	  
	        return maxProd;
	}
	
	//To calculate maximum of two numbers
	public int maxNumber(int a, int b) {
		return a > b ? a : b;
	}
	
	//To calculate minimum of two numbers
	public int minNumber(int a, int b) {
		return a < b ? a : b;
	}
	
}
public class ContinousProductSubarray {
	
	public static void main(String[] args) {
		//int array[] = {5, 7, 9, 8, -9, 6, 8, 4};
		//int array[] = {5, 7, -5, 0, 6, 7, -4, 0, 2, -2, -3, 1};
		int array[] = {7, -9, 2, -1};
		Calculate cal = new Calculate();
        System.out.println("Maximum Sub array product is "+ cal.maxProductOfSubarry(array));
	}

}
