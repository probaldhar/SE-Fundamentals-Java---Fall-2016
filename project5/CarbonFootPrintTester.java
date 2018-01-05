import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 A class to test the Carbon footprint classes.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 5
 File Name: CarbonFootPrintTester.java
 */

public class CarbonFootPrintTester {

    public static void main(String[] args) {

        /**
         * Type of things to calculate carbon footprint.
         */
        String whichClass;

        /**
         * name of the building/vehicle/food.
         */
        String getTheName;

        /**
         * 1st factor of any type of class. such as electricity usage,
         * miles driven per week or dollars spent on category per month.
         */
        double firstFactor;

        /**
         * fuel efficiency per vehicle
         */
        double fuleEfficiencyVehicle;

        /**
         * Food category
         */
        String typeOfFood;

        /**
         An integer used for the loop instance.
         */
        int i = 0;

        /**
         * store the number of objects added from the file.
         */
        int numOfObject;

        /**
         * Array of the CarbonFootprint Interface type
         */
        CarbonFootprint[] objectList = new CarbonFootprint[20];


        // Initializes fileIn to an empty object
        Scanner fileIn = null;

        try
        {
            // Attempt to open the file
            fileIn = new Scanner(new FileInputStream("data.txt"));
        }
        catch (FileNotFoundException e)
        {
            // If the file could not be found, this code is executed
            // and then the program exits
            System.out.println("File not found.");
            System.exit(0);
        }


        do {

            // find the type of carbon footprint from the file
            whichClass = fileIn.nextLine();

            // get the name of the thing
            getTheName = fileIn.nextLine();

            if ( whichClass.equalsIgnoreCase("B") ) {

                firstFactor = fileIn.nextDouble();

                // just to eat the next line
                if (fileIn.hasNextLine()) {
                    fileIn.nextLine();
                }

                Building newBuilding = new Building( getTheName, firstFactor );

                // add the new created building object to Array of the CarbonFootprint Interface type.
                objectList[i] = newBuilding;

            } else if ( whichClass.equalsIgnoreCase("A") ) {

                firstFactor = fileIn.nextDouble();

                fuleEfficiencyVehicle = fileIn.nextDouble();

                // just to eat the next line
                if (fileIn.hasNextLine()) {
                    fileIn.nextLine();
                }

                Auto newVehicle = new Auto( getTheName, firstFactor, fuleEfficiencyVehicle );

                // add the new created auto object to Array of the CarbonFootprint Interface type.
                objectList[i] = newVehicle;

            } else if (whichClass.equalsIgnoreCase("F") ) {

                typeOfFood = fileIn.nextLine();

                firstFactor = fileIn.nextDouble();

                // just to eat the next line
                if (fileIn.hasNextLine()) {
                    fileIn.nextLine();
                }

                Food newFood = new Food( getTheName, typeOfFood, firstFactor );

                // add the new created food object to Array of the CarbonFootprint Interface type.
                objectList[i] = newFood;

            } else {
                System.out.println("Invalid input in file");
            }

            i++;

        } while ( fileIn.hasNextLine() );


        // storing the number of objects in the file
        numOfObject = i;

        // printing the objects polymorphically
        for ( i = 0; i < numOfObject; i++ ) {

            if ( objectList[i] instanceof Building ) {

                Building newBuilding = new Building();
                newBuilding = (Building) objectList[i];

                System.out.println(newBuilding.getName() + "'s carbon footprint is " + objectList[i].getCarbonFootprint() + " lbs per year." );

            } else if ( objectList[i] instanceof Auto ) {

                Auto newAuto = new Auto();
                newAuto = (Auto) objectList[i];

                System.out.println(newAuto.getAutoName() + "'s carbon footprint is " + objectList[i].getCarbonFootprint() + " lbs per year." );

            } else if ( objectList[i] instanceof Food ) {

                Food newFood = new Food();
                newFood = (Food) objectList[i];

                System.out.println(newFood.getFoodName() + "'s carbon footprint is " + objectList[i].getCarbonFootprint() + " lbs per year." );

            } else {
                System.out.println("Invalid object type");
            }

        }


    }
}
