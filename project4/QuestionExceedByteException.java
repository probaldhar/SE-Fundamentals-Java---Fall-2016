/**
 An Exception class to handle the Exception when question exceed the specified Byte.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 4
 File Name: QuestionExceedByteException.java
 */
public class QuestionExceedByteException extends Exception
{

    public QuestionExceedByteException()
    {
        super("Question length is exceeded. Questions must be within 50 characters ");
    }

    public QuestionExceedByteException(String message)
    {
        super(message);
    }
}