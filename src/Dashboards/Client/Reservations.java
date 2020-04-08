package Dashboards.Client;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Reservations {

    @FXML
    AnchorPane pane;

    public void NewReservation(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Tables.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().add(fxml);
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
