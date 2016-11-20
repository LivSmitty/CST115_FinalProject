import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class InventoryManagement extends Application{
    //Stock array: Drink
    String[][] drinkStockArray = {
            {"Coke", "Crush", "Sprite", "Water"},
            {"10", "10", "10", "10"}
    };



    //Stock array: Candy
    String[][] candyStockArray = {
            {"M&M's", "Snickers", "Hershey", "100 Grand"},
            {"10", "10", "10", "10"}
    };

    //Stock array: Gum
    String[][] gumStockArray = {
            {"Big Red", "Spearmint", "Peppermint", "Juicy Fruit"},
            {"10", "10", "10", "10"}
    };

    //Stock array: Chips
    String[][] chipStockArray = {
            {"Dorito's", "Pringles", "Fritos", "Barbeque"},
            {"10", "10", "10", "10"}
    };

    @Override
    public void start(Stage primaryStage){
        ColumnConstraints col1 = new ColumnConstraints(200);
        col1.setPercentWidth(33);
        ColumnConstraints col2 = new ColumnConstraints(200);
        col2.setPercentWidth(33);
        ColumnConstraints col3 = new ColumnConstraints(200);
        col3.setPercentWidth(33);

        GridPane grid = new GridPane();
        grid.getColumnConstraints().addAll(col1, col2, col3);
        Label lblDirections = new Label("Choose item:");
        grid.add(lblDirections, 0, 0);

        //Add Image of shopping cart
        ImageView image = new ImageView("https://cdn0.iconfinder.com/data/icons/kitchen-utensils-6/24/262-512.png");
        image.setFitHeight(100);
        image.setFitWidth(100);
        grid.add(image, 2, 3);

        //Create HBox with buttons
        VBox vBoxButtons = new VBox();
        vBoxButtons.setSpacing(10);
        vBoxButtons.setPadding(new Insets(10));
        Button btCancel = new Button("Cancel");


        //Create Drink Combo Box
        ComboBox<String> cbDrink = new ComboBox<String>();
        cbDrink.getItems().add(drinkStockArray[0][0]);
        cbDrink.getItems().add(drinkStockArray[0][1]);
        cbDrink.getItems().add(drinkStockArray[0][2]);
        cbDrink.getItems().add(drinkStockArray[0][3]);
        cbDrink.setOnAction(e -> {
            String selection = cbDrink.getValue();
            for (int i = 0; i < 4; i++) {
                if (drinkStockArray[0][i].equals(selection)){
                    int count = Integer.parseInt(drinkStockArray[1][i]);
                    count = count - 1;
                    drinkStockArray[1][i] = Integer.toString(count);
                }
                FadeTransition ft = new FadeTransition(Duration.millis(250), image);
                ft.setFromValue(1.0);
                ft.setToValue(0.1);
                ft.setCycleCount(2);
                ft.setAutoReverse(true);
                ft.play();

            }

        });

        //Create Candy Combo Box
        ComboBox<String> cbCandy = new ComboBox<String>();
        cbCandy.getItems().add(candyStockArray[0][0]);
        cbCandy.getItems().add(candyStockArray[0][1]);
        cbCandy.getItems().add(candyStockArray[0][2]);
        cbCandy.getItems().add(candyStockArray[0][3]);
        cbCandy.setOnAction(e -> {
            String selection = cbCandy.getValue();
            for (int i = 0; i < 4; i++) {
                if (candyStockArray[0][i].equals(selection)){
                    int count = Integer.parseInt(candyStockArray[1][i]);
                    count = count - 1;
                    candyStockArray[1][i] = Integer.toString(count);
                }

            }
            FadeTransition ft = new FadeTransition(Duration.millis(250), image);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setCycleCount(2);
            ft.setAutoReverse(true);
            ft.play();

        });

        //Create Gum Combo Box
        ComboBox<String> cbGum = new ComboBox<String>();
        cbGum.getItems().add(gumStockArray[0][0]);
        cbGum.getItems().add(gumStockArray[0][1]);
        cbGum.getItems().add(gumStockArray[0][2]);
        cbGum.getItems().add(gumStockArray[0][3]);
        cbGum.setOnAction(e -> {
            String selection = cbGum.getValue();
            for (int i = 0; i < 4; i++) {
                if (gumStockArray[0][i].equals(selection)){
                    int count = Integer.parseInt(gumStockArray[1][i]);
                    count = count - 1;
                    gumStockArray[1][i] = Integer.toString(count);
                }

            }
            FadeTransition ft = new FadeTransition(Duration.millis(250), image);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setCycleCount(2);
            ft.setAutoReverse(true);
            ft.play();

        });

        //Create Chips Combo Box
        ComboBox<String> cbChips = new ComboBox<String>();
        cbChips.getItems().add(chipStockArray[0][0]);
        cbChips.getItems().add(chipStockArray[0][1]);
        cbChips.getItems().add(chipStockArray[0][2]);
        cbChips.getItems().add(chipStockArray[0][3]);
        cbChips.setOnAction(e -> {
            String selection = cbChips.getValue();
            for (int i = 0; i < 4; i++) {
                if (chipStockArray[0][i].equals(selection)){
                    int count = Integer.parseInt(chipStockArray[1][i]);
                    count = count - 1;
                    chipStockArray[1][i] = Integer.toString(count);
                }

            }
            FadeTransition ft = new FadeTransition(Duration.millis(250), image);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setCycleCount(2);
            ft.setAutoReverse(true);
            ft.play();

        });

        //Create Labels for Combo Box
        Label lblDrink = new Label("Drinks: ");
        Label lblCandy = new Label("Candy: ");
        Label lblGum = new Label("Gum: ");
        Label lblChips = new Label("Chips: ");

        //Create vBox and add combo box to it
        VBox vBoxInventory = new VBox();
        vBoxInventory.setSpacing(10);
        vBoxInventory.setPadding(new Insets(10));
        vBoxInventory.getChildren().addAll(lblDrink, cbDrink, lblCandy, cbCandy, lblGum, cbGum, lblChips, cbChips);
        grid.add(vBoxInventory, 0, 1);


        Button btDisplay = new Button ("List Inventory");
        btDisplay.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setTitle("Complete Inventory");
            ListView lstInventory = new ListView();
            //add drinks to master list
            lstInventory.getItems().add("Drinks");
            lstInventory.getItems().add(drinkStockArray[0][0] + "\t" + drinkStockArray[1][0]);
            lstInventory.getItems().add(drinkStockArray[0][1] + "\t" + drinkStockArray[1][1]);
            lstInventory.getItems().add(drinkStockArray[0][2] + "\t" + drinkStockArray[1][2]);
            lstInventory.getItems().add(drinkStockArray[0][3] + "\t" + drinkStockArray[1][3]);

            //add candy to master list
            lstInventory.getItems().add("Candy");
            lstInventory.getItems().add(candyStockArray[0][0] + "\t" + candyStockArray[1][0]);
            lstInventory.getItems().add(candyStockArray[0][1] + "\t" + candyStockArray[1][1]);
            lstInventory.getItems().add(candyStockArray[0][2] + "\t" + candyStockArray[1][2]);
            lstInventory.getItems().add(candyStockArray[0][3] + "\t" + candyStockArray[1][3]);

            //add gum to master list
            lstInventory.getItems().add("Gum");
            lstInventory.getItems().add(gumStockArray[0][0] + "\t" + gumStockArray[1][0]);
            lstInventory.getItems().add(gumStockArray[0][1] + "\t" + gumStockArray[1][1]);
            lstInventory.getItems().add(gumStockArray[0][2] + "\t" + gumStockArray[1][2]);
            lstInventory.getItems().add(gumStockArray[0][3] + "\t" + gumStockArray[1][3]);

            //add chips to master list
            lstInventory.getItems().add("Chips");
            lstInventory.getItems().add(chipStockArray[0][0] + "\t" + chipStockArray[1][0]);
            lstInventory.getItems().add(chipStockArray[0][1] + "\t" + chipStockArray[1][1]);
            lstInventory.getItems().add(chipStockArray[0][2] + "\t" + chipStockArray[1][2]);
            lstInventory.getItems().add(chipStockArray[0][3] + "\t" + chipStockArray[1][3]);



            stage.setScene(new Scene(lstInventory, 400, 400));
            stage.show();
        });


        vBoxButtons.getChildren().addAll(btCancel, btDisplay);
        grid.add(vBoxButtons, 1, 1);




        //Set Scene
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setTitle("Inventory");
        primaryStage.setScene(scene);
        primaryStage.show();

    }




    public static void main(String[] args) {
        Application.launch();
    }


}
