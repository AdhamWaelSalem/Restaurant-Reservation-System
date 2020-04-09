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
    @FXML
    public Label Name;
    @FXML
    public Label UserName;
    @FXML
    public Label StarPoints;
    @FXML
    private Tables tablesController;

    protected User user;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initUser();
    }

    private void initUser(){
        for (User u : Restaurant.getRestaurant().getUsers()) {
            if (u.isLoggedIn()) {
                user = u;
                break;
            }
        }
        Name.setText(user.getName());
        UserName.setText("@"+user.getUsername());
        StarPoints.setText("StarPoints " + ((Client) user).getStarPoints());
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

    public void returnToLogin(MouseEvent mouseEvent) {
        user.logout((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow());
    }
}
