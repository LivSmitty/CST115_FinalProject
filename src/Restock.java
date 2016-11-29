import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Button;
import java.awt.geom.Arc2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by scott_000 on 11/27/2016.
 */
public class Restock extends Application{

    static String xStrPath;
    static String[][] vending1;
    static String[][] vending2;
    static String[][] vending3;
    String numberAsString;
    int number;
    int quantity;
    double cost;
    double totalCost;

    @Override
    public void start(Stage primaryStage){
        BorderPane pane = new BorderPane();

        //Create Hbox to hold checkboxes
        Label label = new Label("Select a vending machine:");
        CheckBox chkVending1 = new CheckBox("Vending Machine 1");
        CheckBox chkVending2 = new CheckBox("Vending Machine 2");
        CheckBox chkVending3 = new CheckBox("Vending Machine 3");
        javafx.scene.control.Button btnViewInventory = new javafx.scene.control.Button("View Inventory");
        javafx.scene.control.Button btnViewPurchaseOrder = new javafx.scene.control.Button("View Purchase Order");
        VBox vBoxSelection = new VBox(10, label, chkVending1, chkVending2, chkVending3, btnViewInventory, btnViewPurchaseOrder);
        vBoxSelection.setPadding(new Insets(20, 10, 20, 10));
        vBoxSelection.setSpacing(30);
        ListView list = new ListView();

        btnViewInventory.setOnAction(e -> {
            if (chkVending1.isSelected()) {
                list.getItems().add("Current Inventory: VENDING 1");
                for (int i = 0; i < vending1.length; i++) {
                    numberAsString = vending1[i][1];
                    number = Integer.parseInt(numberAsString);
                    quantity = 20 - number;
                    cost = quantity * Double.parseDouble(vending1[i][2]);
                    if (number <= 3) {
                        list.getItems().add(vending1[i][0] + "\t\t" + vending1[i][1] + "\t\t" + vending1[i][2] + "\t\t" + "LOW");
                    } else {
                        list.getItems().add(vending1[i][0] + "\t\t" + vending1[i][1] + "\t\t" + vending1[i][2]);

                    }
                }

            }
            if (chkVending2.isSelected()) {
                list.getItems().add("Current Inventory: VENDING 2");
                for (int i = 0; i < vending2.length; i++) {
                    numberAsString = vending2[i][1];
                    number = Integer.parseInt(numberAsString);
                    if (number <= 3) {
                        list.getItems().add(vending2[i][0] + "\t\t" + vending2[i][1] + "\t\t" + vending2[i][2] + "\t\t" + "LOW");
                    } else {
                        list.getItems().add(vending2[i][0] + "\t\t" + vending2[i][1] + "\t\t" + vending2[i][2]);

                    }
                }
            }

            if (chkVending3.isSelected()) {
                list.getItems().add("Current Inventory: VENDING 3");
                for (int i = 0; i < vending3.length; i++) {
                    numberAsString = vending3[i][1];
                    number = Integer.parseInt(numberAsString);
                    if (number <= 3) {
                        list.getItems().add(vending3[i][0] + "\t\t" + vending3[i][1] + "\t\t" + vending3[i][2] + "\t\t" + "LOW");
                    } else {
                        list.getItems().add(vending3[i][0] + "\t\t" + vending3[i][1] + "\t\t" + vending3[i][2]);

                    }
                }
            }

        });

        //BUTTON View Purchase Order
        btnViewPurchaseOrder.setOnAction(e -> {
            if (chkVending1.isSelected()) {

                ListView listPO = new ListView();
                listPO.getItems().add("VENDING MACHINE 1");
                listPO.getItems().add("Item" + "\t\t" + "Quantity" + "\t\t" + "Cost");
                totalCost = 0;
                for (int i = 0; i < vending1.length; i++) {
                    numberAsString = vending1[i][1];
                    number = Integer.parseInt(numberAsString);
                    quantity = 20 - number;
                    cost = quantity * Double.parseDouble(vending1[i][2]);
                    totalCost = totalCost + cost;
                    listPO.getItems().add(vending1[i][0] + "\t\t" + quantity + "\t\t" + cost);

                }

                //add total cost
                listPO.getItems().add("Total Cost:                    " + totalCost);

                //display stage
                Stage stage = new Stage();
                stage.setTitle("Purchase Order");
                stage.setScene(new Scene(listPO, 300, 300));
                stage.show();

            }

            if (chkVending2.isSelected()) {
                ListView listPO = new ListView();
                listPO.getItems().add("VENDING MACHINE 2");
                listPO.getItems().add("Item" + "\t\t" + "Quantity" + "\t\t" + "Cost");
                totalCost = 0;
                for (int i = 0; i < vending2.length; i++) {
                    numberAsString = vending2[i][1];
                    number = Integer.parseInt(numberAsString);
                    quantity = 20 - number;
                    cost = quantity * Double.parseDouble(vending2[i][2]);
                    totalCost = totalCost + cost;
                    listPO.getItems().add(vending2[i][0] + "\t\t" + quantity + "\t\t" + cost);
                }

                listPO.getItems().add("Total Cost:                    " + totalCost);

                Stage stage = new Stage();
                stage.setTitle("Purchase Order");
                stage.setScene(new Scene(listPO, 300, 300));
                stage.show();
            }

            if (chkVending3.isSelected()) {
                ListView listPO = new ListView();
                listPO.getItems().add("VENDING MACHINE 3");
                listPO.getItems().add("Item" + "\t\t" + "Quantity" + "\t\t" + "Cost");
                totalCost = 0;
                for (int i = 0; i < vending3.length; i++) {
                    numberAsString = vending3[i][1];
                    number = Integer.parseInt(numberAsString);
                    quantity = 20 - number;
                    cost = quantity * Double.parseDouble(vending3[i][2]);
                    totalCost = totalCost + cost;
                    listPO.getItems().add(vending3[i][0] + "\t\t" + quantity + "\t\t" + cost);
                }

                listPO.getItems().add("Total Cost:                    " + totalCost);

                Stage stage = new Stage();
                stage.setTitle("Purchase Order");
                stage.setScene(new Scene(listPO, 300, 300));
                stage.show();
            }

        });


        //add list and vbox to pane
        pane.setCenter(list);
        pane.setLeft(vBoxSelection);

        //set scene
        Scene scene = new Scene(pane, 600, 500);
        primaryStage.setTitle("Create Purchase Order");
        primaryStage.setScene(scene);
        primaryStage.show();

    }



