package Dashboards.Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
      //  Parent fxml = FXMLLoader.load(getClass().getResource("Reservations.fxml"));
        Parent fxml = FXMLLoader.load(getClass().getResource("../../FXML/Tables.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }

    public void openOrders(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("../../FXML/Dishes.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }

    public void returnToLogin(MouseEvent mouseEvent) {
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(this.dashLocation()));
        Parent parent = loader.load();
        Scene Dash = new Scene(parent);
        Dash.setFill(Color.TRANSPARENT);*/

    }

    public void openFinances(MouseEvent mouseEvent) {
    }
}
