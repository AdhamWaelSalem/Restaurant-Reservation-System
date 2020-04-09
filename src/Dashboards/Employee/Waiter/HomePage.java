package Dashboards.Employee.Waiter;

import MainPack.Restaurant;
import UsersPack.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {
    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void openProfile(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("../Profile/Profile.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }


    public void openReservations(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("../Reservations/Reservations.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }
}
