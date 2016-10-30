/**
 * Created by scott_000 on 10/27/2016.
 */
public class Drink extends Product {
    String productName;
    double productPrice;
    private String productType = "Drink";

    Drink(){ //default constructor

    }

    Drink(String name, double price){
        productName = name;
        productPrice = price;
        addToArray(productType);
    }

    Drink(Drink x){ //copy constructor
        productName = x.name;
        productPrice = x.price;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
