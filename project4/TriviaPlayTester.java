import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 A class to play trivia game.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 4
 File Name: TriviaPlayTester.java
 */

public class TriviaPlayTester {

    public static void main(String[] args) {

        /**
         * Integer to store the choose menu number.
         */
        int adminChoose;

        /**
         * integer to store the ID of a question to delete.
         */
        int askedIDForDelete;

        /**
         * String to store the given question by a user.
         */
        String inputQuestion;

        /**
         * String to store the given answer of a question by a user.
         */
        String inputAnswer;

        /**
         * Integer to store the point for the given question
         */
        int inputPoint;

        /**
         * String to store the user input if a user is new or existing one.
         */
        String playerStatus;

        /**
         * Player's name
         */
        String playerName;

        /**
         * Player's nick name.
         */
        String playerNickName;

        /**
         * Player's score of this session.
         */
        int playerScoreSession;

        /**
         * Player's all time Score.
         */
        int playerAllTimeScore;

        /**
         * Stores the current question object.
         */
        Questions currentQuestion;

        /**
         * Stores the answer given by user.
         */
        String givenAnswerByUser;

        /**
         * Stores the correct answer of a question. Read from file
         */
        String correctQuestion;

        /**
         * Yes/No decision.
         */
        String yesNoDecision;

        /**
         * Another user game play input
         */
        String anotherUserPlay;


        /**
         * keyboard input
         */
        Scanner userInput = new Scanner(System.in);

        /**
         * An administrator object.
         */
        QuestionAdministrator newGameAdmin = new QuestionAdministrator();


        // administrator starts

        do{
            // calling the show menu
            newGameAdmin.lineMenu();

            System.out.println("Enter choice: ");
            adminChoose = userInput.nextInt();

            // finishing the line for input
            userInput.nextLine();

            // switch case to doing operation
            switch (adminChoose){

                case 1 :
                    // List all questions
                    newGameAdmin.displayQuestions();
                    break;

                case 2 :
                    // delete questions
                    // asking user to enter ID number of a question
                    System.out.println("Enter a valid question ID to delete from file.");
                    askedIDForDelete = userInput.nextInt();
                    newGameAdmin.deleteQuestion(askedIDForDelete);

                    // should I eat this line also?
                    userInput.nextLine();
                    break;

                case 3 :
                    // add question
                    System.out.println("Enter Question to add in file.");
                    inputQuestion = userInput.nextLine();
                    System.out.println("Enter Answer of the Question.");
                    inputAnswer = userInput.nextLine();

                    // check for incorrect question point
                    do {
                        System.out.println("Enter Point of the question.");
                        inputPoint = userInput.nextInt();

                        if (inputPoint<1 || inputPoint>5)
                            System.out.println("Points for a question must be between 1 and 5, Try again");

                    }while (inputPoint<1 || inputPoint>5);

                    // need to figure out the ID
                    // adding question to file
                    newGameAdmin.addQuestion( inputQuestion, inputAnswer, inputPoint );

                    // Eat the current Line
                    userInput.nextLine();

                    break;

                case 4:
                    System.out.println("Quiting administrator: ");
                    break;

                default:
                    System.out.println("Enter correct number from the menu.");
                    break;

            }

        } while ( adminChoose != 4 );

        // administrator ends


        // setting player's current score to 0
        playerScoreSession = 0;


        do {

            // check for incorrect input from user
            do {
                // player info starts
                System.out.println("Are you a new or existing user. Enter n for new user, e for existing user");
                playerStatus = userInput.nextLine();

                if ( !playerStatus.equalsIgnoreCase("n") && !playerStatus.equalsIgnoreCase("e") ){
                    System.out.println("Please enter correct choice. Try again");
                }

            } while( !playerStatus.equalsIgnoreCase("n") && !playerStatus.equalsIgnoreCase("e") );

            if (playerStatus.equalsIgnoreCase("n")) {
                //new user, create file

                // setting all time score of a user to 0 because of new user
                playerAllTimeScore = 0;

                System.out.println("Enter name: ");
                playerName = userInput.nextLine();

                System.out.println("Enter nickname: ");
                playerNickName = userInput.nextLine();

                TriviaGame newTriviaGame = new TriviaGame();

                do {

                    newTriviaGame.randomQuestions();

                    for (int i = 0; i < 5; i++) {

                        currentQuestion = newTriviaGame.nextQuestion(i);

                        // current question asked
                        System.out.println(currentQuestion.getQuestion().trim());

                        // prompt user for answer
                        givenAnswerByUser = userInput.nextLine();

                        // evaluating the answer
                        correctQuestion = newTriviaGame.evaluateAnswer(currentQuestion, givenAnswerByUser);

                        // displaying the evaluation
                        System.out.println(correctQuestion);
                        if ( correctQuestion.equalsIgnoreCase("That is correct!")){
                            playerScoreSession += currentQuestion.getValue();
                        }

                        System.out.println("Your score is " + playerScoreSession);


                    } // random question ends

                    // only 1 session for new player
                    playerAllTimeScore = playerAllTimeScore + playerScoreSession;

                    do {
                        System.out.println("Want to play again? Enter y for yes n for No.");
                        yesNoDecision = userInput.nextLine();

                        if ( !yesNoDecision.equalsIgnoreCase("y") && !yesNoDecision.equalsIgnoreCase("n") ){
                            System.out.println("Please enter correct choice. Try again");
                        }

                    } while( !yesNoDecision.equalsIgnoreCase("y") && !yesNoDecision.equalsIgnoreCase("n") );

                } while (yesNoDecision.equalsIgnoreCase("y"));

                // Displaying Player Info
                System.out.println("Your Nick Name is " + playerNickName);
                System.out.println("Your current score is " + playerScoreSession);
                System.out.println("Your Total score is " + playerAllTimeScore);

                PlayerInfo newPlayerAndFile = new PlayerInfo(playerName, playerNickName, playerAllTimeScore);

                // File creating
                newPlayerAndFile.addPlayerFile(newPlayerAndFile);


            } else if (playerStatus.equalsIgnoreCase("e")) {
                // existing user

                String existingNickName = "";
                playerAllTimeScore = 0;

                while (true) {

                    System.out.println("Enter your user name");
                    playerName = userInput.nextLine();


                    try {
                        ObjectInputStream inputStream =
                                new ObjectInputStream(new FileInputStream(playerName.trim().replaceAll("\\s","") + ".dat"));

                        PlayerInfo existingPlayer = (PlayerInfo) inputStream.readObject();

                        existingNickName = existingPlayer.getNickName();
                        playerAllTimeScore = existingPlayer.getCurrentScore();

                        System.out.println("Welcome back : " + existingPlayer.getName());

                        inputStream.close();
                        break;

                    } catch (ClassNotFoundException e) {
                        System.out.println("Problems with file input.");
                    } catch (FileNotFoundException e) {
                        System.out.println("Cannot find user file.\nTry Again with correct user name");
                    } catch (IOException e) {
                        System.out.println("Problems with input from numbers.dat.");
                    }

                }


                // creating TriviaGame object to play the game
                TriviaGame newTriviaGame = new TriviaGame();

                do {

                    // generating questions randomly
                    newTriviaGame.randomQuestions();

                    for (int i = 0; i < 5; i++) {

                        currentQuestion = newTriviaGame.nextQuestion(i);

                        // current question asked
                        System.out.println(currentQuestion.getQuestion().trim());

                        // prompt user for answer
                        givenAnswerByUser = userInput.nextLine();

                        // evaluating the answer
                        correctQuestion = newTriviaGame.evaluateAnswer(currentQuestion, givenAnswerByUser);

                        // displaying the evaluation
                        System.out.println(correctQuestion);
                        if ( correctQuestion.equalsIgnoreCase("That is correct!")){
                            playerScoreSession += currentQuestion.getValue();
                        }

                        System.out.println(" Your score is " + playerScoreSession);

                    } // random question ends

                    // adding the score to all time score fot the user
                    playerAllTimeScore = playerAllTimeScore + playerScoreSession;

                    do {
                        System.out.println("Want to play again? Enter y for yes n for No");
                        yesNoDecision = userInput.nextLine();

                        if ( !yesNoDecision.equalsIgnoreCase("y") && !yesNoDecision.equalsIgnoreCase("n") ){
                            System.out.println("Please enter correct choice. Try again");
                        }

                    } while( !yesNoDecision.equalsIgnoreCase("y") && !yesNoDecision.equalsIgnoreCase("n") );

                } while (yesNoDecision.equalsIgnoreCase("y"));

                // Displaying Player Info
                System.out.println("Your Nick Name is " + existingNickName);
                System.out.println("Your current score is " + playerScoreSession);
                System.out.println("Your Total score is " + playerAllTimeScore);

                PlayerInfo newPlayerAndFile = new PlayerInfo(playerName, existingNickName, playerAllTimeScore);

                // File creating
                newPlayerAndFile.addPlayerFile(newPlayerAndFile);


            } else {
                System.out.println("Incorrect choice.");
                // exit
            }

            // checking for invalid input
            do {
                System.out.println("Any another user to play the game? Enter y for yes q for quit");
                anotherUserPlay = userInput.nextLine();

                if ( !anotherUserPlay.equalsIgnoreCase("y") && !anotherUserPlay.equalsIgnoreCase("q") ){
                    System.out.println("Please enter correct choice. Try again");
                }
            } while ( !anotherUserPlay.equalsIgnoreCase("y") && !anotherUserPlay.equalsIgnoreCase("q") );


        } while (!anotherUserPlay.equalsIgnoreCase("q"));// end of main do



    } // end of main

} // end of class
