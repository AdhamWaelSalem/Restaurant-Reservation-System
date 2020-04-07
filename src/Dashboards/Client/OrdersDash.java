package Dashboards.Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class OrdersDash {
    @FXML
    private AnchorPane pane;
    @FXML
    private AnchorPane foodPane;

    public void ConfirmOrder(MouseEvent mouseEvent) throws IOException {
       /* Parent fxml = FXMLLoader.load(getClass().getResource(""));
        foodPane.getChildren().removeAll();
        foodPane.getChildren().setAll(fxml);*/
    }

    public void goToMainCourse(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Appetizers.fxml"));
        foodPane.getChildren().removeAll();
        foodPane.getChildren().setAll(fxml);
    }

    public void goToAppetizer(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Desserts.fxml"));
        foodPane.getChildren().removeAll();
        foodPane.getChildren().setAll(fxml);
    }

    public void goToDessert(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("MainCourses.fxml"));
        foodPane.getChildren().removeAll();
        foodPane.getChildren().setAll(fxml);
    }
}
