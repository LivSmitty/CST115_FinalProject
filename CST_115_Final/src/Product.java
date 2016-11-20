import java.lang.reflect.Array;


public abstract class Product {

    String name;
    double price;
    public String[] nameArray = new String[100];
    public double[] priceArray = new double[100];
    public String[] typeArray = new String[100];
    public int amt = 0;


    Product(){ //default constructor

    }

    Product(String productName, double productPrice){
        name = productName;
        price = productPrice;


    }

    public void addToArray(String productType){
        nameArray[amt] = getName();
        priceArray[amt] = getPrice();
        typeArray[amt] = productType;

        amt++;

    }

    public void printProductList(){
        for (int i = 0; i < nameArray.length; i++)
            if (nameArray[i] == null)
                break;
            else
                System.out.println(nameArray[i] + "\t" + priceArray[i]);

    }

    public void findProduct(String x){
        for (int i = 0; i < priceArray.length; i++) {
            if (nameArray[i].equals(x)) {
                int pointer = i;
                System.out.println("Match found.");
            }
            if (nameArray[i] == null) {
                break;
            } else i++;
        }
    }

    public void sortProducts(){

    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return this.getName();
    }



}

