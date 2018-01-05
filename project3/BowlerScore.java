import java.util.GregorianCalendar;

/**
 A class to get and set all the variables needed for Bowler score Information.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 3
 File Name: BowlerScore.java
 */
public class BowlerScore {

    /**
     a String representing the name of the lane
     */
    private String laneName;

    /**
     an int representing a game's score, it must be between 0 and 300 (inclusive).
     */
    private int score;

    /**
     a String representing the date in format mm/dd/yy.
     */
    private String date;


    /**
     Default Constructor - sets all instance fields to a default value.
     */
    public BowlerScore(){

        setLaneName("John Doe");

        setScore(200);

        setDate("");

    }

    /**
     Constructor - sets all instance fields from parameters
     */
    public BowlerScore( String givenName, int givenScore, String givenDate ){

        setLaneName(givenName);

        setScore(givenScore);

        setDate(givenDate);

    }

    /**
     accessor method for instance variable laneName.
     @return the value of the laneName.
     */
    public String getLaneName(){
        return laneName;
    }

    /**
     mutator method for instance variable laneName.
     @param theName String type parameter that set the value of the laneName instance variable.
     */
    public void setLaneName( String theName ){
        laneName = theName;
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
     @param theScore String type parameter that set the value of the score instance variable.
     */
    public void setScore( int theScore ){

        // it must be between 0 and 300 (inclusive)

        if( theScore >= 0 && theScore <= 300 ) {
            score = theScore;
        }else{
            score = 9999;
        }
    }

    /**
     accessor method for instance variable courseSlope.
     @return the value of the courseSlope.
     */
    public String getDate(){
        return date;
    }

    /**
     mutator method for instance variable courseSlope.
     @param theDate String type parameter that set the value of the courseSlope instance variable.
     */
    public void setDate( String theDate ){

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

        date = theDate;

    }

    /**
     toString returns a nicely formatted String that contains the BowlerScore and its instance fields that looks
     like the given in the project doc file.
     @return - a nicely formatted String that contains the BowlerScore and its instance fields.
     */
    public String toString(){

        if ( getScore() == 9999 && !getDate().equals("INVALID") ){

            return getScore() + "\t\t" + getDate() + "\t\t" + getLaneName() + "\n";

        }else if ( getDate().equals("INVALID") && getScore() != 9999 ){

            return getScore() + "\t\t\t" + getDate() + "\t\t\t" + getLaneName() + "\n";

        }else if ( getScore() == 9999 && getDate().equals("INVALID") ){

            return getScore() + "\t\t" + getDate() + "\t\t\t" + getLaneName() + "\n";

        }

        return getScore() + "\t\t\t" + getDate() + "\t\t" + getLaneName() + "\n";

    }

}
