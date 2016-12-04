import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by scott_000 on 12/2/2016.
 */
public class ProcessCustomerQueue {

    static String queuePath;
    static String[][] customerArray = new String[5][2];
    static LinkedList customerName;
    static List customerChoice;
    static String currentChoice;

    public static void main(String[] args) {
        processQueue();


        //create Customer Name List
        LinkedList<String>  customerName = new LinkedList<>();
        for (int i = 0; i < customerArray.length; i++) {
            customerName.add(customerArray[i][0]);
        }

        //Create Customer Choice List
        LinkedList<String> customerChoice = new LinkedList<>();
        for(int i = 0; i < customerArray.length; i++){
            customerChoice.add(customerArray[i][1]);
        }

        //print list of customers
        for (int i = 0; i < customerName.size(); i++){
            System.out.println(customerName.get(i) + "\t" + customerChoice.get(i));
        }

        //How many customers are in the queue
        System.out.println("\n" + "Customers in queue: " + customerName.size());

        //current person in queue
        System.out.println("\n" + "Current Customer: ");
        System.out.println(customerName.peek() + "\t" + customerChoice.peek());
        currentChoice = customerChoice.peek();
        for (int i = 0; i <= 3; i++){
            if (InventoryManagement.chipStockArray[0][i].equals(currentChoice)){
                int stock = Integer.parseInt(InventoryManagement.chipStockArray[1][i]);
                if (stock > 0) {
                    System.out.println("Item available. Enjoy!");
                    customerName.removeFirst();
                    customerChoice.removeFirst();
                    System.out.println("\n" + "Current Customer: " + customerName.peek() + "\t" + customerChoice.peek());

                }
                else if (stock < 1) {
                    System.out.println("OUT OF STOCK. Other options: ");
                    for (int j = 0; j <= 3; j++) {
                        if (InventoryManagement.chipStockArray[0][j] != currentChoice) {
                            System.out.print(InventoryManagement.chipStockArray[0][j] + "\t" + "\n");
                        }

                    }
                }

            }


        }


        //add new customer
        customerName.offerLast("George");
        customerChoice.offerLast("Coke");
        System.out.println("\n" + "The following customer has been added: " + "\n" + customerName.getLast()+ "\t" + customerChoice.getLast());

        //Customer transaction is complete
        customerName.removeFirst();
        customerChoice.removeFirst();

        //complete transaction


    }

    static void processQueue() {
        String name = "";
        String item = "";
        int count= 0;


        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\scott_000\\IdeaProjects\\CST_115_Final\\CustomerQueue.txt"));
            String line = null;

            while ((line = br.readLine()) != null) {

                String tmp[] = line.split(",");
                name = tmp[0];
                item = tmp[1];

                customerArray[count][0] = name;
                customerArray[count][1] = item;

                count++;


            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}








