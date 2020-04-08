package Dashboards.Client;

import MainPack.Restaurant;
import ReservationPack.Reservation;
import UsersPack.Client;
import UsersPack.User;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Invoice implements Initializable {

    @FXML
    JFXListView<String> Invoice;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewInvoice();
    }
    public void viewInvoice(){
        int i = 0;
        for (User u: Restaurant.getRestaurant().getUsers()) {
            if (u.isLoggedIn()){
                for (Reservation r: ((Client) u).getReservations()) {
                    try {
                        r.getOrder();
                        Invoice.getItems().add("Order "+(++i));
                        Invoice.getItems().addAll(r.getOrder().getPaymentCheck().getInvoice());
                        Invoice.getItems().add("");
                    }catch (NullPointerException n){
                        //
                    }

                }
            }
        }

    }
}
