package MainPack;

import DashboardsPack.UserDash;
import XMLPack.LoadXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    Restaurant Restaurant = MainPack.Restaurant.getRestaurant();
    @Override
    public void init() throws Exception {
        LoadXML xml = new LoadXML();
        Restaurant.setUsers(xml.LoadUsers());
        Restaurant.setTables(xml.LoadTables());
        Restaurant.setDishes(xml.LoadDishes());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../DashboardsPack/LoginDash.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root,750,500);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
