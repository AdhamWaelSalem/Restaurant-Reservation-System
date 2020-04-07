package Dashboards.Waiter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WaiterMainScreen {
    @FXML
    private Pane pane;
    public void openProfile(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("../Profile.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }


    public void openReservations(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Reservations.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }
}
