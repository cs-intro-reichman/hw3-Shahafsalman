// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		
		while (x2 != 0)
		{
			x1 ++;
			x2 --;
		} 
		return x1;		// need to change the 0 
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		while (x2 != 0)
		{
			x1 --;
			x2 --;	
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int saveTimes = x1;
		while (x2 > 1)
		{
			saveTimes = plus(saveTimes, x1);
			x2--;	
		}
		return saveTimes;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int savePow = x;
		while (n > 1)
		{
			savePow = times(savePow, x);
			n--;
		}
		return savePow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 > x1)
		{
			return 0;
		}
		else
		{
			int divNum = 0;
			while ((minus(x1, x2)) >= 0)
			{
				x1 = minus(x1, x2);
				divNum++;
			}
		return divNum;
		}
		
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int saveMultiply = times(div(x1, x2), x2);
        return minus(x1, saveMultiply);
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x)
	 {
		if (x == 0 || x == 1)
        {
			return x;
        }
        else
        {
            int start = 1; 
            int end = div(x, 2);
            int result = 0;

            while (start <= end)
			{
                int mid =  plus(start, (minus(end, start)));

                if (mid <=  div(x, mid))
				{
                    result = mid;
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
		return result;
		}
	 }	  	  
}