    static void Vending_1() {
        vending1 = new String[12][3];

        Scanner scanIn = null;
        int rowC = 0;
        int row = 0;
        int colC = 0;
        int col = 0;
        String inputLine = " ";
        double xNum = 0;
        String xfileLocation;

        xfileLocation = "C:\\Users\\scott_000\\IdeaProjects\\CST_115_Final\\Vending_1.txt";

        try {
            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));

            while (scanIn.hasNext()) {
                inputLine = scanIn.nextLine();

                String[] inArray = inputLine.split(",");

                for (int x = 0; x < inArray.length; x++) {
                    vending1[rowC][x] = inArray[x];
                }
                rowC++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void Vending_2() {
        vending2 = new String[12][3];

        Scanner scanIn = null;
        int rowC = 0;
        int row = 0;
        int colC = 0;
        int col = 0;
        String inputLine = " ";
        double xNum = 0;
        String xfileLocation;

        xfileLocation = "C:\\Users\\scott_000\\IdeaProjects\\CST_115_Final\\Vending_2.txt";

        try {
            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));

            while (scanIn.hasNext()) {
                inputLine = scanIn.nextLine();

                String[] inArray = inputLine.split(",");

                for (int x = 0; x < inArray.length; x++) {
                    vending2[rowC][x] = inArray[x];
                }
                rowC++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void Vending_3() {
        vending3 = new String[12][3];

        Scanner scanIn = null;
        int rowC = 0;
        int row = 0;
        int colC = 0;
        int col = 0;
        String inputLine = " ";
        double xNum = 0;
        String xfileLocation;

        xfileLocation = "C:\\Users\\scott_000\\IdeaProjects\\CST_115_Final\\Vending_3.txt";

        try {
            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));

            while (scanIn.hasNext()) {
                inputLine = scanIn.nextLine();

                String[] inArray = inputLine.split(",");

                for (int x = 0; x < inArray.length; x++) {
                    vending3[rowC][x] = inArray[x];
                }
                rowC++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {

        Vending_1();
        Vending_2();
        Vending_3();

        Application.launch();


    }



}

