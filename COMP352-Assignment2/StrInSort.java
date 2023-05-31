// Author: Nirav Patel #40248940

/* Question 1:
    Reversals help to organize the array into decreasing runs, which can be efficiently sorted using insertion 
    sort. By reversing specific sections, the algorithm minimizes the number of swaps required to sort the array. Additionally, 
    the chosen reversals affect the number of comparisons performed during the structuring phase. The goal is to identify 
    decreasing runs and perform reversals on them. Overall, the choice of reversals impacts the efficiency of the sorting 
    process in terms of swaps and comparisons, leading to a more optimized sorting outcome.
	
   Question 2:
    The size of the specific runs recorded, which are in ascending order and have a length of 3, can impact the performance 
    of the sorting algorithm. These runs of length 3 can be efficiently sorted with minimal swaps and comparisons, as they 
    are small and already partially sorted. By identifying and processing these runs separately, the algorithm can optimize
    its sorting strategy. Consequently, the smaller size of these runs helps reduce the overall number of swaps and comparisons 
    required, leading to improved performance and faster sorting of the array.

   Question 3:
    Implementing the sorting algorithm as a Doubly Linked List would change the data structure used for storing and manipulating 
    the elements. The specified structuring, such as the chosen reversals and comparisons, would still affect the results. 
    However, the implementation with a Doubly Linked List would introduce additional complexity in terms of managing node pointers 
    and updating links during reversals and swaps. The performance impact would depend on the efficiency of the linked list operations
    and the specific implementation details, but the basic sorting strategy and the impact of structuring on swaps and comparisons 
    would remain similar.
*/

import java.io.*;

import java.util.Scanner;

public class StrInSort {

    static int threes = 0;

    static int reverses = 0;

    static int comparesStructure = 0;

    static int compares = 0;

    static int swaps = 0;

    public static void reverse(int[] arr, int first, int last) {
        if (first == last) {
            return;
        }

        int size = last - first + 1;

        int[] tempArr = new int[size];

        for (int i = last; i >= first; i--) {
            tempArr[last - i] = arr[i];
        }

        for (int i = first; i <= last; i++) {
            arr[i] = tempArr[i - first];
        }

        reverses++;
    }

    public static void merge(int[] arr1, int[] arr2) {
        if (arr1.length == 0) {
            arr1 = arr2;
        }

        if (arr2[0] < arr2[arr2.length - 1] && arr2.length == 3) {
            threes++;
        }

        int size = arr1.length + arr2.length;

        int[] temp = new int[arr1.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr1[i];
        }

        arr1 = new int[size];

        for (int i = 0; i < temp.length; i++) {
            arr1[i] = temp[i];
        }

        for (int i = temp.length; i < size; i++) {
            arr1[i] = arr2[i - temp.length];
        }
    }

    public static boolean smaller(int first, int second) {
        compares++;

        return second > first;
    }

    public static void main(String[] args) {
        Scanner scan = null;

        try {
            scan = new Scanner(new File(args[0]));
        } catch (Exception e) {
            System.out.print("There was an error reading the input file!");

            System.exit(1);
        }

        int count = 0;

        while (scan.hasNextInt()) {
            count++;
            scan.next();
        }

        int[] values = new int[count];

        try {
            scan = new Scanner(new File(args[0]));
        } catch (Exception e) {
            System.out.print("There was an error reading the input file!");

            System.exit(1);
        }

        for (int i = 0; i < count; i++) {
            values[i] = scan.nextInt();
            System.out.print(values[i] + " ");
        }

        System.out.println("\nWe sorted in DECR order");

        int startDECR = 0;

        int startINCR = 0;

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] > values[i + 1] && values[i + 1] < values[i + 2]) {
                comparesStructure += 2;

                reverse(values, startDECR, i + 1);
                startDECR = i + 2;
                startINCR = i + 2;
                i++;
            } else if (values[i] < values[i + 1] && values[i + 1] > values[i + 2]) {
                comparesStructure += 2;

                if (i + 2 - startINCR == 3) {
                    threes++;
                }
                startDECR = i + 2;
                startINCR = i + 2;
                i++;
            } else {
                comparesStructure++;
            }
        }

        for (int i = 1; i < values.length; i++) {
            int value = values[i];

            int j = i;

            while (j > 0 && smaller(values[j - 1], value)) {
                values[j] = values[j - 1];
                swaps++;
                j--;
            }

            values[j] = value;
        }

        System.out.println("We counted " + threes + " INCR runs of length 3");
        System.out.println("We performed " + reverses + " reversals of runs in DECR order");
        System.out.println("We performed " + comparesStructure + " compares during structuring");
        System.out.println("We performed " + (compares + comparesStructure) + " compares overall");
        System.out.println("We performed " + (reverses + swaps) + " swaps overall");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        scan.close();
    }
}

