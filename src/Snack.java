/**
 * Created by scott_000 on 10/27/2016.
 */
public abstract class Snack extends Product implements Comparable<Product>{

    String name;
    double price;
    private String productType = "Snack";
    private String[] snackName = new String[100];
    private double[] snackPrice = new double[100];
    private int amt = 0;

    Snack() { //default constructor

    }

    Snack(String name, double price) {
        name = name;
        price = price;
        addToArray();
    }


    Snack(Snack x) { //copy constructor
        name = x.name;
        price = x.price;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    public void addToArray() {
        snackName[amt] = getName();
        snackPrice[amt] = getPrice();
        amt++;
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


//  SAVING OLD CODE
// if (getName().toLowerCase().compareTo(other.getName().toLowerCase()) > 0) //object 1 is greater than object 2
//        {
//            return 1;
//        }
//        else if (getName().toLowerCase().compareTo(other.getName().toLowerCase()) < 0) {//object 2 is greater than object 1
//            return -1;
//        }
//        else
//            return 0;//objects are equal
//
//        }
//
//    }
