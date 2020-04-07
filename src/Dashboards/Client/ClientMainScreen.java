package Dashboards.Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientMainScreen implements Initializable {
    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void openProfile(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Profile.fxml"));
       // pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }

    public void openReservations(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Reservations.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }

    public void openOrders(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Orders.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }

    public void returnToLogin(MouseEvent mouseEvent) {
    }

    public void openFinances(MouseEvent mouseEvent) {
    }
}
