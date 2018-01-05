/**
 A class that will contain all the variables needed to save Golf score and get the scores when needed.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 3
 File Name: Score.java
 */
public class Score {

    /**
     Course object of type Course that stores the courseName, courseRating and courseSlope.
     */
    private Course theCourse;

    /**
     An integer representing a 18 hole score. it must be between 40 and 200 (inclusive)
     */
    private int score;

    /**
     a String representing the date in format mm/dd/yy .
     */
    private String date;


    /**
     Constructs a Score with no parameter value. In which sets all instance field to a default value. Creates Array.
     */
    public Score(){

        theCourse = new Course("", 0, 0);

        setScore(0);

        setDate("");

    }

    /**
     Constructs a Golfer with the maximumGuess parameter. In which the Random object has been initialized.
     @param givenCourseName a constructor parameter that is used to set the value of courseName.
     @param givenScore a constructor parameter that is used to set the value of score.
     @param givenDate a constructor parameter that is used to set the value of date.
     @param givenCourseRating a constructor parameter that is used to set the value of courseRating.
     @param givenCourseSlope a constructor parameter that is used to set the value of courseSlope.
     */
    public Score( String givenCourseName, int givenScore, String givenDate, double givenCourseRating, int givenCourseSlope ){

        theCourse = new Course ( givenCourseName, givenCourseRating, givenCourseSlope );

        setScore(givenScore);

        setDate(givenDate);

    }


    /**
     accessor method for instance variable score.
     @return the value of the score.
     */
    public int getScore(){
        return score;
    }

    /**
     mutator method for instance variable score.
     @param theScore integer type parameter that set the value of the score instance variable.
     */
    public void setScore( int theScore ){

        // it must be between 40 and 200 (inclusive)

        if( theScore >= 40 && theScore <= 200 ) {
            score = theScore;
        }else{
            score = 9999;
        }

    }

    /**
     accessor method for instance variable date.
     @return the value of the date.
     */
    public String getDate(){
        return date;
    }

    /**
     mutator method for instance variable date.
     @param theDate String type parameter that set the value of the date instance variable.
     */
    public void setDate( String theDate ){
        date = theDate;
    }

    /**
     * accessor method for instance Course variable.
     */
    public Course getCourse(){
        return theCourse;
    }

    /**
     toString returns a nicely formatted String that contains the score and its instance fields that looks
     like the given in the project doc file.
     @return - a nicely formatted String that contains the score and its instance fields.
     */
    public String toString(){

        if( getScore() == 9999 && !getDate().equals("INVALID") ){

            return getScore() + "\t" + getDate() + "\t\t" + getCourse().toString();

        }else if ( getDate().equals("INVALID") && getScore() != 9999 ){

            return getScore() + "\t\t" + getDate() + "\t\t\t" + getCourse().toString();

        }else if ( getScore() == 9999 && getDate().equals("INVALID") ){

            return getScore() + "\t" + getDate() + "\t\t\t" + getCourse().toString();

        }

        return getScore() + "\t\t" + getDate() + "\t\t" + getCourse().toString();

    }
}


