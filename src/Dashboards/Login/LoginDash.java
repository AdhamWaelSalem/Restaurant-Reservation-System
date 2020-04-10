package Dashboards.Login;

import Main.Restaurant;
import Users.User;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginDash implements Initializable {

    @FXML
    JFXTextField username;
    @FXML
    JFXPasswordField password;
    @FXML
    Text PECUsername;
    @FXML
    Text PECPassword;
    @FXML
    VBox userBox;
    @FXML
    VBox passBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setStyle("-fx-text-fill: WHITE;-fx-prompt-text-fill: rgba(255,255,255,0.50)");
        password.setStyle("-fx-text-fill: WHITE;-fx-prompt-text-fill: rgba(255,255,255,0.50)");
        userBox.getChildren().remove(PECUsername);
        passBox.getChildren().remove(PECPassword);
    }

    public void Login(javafx.event.ActionEvent event) throws Exception {
        boolean found = false,logged = false;
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user.getUsername().equals(username.getText())){
                found = true;
                if (user.getPassword().equals(password.getText())){
                    user.login((Stage) ((Node) event.getSource()).getScene().getWindow());
                    logged = true;
                }
                break;
            }
        }
        if (found && !logged){
            KeyTyped();
            passBox.getChildren().add(PECPassword);
        }else if (!found){
            KeyTyped();
            userBox.getChildren().add(PECUsername);
            passBox.getChildren().add(PECPassword);
        }
    }

    public void KeyTyped() throws Exception{
        userBox.getChildren().remove(PECUsername);
        passBox.getChildren().remove(PECPassword);
    }

    public void Exit(){
        Platform.exit();
    }
}
