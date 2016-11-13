import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

/**
 * Created by scott_000 on 11/10/2016.
 */
public class ShowDisplay extends Application {

    public static int choice = 0;
    @Override
    public void start(Stage primaryStage) {
        //create gridpane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        //show the start screen
        pane.getChildren().add(startDisplay());


        //create scene and place in stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Vending Machine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane startDisplay() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        //row 1
        ImageView imageDrink = new ImageView(new Image("http://cdn3.volusion.com/nhepf.lvwfa/v/vspfiles/photos/1011-2.jpg"));
        imageDrink.setFitHeight(200);
        imageDrink.setFitWidth(250);
        Button btDrink = new Button("Drink");
        DrinkHandlerClass handleDrink = new DrinkHandlerClass();
        btDrink.setOnAction(handleDrink);
        grid.add(imageDrink, 0, 0);
        grid.add(btDrink, 1, 0);

        //row 2
        ImageView imageCandy = new ImageView(new Image("http://www.mms.com/Resources/img/products/milk/prd.jpg"));
        imageCandy.setFitHeight(150);
        imageCandy.setFitWidth(250);
        Button btCandy = new Button("Candy");
        CandyHandlerClass handleCandy = new CandyHandlerClass();
        btCandy.setOnAction(handleCandy);
        grid.add(imageCandy, 0, 1);
        grid.add(btCandy, 1, 1);

        //row 3
        ImageView imageChips = new ImageView(new Image("https://s-media-cache-ak0.pinimg.com/236x/d0/23/a5/d023a5144149d0b18c2fca76a314d703.jpg"));
        imageChips.setFitHeight(250);
        imageChips.setFitWidth(200);
        Button btChips = new Button("Chips");
        ChipsHandlerClass handleChips = new ChipsHandlerClass();
        btChips.setOnAction(handleChips);
        grid.add(imageChips, 0, 2);
        grid.add(btChips, 1, 2);

        //row 4
        ImageView imageGum = new ImageView(new Image("https://www.meijer.com/assets/product_images/styles/xlarge/1001029_022000004864_A_400.jpg"));
        imageGum.setFitHeight(175);
        imageGum.setFitWidth(250);
        Button btGum = new Button("Gum");
        GumHandlerClass handleGum = new GumHandlerClass();
        btGum.setOnAction(handleGum);
        grid.add(imageGum, 0, 3);
        grid.add(btGum, 1,3);

        return grid;
    }
}

class DrinkHandlerClass extends Product implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        //new stage
        int choice = 1;
        Stage stage = new Stage();
        stage.setTitle("Drinks");
        BorderPane pane = new BorderPane();


        //place vBox on pane
        pane.setBottom(getVBoxDone());
        pane.setCenter(availableDrinks());



        //define and show scene
        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.show();


    }

    //List available drinks
    public VBox availableDrinks(){
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        Text text1 = new Text(30, 60, "Coke\t\t" + "1.00");
        Text text2 = new Text(30, 75, "Diet Coke\t\t" + "1.00");
        Text text3 = new Text(30, 90, "Root Beer\t\t" + "1.00");
        vBox.getChildren().addAll(text1, text2, text3);
        return vBox;
    }

    //Create Done button
    private VBox getVBoxDone() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        Button btDone = new Button("Done");
        vBox.getChildren().add(btDone);
        DoneHandlerClass handleDone = new DoneHandlerClass();
        btDone.setOnAction(handleDone);
        return vBox;
    }



}

class DoneHandlerClass implements EventHandler<ActionEvent> {

    public String money;
    public double change;
    public BorderPane pane = new BorderPane();

    @Override
    public void handle(ActionEvent e) {

        Stage stage = new Stage();
        stage.setTitle("Ready to Purchase");
        pane.setTop(listDrinks());
        pane.setRight(listCandy());
        pane.setLeft(listGum());
        pane.setCenter(listChips());


        //create vBox to hold labels/text field
        VBox vBox = new VBox();
        Label lbl = new Label("Cost: 1.00");
        Label lbl2 = new Label("Enter Payment");
        TextField txt = new TextField();
        money = txt.getText();
        Button btTransaction = new Button("Take Payment");
        vBox.getChildren().addAll(lbl, lbl2, txt, btTransaction);
        pane.setBottom(vBox);
        TransactionHandlerClass handleTransaction = new TransactionHandlerClass();
        btTransaction.setOnAction(handleTransaction);


        //define and show scene
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    private VBox listDrinks() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        Text text = new Text("Available Drinks");
        Text text1 = new Text(30, 60, "Coke\t\t" + "1.00");
        Text text2 = new Text(30, 70, "Diet Coke\t\t" + "1.00");
        Text text3 = new Text(30, 80, "Root Beer\t\t" + "1.00");
        vBox.getChildren().addAll(text, text1, text2, text3);
        return vBox;
    }

    private VBox listCandy() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        Text text = new Text("Available Candy");
        Text text1 = new Text(30, 60, "M&M's\t\t" + "1.00");
        Text text2 = new Text(30, 75, "Kit Kat\t\t" + "1.00");
        Text text3 = new Text(30, 90, "Snickers\t\t" + "1.00");
        vBox.getChildren().addAll(text, text1, text2, text3);
        return vBox;
    }

    private VBox listGum() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        Text text = new Text("Available Gum");
        Text text1 = new Text(30, 60, "Big Red\t\t" + "1.00");
        Text text2 = new Text(30, 75, "Orbitz\t\t" + "1.00");
        Text text3 = new Text(30, 90, "Trident\t\t" + "1.00");
        vBox.getChildren().addAll(text, text1, text2, text3);
        return vBox;
    }

    private VBox listChips() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        Text text = new Text("Available Chips");
        Text text1 = new Text(30, 60, "Lays\t\t" + "1.00");
        Text text2 = new Text(30, 75, "Doritos\t\t" + "1.00");
        Text text3 = new Text(30, 90, "Sun Chips\t\t" + "1.00");
        vBox.getChildren().addAll(text, text1, text2, text3);
        return vBox;
    }

    class TransactionHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            change = (Double.parseDouble(money) - 1.00);
            Label lblChange = new Label("Change Due: " + change);
            pane.getChildren().add(lblChange);
            pane.getChildren().clear();
            pane.setLeft(lblChange);


        }
    }


}





