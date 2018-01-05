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
 File Name: BreadRadioBox.java
 */
public class BreadRadioBox {

    /**
     * Radio button for the option white
     */
    private JRadioButton breadWhite;

    /**
     * Radio button for the option wheat
     */
    private JRadioButton breadWheat;

    /**
     * Panel that will hold the radio buttons
     */
    private JPanel panel;

    /**
     * Constructor fot the class BreadRadioBox. It will create and add the radio buttons to a panel.
     */
    public BreadRadioBox(){

        breadWhite = new JRadioButton("White");
        breadWhite.setSelected(true);

        breadWheat = new JRadioButton("Wheat");

        // Add radio buttons to button group
        ButtonGroup group = new ButtonGroup();
        group.add(breadWhite);
        group.add(breadWheat);

        // adding the radio buttons to a panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.add(breadWhite);
        panel.add(breadWheat);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Bread"));

    }

    /**
     * Getting the panel that will hold the radio buttons.
     * @return that panel with the radio buttons
     */
    public JPanel getBreadPanel(){
        return panel;
    }

    /**
     * Accessor method for the instance variable breadWhite.
     * @return the value of the breadWhite
     */
    public JRadioButton getBreadWhite(){
        return breadWhite;
    }

    /**
     * Accessor method for the instance variable breadWheat.
     * @return the value of the breadWheat
     */
    public JRadioButton getBreadWheat(){
        return breadWheat;
    }


}
