package DashboardsPack.Client;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientReservationPane{
    @FXML
    private StackPane stackPane;
    public void New(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void View(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void Edit(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void Cancel(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void Exit(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
}
