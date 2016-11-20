/**
 * Created by scott_000 on 10/27/2016.
 */
public class Drink extends Product implements Comparable<Product> {
    String name;
    double price;
    private String productType = "Drink";

    Drink(){ //default constructor

    }

    Drink(String name, double price){
        name = name;
        price = price;
        addToArray(productType);
    }

    Drink(Drink x){ //copy constructor
        name = x.name;
        price = x.price;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public int compareTo(Product other) {
        int result = this.name.toLowerCase().compareTo(other.name.toLowerCase());
        if (result == 0) {
            result = Double.compare(this.price, other.price);
        }
        return result;
    }
}
