/**
 A class to test the GuessingGame class properly.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 1
 File Name: GuessingGameTester.java
 */

import java.util.Scanner;

public class GuessingGameTester {


    public static void main(String[] args) {

        /**
         againNewGame - A string type variable to get the input if a user wants any new game or not.
         guessResponse - Temporary string variable to store the output of every guess found from guess class.
         */
        String againNewGame = "";
        String guessResponse;

        /**
         Create the scanner object to get the input from user.
         */
        Scanner userInput = new Scanner(System.in);

        /**
         Create the GuessingGame class object to test.
         */
        GuessingGame newGussingGame = new GuessingGame();


        /**
         The first loop that start the game with a checking if the game is over or not.
         */
        do{

            System.out.println("Welcome to the Guessing Game");
            System.out.println("Enter the maximum number");

            /**
             Set the maximum value of the number to guess.
             */
            newGussingGame.setMax(userInput.nextInt());

            System.out.println("Enter the number of guess allowed:");

            /**
             maxAllow - A temporary variable to save the user input and pass it to the newGame parameter.
             */
            int maxAllow = userInput.nextInt();


            /**
             Starts a new game by calling the newGame method of GuessingGame class.
             */
            newGussingGame.newGame( maxAllow );


            /**
             Starts the inner loop that will take guesses and prints the appropriate response for every guess.
             */
            while( !newGussingGame.isGameOver() ){

                System.out.println("Enter your guess, remember it must be between 0 and " + newGussingGame.getMax());

                /**
                 userGuessInput - A temporary variable to save the user input and pass it to the guess method parameter.
                 */
                int userGuessInput = userInput.nextInt();

                /**
                 Prints every response from the guess method of GuessingGame class.
                 */
                guessResponse = newGussingGame.guess(userGuessInput);
                System.out.println( guessResponse );

            }

            /**
             Check if the user wants to play any new game or not.
             */
            System.out.println("Would you like to play again, enter Y for yes, N for no.");

            againNewGame = userInput.next();


        }while( againNewGame.equalsIgnoreCase("y") );

    }


}