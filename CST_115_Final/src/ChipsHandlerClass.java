import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by scott_000 on 11/13/2016.
 */
public class ChipsHandlerClass implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent e) {
            //new stage
            Stage stage = new Stage();
            stage.setTitle("Chips");
            BorderPane pane = new BorderPane();


            //place vBox on pane
            pane.setBottom(getVBoxDone());
            pane.setCenter(availableChips());



            //define and show scene
            Scene scene = new Scene(pane, 300, 300);
            stage.setScene(scene);
            stage.show();


        }

        //List available drinks
        public VBox availableChips(){
            VBox vBox = new VBox(15);
            vBox.setPadding(new Insets(15, 15, 15, 15));
            Text text1 = new Text(30, 60, "Lays\t\t" + "1.00");
            Text text2 = new Text(30, 75, "Doritos\t\t" + "1.00");
            Text text3 = new Text(30, 90, "Sun Chips\t\t" + "1.00");
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
