import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 A class to to fully test all the classes regarding golf and bowling.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 3
 File Name: PlayerTester.java
 */
public class PlayerTester {

    public static void main(String[] args) {

        // Initializes fileIn to an empty object
        Scanner fileIn = null;

        try
        {
            // Attempt to open the file
            fileIn = new Scanner(new FileInputStream("data.txt"));
        }
        catch (FileNotFoundException e)
        {
            // If the file could not be found, this code is executed
            // and then the program exits
            System.out.println("File not found.");
            System.exit(0);
        }


        /**
         Player array to store the bowler 0r golfer player.
         */
        Player[] playerList = new Player[100];

        /**
         An integer used for the loop instance.
         */
        int i = 0;

        /**
         An integer to store the number of scores of a particular player.
         */
        int numOfScores;

        /**
         A character to store the type of the player.
         */
        char typeOfPlayer;

        /**
         A string to store the names and other information from the file.
         */
        String namesAndOthers;

        /**
         A string to store the next characters of the typeOfPlayer line.
         */
        String blankLine;

        /**
         A String representing the scores string from the file.
         */
        String singleScore;


        do {

            // how many scores?
            numOfScores = fileIn.nextInt();

            // what type of player?
            typeOfPlayer = fileIn.next().charAt(0);

            // to skip the rest of the line after B or G
            blankLine = fileIn.nextLine();

            // name and coursename/lanename
            namesAndOthers = fileIn.nextLine();

            // Spliting the sting to values to store the value in the class object
            String[] nameAndOthersArray = namesAndOthers.split("\\s*,\\s*");


            if( typeOfPlayer == 'G' ){

                // With the file's bowler player info creating a new Golfer object
                Golfer newGolferPlayer = new Golfer(nameAndOthersArray[0], nameAndOthersArray[1]);

                for (int j = 0; j < numOfScores; j++) {

                    singleScore = fileIn.nextLine();

                    // Splitting the sting to values to store the value in the class object
                    String[] singleScoreArray = singleScore.split("\\s*,\\s*");

                    // adding the score to the newly created Golfer object's score class
                    newGolferPlayer.addScore( singleScoreArray[0], Integer.parseInt(singleScoreArray[1]), singleScoreArray[2], Double.parseDouble(singleScoreArray[3]), Integer.parseInt(singleScoreArray[4]) );

                }

                // add the newly created golfer player to player array
                playerList[i] = newGolferPlayer;


            }else if ( typeOfPlayer == 'B' ){

                // With the file's bowler player info creating a new Bowler object
                Bowler newBowlerPlayer = new Bowler(nameAndOthersArray[0], nameAndOthersArray[1]);

                for (int j = 0; j < numOfScores; j++) {

                    singleScore = fileIn.nextLine();

                    // Splitting the sting to values to store the value in the class object
                    String[] singleScoreArray = singleScore.split("\\s*,\\s*");

                    // Creating the bowlerScore object to store the Bowler player's score
                    BowlerScore newBowlerScore = new BowlerScore( singleScoreArray[0], Integer.parseInt(singleScoreArray[1]), singleScoreArray[2] );

                    // adding the score to the newly created Bowler object's score class
                    newBowlerPlayer.addScore( newBowlerScore );

                }

                // add the newly created bowler player to player array
                playerList[i] = newBowlerPlayer;

            }else{
                // not bowler and golfer
                System.out.println("Not Golfer or Bowler Player");
            }

             i++;

        // checking if there's any next integer in the file
        } while ( fileIn.hasNextInt() );

        // counter to count the "non-null" values in player array
        int counter = 0;
        for ( i = 0; i < playerList.length; i ++)
            if (playerList[i] != null)
                counter ++;


        // print all the values from file by calling the toString method
        for ( i =0; i< counter; i++ ){

            // print a single player's information using toString to each object.
            System.out.println(playerList[i]);

        }


        System.out.println("\n---------Golfer class methods test---------------\n");

        /**
         * Integer to track the number of Golfer object in the Player array also in the file.
         */
        int golferCount = 1;

        for ( i =0; i< counter; i++ ){

            /**
             * Checking if the Player object is a instance of Golfer or not.
             */
            if ( playerList[i] instanceof Golfer ){
                 System.out.println("Golfer object: " + golferCount );

                Golfer newGolfer = new Golfer();
                newGolfer = (Golfer) playerList[i];

                System.out.println();
                System.out.println(newGolfer);

                // Get the score object of a given date
                System.out.println("Get the score of this date(10/23/2013):\n" );

                if( newGolfer.getScore("10/23/2013") != null ) {
                    System.out.println("Score   Date\t       Course    \tCourse Rating    Course Slope");
                    System.out.println(newGolfer.getScore("10/23/2013"));
                }else{
                    System.out.println("The score of the given date is not found in the score array.\n");
                }

                // Find the lowest score of the score object
                System.out.println("\nFind the lowest score of the score array:");

                if( newGolfer.lowestScore() != null ) {
                    System.out.println("Score   Date\t\t     Course    \tCourse Rating    Course Slope");
                    System.out.println(newGolfer.lowestScore());
                }else{
                    System.out.println("There's no score object added in the score array.\n");
                }

                // delete a score object
                System.out.println("Delete the score of this date(10/23/2013).\n ");

                if( newGolfer.deleteScore("10/23/2013") ) {
                    System.out.println("After deleting show the rest of the scores left in the score array.");
                    System.out.println(newGolfer);
                }else{
                    System.out.println("The score of the given date is not found in the score array.");
                }

                golferCount++;

            }


        }


        // closing the file
        fileIn.close();

    }

}