package ManagerFXML;

import MainPack.Restaurant;
import ReservationPack.Reservation;
import UsersPack.Client;
import UsersPack.User;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTreeCell;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.JFXTreeView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class Reservations implements Initializable {

    @FXML
    JFXListView<String> Reservations;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewReservations();
    }
    public void viewReservations(){
        for (User user: Restaurant.getRestaurant().getUsers()) {
            int i = 0;
            if (user instanceof Client){
                try {
                    for (Reservation r: ((Client) user).getReservations()) {
                        Reservations.getItems().add("Reservation "+ (++i) );
                        Reservations.getItems().add("Client");
                        Reservations.getItems().add(user.getName());
                        Reservations.getItems().add("Table");
                        Reservations.getItems().add(r.getTable().Details());
                        try {
                            r.getOrder().Details();
                            Reservations.getItems().add("Orders");
                            Reservations.getItems().addAll(r.getOrder().Details());
                        }catch (NullPointerException n){
                            //No Orders Made
                        }
                        Reservations.getItems().add("Date");
                        Reservations.getItems().add(r.getReservationDate().toString());
                        Reservations.getItems().add("");
                    }
                }catch (NullPointerException n){
                    //No Reservations for this client
                }
            }
        }
    }
}
