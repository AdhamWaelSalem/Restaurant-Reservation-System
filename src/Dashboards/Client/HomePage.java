package Dashboards.Client;

import Main.Restaurant;
import Users.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {

    @FXML
    private StackPane pane;

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
    }

    public void openProfile(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Profile.fxml"));
        fxmlLoader.load();
        Profile profileController = fxmlLoader.getController();
        profileController.initHomePage(this);
        Parent fxml = fxmlLoader.getRoot();
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
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

    public void openInvoice(MouseEvent mouseEvent) throws IOException{

    }

}
