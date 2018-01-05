/**
 A class to test the Golfer and Score class properly.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 2
 File Name: GolferTester.java
 */
public class GolferTester {

    public static void main(String[] args) {

        Golfer newGolfGame = new Golfer();

        newGolfGame.setName("John Smith");
        newGolfGame.getIdNum();
        newGolfGame.setHomeCourse("Bay Hill CC");

        newGolfGame.addScore( "Alaska", 75, "6/36/12", 69.5, 123);
        newGolfGame.addScore( "Georgia", 77, "70/23/12", 76.4, 128);
        newGolfGame.addScore( "Alabama", 70, "6/12/13", 79.4, 66);
        newGolfGame.addScore( "Arizona", 70, "8/24/16", 70.4, 66);
        newGolfGame.addScore( "Ohio", 87, "9/03/15", 70.4, 66);

        // Print all the scores added above.
        System.out.println(newGolfGame);

        // Get the score object of a given date
        System.out.println("Get the score of this date(6/12/13):\n" );

        if( newGolfGame.getScore("6/12/13") != null ) {
            System.out.println("Score   Date       Course    \tCourse Rating    Course Slope");
            System.out.println(newGolfGame.getScore("6/12/13"));
        }else{
            System.out.println("The score of the given date is not found in the score array.\n");
        }

        // delete a score object
        System.out.println("Delete the score of this date(6/12/13).\n ");

        if( newGolfGame.deleteScore("6/12/13") ) {
            System.out.println("After deleting show the rest of the scores left in the score array.");
            System.out.println(newGolfGame);
        }else{
            System.out.println("The score of the given date is not found in the score array.");
        }

        // Find the lowest score of the score object
        System.out.println("\nFind the lowest score of the score array:");

        if( newGolfGame.lowestScore() != null ) {
            System.out.println("Score   Date       Course    \tCourse Rating    Course Slope");
            System.out.println(newGolfGame.lowestScore());
        }else{
            System.out.println("There's no score object added in the score array.\n");
        }

        System.out.println("----------------------------");

        System.out.println("\nSecond Object\n");
        // create a new object for golfer.
        Golfer newGolfGame1 = new Golfer();

        newGolfGame1.setName("Probal dhar");
        newGolfGame1.getIdNum();
        newGolfGame1.setHomeCourse("Bay Hill CC");

        newGolfGame1.addScore( "New York", 75, "6/3/12", 69.5, 123);
        newGolfGame1.addScore( "Atlanta", 77, "7/23/12", 76.4, 128);
        newGolfGame1.addScore( "Utah", 70, "6/12/13", 79.4, 28);
        newGolfGame1.addScore( "Florida", 7, "8/24/16", 80.4, 12);
        newGolfGame1.addScore( "Texas", 87, "9/03/15", 90.4, 1);

        System.out.println(newGolfGame1);

        System.out.println("----------------------------");

        System.out.println("\nThird Object\n");
        Golfer newGolfGame2 = new Golfer();

        newGolfGame2.setName("John Smith 3333");
        newGolfGame2.getIdNum();
        newGolfGame2.setHomeCourse("Bay Hill CC");

        newGolfGame2.addScore( "California", 75, "6/3/19", 69.5, 123);
        newGolfGame2.addScore( "Montana", 77, "7/23/12", 76.4, 128);
        newGolfGame2.addScore( "Idaho", 70, "6/12/13", 79.4, 28);
        newGolfGame2.addScore( "North carolina", 70, "8/24/16", 80.4, 12);
        newGolfGame2.addScore( "Delaware", 87, "9/039/15", 90.4, 1);


        System.out.println(newGolfGame2);

        // delete a score object
        System.out.println("Delete the score of this date(6/12/11) of newGolfGame2 object.\n ");

        if( newGolfGame2.deleteScore("6/12/11") ) {
            System.out.println("After deleting show the rest of the scores left in the score array.");
            System.out.println(newGolfGame2);
        }else{
            System.out.println("The score of the given date is not found in the score array.");
        }

    }

}

