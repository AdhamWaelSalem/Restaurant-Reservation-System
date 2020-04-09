package Dashboards.Client;

import Users.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {

    @FXML
    public Label Name;
    @FXML
    public Label UserName;
    @FXML
    public Label StarPoints;

    private HomePage homePage;
    protected void initHomePage(HomePage controller){
        homePage = controller;
        Name.setText(homePage.user.getName());
        UserName.setText("@"+homePage.user.getUsername());
        StarPoints.setText("StarPoints " + ((Client) homePage.user).getStarPoints());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void returnToLogin(MouseEvent mouseEvent) {
        homePage.user.logout((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow());
    }
}
