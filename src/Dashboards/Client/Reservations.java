package Dashboards.Client;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Reservations extends HomePage {
    @FXML
    AnchorPane mainPane;
    @FXML
    AnchorPane pane;

    public void NewReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Tables.fxml"));
        Parent parent = (Parent) fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//    public void ViewReservations(MouseEvent mouseEvent) throws IOException {
//        Parent fxml = FXMLLoader.load(getClass().getResource("Profile.fxml"));
//        pane.getChildren().removeAll();
//        pane.getChildren().setAll(fxml);
//    }
//    public void EditReservation(MouseEvent mouseEvent) throws IOException {
//        Parent fxml = FXMLLoader.load(getClass().getResource("Profile.fxml"));
//        pane.getChildren().removeAll();
//        pane.getChildren().setAll(fxml);
//    }
//    public void CancelReservation(MouseEvent mouseEvent) throws IOException {
//        Parent fxml = FXMLLoader.load(getClass().getResource("Profile.fxml"));
//        pane.getChildren().removeAll();
//        pane.getChildren().setAll(fxml);
//    }
}
