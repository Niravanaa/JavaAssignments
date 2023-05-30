// Name and ID : Nirav Patel #40248940
// COMP249
// Assignment #1
// Due Date February 3 2023

import java.util.Random;

/**
 * This class represents a ladder in the Snakes and Ladders game.
 * 
 * @author Nirav
 */
public class Ladder {
    /**
     * The position of the ladder's bottom step
     */
    public int bottomStepPos;

    /**
     * The name of the ladder's bottom step
     */
    public String bottomStepName;

    /**
     * The position of the ladder's top step
     */
    public int topStepPos;

    /**
     * The name of the ladder's top step
     */
    public String topStepName;

    /**
     * The unique identifier of the ladder object
     */
    public int identifier;

    /**
     * Represents the nearest number divisible by the board's length
     */
    private int nearestWhole;

    /**
     * Represents a random number generator for the ladder
     */
    private Random rand = new Random();

    /**
     * Creates a ladder with a given board size
     * 
     * @param boardSize The board game's size
     * @param identifier The ID of the Ladder object
     */
    public Ladder(int boardSize, int identifier) {
        this.bottomStepPos = rand.nextInt(boardSize * (boardSize - 1)) + 1;

        this.nearestWhole = this.bottomStepPos + 1;

        this.identifier = identifier;

        while (this.nearestWhole % boardSize != 0) {
            this.nearestWhole++;
        }

        while (this.topStepPos < boardSize || this.topStepPos <= this.nearestWhole) {
            this.topStepPos = boardSize + rand.nextInt((boardSize * boardSize - 2) - boardSize + 1);
        }

        this.topStepName = "LT" + identifier;
        this.bottomStepName = "LB" + identifier;
    }

    /**
     * Creates a ladder with given bottom step and top step positions
     * 
     * @param bottomStepPos The position of the ladder's bottom step
     * @param topStepPos The position of the ladder's top step
     * @param identifier The ID of the Ladder object constructed
     */
    public Ladder(int bottomStepPos, int topStepPos, int identifier) {
        this.bottomStepPos = bottomStepPos;
        this.topStepPos = topStepPos;

        this.topStepName = "LT" + identifier;
        this.bottomStepName = "LB" + identifier;
    }

    /**
     * This method returns true if a ladder object is equal to the object calling the method
     * 
     * @param ladder The other Ladder object to be compared with the one calling the method
     * @return True if either of the parameters are equal or False if none of the parameters are equal
     */
    public boolean equals(Ladder ladder) {
        if (this.bottomStepPos == ladder.bottomStepPos || this.topStepPos == ladder.topStepPos || this.bottomStepPos == ladder.topStepPos || this.topStepPos == ladder.bottomStepPos) {
            return true;
        }

        return false;
    }
}