/**
 * Created by scott_000 on 10/27/2016.
 */
public class Gum extends Snack {
    String productName;
    double productPrice;
    private String productType = "Gum";

    Gum(){ //default constructor

    }

    Gum(String name, double price){
        productName = name;
        productPrice = price;
        addToArray(productType);
    }

    Gum(Gum x){ //copy constructor
        productName = x.name;
        productPrice = x.price;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
