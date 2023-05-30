// Name and ID : Nirav Patel #40248940
// COMP249
// Assignment #1
// Due Date February 3 2023

import java.util.Scanner;

/**
 * The driver class of the program, which is used to run the game.
 * 
 * @author Nirav
 */
public class PlayLadderAndSnake {
	/**
     * The main method of the class which prompts the user whether they would like to play a premade or custom version of the board game.
     * If the user wishes to play the premade version of the game, a 10 x 10 board is initialized with 8 snakes and 9 ladders, whose positions are identical to the one's presented in the assignment PDF.
     * If the user wishes to play a custom version of the game, the main method prompts the user to enter the board size of the game, the number of snakes on the board, the number of ladders on the board, and the number of players that will be playing.
     * The program quits if only 1 player is entered, and sets to 2 if an integer larger than 2 is inputted as the number of players.
     * @param args
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Snakes and Ladder program!");

        System.out.print("\nWould you like to play the custom or premade gamemode? (enter 'custom' or 'premade'): ");

        String answer = keyboard.nextLine();

        while (!answer.trim().equalsIgnoreCase("custom") && !answer.trim().equalsIgnoreCase("premade")) {
            System.out.print("You must write 'custom' or 'premade': ");

            answer = keyboard.nextLine();
        }

        LadderandSnake game;

        if (answer.trim().equalsIgnoreCase("premade")) {
            game = new LadderandSnake();

            game.play();
        } else {
            int boardSize = LadderandSnake.getIntegerInput(keyboard, "\nWhat board size would you like to play with (2 to infinity inclusively): ", "Please enter an integer larger than 2: ", 2, 1000);

            int maxSnakes = boardSize;

            int numberOfSnakes = LadderandSnake.getIntegerInput(keyboard, "\nHow many snakes would you like to play with (0 to " + maxSnakes + " inclusively): ", "Please enter an integer between 0 to " + maxSnakes + " inclusively: ", 0, maxSnakes);

            int maxLadders = maxSnakes - numberOfSnakes;

            int numberOfLadders = LadderandSnake.getIntegerInput(keyboard, "\nHow many ladders would you like to play with (0 to " + maxLadders + " inclusively): ", "Please enter an integer between 0 to " + maxLadders + " inclusively: ", 0, maxLadders);

            int numberOfPlayers = LadderandSnake.getIntegerInput(keyboard, "\nHow many players are playing (only 2 for the moment): ", "Please enter a positive integer: ", 0, 1000);

            game = new LadderandSnake(boardSize, numberOfPlayers, numberOfSnakes, numberOfLadders);

            game.play();
        }

        keyboard.close();
    }
}
