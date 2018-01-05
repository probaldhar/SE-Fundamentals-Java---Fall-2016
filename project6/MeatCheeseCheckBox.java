import javax.swing.*;
import java.awt.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 A class to define a panel that will hold some check boxes

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 6
 File Name: MeatCheeseCheckBox.java
 */
public class MeatCheeseCheckBox {

    /**
     * Check box for the cheese
     */
    private JCheckBox meatCheese;

    /**
     * check box for the Roast Beef
     */
    private JCheckBox meatBeef;

    /**
     * Check box for the Turkey
     */
    private JCheckBox meatTurkey;

    /**
     * Check box for the Ham
     */
    private JCheckBox meatHam;

    /**
     * Panel that will hold the checkboxes
     */
    private JPanel panel;


    /**
     * Constructor fot the class MeatCheeseCheckBox. It will create and add the checkboxes to a panel.
     */
    public MeatCheeseCheckBox(){

        meatCheese = new JCheckBox("Cheese");

        meatBeef = new JCheckBox("Roast Beef");

        meatTurkey = new JCheckBox("Turkey");

        meatHam = new JCheckBox("Cheese");

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        panel.add(meatCheese);
        panel.add(meatBeef);
        panel.add(meatTurkey);
        panel.add(meatHam);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Meat/Cheese"));

    }

    /**
     * Getting the panel that will hold the checkboxes.
     * @return that panel with the checkboxes
     */
    public JPanel getMeatPanel(){
        return panel;
    }

    /**
     * Accessor method for the instance variable meatCheese.
     * @return the value of the meatCheese
     */
    public JCheckBox getMeatCheese(){
        return meatCheese;
    }

    /**
     * Accessor method for the instance variable meatBeef.
     * @return the value of the meatBeef
     */
    public JCheckBox getMeatBeef(){
        return meatBeef;
    }

    /**
     * Accessor method for the instance variable meatTurkey.
     * @return the value of the meatTurkey
     */
    public JCheckBox getMeatTurkey(){
        return meatTurkey;
    }

    /**
     * Accessor method for the instance variable meatHam.
     * @return the value of the meatHam
     */
    public JCheckBox getMeatHam(){
        return meatHam;
    }

}
