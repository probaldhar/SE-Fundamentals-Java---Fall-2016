/**
 A class to calculate handicap and show formatted information of a bowler player.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 3
 File Name: Bowler.java
 */
public class Bowler extends Player{

    /**
     A String representing the bowler's team.
     */
    private String teamName;


    /**
     Array of BowlerScore objects - stores all the bowler's scores.
     */
    private BowlerScore[] bowlerScore;


    /**
     Default Constructor - sets all instance fields to a default value.
     */
    public Bowler(){

        super("John Doe");

        setTeamName("Argo");

        setIdNum();

        bowlerScore = new BowlerScore[20];

    }

    /**
     Constructor - sets all instance fields from parameters
     */
    public Bowler( String givenName, String givenTeamName ){

        super(givenName);

        setTeamName(givenTeamName);

        bowlerScore = new BowlerScore[20];

    }

    /**
     accessor method for instance variable teamName.
     @return the value of the teamName.
     */
    public String getTeamName(){
        return teamName;
    }

    /**
     mutator method for instance variable teamName.
     @param theName String type parameter that set the value of the teamName instance variable.
     */
    public void setTeamName( String theName ){
        teamName = theName;
    }


    /**
     * that returns a double representing the golfers current handicap. (Player's class abstract method)
     *
     * The Bowling handicap is calculated using the following steps:
     *
     *  1. Calculate the average of the bowlers last 5 scores.
     *  2. Calculate the difference between the established base bowling average which in our case is 200 and the bowlers average.
     *  3. Calculate the final handicap by taking 80% of the results of step 2.
     *
     * @return handicap - the golfers current handicap.
     */
    public double calculateHandicap(){

        int sumOfLastFiveScores = 0;
        int flag = 0;
        int indexOfLastBowler = 0;

        // Count the valid scores object in array
        int counter = 0;
        for (int i = 0; i < bowlerScore.length; i ++)
            if (bowlerScore[i] != null)
                counter ++;

        for (int i = counter; i > 0; i--){

            if( bowlerScore[i] != null ) {

                if ( flag < 5 && bowlerScore[i].getScore() != 9999 ) {
                    sumOfLastFiveScores += bowlerScore[i].getScore();

                    flag++;
                    indexOfLastBowler = i;
                }

            }

        }

        // average of last 5 scores.
        double average = sumOfLastFiveScores / 5;

        double Difference;
        double handicap;

        Difference = 200 - average;
        handicap = 0.8 * Difference;

        // add/subtract handicap to the player's next score
        if ( indexOfLastBowler != 0 )
            bowlerScore[indexOfLastBowler + 1].setScore( bowlerScore[indexOfLastBowler + 1].getScore() + (int)handicap );


        return handicap;


    }

    /**
     * receives a BowlerScore object and adds it to the Array of BowlerScores.
     * @param theBowlerScore BowlerScore object.
     */
    public void addScore(BowlerScore theBowlerScore){

        /**
         * Integer counter to count the valid score object in the score array.
         */
        int counter = 0;
        for (int i = 0; i < bowlerScore.length; i++)
            if (bowlerScore[i] != null)
                counter ++;


        // Adds the newly created Score object to the Array of Scores.
        bowlerScore[counter] = theBowlerScore;

    }

    /**
     toString returns a nicely formatted String that contains the Bowler and its instance fields that looks
     like the given in the project doc file including error messages.
     @return - a nicely formatted String that contains the Bowler and its instance fields.
     */
    public String toString(){

        // Count the "non-null" fields of bowlerScore array
        int counter = 0;
        for (int i = 0; i < bowlerScore.length; i++)
            if (bowlerScore[i] != null)
                counter ++;

        /**
         A String representing the information will be in below.
         */
        String baseInfo = getName() + "\t ID number: " + getIdNum() + "\t Team Name: " + getTeamName() + "\t Current Handicap:" + calculateHandicap() + "\n\n";

        /**
         A String representing the score information columns.
         */
        String staticString = "Score \t\t Date \t\t\t Lane \n";

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
        int flagScore = 0, flagDate = 0;


        // calling toString of BowlerScore class
        for ( int i =0; i < counter; i++ ){

            if( bowlerScore[i] != null ) {
                getAllScores = getAllScores + bowlerScore[i];

                if( bowlerScore[i].getScore() == 9999 || bowlerScore[i].getDate().equals("INVALID") ){

                    if( bowlerScore[i].getScore() == 9999 ){
                        if( flagScore == 0 ) {
                            errorMessage = errorMessage + "Scores must be between 0 and 200 (inclusive).\n";
                        }
                        flagScore++;
                    }

                    if( bowlerScore[i].getDate().equals("INVALID") ){
                        if( flagDate == 0 ) {
                            errorMessage = errorMessage + "INVALID in date represents error input of the date.\nDate must be provided in mm/dd/yy format and in valid input.\n";
                        }
                        flagDate++;
                    }

                }


            }

        }

        if( errorMessage.equals("\nERROR messages:\n") ) {

            return baseInfo + staticString + getAllScores;

        }else{

            if( flagScore != 0 ) {

                String finalMessage = "\nERROR messages:\n9999 represents error input in the Score object.\n" + errorMessage.substring(17);

                return baseInfo + staticString + getAllScores + finalMessage;

            }else{
                return baseInfo + staticString + getAllScores + errorMessage;
            }

        }


    }

}
