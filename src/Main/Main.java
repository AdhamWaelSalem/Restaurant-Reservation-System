package Main;

import XML.LoadXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    Restaurant restaurant = Restaurant.getRestaurant();
    @Override
    public void init() throws Exception {
       LoadXML xml = new LoadXML() {};
        restaurant.setUsers(xml.LoadUsers());
        restaurant.getReserveItems().addAll(xml.LoadTables());
        restaurant.getOrderItems().addAll(xml.LoadDishes());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Dashboards/Login/LoginDash.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {

    }

    public static void main(String[] args) {
        launch(args);

    }
}
