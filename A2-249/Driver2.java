// -----------------------------------------------------
// Assignment 2
// Part: 2
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

import Aircrafts.*;
import Ferry.*;
import Metro.*;
import Monowheel.*;
import TrainTram.*;
import WheeledTransportation.*;

/**
 * The Driver2 class creates an array of objects of various transportation types and provides two methods to copy the array:
 * the incorrectCopyTheObjects() method and the correctCopyTheObjects() method.
 * The incorrectCopyTheObjects() method is incorrect because it explicitly determines the type of the object being copied,
 * while the correctCopyTheObjects() method uses the getClass() and newInstance() methods to create a copy of the original array
 * without explicitly determining the type of the object being copied.
 * The class imports the following packages: Aircrafts., Ferry., Metro., Monowheel., TrainTram., WheeledTransportation.
 */
public class Driver2
{
	/**
	 * This method to deep copy an array of the eight classes objects is incorrect as it explicitly determines the type of the object being copied.
	 * However, without the constraint, this method still works in deep copying nonetheless.
	 * @param objects the array of objects to be copied
	 * @return the copy of the objects array
	 */
	public static Object[] incorrectCopyTheObjects(Object[] objects)
	{
		Object[] result = new Object[objects.length];
		
		for (int i = 0; i < objects.length; i++)
		{
			if (objects[i] instanceof WW2Aircraft)
			{
				result[i] = new WW2Aircraft((WW2Aircraft) objects[i]);
				continue;
			}
			
			if (objects[i] instanceof Aircraft)
			{
				result[i] = new Aircraft((Aircraft) objects[i]);
				continue;
			}
			
			if (objects[i] instanceof Ferry)
			{
				result[i] = new Ferry((Ferry) objects[i]);
				continue;
			}
			
			if (objects[i] instanceof Monowheel)
			{
				result[i] = new Monowheel((Monowheel) objects[i]);
				continue;
			}
			
			if (objects[i] instanceof Tram)
			{
				result[i] = new Tram((Tram) objects[i]);
				continue;
			}
			
			if (objects[i] instanceof Metro)
			{
				result[i] = new Metro((Metro) objects[i]);
				continue;
			}
			
			if (objects[i] instanceof Train)
			{
				result[i] = new Train((Train) objects[i]);
				continue;
			}
			
			if (objects[i] instanceof WheeledTransportation)
			{
				result[i] = new WheeledTransportation((WheeledTransportation) objects[i]);
				continue;
			}
		}
		
		return result;
	}
	
	/**
	 * This method to deep copy an array of the eight classes objects is correct as it does not explicitly determine the type of the object being copied.
	 * @param objects the array of objects to be copied
	 * @return the copy of the objects array
	 */
	public static Object[] correctCopyTheObjects(Object[] objects)
	{
		Object[] result = new Object[objects.length];
		
		try
		{
			for (int i = 0; i < objects.length; i++)
			{
				final var typeOfObject = objects[i].getClass();
				
				final var constructorToBeUsed = typeOfObject.getConstructor(typeOfObject);
				
				result[i] = constructorToBeUsed.newInstance(objects[i]);
			}
		}
		
		catch (Exception e)
		{
			System.out.println("There was a problem in copying the array!");
		}
		
		return result;
	}
	
	/**
     * The main method creates objects from eight different classes, adds them to an array
     * and tests the incorrect and correct copy array methods.
     *
     * @param args the command line arguments passed to the program
     */
	public static void main(String[] args)
	{
		// We initialize sixteen objects, two objects of each class using different constructors.
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
		
		System.out.println("**Using a CopyTheObjects() method that goes against the rules but produces a good deep copy of the original Object[] array:");
		Object[] copyOfObjects = incorrectCopyTheObjects(objects);		
		
		for (int i = 0; i < copyOfObjects.length; i++)
		{
			System.out.println("It is " + objects[i].equals(copyOfObjects[i]) + " that the objects of index " + i + " are the same.");
		}
				
		System.out.println(copyOfObjects[0]);
		
		System.out.println("\n**Using a CopyTheObjects() method that does not go against the rules and produces a good deep copy of the original Object[] array:");
		Object[] secondCopyOfObjects = correctCopyTheObjects(objects);
		
		for (int i = 0; i < secondCopyOfObjects.length; i++)
		{
			System.out.println("It is " + objects[i].equals(secondCopyOfObjects[i]) + " that the objects of index " + i + " are the same.");
		}

		System.out.print("\nThe program has terminated.");
	}	
}
