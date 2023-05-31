// Author: Nirav Patel #40248940

/* 
	Question 1:
	The skipping and multiplication operations in the Fibonacci program can increase memory usage due to 
	the recursive nature of the calculations. Each recursive call adds a new layer to the stack, consuming 
	additional memory. The skipping operation (e.g., fibonacci(n-3)) introduces additional recursive calls, 
	leading to a deeper stack and increased memory usage. Similarly, the multiplication operation (e.g., 3 * fibonacci(n-4)) 
	increases the complexity of the calculations, potentially requiring more memory to store intermediate results. 
	These factors can contribute to increased memory usage as the program executes, particularly for larger 
	input values of 'n'.
	
	Question 2:
	The runtime of the given program, is expected to scale exponentially as the size of the input sequence grows. 
	This is because the recursive Fibonacci function makes multiple recursive calls for each value in the sequence. 
	The number of recursive calls increases rapidly with each iteration, leading to an exponential growth in the number 
	of function invocations. Consequently, the runtime complexity is exponential, making the program's runtime significantly 
	slower as the input sequence size increases.
*/

public class FibonacciSequenceInspector {
	
	private static int calls = 0;
	
	public static int fibonacci(int n)
	{
		calls++;
		
		if (n <= 4)
		{
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n-3) + 3 * fibonacci(n-4);
	}
	
	public static void main(String[] args)
	{
		int sequenceLength = 0;
		
		try
		{
			sequenceLength = Integer.parseInt(args[0]);
			
			if (sequenceLength <= 0)
			{
				throw new Exception();
			}
		}
		
		catch (Exception e)
		{
			System.out.println("There was an error taking the argument!");
			
			System.exit(0);
		}
		
		for (int i = 0; i < sequenceLength; i++)
		{
			System.out.print(fibonacci(i) + " ");
		}
		
		System.out.print("\nCalls: " + calls);
	}
}
