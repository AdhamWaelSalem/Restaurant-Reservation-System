package DashboardsPack.Client;

import MainPack.Restaurant;
import UsersPack.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ClientDash implements Initializable {
    @FXML
    public Button Reserve;
    @FXML
    private Button SignOut;
    @FXML
    private Button Orders;
    @FXML
    private Label ClientName;
    @FXML
    private Label Welcome;

    public void details(Client client) {
        ClientName.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ClientName.setText("Welcome Mr." + client.getFirstName() + " " + client.getLastName());
      //  StarPoints.setText("Star Points" + client.getStarPoints());

    }
    public void returnToLoginScreen(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../LoginDash.fxml"));
        Scene scene = new Scene(root, 630, 522);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    public void gotoReservationsScreen(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ItemsToBeReserved.fxml"));
        Scene scene = new Scene(root, 800, 522);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Restaurant restaurant = Restaurant.getRestaurant();



    }

}
