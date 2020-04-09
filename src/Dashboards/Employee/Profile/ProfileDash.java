package Dashboards.Employee.Profile;

import MainPack.Restaurant;
import UsersPack.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileDash implements Initializable {

    @FXML
    private Label Name;
    @FXML
    private Label UserName;


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
    }
    public void returnToLogin(MouseEvent mouseEvent) {
        user.logout((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow());
    }


}
