/**
 A class to calculate CarbonFootprint for Building. Using only Electricity for calculate.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 5
 File Name: Building.java
 */
public class Building implements CarbonFootprint {

    /**
     * Stores the name of the building.
     */
    public String name;

    /**
     * double to store average amount of electric bill per month.
     */
    private double amountElectricityPerMonth;

    /**
     * double to store price per kwh.
     */
    private final double PRICEPERKWH = 0.25;

    /**
     * Electricity emissions factor.
     */
    private final double EMISSIONFACTOR = 1.37;


    /**
     * Constructs a Building with default values.
     */
    public Building(){

        setName("");

        setAmountElectricityPerMonth(0);

    }

    /**
     * Constructs a Building with the parameters.
     * @param theName the name of the building
     * @param theElectricUse average amount of electric bill per month.
     */
    public Building( String theName, double theElectricUse ){

        setName(theName);

        setAmountElectricityPerMonth(theElectricUse);

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
     accessor method for instance variable amountElectricityPerMonth.
     @return the value of the amountElectricityPerMonth.
     */
    public double getAmountElectricityPerMonth(){
        return amountElectricityPerMonth;
    }

    /**
     mutator method for instance variable amountElectricityPerMonth.
     @param theUsage double type parameter that set the value of the amountElectricityPerMonth instance variable.
     */
    public void setAmountElectricityPerMonth( double theUsage ){
        amountElectricityPerMonth = theUsage;
    }

    /**
     accessor method for instance variable PRICEPERKWH.
     @return the value of the PRICEPERKWH.
     */
    public double getPricePerKwh(){
        return PRICEPERKWH;
    }

    /**
     accessor method for instance variable EMISSIONFACTOR.
     @return the value of the EMISSIONFACTOR.
     */
    public double getEmissionFactor(){
        return EMISSIONFACTOR;
    }

    /**
     * An additional method that is unique to this class.
     * @return a string with the name of the building.
     */
    public String helloFromBuilding(){
        return "This is a Building class and it's name is: " + getName();
    }

    /**
     * The method to calculate carbon foot print of a specific building. 12 months in a year.
     @return the carbon footprint of a Building
     */
    public double getCarbonFootprint(){

        return ( getAmountElectricityPerMonth()/getPricePerKwh() ) * getEmissionFactor() * 12;

    }

    /**
     toString returns a nicely formatted String that contains the instance variable needed to
     calculate carbonFootPrint for a Building.
     @return - a nicely formatted String that contains the carbonFootPrint and all other staffs needed.
     */
    public String toString(){

        return getName() + "'s carbon footprint is " + getCarbonFootprint() + " lbs per year.";

    }

}
