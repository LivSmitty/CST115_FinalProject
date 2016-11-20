/**
 * Created by scott_000 on 10/27/2016.
 */
public class Chips extends Snack {
    String productName;
    double productPrice;
    private String productType = "Chips";

    Chips() { //default constructor

    }

    Chips(String name, double price) {
        productName = name;
        productPrice = price;
        addToArray(productType);
    }

    Chips(Chips x) { //copy constructor
        productName = x.name;
        productPrice = x.price;
    }


    @Override
    public String toString() {
        return super.toString();
    }

}
