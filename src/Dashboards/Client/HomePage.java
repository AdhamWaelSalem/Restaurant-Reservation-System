package Dashboards.Client;

import MainPack.Restaurant;
import UsersPack.Client;
import UsersPack.User;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Pane pane;
    @FXML
    JFXButton openReservations;
    @FXML
    JFXButton openOrders;
    protected Client client;
    @FXML
    public Label Name;
    @FXML
    public Label UserName;
    @FXML
    public Label StarPoints;
    @FXML
    private Tables tablesController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initClient();
        client.getName();
        Name.setText(client.getName());
        UserName.setText("@"+client.getUsername());
        StarPoints.setText("StarPoints " + client.getStarPoints());
    }

    private void initClient(){
        for (User u : Restaurant.getRestaurant().getUsers()) {
            if (u.isLoggedIn() && u instanceof Client) {
                client = (Client) u;
                break;
            }
        }
    }

    public Client getLoggedClient() {
        return client;
    }

    public void openReservations(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Reservations.fxml"));
        fxmlLoader.load();
        Reservations reservationsController = fxmlLoader.getController();
        reservationsController.initHomePage(this);
        Parent fxml = fxmlLoader.getRoot();
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }

    public void openOrders(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Dishes.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }

    public void returnToLogin(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../Z/LoginDash.fxml"));
        Parent parent = (Parent) fxmlLoader.load();
        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        for (User u : Restaurant.getRestaurant().getUsers()) {
            if (u.isLoggedIn()) {
                u.setLoggedIn(false);
                break;
            }

        }

    }
}
