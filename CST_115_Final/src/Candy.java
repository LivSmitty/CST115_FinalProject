/**
 * Created by scott_000 on 10/27/2016.

 */
public class Candy extends Snack implements Comparable<Product> {
    String productName;
    double productPrice;
    private String productType = "Snack";

    Candy(){ //default constructor

    }

    Candy(String name, double Price){
        productName = name;
        productPrice = price;
        addToArray(productType);

        printProductList();
    }

    Candy(Candy x){ //copy constructor
        productName = x.name;
        productPrice = x.price;
    }


    @Override
    public String toString() {
        return super.toString();
    }



}
