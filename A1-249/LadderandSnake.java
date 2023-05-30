// Name and ID : Nirav Patel #40248940
// COMP249
// Assignment #1
// Due Date February 3 2023

import java.util.Random;
import java.util.Scanner;

/**
 * The main class of the program, which describes the logic of the game
 * @author Nirav
 */
public class LadderandSnake {
    /**
     * The board game's size
     */
    private int boardSize;

    /**
     * The number of players that will be playing the game
     */
    public int numPlayers;

    /**
     * The ID of the player currently performing their turn in the game
     */
    private int currentPlayer;

    /**
     * The number of attempts it took before deciding which player goes first
     */
    private int attempts;

    /**
     * The random number generator which is used to flip the dice
     */
    private Random rand;

    /**
     * The number of Snakes that will be present in the game board
     */
    public int numberOfSnakes;

    /**
     * The number of Ladders that will be present in the game board
     */
    public int numberOfLadders;

    /**
     * The static array of Snake objects that will be present in the game board. This array is used to assign unique positions to the Snake objects.
     */
    static Snake[] snakes;

    /**
     * The static array of Ladder objects that will be present in the game board. This array is used to assign unique position to the Ladder objects.
     */
    static Ladder[] ladders;

    /**
     * Represents the first player of the game, using the Player() constructor
     */
    static Player player1 = new Player(1);

    /**
     * Represents the second player of the game using the Player() constructor
     */
    static Player player2 = new Player(2);

    /**
     * Creates the Snakes and Ladders game using default parameters, as given in the assignment document.
     */
    public LadderandSnake() {
        this.boardSize = 10;

        this.rand = new Random();

        this.numPlayers = 2;

        snakes = new Snake[8];
        ladders = new Ladder[9];

        snakes[0] = new Snake(6, 16, 0);
        snakes[1] = new Snake(19, 79, 1);
        snakes[2] = new Snake(30, 48, 2);
        snakes[3] = new Snake(24, 95, 3);
        snakes[4] = new Snake(60, 64, 4);
        snakes[5] = new Snake(78, 98, 5);
        snakes[6] = new Snake(68, 93, 6);
        snakes[7] = new Snake(76, 97, 7);

        ladders[0] = new Ladder(1, 38, 0);
        ladders[1] = new Ladder(9, 31, 1);
        ladders[2] = new Ladder(4, 14, 2);
        ladders[3] = new Ladder(28, 84, 3);
        ladders[4] = new Ladder(21, 41, 4);
        ladders[5] = new Ladder(36, 44, 5);
        ladders[6] = new Ladder(51, 67, 6);
        ladders[7] = new Ladder(71, 91, 7);
        ladders[8] = new Ladder(80, 100, 8);
    }

    /**
     * Creates the Snakes and Ladders game using user input
     * 
     * @param boardSize The size of the board's length and width
     * @param numPlayers The number of players that will be playing the game
     * @param numberOfSnakes The number of Snake objects that will be present on the game board
     * @param numberOfLadders The number of Ladder objects that will be present on the game board
     */
    public LadderandSnake(int boardSize, int numPlayers, int numberOfSnakes, int numberOfLadders) {
        System.out.println();

        this.boardSize = boardSize;

        this.rand = new Random();

        if (numPlayers == 2) {
            this.numPlayers = numPlayers;
        } else if (numPlayers > 2) {
            System.out.println("Initialization was attempted for " + numPlayers + " member of players; however, this is only expected for an extended version of the game. Value will be set to 2");
        } else {
            System.out.println("Error: Cannot execute the game with less than 2 players! Will exit now.");
            System.exit(0);
        }

        snakes = new Snake[numberOfSnakes];
        ladders = new Ladder[numberOfLadders];

        int counter = 0;

        while (counter < snakes.length) {
            boolean original = true;

            Snake snake = new Snake(this.boardSize, counter);

            for (int i = 0; i < counter; i++) {
                if (snakes[i].equals(snake)) {
                    original = false;

                    break;
                }
            }

            if (original) {
                System.out.println("Snake " + snake.identifier + " has tail and head positions " + snake.tailPos + " and " + snake.headPos);

                snakes[counter++] = snake;
            }
        }

        int[] positions = new int[snakes.length * 2];
        
        counter = 0;

        for (int i = 0; i < snakes.length; i++) {
            positions[counter] = snakes[i].tailPos;
            positions[counter + 1] = snakes[i].headPos;
            counter += 2;
        }
        
        counter = 0;

        while (counter < ladders.length) {
            boolean original = true;

            Ladder ladder = new Ladder(this.boardSize, counter);

            for (int i = 0; i < counter; i++) {
                if (ladders[i].equals(ladder)) {
                    original = false;
                    break;
                }
            }

            for (int i = 0; i < positions.length; i++) {
                if (ladder.bottomStepPos == i || ladder.topStepPos == i) {
                    original = false;
                    break;
                }
            }

            if (original) {
                System.out.println("Ladder " + ladder.identifier + " has tail and head positions " + ladder.bottomStepPos + " and " + ladder.topStepPos);

                ladders[counter++] = ladder;
            }
        }

        Scanner in = new Scanner(System.in);
        
        System.out.println("\nPress enter to start the game!");
        
        in.nextLine();
    }

