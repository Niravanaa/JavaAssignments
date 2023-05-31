# String In Sort

This Java program performs sorting on an array of integers using the String In Sort algorithm. It also provides information about the chosen reversals, the size of specific runs, and the number of comparisons and swaps performed during the sorting process.
## Features

    Reads input from a file specified as a command-line argument.
    Performs sorting using the String In Sort algorithm.
    Tracks the number of reversals, comparisons, and swaps made during the sorting process.
    Prints the sorted array and displays additional statistics.

## Reversals and Sorting Efficiency

The program explains how reversals help organize the array into decreasing runs, which can be efficiently sorted using the insertion sort algorithm. By reversing specific sections of the array, the algorithm minimizes the number of swaps required to sort it. The choice of reversals also affects the number of comparisons performed during the structuring phase. The goal is to identify decreasing runs and perform reversals on them, optimizing the sorting process in terms of swaps and comparisons and achieving a more efficient sorting outcome.
## Size of Runs and Sorting Performance

The program discusses the impact of the size of specific runs on the performance of the sorting algorithm. It notes that runs of length 3, which are in ascending order, can be efficiently sorted with minimal swaps and comparisons. These runs are small and already partially sorted, allowing the algorithm to process them separately and optimize its sorting strategy. The smaller size of these runs helps reduce the overall number of swaps and comparisons required, leading to improved performance and faster sorting of the array.
## Doubly Linked List Implementation

The program briefly considers implementing the sorting algorithm using a Doubly Linked List. It mentions that such an implementation would change the data structure used for storing and manipulating the elements. While the specific structuring, reversals, and comparisons would still impact the results, the implementation with a Doubly Linked List would introduce additional complexity in managing node pointers and updating links during reversals and swaps. The overall impact on performance would depend on the efficiency of linked list operations and the specific implementation details, but the fundamental sorting strategy and the impact of structuring on swaps and comparisons would remain similar.
## Usage

To run the program, provide the input file path as a command-line argument.

```shell
java StrInSort <inputFilePath>
```

    Replace <inputFilePath> with the path to the input file containing the integers to be sorted.

Note: The program reads integers from the input file, one integer per line.
## Example Output

Below is an example output of the program:

```shell
10 8 7 6 5 4 3 2 1 
We sorted in DECR order
We counted 2 INCR runs of length 3
We performed 6 reversals of runs in DECR order
We performed 19 compares during structuring
We performed 38 compares overall
We performed 12 swaps overall
1 2 3 4 5 6 7 8 10 
```

In this example, the program reads the input integers from the file and prints them. It then performs the sorting using the String In Sort algorithm. The program displays the number of INCR runs of length 3, the number of reversals performed, the number of comparisons during structuring, the overall number of comparisons, and the overall number of swaps. Finally, it prints the sorted array.

---

Note: This is a summary of the provided Java program, and additional details or explanations may be required depending on the context or specific requirements of the project.
