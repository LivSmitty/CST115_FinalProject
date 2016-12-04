import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by scott_000 on 12/3/2016.
 */
public class CustomerDisplay extends Application {

    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();
        pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(10);
        ImageView customerImage = new ImageView("http://media.istockphoto.com/photos/stick-figure-icon-picture-id531852720?k=6&m=531852720&s=170667a&w=0&h=Vkb76tQVvnfuB0Jkw9yp_uLb34s95ShAWd_ELagdXgI=");
        customerImage.setFitHeight(100);
        customerImage.setFitWidth(60);
        ImageView customerImage2 = new ImageView("http://media.istockphoto.com/photos/stick-figure-icon-picture-id531852720?k=6&m=531852720&s=170667a&w=0&h=Vkb76tQVvnfuB0Jkw9yp_uLb34s95ShAWd_ELagdXgI=");
        customerImage2.setFitHeight(100);
        customerImage2.setFitWidth(60);
        ImageView customerImage3 = new ImageView("http://media.istockphoto.com/photos/stick-figure-icon-picture-id531852720?k=6&m=531852720&s=170667a&w=0&h=Vkb76tQVvnfuB0Jkw9yp_uLb34s95ShAWd_ELagdXgI=");
        customerImage3.setFitHeight(100);
        customerImage3.setFitWidth(60);
        ImageView customerImage4 = new ImageView("http://www.designofsignage.com/application/symbol/hospital/image/600x600/arrow-right.jpg");
        customerImage4.setFitHeight(100);
        customerImage4.setFitWidth(100);
        FadeTransition ft = new FadeTransition(Duration.millis(1000), customerImage4);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        hBox.getChildren().addAll(customerImage, customerImage2, customerImage3, customerImage4);


        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(20));
        hBox2.setSpacing(10);
        ImageView machineImage = new ImageView("http://cliparts.co/cliparts/dc9/KnM/dc9KnMxqi.jpg");
        machineImage.setFitHeight(100);
        machineImage.setFitWidth(100);
        hBox2.getChildren().add(machineImage);
        pane.setRight(hBox2);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(10);
        TextField txtName = new TextField("Livia");
        TextField txtChoice = new TextField("Coke");
        TextField txtTotal = new TextField("1.00");
        Label lblOutOfStock = new Label("Out of Stock");
        lblOutOfStock.setStyle("-fx-border-color:red; -fx-background-color: red;");
        lblOutOfStock.setTextFill(Color.WHITE);
        vBox.getChildren().addAll(txtName, txtChoice, txtTotal, lblOutOfStock);
        pane.setBottom(vBox);

        pane.setLeft(hBox);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Customer in Queue");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
