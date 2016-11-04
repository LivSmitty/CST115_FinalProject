import sun.util.resources.cldr.bas.CalendarData_bas_CM;

import java.util.ArrayList;

/**
 * Created by scott_000 on 10/27/2016.
 */
public class TestDispenser extends Dispenser{
    public static void main(String[] args) {
        //display products

        //Create Products
        Candy candy1 = new Candy("M&M's", 1.20);
        Candy candy2 = new Candy("Butterfinger", 1.40);
        Drink drink1 = new Drink("Coke", 1.00);
        Chips chips1 = new Chips("Pringles", 1.50);
        Gum gum1 = new Gum("Big Red", .75);



        //Create Dispenser
        Dispenser dispenser1 = new Dispenser();

        //Print displayArrayList
        dispenser1.displayProducts();

        System.out.print(candy1.compareTo(candy2));

    }
}
