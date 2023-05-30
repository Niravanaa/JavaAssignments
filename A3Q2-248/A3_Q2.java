// -------------------------------------------------------
// Assignment 3 - Question 2
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// --------------------------------------------------------

// Description of the program:
// The SEVS program is a program that enables a user to input candidates' names and IDs.
// The user can display their entered list of candidates.
// The user can vote for any candidate an unlimited number of times.
// The user can add another sequence of candidates' names and IDs.
// The user can display a ranking of the candidates based on their number of votes.

import java.util.Scanner;

public class A3_Q2 {
    public static void main(String[] args) {
        
    	// We initialize our scanner variable
    	Scanner in = new Scanner(System.in);

    	// We display the Welcome Message and the Instruction to input candidates.
        System.out.println("Welcome to the Simple Electronic Voting System (SEVS):");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("Please enter a String collection of electoral candidates below:");
        
        // We store the user's input in a String variable.
        String collection = in.nextLine();

        // We display the possible codes that can be used to operate the program.
        System.out.println("********************************");
        System.out.println("| Code >> Description          |");
        System.out.println("|  1   >> Display candidates   |");
        System.out.println("|  2   >> Vote a candidate     |");
        System.out.println("|  3   >> Add new candidate(s) |");
        System.out.println("|  4   >> Display results      |");
        System.out.println("|  0   >> End SEVS             |");
        System.out.println("********************************\n");

        // we initialize the user's inputted code as an integer.
        int codeEntered;

        // Lines 37 to 67 process the user's input and creates a two-dimensional array containing a column with the IDs
        // of the candidates and a column with the names of the candidates. Every row in this two-dimensional array
        // represents a candidate.
        
        // We create a String array with each element representing the information of a candidates (ID and name).
        // Since every element in the user's input is separated with a semi-colon, we make use of the .split() method
        // to split every element into a neat array.
        String[] candidates = collection.split(";");

        // We create another String array of length 2 that will contain a candidate's ID and name in a for-loop.
        String[] processCandidates = new String[2];

        // We create the main two-dimensional array that will contain a column of IDs and a column of names.
        // Each candidate will have their own row.
        String[][] finalCandidates = new String[candidates.length][2];

        // We create an Int array that contain each candidate's total number of votes. The index of the vote number
        // is the same as the index of the candidate in the main two-dimensional array.
        int[] votes = new int[finalCandidates.length];

        // In this for-loop, we iterate through every element in the 'candidates' array and split the ID and the name
        // of the candidates, which are separated with a comma. Using the .split() method, we store the ID and the name
        // of the candidate in the 'processCandidates' array, and use the .trim() method to remove any whitespaces
        // located at the beginning and the end of the ID and the name. In the 'finalCandidates' array, we store the
        // ID of the candidate at index 0 in their respective row, and the name of the candidates at index 1 in the same
        // row. We also employ the .toUpperCase() method to turn every character of the candidate's name upper-case
        // for clear formatting later on.
        for (int i = 0; i < candidates.length; i++) {
            processCandidates = candidates[i].split(",");
            finalCandidates[i][0] = processCandidates[0].trim();
            finalCandidates[i][1] = processCandidates[1].trim().toUpperCase();
        }

        // This do-while loop requests the user to input a code to operate the program. If the user does not input a
        // valid input, which either is a non-integer or an integer lesser than 0 and larger than 4, the loop
        // repeats the instruction and awaits a valid input.
        do {
            System.out.print("Enter a code, from the aforemenetioned, that corresponds to your task: ");
            while (! in.hasNextInt()) {
                System.out.print("\nEnter a code, from the aforemenetioned, that corresponds to your task: "); in.next();
            }
            codeEntered = in.nextInt();
        } while (codeEntered < 0 && codeEntered > 4);
        
        // This while-loop is the main loop of the entire program, if the user inputs the code 0, it terminates
        // the program and displays the exit message, found at the end of the code.
        while (codeEntered != 0) {
        	
        	// If the code entered by the user is an integer inclusively found between 1 and 4, we run a switch
        	// statement that each contains a specific set of instruction to perform a certain operation.
            switch (codeEntered) {
            
            // If the code entered by the user is 1, the goal of the program is to display the IDs and the names
            // of the candidates in a well-formatted table.
            case 1:
            	
            	// We first display the heading of the table.
                System.out.println("****************************************");
                System.out.println("| ID >> Candidate's Name               |");
                System.out.println("****************************************");
                
                // This for-loop iterates through the 'finalCandidates' array and displays each candidate's ID
                // and name in a line.
                for (int i = 0; i < finalCandidates.length; i++) {
                    System.out.print("| " + finalCandidates[i][0] + " >> ");

                    System.out.printf("%-31s", finalCandidates[i][1]);

                    System.out.println("|");
                }
                
                // Once every candidate has been displayed, we close the table.
                System.out.println("****************************************");
                
                // The operation is done, and we end the case, next requesting the user for another code.
                break;

            // If the code entered by the user is 2, the goal of the program is to increment the vote number
            // of a candidate that the user will specifically identify.
            case 2:
            	
            	// We initialize a boolean variable that will be used in a do-while loop.
                boolean actualID = false;
                
                // We initialize a String variable which will contain the user's input in
                // identifying the ID of the candidate for which they wish to vote for.
                String idEntered = "";

                // The following do-while loop requests the user to enter the ID of the candidate that
                // the user would like to vote for.
                do {
                	// We display the request message.
                    System.out.print("\nPlease enter the ID of the candidate you wish to vote for: ");

                    // We save the user's input in the 'idEntered' variable.
                    idEntered = in.next();
                    
                    // We validate the input by attempting to match it one of the existing IDs in 
                    // our 'finalCandidates' array.
                    for (int i = 0; i < finalCandidates.length; i++) {
                    	
                    	// This if statement runs if the user's input matches a certain ID from the 'finalCandidates' array.
                        if (idEntered.equals(finalCandidates[i][0])) {
                            
                        	//We set the 'actualID' boolean variable to end the do-while loop on the next iteration.
                        	actualID = true;
                            
                        	// We display a message explaining that the user's vote has been processed.
                            System.out.println("Your ballot has been successfully casted for: " + finalCandidates[i][1] + " bearing Candidate ID: " + finalCandidates[i][0]);
                            
                            // We match the candidate's index in 'finalCandidates' to the same vote number having the same index in the 'votes' array.
                            votes[i] = votes[i] + 1;
                            
                            // We break the for-loop, thus stopping the do-while loop.
                            break;
                        }
                    }
                } while (!actualID);

                // The operation is done, and we end the case, next requesting the user for another code.
                break;

            // If the code entered by the user is 3, the goal of the program is to receive a new list of
            // candidates and to add their IDs and names to the existing two-dimensional array of candidates.
            case 3:
            	
            	// We display a request message for the user to input the IDs and names of new candidates.
                System.out.println("\nPlease enter a String collection of the NEW electoral candidates below:");
                
                // For the program to consume the next line and let the user input on a brand new line.
                in.nextLine(); 
                
                // The user enters a new sequence of candidates, which will be processed just like in the beginning of the program.
                String newCollection = in.nextLine();
                
                // A String array is created to store the candidates information, both ID and name in one element at a time.
                String[] tempCandidates = newCollection.split(";");
                
                // Another String array is created, which will be used in a for-loop.
                String[] processTempCandidates = new String[2];

                // A temporary 2-dimensional String array is created to contain the processed IDs and Names of the candidates inputted.
                String[][] finalTempCandidates = new String[tempCandidates.length][2];
                
                // A temporary 2-dimensional String array is created to contain the existing IDs and Names of candidates.
                String[][] oldCandidates = new String[finalCandidates.length][2];
                
                // The following for-loop goes through each semi-processed candidate in the tempCandidates array and processes them in the temporary final candidates array.
                for (int i = 0; i < tempCandidates.length; i++) {
                    processTempCandidates = tempCandidates[i].split(",");
                    finalTempCandidates[i][0] = processTempCandidates[0].trim();
                    finalTempCandidates[i][1] = processTempCandidates[1].trim().toUpperCase();
                }

                // The following for-loop stores the processed IDs and Names of the original candidates in the original final candidates array.
                for (int i = 0; i < finalCandidates.length; i++) {
                    oldCandidates[i][0] = finalCandidates[i][0];
                    oldCandidates[i][1] = finalCandidates[i][1];
                }

                // The global candidates array is reintialized to be of a larger size.
                finalCandidates = new String[oldCandidates.length + finalTempCandidates.length][2];

                // The following for-loop replaces the first few elements of the newly reinitalized array to contain the original candidates' IDs and Names.
                for (int i = 0; i < oldCandidates.length; i++) {
                    finalCandidates[i][0] = oldCandidates[i][0];
                    finalCandidates[i][1] = oldCandidates[i][1];
                }

                // The following for-loop replaces the last remaining elements of the reinitialized array to contain the new candidates.
                for (int i = oldCandidates.length; i < finalCandidates.length; i++) {
                    finalCandidates[i][0] = finalTempCandidates[i - oldCandidates.length][0];
                    finalCandidates[i][1] = finalTempCandidates[i - oldCandidates.length][1];
                }

                // An integer array is created to contain the current number of votes for each original candidate.
                int[] oldVotes = new int[votes.length];

                // The following for-loop makes the oldVotes array contain the original number of votes for each original candidate.
                for (int i = 0; i < votes.length; i++) {
                    oldVotes[i] = votes[i];
                }

                // The original votes integer array is reinitalized to be of a larger size.
                votes = new int[oldVotes.length + finalTempCandidates.length];

                // The following for-loop replaces the first few elements of the newly reinitialized votes array to contain the original number of votes for each original candidate.
                // The remaining elements are defaulted to be equal to 0.
                for (int i = 0; i < oldVotes.length; i++) {
                    votes[i] = oldVotes[i];
                }
                
                // The following message is printed to show that the program has successfully added new candidates to the system.
                System.out.println("Successfully added a NEW set of electoral candidates to the Simple Electronic Voting System (SEVS).");
                
                // The operation is completed.
                break;

            // If the code entered by the user is 4, the goal of the program is to display a table that ranks the candidates in decreasing order of votes.
            case 4:

            	// A 2-dimensional integer array is created to contain the vote number and index number of each candidate.
                int[][] voteSort = new int[votes.length][2];

                // The following for-loop adds every candidate's vote number and assigns the vote number an index value matching the index value in the main finalCandidates array.
                for (int i = 0; i < voteSort.length; i++) {
                    voteSort[i][0] = i;
                    voteSort[i][1] = votes[i];
                }

                // A boolean variable is created for a while-loop.
                boolean sorted = false;

                // The following while-loop sorts the 2-dimensional voteSort array in decreasing order by using a temporary variable for vote number and index number.
                while (!sorted) {

                    for (int i = 1; i < votes.length; i++) {
                        int index = -1;
                        int temp = -1;

                        if (voteSort[i][1] > voteSort[i - 1][1]) {
                            index = voteSort[i - 1][0];
                            temp = voteSort[i - 1][1];

                            voteSort[i - 1][0] = voteSort[i][0];
                            voteSort[i - 1][1] = voteSort[i][1];

                            voteSort[i][0] = index;
                            voteSort[i][1] = temp;

                            break;
                        }

                        if (i == votes.length - 1)
                            sorted = true;
                    }
                }

                // The top of the table is displayed.
                System.out.println("*******************************************************************");
                System.out.println("| Position | Votes/Ballots | ID | Candidate's Name                |");
                System.out.println("*******************************************************************");

                // The position integer is created to display the vote ranking of the candidate.
                int position = 1;

                // The following for-loop prints the name, id, number of votes and position number of every candidate.
                for (int i = 0; i < finalCandidates.length; i++) {
                    if (i != 0 && voteSort[i][1] != voteSort[i - 1][1]) {
                        position++;
                    }

                    System.out.print("|");
                    System.out.printf("%9s", position);
                    System.out.print(" |");

                    System.out.printf("%14s", voteSort[i][1]);
                    System.out.print(" |");

                    System.out.print(" " + finalCandidates[voteSort[i][0]][0] + " ");

                    System.out.print("| ");
                    System.out.printf("%-32s", finalCandidates[voteSort[i][0]][1]);
                    System.out.println("|");
                }

                // The bottom of the table is displayed.
                System.out.println("*******************************************************************");

                // The operation is completed.
                break;
            }

            // This do-while loop waits for the user to enter a code after every operation completed.
            // This is the part of the program that will repeat until the user has used the program
            // and enters the code 0 to exit.
            do {
                System.out.print("\nKindly continue by entering a valid code, from the aforementioned, which corresponds to your task: ");
                while (! in.hasNextInt()) {
                    System.out.print("\nKindly continue by entering a valid code, from the aforementioned, which corresponds to your task: "); in.next();
                }
                codeEntered = in.nextInt();
            } while (codeEntered < 0 && codeEntered > 4);
        }

        // If the code entered is 0, the program exits with the following message.
        System.out.print("\nThank you for using our Simple Electronic Voting System (SEVS).");

        // The scanner variable is closed once its purpose has been fulfilled.
        in.close();
    }
}