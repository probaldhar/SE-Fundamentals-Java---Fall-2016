/**
 A class to calculate CarbonFootprint for Food.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 5
 File Name: Food.java
 */
public class Food implements CarbonFootprint {


    /**
     * Stores the Food name.
     */
    private String foodName;

    /**
     * Category of food
     */
    private String foodCategory;

    /**
     * Emission factor based on category of food.
     */
    private double foodEmissionFactor;

    /**
     * dollars spent on category per month.
     */
    private double dollarSpent;

    /**
     * constant to store Gram to pound conversion factor;
     */
    private final double GRAMTOPOUND = 0.0022;

    /**
     * Constructs a Food with default values.
     */
    public Food(){

        setFoodName("Food");
        setFoodCategory("");
        setFoodEmissionFactor("");
        setDollarSpent(0);

    }

    /**
     * Constructs a Food with the parameters.
     * @param theName the name of the Food.
     * @param theCategory the food category.
     * @param dollarUse dollars spent on a category per month
     */
    public Food( String theName, String theCategory, double dollarUse ){

        setFoodName(theName);
        setFoodCategory(theCategory);
        setFoodEmissionFactor(getFoodCategory());
        setDollarSpent(dollarUse);

    }

    /**
     accessor method for instance variable foodName.
     @return the value of the foodName.
     */
    public String getFoodName(){
        return foodName;
    }

    /**
     mutator method for instance variable autoName.
     @param theFoodName String type parameter that set the value of the autoName instance variable.
     */
    public void setFoodName( String theFoodName ){
        foodName = theFoodName;
    }

    /**
     accessor method for instance variable foodCategory.
     @return the value of the foodCategory.
     */
    public String getFoodCategory(){
        return foodCategory;
    }

    /**
     mutator method for instance variable foodCategory.
     @param theFoodCat String type parameter that set the value of the foodCategory instance variable.
     */
    public void setFoodCategory( String theFoodCat ){
        foodCategory = theFoodCat;
    }

    /**
     accessor method for instance variable dollarSpent.
     @return the value of the dollarSpent.
     */
    public double getDollarSpent(){
        return dollarSpent;
    }

    /**
     mutator method for instance variable dollarSpent.
     @param dollarUsage double type parameter that set the value of the dollarSpent instance variable.
     */
    public void setDollarSpent( double dollarUsage ){
        dollarSpent = dollarUsage;
    }

    /**
     accessor method for instance variable foodEmissionFactor.
     @return the value of the foodEmissionFactor.
     */
    public double getFoodEmissionFactor(){
        return foodEmissionFactor;
    }

    /**
     mutator method for instance variable foodEmissionFactor.
     @param theFoodCategory string type parameter that set the value of the foodEmissionFactor instance variable.
     */
    public void setFoodEmissionFactor( String theFoodCategory ){

        theFoodCategory = theFoodCategory.toLowerCase();

        switch (theFoodCategory){

            case "meat":
                foodEmissionFactor = 1452;
                break;
            case "cereals":
                foodEmissionFactor = 741;
                break;
            case "dairy":
                foodEmissionFactor = 1911;
                break;
            case "fruits":
                foodEmissionFactor = 1176;
                break;
            case "eat":
                foodEmissionFactor = 368;
                break;
            case "other":
                foodEmissionFactor = 467;
                break;
            default:
                foodEmissionFactor = 9999;
                break;

        }

    }

    /**
     accessor method for instance variable GRAMTOPOUND.
     @return the value of the GRAMTOPOUND.
     */
    public double getGramToPound(){
        return GRAMTOPOUND;
    }

    /**
     * An additional method that is unique to this class.
     * @return a string with the name of the Food item.
     */
    public String helloFromFood(){
        return "This is a Food class and the item's name is: " + getFoodName();
    }

    /**
     * The method to calculate carbon foot print of a specific vehicle. 52 weeks in a year.
     @return the carbon footprint of a Food item
     */
    public double getCarbonFootprint(){

        return ( getDollarSpent() * getFoodEmissionFactor() * 12 ) * getGramToPound();

    }

    /**
     toString returns a nicely formatted String that contains the instance variable needed to
     calculate carbonFootPrint for a Building.
     @return - a nicely formatted String that contains the carbonFootPrint and all other staffs needed.
     */
    public String toString(){

        return getFoodName() + "'s carbon footprint is " + getCarbonFootprint() + " lbs per year.";

    }


}
