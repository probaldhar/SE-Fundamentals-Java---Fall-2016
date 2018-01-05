/**
 A class to get and set all the variables needed for Golf course information.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 3
 File Name: Course.java
 */
public class Course {

    /**
     a String representing the name of the course.
     */
    private String courseName;

    /**
     a double representing the course rating, it must be between 60 and 80.
     */
    private double courseRating;

    /**
     an int representing the course slope, it must be between 55 and 155.
     */
    private int courseSlope;


    /**
     Default Constructor - sets all instance fields to a default value.
     */
    public Course(){

        setCourseName("John Doe");

        setCourseRating(70.00);

        setCourseSlope(100);

    }

    /**
     Constructor - sets all instance fields from parameters
     */
    public Course( String givenCourse, double givenCourseRating, int givenCourseSlope ){

        setCourseName(givenCourse);

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
     @param theName String type parameter that set the value of the courseName instance variable.
     */
    public void setCourseName( String theName ){
        courseName = theName;
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
     @param theCourseRating String type parameter that set the value of the courseRating instance variable.
     */
    public void setCourseRating( double theCourseRating ){

        // it must be between 60 and 80 (inclusive)

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
     mutator method for instance variable courseSlope.
     @param theCourseSlope String type parameter that set the value of the courseSlope instance variable.
     */
    public void setCourseSlope( int theCourseSlope ){

        // it must be between 55 and 155 (inclusive)

        if( theCourseSlope >= 55 && theCourseSlope <= 155 ) {
            courseSlope = theCourseSlope;
        }else{
            courseSlope = 9999;
        }

    }

    /**
     toString returns a nicely formatted String that contains the Course and its instance fields that looks
     like the given in the project doc file.
     @return outputString - a nicely formatted String that contains the score and its instance fields.
     */
    public String toString(){

        return getCourseName() + "\t\t\t" + getCourseRating() + "\t\t\t\t" + getCourseSlope() + "\n";

    }



}
