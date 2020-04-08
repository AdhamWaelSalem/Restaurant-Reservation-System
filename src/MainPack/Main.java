package MainPack;

import ReservationPack.Reservation;
import ReservationPack.ReserveItem;
import ReservationPack.Table;
import UsersPack.Client;
import UsersPack.User;
import XMLPack.LoadXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Calendar;


public class Main extends Application {

    Restaurant Restaurant = MainPack.Restaurant.getRestaurant();
    @Override
    public void init() throws Exception {
        LoadXML xml = new LoadXML() {};
        Restaurant.setUsers(xml.LoadUsers());
        Restaurant.getReserveItems().addAll(xml.LoadTables());
        Restaurant.getOrderItems().addAll(xml.LoadDishes());
        ((Client) Restaurant.getUsers().get(1)).MakeReservation(((Table) Restaurant.getReserveItems().get(3)), Calendar.getInstance().getTime());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("../Z/LoginDash.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("../ClientFXML/Dishes.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../ManagerFXML/Reservations.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