    /**
     * This method uses a Random object to generate a integer from 1 to 6
     * @return A integer from 1 to 6
     */
    public int flipDice() {
        return rand.nextInt(6) + 1;
    }

    /**
     * This method places a given ladder on the game board
     * 
     * @param board The game board on which the ladder object will be placed on
     * @param ladder The ladder object that is to be placed
     */
    public void placeLadders(String[][] board, Ladder ladder) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(Integer.toString(ladder.bottomStepPos))) {
                    board[i][j] = ladder.bottomStepName;
                }

                if (board[i][j].equals(Integer.toString(ladder.topStepPos))) {
                    board[i][j] = ladder.topStepName;
                }
            }
        }
    }

    /**
     * This method obtains a snake and places it on the game board
     * 
     * @param board The game board in which the snake object will be placed in
     * @param snake The snake object that is to be placed
     */
    public void placeSnakes(String[][] board, Snake snake) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(Integer.toString(snake.tailPos))) {
                    board[i][j] = snake.tailName;
                }

                if (board[i][j].equals(Integer.toString(snake.headPos))) {
                    board[i][j] = snake.headName;
                }
            }
        }
    }

    /**
     * This method places one of the two players on the game board
     * 
     * @param board The board on which the game is being played on
     * @param player The player object that is to be placed
     */
    public void placePlayer(String[][] board, Player player) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(Integer.toString(player.position))) {
                    board[i][j] = "P" + player.ID;
                }
            }
        }
    }

    /**
     * This method displays a 2-dimensional String array using for-loops. The grid has cells that are numbered from 1 to the square of the board's length, in a zig-zag pattern from the bottom left
     */
    public void displayBoard() {
        String[][] board = new String[boardSize][boardSize];
        int num = 1;

        for (int i = board.length - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = Integer.toString(num);
                    num++;
                }
            } else {
                for (int j = board[i].length - 1; j >= 0; j--) {
                    board[i][j] = Integer.toString(num);
                    num++;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                placePlayer(board, player1);

                placePlayer(board, player2);

                for (int k = 0; k < snakes.length; k++) {
                    placeSnakes(board, snakes[k]);
                }

                for (int k = 0; k < ladders.length; k++) {
                    placeLadders(board, ladders[k]);
                }
            }
        }

        // Display board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }

            System.out.println("\n");
        }
    }
    /**
     * This method performs the turn of a player and decides whether the game has completed or not
     * 
     * @param player The player object who is currently playing
     * @param otherPlayer The other player object who is not currently playing
     * @return True if the game has not yet completed and False if the player has reached the end of the board
     */
    public boolean playTurn(Player player, Player otherPlayer) {
        boolean alreadyChanged = false;

        int diceValue = flipDice();

        player.position += diceValue;

        for (int i = 0; i < snakes.length; i++) {
            if (player.position == snakes[i].headPos) {
                System.out.println("Player " + player.ID + " rolled " + diceValue + " and is now at square " + player.position + ", which is the head of a snake! Player " + player.ID + " is now at square " + snakes[i].tailPos + ".");

                player.position = snakes[i].tailPos;

                if (player.position == otherPlayer.position) {
                    System.out.println("Player " + player.ID + " landed on Player " + otherPlayer.ID + "'s square! Player " + otherPlayer.ID + " is now back to 0!");

                    otherPlayer.position = 1;
                }

                displayBoard();

                alreadyChanged = true;

                break;
            }
        }

        for (int i = 0; i < ladders.length; i++) {
            if (player.position == ladders[i].bottomStepPos) {
                System.out.println("Player " + player.ID + " rolled " + diceValue + " and is now at square " + player.position + ", which is the bottom of a ladder! Player " + player.ID + " is now at square " + ladders[i].topStepPos + ".");

                player.position = ladders[i].topStepPos;

                if (player.position == otherPlayer.position) {
                    System.out.println("Player " + player.ID + " landed on Player " + otherPlayer.ID + "'s square! Player " + otherPlayer.ID + " is now back to 0!");

                    otherPlayer.position = 1;
                }

                displayBoard();

                if (player.position == boardSize * boardSize) {
                    System.out.println("Player " + player.ID + " wins!");

                    return false;
                }

                alreadyChanged = true;

                break;
            }
        }

        if (!alreadyChanged) {
            if (player.position >= boardSize * boardSize) {
                player.position = boardSize * boardSize;

                System.out.println("Player " + player.ID + " rolled " + diceValue + " and is now at square " + player.position + ".");

                displayBoard();

                System.out.println("Player " + player.ID + " wins!");

                return false;
            } else {
                System.out.println("Player " + player.ID + " rolled " + diceValue + " and is now at square " + player.position);

                if (player.position == otherPlayer.position) {
                    System.out.println("Player " + player.ID + " landed on Player " + otherPlayer.ID + "'s square! Player " + otherPlayer.ID + " is now back to 0!");

                    otherPlayer.position = 1;
                }

                displayBoard();
            }
        }

        return true;
    }

    /**
     * This method runs the main game. This method first determines which of the two players will go first by using a Random object to generate a number between 1 to 6 and assigning it respectively to the players
     * The player with the largest number will go first. If both players rolled the same integer, the attempt number is recorded and the method generates a new number once more, this reoccurs until one of the players has obtained a larger number than the other.
     */
    public void play() {
        System.out.println("Game is played by 2 players.\n");

        attempts = 0;

        while (true) {
            int player1Dice = flipDice();

            int player2Dice = flipDice();

            attempts++;

            if (player1Dice == player2Dice) {
                System.out.println("Player 1 got a dice value of " + player1Dice);
                System.out.println("Player 2 got a dice value of " + player2Dice);
                System.out.println("A tie was achieved between Player 1 and 2. Attempting to break the tie.\n");
            } else if (player1Dice > player2Dice) {
                System.out.println("Player 1 got a dice value of " + player1Dice);
                System.out.println("Player 2 got a dice value of " + player2Dice);
                System.out.println("Reached final decision on order of playing: Player 1 then Player 2. It took " + attempts + " attempts before a decision could be made.\n");
                currentPlayer = 1;
                break;
            } else {
                System.out.println("Player 1 got a dice value of " + player1Dice);
                System.out.println("Player 2 got a dice value of " + player2Dice);
                System.out.println("Reached final decision on order of playing: Player 2 then Player 1. It took " + attempts + " attempts before a decision could be made.\n");
                currentPlayer = 2;
                break;
            }
        }

        while (true) {
            if (currentPlayer == 1) {
                if (!playTurn(player1, player2)) {
                    break;
                }

                currentPlayer = 2;
            } else {
                if (!playTurn(player2, player1)) {
                    break;
                }

                currentPlayer = 1;
            }
        }
    }

    /**
     * This method is used to validate the input of the user when requesting for a certain integer in a pre-determined range
     * 
     * @param keyboard The Scanner object used to obtain the user's input
     * @param message The message first displayed to the user requesting that they enter an integer in a pre-determined range
     * @param errorMessage The error message that displays when the user has failed to enter an integer in a pre-determined range
     * @param minimum The smallest integer that the user can input
     * @param maximum The largest integer that the user can input
     * @return The integer that is within the pre-determined range and that was inputted by the user
     */
    public static int getIntegerInput(Scanner keyboard, String message, String errorMessage, int minimum, int maximum) {
        int number = -1;

        boolean validated = false;

        System.out.print(message);

        while (!validated) {
            if (keyboard.hasNextInt()) {
                number = keyboard.nextInt();

                if (number >= minimum && number <= maximum) {
                    validated = true;
                } else {
                    System.out.print(errorMessage);
                }
            } else {
                System.out.print(errorMessage);
                keyboard.next();
            }
        }

        return number;
    }
}