package Dashboards.Client;

import MainPack.Restaurant;
import UsersPack.User;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void SignOut(MouseEvent mouseEvent) {
        for (User u: Restaurant.getRestaurant().getUsers()) {
            if (u.isLoggedIn()){

            }
        }
    }


}
