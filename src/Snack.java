/**
 * Created by scott_000 on 10/27/2016.
 */
public abstract class Snack extends Product implements Comparable {

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



    public int compareTo(Snack other) {
        if (getName().toLowerCase().compareTo(other.getName().toLowerCase()) > 0)
        {
            return 1;
        }
        else if (getName().toLowerCase().compareTo(other.getName().toLowerCase()) < 0)
        {
            return -1;
        }
        else
        {
            return 0;

        }

    }

}
