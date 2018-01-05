/**
 An abstract class that contains information of golf/bowling player.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 3
 File Name: Player.java
 */
public abstract class Player {

    /**
     A String representing the player's name
     */
    private String name;

    /**
     A unique integer that identifies each player
     */
    private int IDNum;

    /**
     A integer that starts at 1000 and is used to generate the next Player's IDNum.
     */
    private static int nextIDNum = 1000;


    /**
     Default Constructor - sets all instance fields to a default value.
     */
    public Player(){

        setName("John Doe");

        setIdNum();

    }

    /**
     Constructor - sets all instance fields from parameters
     */
    public Player( String givenName ){

        setName(givenName);

        setIdNum();

    }

    /**
     accessor method for instance variable name.
     @return the value of the name.
     */
    public String getName(){
        return name;
    }

    /**
     mutator method for instance variable name.
     @param theName String type parameter that set the value of the name instance variable.
     */
    public void setName( String theName ){
        name = theName;
    }

    /**
     accessor method for instance variable idNum.
     @return the value of the idNum.
     */
    public int getIdNum(){
        return IDNum;
    }

    /**
     mutator method for instance variable idNum.
     */
    public void setIdNum(){

        IDNum = getNextIDNum() + 1;

        setNextIDNum( getIdNum() );

    }

    /**
     accessor method for instance variable nextIDNum.
     @return the value of the nextIDNum.
     */
    public static int getNextIDNum(){
        return nextIDNum;
    }

    /**
     mutator method for instance variable nextIDNum.
     @param theNextIDNum static integer parameter that set the value of the nextIDNum instance variable.
     */
    public void setNextIDNum( int theNextIDNum ){
        nextIDNum = theNextIDNum;
    }

    /**
     * An abstract method that returns a double representing the golfers current handicap.
     */
    public abstract double calculateHandicap();

    /**
     toString returns a nicely formatted String that contains the Player information and its instance fields
     that looks like the given in the project doc file.
     @return - a nicely formatted String that contains the score and its instance fields.
     */
    public String toSting(){

        return getName() + "\t\t" + getIdNum(); // ?? all their scores ??

    }

}
