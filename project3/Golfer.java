import java.lang.String;
import java.util.GregorianCalendar;

/**
 A class to get and set all the variables needed to play Golf.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 3
 File Name: Golfer.java
 */

public class Golfer extends Player {


    /**
     A String representing the golf course where the player's handicap is keep.
     */
    private String homeCourse;

    /**
     an Array - stores all the golfer's scores.
     */
    private Score[] scores;

    /**
     Constructs a Golfer with no parameter value. In which sets all instance field to a default value. Creates Array.
     */
    public Golfer() {

        super("John Doe");

        setHomeCourse("Pensacola");

        // creates array

        scores = new Score[20];

    }

    /**
     Constructs a Golfer with the maximumGuess parameter. In which the Random object has been initialized.
     @param givenName a constructor parameter that is used to set the value of name.
     @param givenCourse a constructor parameter that is used to set the value of homeCourse.
     */
    public Golfer( String givenName, String givenCourse ){

        super(givenName);

        setHomeCourse( givenCourse );

        // creates array.

        scores = new Score[20];
    }


    /**
     accessor method for instance variable homeCourse.
     @return the value of the homeCourse.
     */
    public String getHomeCourse(){
        return homeCourse;
    }

    /**
     mutator method for instance variable homeCourse.
     @param theHomeCourse String type parameter that set the value of the homeCourse instance variable.
     */
    public void setHomeCourse( String theHomeCourse ){
        homeCourse = theHomeCourse;
    }


    /**
     create a Score object from the parameters that represent the course, course rating, course slope, date and score.
     Adds the newly created Score object to the Array of Scores.
     @param theCourseName a String parameter that is used to set the value of courseName.
     @param theScore a String parameter that is used to set the value of score.
     @param theDate a String parameter that is used to set the value of date.
     @param theCourseRating a String parameter that is used to set the value of courseRating.
     @param theCourseSlope a String parameter that is used to set the value of courseSlope.
     */
    public void addScore( String theCourseName, int theScore, String theDate, double theCourseRating, int theCourseSlope ){


        // gregorian calendar check

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setLenient(false);

        String[] splitDate = theDate.split("/");

        int month = Integer.parseInt( splitDate[0] );
        int days = Integer.parseInt( splitDate[1] );
        int year = Integer.parseInt( splitDate[2] );


        /**
         * Check if the date given is valid or not.
         */
        calendar.set(year, month, days);

        try{
            calendar.getTime();


        }catch (Exception e){

            theDate = "INVALID";
        }

        /**
         Create the Score class object to add values.
         */
        Score newScore = new Score( theCourseName, theScore, theDate, theCourseRating, theCourseSlope );


        /**
         * Integer counter to count the valid score object in the score array.
         */
        int counter = 0;
        for (int i = 0; i < scores.length; i ++)
            if (scores[i] != null)
                counter ++;


        // Adds the newly created Score object to the Array of Scores.
        scores[counter] = newScore;

    }

    /**
     delete a score from the Array based on score date,  Assume only one score per day.
     @param givenDate date to find the score from the score array.
     @return  true if score found and deleted, false if not found.
     */
    public boolean deleteScore( String givenDate ){

        /**
         A temporary integer to store the index of the array for the givenDate
         */
        int scoreIndex = findScore( givenDate );

        if( scoreIndex == -1 ){

            // element not found
            return false;

        }else{

            scores[scoreIndex] = null;

            // move all remaining elements to it's previous subsequent position.
            for( int index = scoreIndex + 1; index < scores.length; index++ ){

                scores[index-1] = scores[index];

            }

            return true;

        }
    }

    /**
     Get the score of a specific date.
     @param givenDate date to find the score from the score array.
     @return a score object based on the score date.
     */
    public Score getScore( String givenDate ){

        /**
         A integer to store the result of the findScore method.
         */
        int getTheDate = findScore( givenDate );

        if( getTheDate != -1 ){

            return scores[getTheDate];

        }else{

            return null;

        }

    }

    /**
     Find the score of a specific date
     @param findDate date to find the score from the score array.
     @return if found the Array index of a score, otherwise -1.
     */
    private int findScore( String findDate ){

        /**
         * Constant NOTFOUND that is initiated -1.
         */
        final int NOTFOUND = -1;

        for ( int i=0; i < scores.length; i++ ){

            if( scores[i] != null ) {

                /**
                 A String to store the date of a score array.
                 */
                String getTheDate = scores[i].getDate();

                if (getTheDate.equals(findDate)) {

                    return i; // return the index.

                }
            }

        }

        return NOTFOUND;

    }

    /**
     Find the lowest score of a the score array.
     @return if found the Array index of a score, otherwise -1.
     */
    public Score lowestScore(){

        /**
         Integer to store the temporary minimum value set to 0 at first.
        */
        int tempMinScore = 0;

        int small = scores[0].getScore();

        if (scores == null) {

            return null;

        }else{
            for (int i = 1; i < scores.length; i++) {

                if ( ( scores[i] != null ) ) {

                    if (scores[i].getScore() < small ) {

                        small = scores[i].getScore();
                        tempMinScore = i;

                    }
                }

            }

            return scores[tempMinScore];
        }

    }


