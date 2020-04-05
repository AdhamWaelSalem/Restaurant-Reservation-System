package DashboardsPack.Client;

import DashboardsPack.UserDash;
import MainPack.Restaurant;
import UsersPack.Client;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ClientDash extends UserDash implements Initializable {

    @FXML
    private JFXButton reservations;
    @FXML
    private JFXButton orders;
    @FXML
    private JFXButton finances;
    @FXML
    private JFXButton signOut;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void TablesPane(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("TablesPane.fxml"));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
//LOL//
    public void OrdersPane(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("ClientOrdersPane.fxml"));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }

    public void FinancesPane(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("FinancesPane.fxml"));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }

    public void SignOut(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../LoginDash.fxml"));
        Scene Dashboard = new Scene(root);
        Dashboard.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(Dashboard);
        stage.show();
    }

}
