package DashboardsPack.Manager;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ManagerDash {

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

    public void ReservationPane(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("ReservationsPane.fxml"));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void OrdersPane(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("OrdersPane.fxml"));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void FinancesPane(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("FinancesPane.fxml"));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void SignOut(ActionEvent event) throws Exception{

    }



}
