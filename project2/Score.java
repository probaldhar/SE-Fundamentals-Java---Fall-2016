/**
 A class that will contain all the variables needed to save Golf score and get the scores when needed.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 2
 File Name: Score.java
 */
public class Score {

    /**
     A String representing the name of the course.
     */
    private String courseName;

    /**
     An integer representing a 18 hole score. it must be between 40 and 200 (inclusive)
     */
    private int score;

    /**
     a String representing the date in format mm/dd/yy .
     */
    private String date;

    /**
     a double representing the course rating, it must be between 60 and 80. (inclusive).
     */
    private double courseRating;

    /**
     An integer representing the course slope, it must be between 55 and 155 (inclusive).
     */
    private int courseSlope;


    /**
     Constructs a Score with no parameter value. In which sets all instance field to a default value. Creates Array.
     */
    public Score(){

        setCourseName("");

        setScore(0);

        setDate("");

        setCourseRating(0);

        setCourseSlope(0);

    }


    /**
     Constructs a Golfer with the maximumGuess parameter. In which the Random object has been initialized.
     @param givenCourseName a constructor parameter that is used to set the value of courseName.
     @param givenScore a constructor parameter that is used to set the value of score.
     @param givenDate a constructor parameter that is used to set the value of date.
     @param givenCourseRating a constructor parameter that is used to set the value of courseRating.
     @param givenCourseSlope a constructor parameter that is used to set the value of courseSlope.
     */
    public Score( String givenCourseName, int givenScore, String givenDate, double givenCourseRating, int givenCourseSlope){

        setCourseName(givenCourseName);

        setScore(givenScore);

        setDate(givenDate);

        setCourseRating(givenCourseRating);

        setCourseSlope(givenCourseSlope);

    }


    /**
     accessor method for instance variable courseName.
     @return the value of the courseName.
     */
    public String getCourseName(){
        return courseName;
    }

    /**
     mutator method for instance variable courseName.
     @param theCourseName String type parameter that set the value of the courseName instance variable.
     */
    public void setCourseName( String theCourseName ){
        courseName = theCourseName;
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
     accessor method for instance variable courseRating.
     @return the value of the courseRating.
     */
    public double getCourseRating(){
        return courseRating;
    }

    /**
     mutator method for instance variable courseRating.
     @param theCourseRating double type parameter that set the value of the courseRating instance variable.
     */
    public void setCourseRating( double theCourseRating ){

        // it must be between 60 and 80. check this condition. (Inclusive)

        if( theCourseRating >= 60 && theCourseRating <= 80 ) {
            courseRating = theCourseRating;
        }else{
            courseRating = 9999;
        }

    }

    /**
     accessor method for instance variable courseSlope.
     @return the value of the courseSlope.
     */
    public int getCourseSlope(){
        return courseSlope;
    }

    /**
     mutator method for instance variable courseRating.
     @param theCourseSlope double type parameter that set the value of the courseSlope instance variable.
     */
    public void setCourseSlope( int theCourseSlope ){

        // it must be between 55 and 155 (inclusive).

        if( theCourseSlope >= 55 && theCourseSlope <= 155 ) {
            courseSlope = theCourseSlope;
        }else{
            courseSlope = 9999;
        }

    }


    /**
     toString returns a nicely formatted String that contains the score and its instance fields that looks
     like the given in the project doc file.
     @return outputString - a nicely formatted String that contains the score and its instance fields.
     */
    public String toString(){

        return getScore() + "\t\t" + getDate() + "\t\t" + getCourseName() + "\t\t\t" + getCourseRating() + "\t\t\t\t" + getCourseSlope() + "\n";

    }
}


