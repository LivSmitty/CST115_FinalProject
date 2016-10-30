import java.util.ArrayList;

/**
 * Created by scott_000 on 10/27/2016.
 */
public class TestDispenser extends Dispenser{
    public static void main(String[] args) {
        //display products

        //Create Products
        Candy candy1 = new Candy("M&M's", 1.20);
        Drink drink1 = new Drink("Coke", 1.00);
        Chips chips1 = new Chips("Pringles", 1.50);
        Gum gum1 = new Gum("Big Red", .75);

        //Create Dispenser
        Dispenser dispenser1 = new Dispenser();

        //Print displayArrayList
        dispenser1.displayProducts();

    }
}
