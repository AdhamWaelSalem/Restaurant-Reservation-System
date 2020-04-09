package Dashboards.Client;

import MainPack.Restaurant;
import UsersPack.Client;
import UsersPack.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    public Label UserName;
    public Label StarPoints;
    @FXML
    private AnchorPane pane;
    Client client;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (User u : Restaurant.getRestaurant().getUsers()) {
            if (u.isLoggedIn()) {
                try {
                    client = (Client) u;
                } catch (Exception e) {
                    client = new Client();
                    System.out.println("User unknown");
                }
                break;
            }
        }
        UserName.setText(client.getName());
        StarPoints.setText("Star Points " + client.getStarPoints());
    }

    public void SignOut(MouseEvent mouseEvent) throws IOException {
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
