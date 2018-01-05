/**
 An Exception class to handle the Exception when answer exceed the specified Byte.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 4
 File Name: QuestionExceedByteException.java
 */
public class AnswerExceedByteException extends Exception
{

    public AnswerExceedByteException()
    {
        super("Answer length is exceeded. Answers must be within 20 characters ");
    }

    public AnswerExceedByteException(String message)
    {
        super(message);
    }
}