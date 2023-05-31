// Name and ID : Nirav Patel #40248940
// COMP249
// Assignment #1
// Due Date February 3 2023

import java.util.Random;

/**
 * The Snake class is used to represent a snake object in the game board
 * The class contains the tail position, tail name, head position, head name, a static ID,
 * the nearest ten number for setting the head position, and a random number generator
 * 
 * @author Nirav
 */
public class Snake {
    /**
     * The position of the snake object's tail
     */
    public int tailPos;

    /**
     * The name of the snake object's tail
     */
    public String tailName;

    /**
     * The position of the snake object's head
     */
    public int headPos;

    /**
     * The name of the snake object's head
     */
    public String headName;

    /**
     * The unique identifier of the snake object
     */
    public int identifier;

    /**
     * Represents the nearest integer divisible by the board's length
     */
    private int nearestWhole;

    /**
     * Represents a random number generator for the snake
     */
    private Random rand = new Random();

    /**
     * Creates a Snake object with a given board size
     * 
     * @param boardSize The size of the game board
     * @param identifier The identifier ID of the Snake
     */
    public Snake(int boardSize, int identifier) {
        this.tailPos = rand.nextInt(boardSize * (boardSize - 1)) + 1;

        this.nearestWhole = this.tailPos + 1;

        this.identifier = identifier;

        while (this.nearestWhole % boardSize != 0) {
            this.nearestWhole++;
        }

        this.headPos = 0;

        while (this.headPos < boardSize || this.headPos <= this.nearestWhole) {
            this.headPos = boardSize + rand.nextInt((boardSize * boardSize - 2) - boardSize + 1);
        }

        this.headName = "ST" + identifier;
        this.tailName = "SB" + identifier;
    }

    /**
     * Creates a snake with given tail and head positions
     * 
     * @param tailPos The position where the tail of the object is located
     * @param headPos The position where the head of the object is located
     * @param identifier The ID of the Snake object constructed
     */
    public Snake(int tailPos, int headPos, int identifier) {
        this.tailPos = tailPos;
        this.headPos = headPos;
        this.identifier = identifier;

        this.headName = "ST" + identifier;
        this.tailName = "SB" + identifier;
    }

    /**
     * This method returns true if a Snake object is equal to the object calling the method
     * 
     * @param snake The snake object that is to be compared to the one calling the method
     * @return True if either of the parameters are equal or False if none of the parameters are equal
     */
    public boolean equals(Snake snake) {
        if (this.headPos == snake.headPos || this.tailPos == snake.tailPos || this.headPos == snake.tailPos || this.tailPos == snake.headPos) {
            return true;
        }

        return false;
    }
}