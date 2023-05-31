// Name and ID : Nirav Patel #40248940
// COMP249
// Assignment #1
// Due Date February 3 2023

/**
 * This class represents a player in the Snakes and Ladders game.
 * @author Nirav
 */
public class Player {
    /**
     * The unique identifier for each player
     */
    public int ID;

    /**
     * The name for each player
     */
    public String name;

    /**
     * The current position of the player on the game board
     */
    public int position = 0;

    /**
     * Creates a new player with the given ID
     * 
     * @param ID The unique identifier for each player
     */
    public Player(int ID) {
        this.ID = ID;
        this.name = "P" + ID;
    }
}