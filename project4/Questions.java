/**
 A class to handle the Questions.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 4
 File Name: Questions.java
 */
public class Questions {


    /**
     A integer to store the question ID.
     */
    private static int questionID;

    /**
     A String to store the question.
     */
    private String question;

    /**
     A String to store the answer of the question.
     */
    private String answer;

    /**
     A integer to store the value of a question. Point value should be 1 to 5.
     */
    private int value;



    /**
     Constructs a Questions with default values.
     */
    public Questions(){

        setQuestionID(0);

        setQuestion("");

        setAnswer("");

        setValue(1);

    }

    /**
     Constructs a Question with the parameters.
     @param theID a constructor parameter that is used to set the value of questionID.
     @param theQues a constructor parameter that is used to set the value of question.
     @param theAnswer a constructor parameter that is used to set the value of answer.
     @param theValue a constructor parameter that is used to set the value of value.
     */
    public Questions( int theID, String theQues, String theAnswer, int theValue ){

        setQuestionID(theID);

        setQuestion(theQues);

        setAnswer(theAnswer);

        setValue(theValue);

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
     // @param theID String type parameter that set the value of the questionID instance variable.
     */
    public void setQuestionID( int theID ){
        questionID = theID;
    }

    /**
     accessor method for instance variable question.
     @return the value of the question.
     */
    public String getQuestion(){
        return question;
    }

    /**
     mutator method for instance variable question.
     @param theQuestion String type parameter that set the value of the question instance variable.
     */
    public void setQuestion( String theQuestion ){
        question = theQuestion;
    }

    /**
     accessor method for instance variable answer.
     @return the value of the answer.
     */
    public String getAnswer(){
        return answer;
    }

    /**
     mutator method for instance variable answer.
     @param theAnswer String type parameter that set the value of the answer instance variable.
     */
    public void setAnswer( String theAnswer ){
        answer = theAnswer;
    }

    /**
     accessor method for instance variable value.
     @return the value of the value.
     */
    public int getValue(){
        return value;
    }

    /**
     mutator method for instance variable value.
     @param theValue String type parameter that set the value of the value instance variable.
     */
    public void setValue( int theValue ){

        if( theValue >= 1 && theValue <= 5 ) {
            value = theValue;
        }else{
            value = 9999;
        }
    }




}
