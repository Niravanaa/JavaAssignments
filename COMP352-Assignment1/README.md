# Fibonacci Sequence Inspector

This Java program calculates and inspects the Fibonacci sequence. It provides information about the memory usage and runtime complexity of the calculations.
## Features

    Calculates the Fibonacci sequence using a recursive function.
    Tracks the number of function calls made during the calculation.
    Prints the Fibonacci sequence up to a specified length.
    Displays the total number of function calls made.

## Memory Usage

The program explains how the skipping and multiplication operations in the Fibonacci calculations can increase memory usage. Each recursive call adds a new layer to the stack, consuming additional memory. The skipping operation introduces additional recursive calls, leading to a deeper stack and increased memory usage. Similarly, the multiplication operation increases the complexity of the calculations, potentially requiring more memory to store intermediate results. These factors contribute to increased memory usage, especially for larger input values of 'n'.
## Runtime Complexity

The program analyzes the runtime complexity of the Fibonacci calculations. It notes that the recursive nature of the Fibonacci function leads to multiple recursive calls for each value in the sequence. As the value of 'n' increases, the number of recursive calls grows exponentially. This exponential growth in function invocations results in an exponential runtime complexity. Consequently, the program's runtime becomes significantly slower as the input sequence size increases.
## Usage

To run the program, pass the desired sequence length as a command-line argument.

```shell
java FibonacciSequenceInspector <sequenceLength>
```

    Replace <sequenceLength> with the desired length of the Fibonacci sequence.

Note: The program expects a positive integer as the sequence length argument. If an invalid argument is provided, an error message will be displayed.
Example Output

Below is an example output of the program for a sequence length of 10:

```shell
1 1 1 3 6 12 23 43 81 151 
Calls: 188
```
In this example, the Fibonacci sequence is printed up to the 10th term. The total number of function calls made during the calculations is 188.

---

Note: This is a summary of the provided Java program, and additional details or explanations may be required depending on the context or specific requirements of the project
