package Dashboards.Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Reservations {

    @FXML
    AnchorPane pane;

    private HomePage homePage;
    protected void initHomePage(HomePage controller){
        homePage = controller;
    }

    public void NewReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Tables.fxml"));
        fxmlLoader.load();
        Tables tablesController = fxmlLoader.getController();
        tablesController.initHomePage(homePage);
        Parent fxml = fxmlLoader.getRoot();
        Scene scene = new Scene(fxml);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void ViewReservation(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Tables.fxml"));
        fxmlLoader.load();
        Tables tablesController = fxmlLoader.getController();
        tablesController.initHomePage(homePage);
        Parent fxml = fxmlLoader.getRoot();
        Scene scene = new Scene(fxml);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void CancelReservation(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Tables.fxml"));
        fxmlLoader.load();
        Tables tablesController = fxmlLoader.getController();
        tablesController.initHomePage(homePage);
        Parent fxml = fxmlLoader.getRoot();
        Scene scene = new Scene(fxml);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void ViewOrders(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Tables.fxml"));
        fxmlLoader.load();
        Tables tablesController = fxmlLoader.getController();
        tablesController.initHomePage(homePage);
        Parent fxml = fxmlLoader.getRoot();
        Scene scene = new Scene(fxml);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
