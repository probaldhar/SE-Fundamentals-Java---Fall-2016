import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 A class to handle the question administrator.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 4
 File Name: QuestionAdministrator.java
 */
public class QuestionAdministrator {

    /**
     A integer to store the question ID.
     */
    public static int questionID = 1;

    /**
     Constructs a QuestionAdministrator with no parameter value.
     */
    public QuestionAdministrator(){

    }

    /**
     accessor method for instance variable questionID.
     @return the value of the questionID.
     */
    public int getQuestionID(){
        return questionID;

    }

    /**
     mutator method for instance variable questionID.
     */
    public void setQuestionID( ){
        questionID++;
    }

    /**
     * The method to show the command line menu.
     */
    public void lineMenu(){

        System.out.println("Trivia Game Administration");
        System.out.println("  1. List all questions");
        System.out.println("  2. Delete question");
        System.out.println("  3. Add question");
        System.out.println("  4. Quit");

    }

    /**
     addQuestion method which append a question to the random access file.
     @param newQuestion the question to be stored.
     @param newAnswer the answer of the question.
     @param newPoint the point for the question.
     */
    public void addQuestion( String newQuestion, String newAnswer, int newPoint ){

        try{

            RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");

            long lengthFile = ioStream.length();

            int numberOfQuestion = (int)lengthFile/83;

            // incrementing the static variable
            setQuestionID();


            // setting the file pointer to the last of the file to add new questions
            ioStream.seek(lengthFile);

            if ( newQuestion.length() > 50 )
                throw new QuestionExceedByteException();

            if ( newAnswer.length() > 20 )
                throw new AnswerExceedByteException();

            // writing to the file
            ioStream.writeInt(++numberOfQuestion);
            ioStream.writeBoolean(true);
            ioStream.writeUTF(String.format("%50s", newQuestion));
            ioStream.writeUTF(String.format("%20s", newAnswer));
            ioStream.writeInt(newPoint);

            // closing the file
            ioStream.close();

        }catch(QuestionExceedByteException e)
        {
            System.out.println(e.getMessage());
        }
        catch(AnswerExceedByteException e)
        {
            System.out.println(e.getMessage());
        }
        catch(FileNotFoundException e)
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
     deleteQuestion method which deletes a question from a file.
     @param givenID is the given ID that should be deleted from file.
     */
    public void deleteQuestion(int givenID){

        try{

            RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");

            long lengthFile = ioStream.length();

            // setting the file pointer to the beginning of the file
            ioStream.seek(0);

            // search the file
            for ( int j = 0; j < lengthFile; j = j + 83 ) {

                ioStream.seek(j);

                // storing the ID
                int tempID = ioStream.readInt();

                // if item found
                if( tempID == givenID ) {
                    //System.out.println("Item found");

                    // writing false for this question
                    ioStream.writeBoolean(false);
                }

            }

            // closing the file
            ioStream.close();


        }
        catch(FileNotFoundException e)
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
     displayQuestions method which displays all the questions stored in the file.
     */
    public void displayQuestions(){

        try{

            RandomAccessFile ioStream = new RandomAccessFile("bytedata", "rw");

            long lengthFile = ioStream.length();

            // setting the file pointer to the beginning of the file
            ioStream.seek(0);

            // search the file
            for ( int j = 0; j < lengthFile; j = j + 83 ) {

                ioStream.seek(j);

                // question ID
                int serialNumber = ioStream.readInt();

                // check if it's a valid question or not.
                if ( ioStream.readBoolean() ){

                    // printing the question
                    System.out.println ( serialNumber + ". " + ioStream.readUTF().trim() );
                    System.out.println ( "   Answer" + ": " + ioStream.readUTF().trim() );
                    System.out.println ( "   Points" + ": " + ioStream.readInt() );

                }

            }

            // closing the file
            ioStream.close();


        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem opening file.");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("Problems with file I/O.");
        }

    }


}
