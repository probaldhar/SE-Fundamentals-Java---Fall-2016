import javax.swing.*;
import java.awt.*;
import javax.swing.ButtonGroup;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 A class to define a panel that will hold some radio buttons

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 6
 File Name: CoffeeRadioBox.java
 */
public class CoffeeRadioBox {

    /**
     * Radio button for the option none
     */
    private JRadioButton coffeeNone;

    /**
     * Radio button for the option Regular Coffee
     */
    private JRadioButton coffeeRegular;

    /**
     * Radio button for the option Decaf Coffee
     */
    private JRadioButton coffeeDecaf;

    /**
     * Radio button for the option coffeecappu
     */
    private JRadioButton coffeecappu;

    /**
     * Panel that will hold the radio buttons
     */
    private JPanel panel;

    /**
     * Constructor fot the class CoffeeRadioBox. It will create and add the radio buttons to a panel.
     */
    public CoffeeRadioBox(){

        // creating the radio buttons
        coffeeNone = new JRadioButton("None");
        coffeeNone.setSelected(true);
        coffeeRegular = new JRadioButton("Regular Coffee");
        coffeeDecaf = new JRadioButton("Decaf Coffee");
        coffeecappu = new JRadioButton("Cappuccino");

        // Add radio buttons to button group
        ButtonGroup group = new ButtonGroup();
        group.add(coffeeNone);
        group.add(coffeeRegular);
        group.add(coffeeDecaf);
        group.add(coffeecappu);

        // adding the radio buttons to a panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        panel.add(coffeeNone);
        panel.add(coffeeRegular);
        panel.add(coffeeDecaf);
        panel.add(coffeecappu);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Coffee"));

    }

    /**
     * Getting the panel that will hold the radio buttons.
     * @return that panel with the radio buttons
     */
    public JPanel getCoffeePanel(){
        return panel;
    }

    /**
     * Accessor method for the instance variable coffeeNone.
     * @return the value of the coffeeNone
     */
    public JRadioButton getCoffeeNone(){
        return coffeeNone;
    }

    /**
     * Accessor method for the instance variable coffeeRegular.
     * @return the value of the coffeeRegular
     */
    public JRadioButton getCoffeeRegular(){
        return coffeeRegular;
    }

    /**
     * Accessor method for the instance variable coffeeDecaf.
     * @return the value of the coffeeDecaf
     */
    public JRadioButton getCoffeeDecaf(){
        return coffeeDecaf;
    }

    /**
     * Accessor method for the instance variable coffeecappu.
     * @return the value of the coffeecappu
     */
    public JRadioButton getCoffeecappu(){
        return coffeecappu;
    }


}
