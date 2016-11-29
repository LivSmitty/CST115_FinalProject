

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

/**
 * Created by scott_000 on 11/27/2016.
 */
public class Global_Inventory_Management {

    static String xStrPath;
    static String[][] myArray;


    static void setUpMyCSVArray() {
        myArray = new String[12][2];

        Scanner scanIn = null;
        int rowC = 0;
        int row = 0;
        int colC = 0;
        int col = 0;
        String inputLine = " ";
        double xNum = 0;
        String xfileLocation;

        xfileLocation = "C:\\Users\\scott_000\\IdeaProjects\\CST_115_Final\\Vending_Machine.txt";

        try {
            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));

            while (scanIn.hasNext()) {
                inputLine = scanIn.nextLine();

                String[] inArray = inputLine.split(",");

                for (int x = 0; x < inArray.length; x++) {
                    myArray[rowC][x] = inArray[x];
                }
                rowC++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        setUpMyCSVArray();


        //Sort items by name
        boolean needNextPass = true;
        for (int k = 1; k < myArray.length; k++) {
            needNextPass = false;
            for (int i = 0; i < myArray.length - k; i++) {
                if (myArray[i][0].compareTo(myArray[i + 1][0]) > 0) {
                    String temp = myArray[i][0];
                    myArray[i][0] = myArray[i + 1][0];
                    myArray[i + 1][0] = temp;

                    temp = myArray[i][1];
                    myArray[i][1] = myArray[i + 1][1];
                    myArray[i + 1][1] = temp;

                    needNextPass = true;
                }
            }
        }

        //print myArray
        for (int i = 0; i <= myArray.length - 1; i++) {
            System.out.println(myArray[i][0] + "     " + myArray[i][1]);
        }


        //search for item by name, find quantity
        System.out.println("Enter item name to search: ");
        Scanner input = new Scanner(System.in);
        String searchedValue = input.nextLine();
        int pos = 0;
        boolean found = false;

        while (pos < myArray.length && !found) {
            if (myArray[pos][0].equals(searchedValue)) {
                found = true;
            } else {
                pos++;
            }
        }
        if (found) {
            System.out.println("Found at Position: " + pos + ". Quantity: " + myArray[pos][1]);


        }

        //print to text file
        BufferedWriter writer = null;

        try{
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File logFile = new File(timeLog);
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            for (int i = 0; i <= myArray.length- 1; i++)
                writer.write("\n" + myArray[i][0] + "," + myArray[i][1]);

        } catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                writer.close();
            }catch (Exception e){

            }
        }

    }

}
