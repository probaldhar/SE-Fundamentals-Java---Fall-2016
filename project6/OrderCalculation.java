import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 A class to implement the Full GUI to calculate the cost to buy a sandwich for a shop.

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 6
 File Name: OrderCalculation.java
 */
public class OrderCalculation extends JFrame{

    /**
     * constant that hold the width of the Main Frame.
     */
    private static final int FRAME_WIDTH = 400;

    /**
     * Constant that hold the height of the Main Frame.
     */
    private static final int FRAME_HEIGHT = 300;

    /**
     * JLabel for showing the welcome message in the Main Frame
     */
    private JLabel welcomeLabel;

    /**
     * JButton for the Calculate Button
     */
    private JButton calculateButton;

    /**
     * JButton for the Exit Button
     */
    private JButton exitButton;

    /**
     * breadtype - an object of BreadRadioBox Class
     */
    private BreadRadioBox breadtype;

    /**
     * meatCheeseType - An object of MeatCheeseCheckBox class
     */
    private MeatCheeseCheckBox meatCheeseType;

    /**
     * coffeeType - An object of CoffeeRadioBox
     */
    private CoffeeRadioBox coffeeType;

    /**
     * Panel for the two buttons
     */
    private JPanel buttonPanel;

    /**
     * Constructor for the class OrderCalculation.
     * It will create the full GUI for the cost calculator of the sandwich shop.
     */
    public OrderCalculation(){

        super("Probal's shop");

        // assigning the size of the JFrame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        // assigning the layout of the Frame
        setLayout(new BorderLayout());

        // setting up the welcome message for the Main Frame
        welcomeLabel = new JLabel("Welcome to Probal's Sandwich Shop");

        // adding some extra space
        welcomeLabel.setBorder(new EmptyBorder(10,0,10,0));

        // add the Label to Frame
        add(welcomeLabel, BorderLayout.NORTH);

        // aligning the label in the Frame
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);

        // creating and adding the First radio button panel to the Main Frame
        breadtype = new BreadRadioBox();
        add(breadtype.getBreadPanel(), BorderLayout.WEST);

        // creating and adding the check boxes to the main Frame
        meatCheeseType = new MeatCheeseCheckBox();
        add(meatCheeseType.getMeatPanel(), BorderLayout.CENTER);

        // creating and adding the coffee types (radio buttons) to the main Frame
        coffeeType = new CoffeeRadioBox();
        add(coffeeType.getCoffeePanel(), BorderLayout.EAST);

        // creating the buttons
        JPanel allButtons = addButtons();

        // adding the buttons to the main Frame
        add(allButtons, BorderLayout.SOUTH);

    }

    /**
     * Create the buttons then create a panel and then add the buttons to the panel and return it.
     * @return buttonPanel - panel that hold the buttons along with the button
     */
    public JPanel addButtons(){

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalcButtonListener());

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new exitButtonListener());

        buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);

        return buttonPanel;
    }

    /**
     * Inner Class to handle the listener that will fire when the "Calculate" button pressed.
     */
    private class CalcButtonListener implements ActionListener{

        /**
         * price of white bread
         */
        private final double BREAD_WHITE_PRICE = 1.0;

        /**
         * price of wheat bread
         */
        private final double BREAD_WHEAT_PRICE = 2.0;

        /**
         * price of cheese
         */
        private final double MEAT_CHEESE_PRICE = 3.0;

        /**
         * price of beef meat
         */
        private final double MEAT_BEEF_PRICE = 4.0;

        /**
         * price of turkey meat
         */
        private final double MEAT_TURKEY_PRICE = 5.0;

        /**
         * price of Ham meat
         */
        private final double MEAT_HAM_PRICE = 6.0;

        /**
         * no coffee included in the meal
         */
        private final double COFFEE_NONE_PRICE = 0.0;

        /**
         * price of regular coffee
         */
        private final double COFFEE_REGULAR_PRICE = 8.0;

        /**
         * price of decaf coffee
         */
        private final double COFFEE_DECAF_PRICE = 9.0;

        /**
         * price of cappuccino coffee
         */
        private final double COFFEE_CAPPU_PRICE = 10.0;

        /**
         * Amount of tax included with total price
         */
        private final double TAX_PERCENTAGE = 0.25;

        /**
         The actionPerformed method executes when the user clicks on the Calculate button.
         @param e The event object.
         */
        public void actionPerformed(ActionEvent e){

            /**
             * Calculate the price of the order
             */
            double sumOfPrice = 0;

            /**
             * Total tax of the order
             */
            double taxOfSum;

            /**
             * Total cost of the order
             */
            double totalCost;

            // bread
            if(breadtype.getBreadWhite().isSelected()){
                sumOfPrice += BREAD_WHITE_PRICE;
            }else if(breadtype.getBreadWheat().isSelected()){
                sumOfPrice += BREAD_WHEAT_PRICE;
            }

            // meat/cheese
            if(meatCheeseType.getMeatCheese().isSelected()){
                sumOfPrice += MEAT_CHEESE_PRICE;
            }

            if(meatCheeseType.getMeatBeef().isSelected()){
                sumOfPrice += MEAT_BEEF_PRICE;
            }

            if(meatCheeseType.getMeatTurkey().isSelected()){
                sumOfPrice += MEAT_TURKEY_PRICE;
            }

            if(meatCheeseType.getMeatHam().isSelected()){
                sumOfPrice += MEAT_HAM_PRICE;
            }

            // coffee
            if(coffeeType.getCoffeeNone().isSelected()){
                sumOfPrice += COFFEE_NONE_PRICE;
            }else if(coffeeType.getCoffeeRegular().isSelected()){
                sumOfPrice += COFFEE_REGULAR_PRICE;
            }else if(coffeeType.getCoffeeDecaf().isSelected()){
                sumOfPrice += COFFEE_DECAF_PRICE;
            }else if(coffeeType.getCoffeecappu().isSelected()){
                sumOfPrice += COFFEE_CAPPU_PRICE;
            }

            // calculating tax of total price
            taxOfSum = sumOfPrice * TAX_PERCENTAGE;

            // calculating total price including tax
            totalCost = sumOfPrice + taxOfSum;

            // Display the result.
            JOptionPane.showMessageDialog(null, "Subtotal: " + sumOfPrice + "\nTax: " + taxOfSum + "\nTotal: " + totalCost);

        }
    }

    /**
     * Inner Class to handle the listener that will fire when the "Exit" button pressed.
     */
    private class exitButtonListener implements ActionListener{

        /**
         The actionPerformed method executes when the user clicks on the Exit button.
         @param e The event object.
         */
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

}
