/**
 A class to calculate CarbonFootprint for vehicle.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 5
 File Name: Auto.java
 */
public class Auto implements CarbonFootprint {


    /**
     * The name of the vehicle.
     */
    private String autoName;

    /**
     * Stores the number of miles driven per week.
     */
    private double milesPerWeek;

    /**
     * Stores the fuel efficiency of vehicle.
     */
    private double fuelEfficiency;

    /**
     * Stores the pounds of CO2 emitted per gallon.
     */
    private final double POUNDSCO2PERGALLON = 19.4;

    /**
     * Stores the emissions of greenhouse gases other than CO2.
     */
    private final double EMISSIONGREENHOUSE = (100/95);

    /**
     * Constructs a Auto with default values.
     */
    public Auto(){

        setAutoName("John Doe");
        setMilesPerWeek(0);
        setFuelEfficiency(0);

    }

    /**
     * Constructs a Auto with the parameters.
     * @param theAutoName the name of the building
     * @param theMilesPerWeek the number of miles driven per week.
     * @param theFuelEfficiency average amount of electric bill per month.
     */
    public Auto( String theAutoName, double theMilesPerWeek, double theFuelEfficiency ){

        setAutoName(theAutoName);
        setMilesPerWeek(theMilesPerWeek);
        setFuelEfficiency(theFuelEfficiency);

    }

    /**
     accessor method for instance variable autoName.
     @return the value of the autoName.
     */
    public String getAutoName(){
        return autoName;
    }

    /**
     mutator method for instance variable autoName.
     @param theAutoName double type parameter that set the value of the autoName instance variable.
     */
    public void setAutoName( String theAutoName ){
        autoName = theAutoName;
    }

    /**
     accessor method for instance variable milesPerWeek.
     @return the value of the milesPerWeek.
     */
    public double getMilesPerWeek(){
        return milesPerWeek;
    }

    /**
     mutator method for instance variable milesPerWeek.
     @param countMiles double type parameter that set the value of the milesPerWeek instance variable.
     */
    public void setMilesPerWeek( double countMiles ){
        milesPerWeek = countMiles;
    }

    /**
     accessor method for instance variable fuelEfficiency.
     @return the value of the fuelEfficiency.
     */
    public double getFuelEfficiency(){
        return fuelEfficiency;
    }

    /**
     mutator method for instance variable fuelEfficiency.
     @param FuelEfficiency double type parameter that set the value of the fuelEfficiency instance variable.
     */
    public void setFuelEfficiency( double FuelEfficiency ){
        fuelEfficiency = FuelEfficiency;
    }

    /**
     accessor method for instance variable POUNDSCO2PERGALLON.
     @return the value of the POUNDSCO2PERGALLON.
     */
    public double getPoundsCO2perGallon(){
        return POUNDSCO2PERGALLON;
    }

    /**
     accessor method for instance variable EMISSIONGREENHOUSE.
     @return the value of the EMISSIONGREENHOUSE.
     */
    public double getEmissionGreenHouse(){
        return EMISSIONGREENHOUSE;
    }

    /**
     * An additional method that is unique to this class.
     * @return a string with the name of the auto.
     */
    public String helloFromAuto(){
        return "This is a auto class and it's vehicle name is: " + getAutoName();
    }

    /**
     * The method to calculate carbon foot print of a specific vehicle. 52 weeks in a year.
     @return the carbon footprint of an Auto(vehicle).
     */
    public double getCarbonFootprint(){

        return ( ( getMilesPerWeek() * 52 ) / getFuelEfficiency() ) * getPoundsCO2perGallon() * getEmissionGreenHouse();

    }

    /**
     toString returns a nicely formatted String that contains the instance variable needed to
     calculate carbonFootPrint for a Building.
     @return - a nicely formatted String that contains the carbonFootPrint and all other staffs needed.
     */
    public String toString(){

        return getAutoName() + "'s carbon footprint is " + getCarbonFootprint() + " lbs per year.";

    }

}
