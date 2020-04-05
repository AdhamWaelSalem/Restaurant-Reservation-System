package DashboardsPack;

import MainPack.Restaurant;
import UsersPack.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginDash implements Initializable {

    @FXML
    JFXTextField usernameField;
    @FXML
    JFXPasswordField passwordField;
    @FXML
    JFXButton signIn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void Login(javafx.event.ActionEvent event) throws Exception {
        Restaurant Restaurant = MainPack.Restaurant.getRestaurant();
        boolean found = false;
        for (User user : Restaurant.getUsers()) {
            if (user.getUsername().equals(usernameField.getText()) && user.getPassword().equals(passwordField.getText())) {
                found = true;
                user.setLoggedIn(true);
                user.login((Stage) ((Node) event.getSource()).getScene().getWindow());
            }
        } if (!found){
            usernameField.setFocusColor(Color.FIREBRICK);
            usernameField.setUnFocusColor(Color.FIREBRICK);
            passwordField.setFocusColor(Color.FIREBRICK);
            passwordField.setUnFocusColor(Color.FIREBRICK);
        }
    }

    public void keyPressed(){
        usernameField.setFocusColor(Color.valueOf("#a85b40"));
        usernameField.setUnFocusColor(Color.valueOf("#f7f7f7"));
        passwordField.setFocusColor(Color.valueOf("#a85b40"));
        passwordField.setUnFocusColor(Color.valueOf("#f7f7f7"));
    }
}
