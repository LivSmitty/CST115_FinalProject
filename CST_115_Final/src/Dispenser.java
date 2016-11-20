import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by scott_000 on 10/27/2016.
 */
public class Dispenser {

    ArrayList<String> displayArrayList = new ArrayList<String>();

    Dispenser(){ //default constructor

        displayArrayList.add("Coke");
        displayArrayList.add("Diet Coke");
        displayArrayList.add("Sprite");
        displayArrayList.add("Root Beer");
        displayArrayList.add("M&M's");
        displayArrayList.add("Snickers");
        displayArrayList.add("Popcorn");
        displayArrayList.add("Wheat Thins");
        displayArrayList.add("Wrigley's Gum");
        displayArrayList.add("Big Red");


    }


    //print displayArrayList
    public void displayProducts() {
        System.out.println("Available Products: ");
        System.out.println("--------------------");
        for (int i = 0; i < displayArrayList.size(); i++)
            System.out.println(displayArrayList.get(i));

    }
}





