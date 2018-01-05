import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 A class to handle the Trivia question game

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 4
 File Name: TriviaGame.java
 */

public class TriviaGame {

    /**
     * Questions array to store the five random questions.
     */
    private Questions[] questionCollection;

    /**
     * generator - a random Generator object.
     */
    private Random generator;

    /**
     Constructs a TriviaGame with no parameter value. In which the Random object has been initialized.
     */
    public TriviaGame(){

        generator = new Random();

        questionCollection = new Questions[100];

    }

    /**
     Constructs a TriviaGame with the maximumGuess parameter. In which the Random object has been initialized.
     @param maxRandom a constructor parameter
     */
    public TriviaGame( int maxRandom ){

        generator = new Random(maxRandom);

        questionCollection = new Questions[100];

    }

    /**
     * The method to choose five questions randomly from file and to store them in the Questions array.
     */
    public void randomQuestions(){

        try{

            RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");

            /**
             * Storing the length of the file
             */
            long lengthFile = ioStream.length();

            /**
             * Calculating the last question ID number. 83 is the Byte size that needed to store a question.
             */
            int lastQuesNum = (int)lengthFile/83;

            ioStream.seek(0);

            /**
             * Integer to keep track of instances of a loop.
             */
            int i=0;
            while (i<5){

                // search the file
                for ( int j = 0; j < lengthFile; j = j + 83 ){

                    // random number generate
                    int randomID = generator.nextInt( lastQuesNum + 1 );

                    ioStream.seek(j);

                    // storing the ID
                    int tempID = ioStream.readInt();

                    // if item found
                    if( tempID == randomID ){
                        // System.out.println("Item found");

                        // if the question not deleted
                        if( ioStream.readBoolean() ){
                            // valid question

                            /**
                             * Temporary storing the question whose ID randomly generated.
                             */
                            String theQuestion = ioStream.readUTF();

                            /**
                             * Temporary storing the answer of the question whose ID randomly generated.
                             */
                            String theAnswer = ioStream.readUTF();

                            /**
                             * Temporary storing the point of the question whose ID randomly generated.
                             */
                            int theValue = ioStream.readInt();

                            // creating new Questions object
                            Questions newQuestion = new Questions(tempID, theQuestion, theAnswer, theValue);

                            // adding question to the question array
                            questionCollection[i] = newQuestion;

                            i++;

                        }

                    }

                }

            }

            System.out.println("Question selected randomly.");

            // closing the file
            ioStream.close();

        }catch(FileNotFoundException e)
        {
            System.out.println("Problem opening file.");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("Problems with file I/O.");
        }


    }

    /**
     * The method to return the next question in the Question array.
     @param currentQuestion the current Question number.
     @return the current question object from the array.
     */
    public Questions nextQuestion(int currentQuestion){

        return questionCollection[currentQuestion];

    }

    /**
     * The method to evaluate the answer of the question.
     @param currentQuestion the current Question object.
     @return the Answer of the question.
     */
    public String evaluateAnswer( Questions currentQuestion, String givenAnswer ){

        String evaluatedOutput;

        if ( currentQuestion.getAnswer().trim().equalsIgnoreCase(givenAnswer) ){
            // correct answer

            evaluatedOutput = "That is correct!";

        }else{
            // wrong answer
            evaluatedOutput = "Wrong. The correct answer is " + currentQuestion.getAnswer().trim();
        }

        return evaluatedOutput;


    }


}