    /**
     * that returns a double representing the golfers current handicap. (Player's class abstract method)
     *
     *  The Golf handicap index is calculated using the following steps:
     *
     *  1. Calculate the stroke differential of each the last 10 scores.
     *      1. Stroke differential is calculated using the following formula:
     *      2. Differential = (Score  -  course Rating)  x  (113 / Slope) :  round to 2 decimal places.
     *  2. Calculate the average of the 5 lowest differentials from step 1.
     *  3. Calculate the final handicap by taking 96% of the results of step 2. round to 2 decimals places
     *
     * @return handicap - the golfers current handicap.
     */
    public double calculateHandicap(){

        /**
         An integer to store the number of last items of the score array.
         */
        int flagCount = 0;

        /**
         A double to store the last scores.
         */
        double[] tempScore = new double[20];

        /**
         A double to store the Differential that'll be needed to calculate the handicap.
         */
        double Differential;


        // Count the valid scores object in array
        int counter = 0;
        for (int i = 0; i < scores.length; i ++)
            if (scores[i] != null)
                counter ++;

        // System.out.println(counter);

        for (int i = counter; i >= 0; i--){

            if( scores[i] != null ) {

                Course currentCourse = scores[i].getCourse();


                if ( flagCount < 10 && scores[i].getScore() != 9999 ) {

                    Differential = ( (double)scores[i].getScore() - currentCourse.getCourseRating()) * (113 / (double)currentCourse.getCourseSlope() );

                    //System.out.println("Diff" + Differential);

                    Differential = Math.round ( Differential * 100.0 ) / 100.0;

                    tempScore[i] = Differential;

                    flagCount++;

                }

                //flagCount++;
            }

        }

        // Sorting

        /**
         * set flag to true to begin first pass
         */
        boolean flag = true;

        /**
         * Temp to store a value in swap.
         */
        double temp;

        while ( flag )
        {
            flag= false;    //set flag to false awaiting a possible swap
            for( int j=0;  j < counter -1;  j++ )
            {
                if( tempScore[j] != 0.0 ) {

                    // check if the next item is bigger or not
                    if (tempScore[j] > tempScore[j + 1]) {
                        //swap elements
                        temp = tempScore[j];
                        tempScore[j] = tempScore[j + 1];
                        tempScore[j + 1] = temp;

                        //shows a swap occurred
                        flag = true;
                    }

                }
            }
        }

        /**
         * double to store the Sum of the minimum five scores of last 10 scores.
         */
        double sumOfMinFive = 0;

        flagCount = 0;

        for ( int i =0; i < counter; i++ ) {
            if ( tempScore[i] != 0.0 && flagCount < 5 ) {
                sumOfMinFive += tempScore[i];
                flagCount++;
            }

        }

        // calculating Average
        double average = sumOfMinFive / 5;

        // The value handicap that will returned from this function.
        double handicap = 0.96 * average;


        return handicap;
    }

    /**
     toString returns a nicely formatted String that contains the score, scorer and everything needed for a golf game.
     @return outputString - a nicely formatted String that contains the score and all other staffs needed.
     */
    public String toString(){

        /**
         * Integer counter to count the valid score object in the score array.
         */
        int counter = 0;
        for (int i = 0; i < scores.length; i ++)
            if (scores[i] != null)
                counter ++;

        /**
         * String to store golfer's name, id number and course name using the accessor method of instance variable.
         */
        String allGolfer = getName() + "\t ID Number: " + getIdNum() + "   Home Course: " + getHomeCourse() + "\t Current Handicap: " + Math.round( calculateHandicap() * 100.0 ) / 100.0 +"\n\n";

        /**
         * String to add the writings from defined output.
         */
        String middleString = "Score   Date       \t\tCourse    \tCourse Rating    Course Slope\n";

        /**
         * String to add all the score from score array.
         */
        String getAllScores = "";

        /**
         * String to add the error message if the score parameter's are not in the specified range.
         */
        String errorMessage = "\nERROR messages:\n";

        /**
         * flag integers to keep track of duplicate error messages.
         */
        int flagScore = 0, flagRating = 0, flagSlope = 0, flagDate = 0;

        for ( int i = 0; i <= counter; i++ ){

            if( scores[i] != null ) {
                getAllScores = getAllScores + scores[i];

                /**
                 * Temporary string to store the date in the score object.
                 */
                String invalidDate = scores[i].getDate();

                Course currentCourse = scores[i].getCourse();


                if ( scores[i].getScore() == 9999 || currentCourse.getCourseRating() == 9999 || currentCourse.getCourseSlope() == 9999 || invalidDate.equals("INVALID") ) {

                    if( scores[i].getScore() == 9999 ){
                        if( flagScore == 0 ) {
                            errorMessage = errorMessage + "Scores must be between 40 and 200 (inclusive).\n";
                        }
                        flagScore++;
                    }

                    if( currentCourse.getCourseRating() == 9999 ){
                        if( flagRating == 0 ) {
                            errorMessage = errorMessage + "Course rating must be between 60 and 80 (inclusive).\n";
                        }
                        flagRating++;
                    }

                    if( currentCourse.getCourseSlope() == 9999 ){
                        if( flagSlope == 0 ) {
                            errorMessage = errorMessage + "Course slope must be between 55 and 155 (inclusive).\n";
                        }
                        flagSlope++;
                    }

                    if( invalidDate.equals("INVALID") ){
                        if( flagDate == 0 ) {
                            errorMessage = errorMessage + "INVALID in date represents error input of the date.\nDate must be provided in mm/dd/yy format and in valid input.\n";
                        }
                        flagDate++;
                    }

                }
            }
        }

        if( errorMessage.equals("\nERROR messages:\n") ){

            return allGolfer + middleString + getAllScores;

        }else {

            if( flagRating != 0 || flagScore != 0 || flagSlope !=0 ) {

                String finalMessage = "\nERROR messages:\n9999 represents error input in the Score object.\n" + errorMessage.substring(17);

                return allGolfer + middleString + getAllScores + finalMessage;

            }else{
                return allGolfer + middleString + getAllScores + errorMessage;
            }

        }

    }

}