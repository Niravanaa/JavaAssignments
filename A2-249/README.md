# Transportation System Project

This project is divided into two parts: Part 1 and Part 2. It involves the implementation and testing of various transportation-related classes.

## Part 1: Driver Class

The `Driver` class provides methods to find the least and most expensive `Aircraft` objects and tests the functionality of objects from eight different classes.

### Functionality

- Finds the least and most expensive `Aircraft` objects in an array of objects.
- Prints the details of the least and most expensive `Aircraft` objects.
- Tests the functionality of objects from eight different classes.

### Usage

To run the `Driver` class, execute the `main` method in the class. It creates objects from different transportation classes, adds them to an array, and tests their functionality.

## Part 2: Driver2 Class

The `Driver2` class creates an array of objects of various transportation types and provides two methods to copy the array: `incorrectCopyTheObjects()` and `correctCopyTheObjects()`.

### Functionality

- Provides an incorrect method `incorrectCopyTheObjects()` to copy the array, explicitly determining the type of the object being copied.
- Provides a correct method `correctCopyTheObjects()` to copy the array, without explicitly determining the type of the object being copied.

### Usage

To run the `Driver2` class, execute the `main` method in the class. It creates objects from different transportation classes, adds them to an array, and tests the incorrect and correct copy array methods.

## Classes

The project includes the following classes:

- `Aircrafts`: Classes related to aircraft objects.
- `Ferry`: Class related to ferry objects.
- `Metro`: Class related to metro objects.
- `Monowheel`: Class related to monowheel objects.
- `TrainTram`: Class related to train and tram objects.
- `WheeledTransportation`: Class related to wheeled transportation objects.
- `Driver`: Main class for Part 1.
- `Driver2`: Main class for Part 2.

## How to Run

1. Compile the Java files: `javac Driver.java` and `javac Driver2.java`.
2. Run Part 1: `java Driver`.
3. Run Part 2: `java Driver2`.

