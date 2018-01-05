/**
 A clsss that contains all the material to play a guessing game.
 It generates a Random number between a range, minimum value is 0, maximum can be defined by user.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 1
 File Name: GuessingGame.java
 */

import java.util.Random;

public class GuessingGame {

    /**
     answer - integer representing the randomly generated number within a range of 0 to max.
     max - an integer representing the maximum value of the number to guess.
     differential - an integer representing the difference between a guess and the answer.
     maxGuessesAllowed - an integer representing the maximum number of guesses the user gets, once this value is passed the game is over.
     numGuessesTaken - an integer that stores the number of guessed taken so far in any game.
     gameOver - a Boolean, false if game still in progress, true if the game is over.
     generator - a random Generator object.
     */

    private int answer, differential, max, maxGuessesAllowed, numGuessesTaken;
    private boolean gameOver;

    private Random generator;


    /**
     Constructs a GuessingGame with no parameter value. In which the Random object has been initialized.
     */

    public GuessingGame(){

        setMax( 0 );

        setGameOver( false );

        generator = new Random();

    }


    /**
     Constructs a GuessingGame with the maximumGuess parameter. In which the Random object has been initialized.
     @param maximumGuess a constructor parameter
     */

    public GuessingGame( int maximumGuess ){

        generator = new Random();

    }

    /**
     accessor method for instance variable gameOver.
     @return the value of the gameOver.
     */
    public boolean getGameOver(){
        return gameOver;
    }

    /**
     mutator method for instance variable gameOver.
     @param ifTheGameOver boolean parameter that set the value of the gameOver instance variable.
     */
    public void setGameOver(boolean ifTheGameOver ){
        gameOver = ifTheGameOver;
    }

    /**
     accessor method for instance variable answer.
     @return the value of the answer.
     */
    public int getAnswer(){
        return answer;
    }

    /**
     mutator method for instance variable answer.
     @param theAnswer boolean parameter that set the value of the answer instance variable.
     */
    public void setAnswer(int theAnswer ){
        answer = theAnswer;
    }

    /**
     mutator method for instance variable differential.
     @param theDifferential boolean parameter that set the value of the differential instance variable.
     */
    public void setDifferential(int theDifferential ){
        differential = theDifferential;
    }

    /**
     accessor method for instance variable differential.
     @return the value of the differential.
     */
    public int getDifferential(){
        return differential;
    }

    /**
     mutator method for instance variable maxGuessesAllowed.
     @param theMaxDifferential boolean parameter that set the value of the maxGuessesAllowed instance variable.
     */
    public void setMaxGuessesAllowed(int theMaxDifferential ){
        maxGuessesAllowed = theMaxDifferential;
    }

    /**
     accessor method for instance variable maxGuessesAllowed.
     @return the value of the maxGuessesAllowed.
     */
    public int getMaxGuessesAllowed(){
        return maxGuessesAllowed;
    }

    /**
     mutator method for instance variable numGuessesTaken.
     @param theNumGuessesTaken integer parameter that set the value of the numGuessesTaken instance variable.
     */
    public void setNumGuessesTaken( int theNumGuessesTaken ){
        numGuessesTaken = theNumGuessesTaken;
    }

    /**
     accessor method for instance variable numGuessesTaken.
     @return the value of the numGuessesTaken.
     */
    public int getNumGuessesTaken(){
        return numGuessesTaken;
    }

    /**
     mutator method for instance variable max.
     @param theMax integer parameter that set the value of the max instance variable.
     */
    public void setMax( int theMax ){
        max = theMax;
    }

    /**
     accessor method for instance variable max.
     @return the value of the max.
     */
    public int getMax(){
        return max;
    }




    /**
     newGame method initialize a new round of guessing game, it also generates the answer by using the generator random
     object, set the gameOver to false, differential to max because there's no differential at the first of every game.
     At this point of the game there's no guesses have taken so set the numGuessesTaken to zero.
     @param maximumGuessUser representing the maximum number of guesses and sets maxGuessesAllowed.
     @return returns nothing.
     */

    public void newGame( int maximumGuessUser ){

        setMaxGuessesAllowed( maximumGuessUser );

        setAnswer( generator.nextInt( getMax() + 1 ) );

        setGameOver( false );

        setDifferential( getMax() );

        setNumGuessesTaken( 0 );

    }

    /**
     guess method which determine the output string based on the every new guess that user has given inout. It takes
     the new guess as it's paramenter named newGuess and calculate the output string based on the difference between the
     answer and newGuess.
     @param newGuess parameter that accept every guess of a game.
     @return outputString - string which calculated based on the guess input.
     */

    public String guess( int newGuess ){

        /**
         outputString - stores the output string based on the guess that a user has given.
         tempNumGuessesTaken - increase the number of guess taken and stores it back to the instance variable.
         */
        String outputString ="";
        int tempNumGuessesTaken;

        tempNumGuessesTaken = getNumGuessesTaken();
        tempNumGuessesTaken++;

        /**
         Increase the number of the guesses taken everytime a user gave a guess.
         */
        setNumGuessesTaken( tempNumGuessesTaken );


        /**
         Check if the number of guesses taken is greater or equal to the maximum number of guess is allowed in a game.
         When this two equals we have to exit this round of the game.
         */
        if( getNumGuessesTaken() >= getMaxGuessesAllowed() ){

            setGameOver( true );

        }

        /**
         Set the appropriate output string for the current guess of the game.
         */
         if( newGuess > getMax() || newGuess < 0 ){

             outputString = "Guess out of range, The guess must be between 0 and " + getMax();

         }else if( newGuess > getAnswer() ){

             if( getDifferential() > newGuess - getAnswer() ) {

                 outputString = "Too High\nGetting Warmer";

             }else{

                 outputString = "Too High\nGetting Colder";

             }

            setDifferential( newGuess - getAnswer() );

         }else if( newGuess < getAnswer() ){

              if( getDifferential() > getAnswer() - newGuess ) {

                  outputString = "Too Low\nGetting Warmer";

              }else{

                  outputString = "Too Low\nGetting Colder";

              }

             setDifferential( getAnswer() - newGuess );

         }else{

            outputString = "Congratulation";

            setGameOver( true );

         }

         return outputString;


    }

    /**
     isGameOver boolean method that determine if the game of over or not with the gameOver boolean variable.
     @param no parameter for this method
     @return returns the boolean gameOver value.
     */

    public boolean isGameOver(){

        return getGameOver();

    }



}