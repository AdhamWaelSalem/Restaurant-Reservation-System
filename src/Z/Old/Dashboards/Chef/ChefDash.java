package Z.Old.Dashboards.Chef;

import Z.Old.Dashboards.UserDash;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChefDash extends UserDash {
    @FXML
    private JFXButton SignOut;

    public void SignOut(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../Dashboards/Login/LoginDash.fxml"));
        Scene Dashboard = new Scene(root);
        Dashboard.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(Dashboard);
        stage.show();
    }
}
