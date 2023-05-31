// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

import Aircrafts.*;
import Ferry.*;
import Metro.*;
import Monowheel.*;
import TrainTram.*;
import WheeledTransportation.*;

/**
 * The Driver class provides methods to find the least and most expensive Aircraft objects
 * and test the functionality of objects from eight different classes.
 */
public class Driver
{
	/**
     * Finds the least and most expensive Aircraft objects in the given array of objects.
     * Prints the details of the least and most expensive Aircraft objects.
     *
     * @param objects the array of objects to be searched for Aircraft objects
     */
	public static void findLeastAndMostExpensiveAircraft(Object[] objects)
	{
		double minimumPrice = Double.MAX_VALUE;
		double maximumPrice = Double.MIN_VALUE;
		
		Aircraft leastExpensiveAircraft = null;
		Aircraft mostExpensiveAircraft = null;
		
		for (int i = 0; i < objects.length; i++)
		{
			if (objects[i] instanceof Aircraft)
			{
				Aircraft currentAircraft = (Aircraft) objects[i];
				
				double price = currentAircraft.getPrice();
				
				if (price < minimumPrice)
				{
					minimumPrice = price;
					leastExpensiveAircraft = currentAircraft;
				}
				
				if (price > maximumPrice)
				{
					maximumPrice = price;
					mostExpensiveAircraft = currentAircraft;
				}
			}
		}
		
		if (leastExpensiveAircraft == null && mostExpensiveAircraft == null)
		{
			System.out.println("No Aircraft Objects found.\n");
		}
		
		else if (leastExpensiveAircraft == mostExpensiveAircraft)
		{
			System.out.println("Only one Aircraft object found:");
			System.out.println(leastExpensiveAircraft.toString() + "\n");
		}
		
		else
		{
			System.out.println("Least expensive Aircraft:");
			System.out.println(leastExpensiveAircraft.toString() + "\n");
			System.out.println("Most expensive Aircraft:");
			System.out.println(mostExpensiveAircraft.toString() + "\n");
		}
	}
	
	/**
     * The main method creates objects from eight different classes, adds them to an array
     * and tests the functionality of the objects.
     *
     * @param args the command line arguments passed to the program
     */
	public static void main(String[] args)
	{
		WheeledTransportation defaultWT = new WheeledTransportation();
		WheeledTransportation parameterWT = new WheeledTransportation(4, 100);
		
		Train parameterTrain = new Train(4, 120, 4, "Montreal", "New York");
		Train copyTrain = new Train(parameterTrain);
		
		Metro defaultMetro = new Metro();
		Metro parameterMetro = new Metro(4, 200, 10, "Montreal", "Vieux-Quebec", 10);
		
		Tram parameterTram = new Tram(12, 80, 5, "Montreal", "Ottawa", 15, 2005);
		Tram copyTram = new Tram(parameterTram);
		
		Monowheel defaultMonowheel = new Monowheel();
		Monowheel parameterMonowheel = new Monowheel(1, 60, 200);
		
		Ferry parameterFerry = new Ferry(200, 1000);
		Ferry copyFerry = new Ferry(parameterFerry);
		
		Aircraft defaultAircraft = new Aircraft();
		Aircraft parameterAircraft = new Aircraft(20000, 2000);
		
		WW2Aircraft parameterWW2Aircraft = new WW2Aircraft(40000, 3000, true);
		WW2Aircraft copyWW2Aircraft = new WW2Aircraft(parameterWW2Aircraft);
		
		Object[] objects = new Object[16];
		
		objects[0] = defaultWT;
		objects[1] = parameterWT;
		objects[2] = parameterTrain;
		objects[3] = copyTrain;
		objects[4] = defaultMetro;
		objects[5] = parameterMetro;
		objects[6] = parameterTram;
		objects[7] = copyTram;
		objects[8] = defaultMonowheel;
		objects[9] = parameterMonowheel;
		objects[10] = parameterFerry;
		objects[11] = copyFerry;
		objects[12] = defaultAircraft;
		objects[13] = parameterAircraft;
		objects[14] = parameterWW2Aircraft;
		objects[15] = copyWW2Aircraft;
		
		System.out.println("**Testing the toString methods of objects from all eight classes:");
		for (int i = 0; i < objects.length; i++)
		{
			System.out.println(objects[i]);
		}
		
		System.out.println("\n**Testing for equality between two different objects:");
		Aircraft aircraftTest1 = new Aircraft();
		Metro metroTest2 = new Metro();
		System.out.println("It is " + aircraftTest1.equals(metroTest2) + " that aircraftTest1 is equal to metroTest2.");
		
		System.out.println("\n**Testing for equality between two different objects of the same type:");
		Tram tramTest1 = new Tram();
		Tram tramTest2 = new Tram(20, 120, 10, "Montreal", "New York", 10, 2005);
		System.out.println("It is " + tramTest1.equals(tramTest2) + " that tramTest1 is equal to tramTest2.");
		
		System.out.println("\n**Testing for equality between two identical objects of the same type:");
		Train trainTest1 = new Train(20, 200, 10, "Montreal", "Ottawa");
		Train trainTest2 = new Train(trainTest1);
		System.out.println("It is " + trainTest1.equals(trainTest2) + " that trainTest1 is equal to trainTest2.\n");
		
		// To test the findLeastAndMostExpensiveAircraft() method, we will use the original array as the first array, and remove the aircraft objects and consider that as the second array.
		System.out.println("**Testing the findLeastAndMostExpensiveAircraft() method for the first array, containing Aircraft objects:");
		findLeastAndMostExpensiveAircraft(objects);
		
		// We then modify the original array by replacing the Aircraft objects with objects of other types.
		objects[12] = new WheeledTransportation();
		objects[13] = new Train();
		objects[14] = new Metro();
		objects[15] = new Monowheel();
		
		System.out.println("**Testing the findLeastAndMostExpensiveAircraft() method for the second array, not containing Aircraft objects:");
		findLeastAndMostExpensiveAircraft(objects);
		
		System.out.print("The program has terminated.");
	}
}
