/**
 * Created by scott_000 on 10/27/2016.
 */
public abstract class Snack extends Product{

    String productName;
    double productPrice;
    private String productType = "Snack";

    Snack(){ //default constructor

    }

    Snack(String name, double price){
        productName = name;
        productPrice = price;}

    Snack(Snack x){ //copy constructor
        productName = x.name;
        productPrice = x.price;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
