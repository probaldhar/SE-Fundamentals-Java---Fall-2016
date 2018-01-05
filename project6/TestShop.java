import javax.swing.*;

/**
 A class to test all the function and classes for the calculator of the price of a sandwich shop

 @author Probal Chandra Dhar
 @version 1.0

 COP5007	Project #: 6
 File Name: TestShop.java
 */

public class TestShop {

    public static void main(String[] args)
    {
        // creating an object of OrderCalculation class
        JFrame frame = new OrderCalculation();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Order Calculator");
        frame.setVisible(true);
    }

}
