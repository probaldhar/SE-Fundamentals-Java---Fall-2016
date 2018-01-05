import java.lang.String;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import java.io.Serializable;

/**
 A class to handle all the information of a Player.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 4
 File Name: PlayerInfo.java
 */

public class PlayerInfo implements Serializable{

    /**
     A String representing the golf course where the player's handicap is keep.
     */
    private String name;

    /**
     A String representing the golf course where the player's handicap is keep.
     */
    private String nickName;

    /**
     A String representing the golf course where the player's handicap is keep.
     */
    private int currentScore;

    /**
     Constructs a Player with no parameter value. In which sets all instance field to a default value.
     */
    public PlayerInfo(){

        setName("John Doe");

        setNickName("John");

        setCurrentScore(0);

    }

    /**
     Constructs a Player with parameter.
     @param theName a constructor parameter that is used to set the value of name.
     @param theNickName a constructor parameter that is used to set the value of nickName.
     @param theScore a constructor parameter that is used to set the value of currentScore.
     */
    public PlayerInfo(String theName, String theNickName, int theScore){

        setName(theName);

        setNickName(theNickName);

        setCurrentScore(theScore);

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
     accessor method for instance variable nickName.
     @return the value of the nickName.
     */
    public String getNickName(){
        return nickName;
    }

    /**
     mutator method for instance variable nickName.
     @param theNickName String type parameter that set the value of the nickName instance variable.
     */
    public void setNickName( String theNickName ){
        nickName = theNickName;
    }

    /**
     accessor method for instance variable currentScore.
     @return the value of the currentScore.
     */
    public int getCurrentScore(){
        return currentScore;
    }

    /**
     mutator method for instance variable currentScore.
     @param theScore String type parameter that set the value of the currentScore instance variable.
     */
    public void setCurrentScore( int theScore ){
        currentScore = theScore;
    }


    /**
     * The method to Creating a new file for a new player and store all the information.
     @param newPlayer PlayerInfo object.
     */
    public void addPlayerFile( PlayerInfo newPlayer ){

        try
        {
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(new FileOutputStream(newPlayer.getName().trim().replaceAll("\\s","")+".dat"));


            // writing object to file
            outputStream.writeObject(newPlayer);

            System.out.println("File created or written: " + newPlayer.getName().trim().replaceAll("\\s","")+".dat" );

            outputStream.close( );
        }
        catch(IOException e)
        {
            System.out.println("Problem with file output.");
        }

    }



    /**
     toString returns a nicely formatted String that contains the name, nickName and current score of playerInfo class.
     @return outputString - a nicely formatted String that contains the currentScore and all other staffs needed.
     */
    public String toString(){

        return "Player name: " + getName() + "\tNick Name: " + getNickName() + "\tCurrent Score: " + getCurrentScore();

    }



}
