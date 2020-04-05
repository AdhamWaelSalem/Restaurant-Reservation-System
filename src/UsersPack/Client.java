package UsersPack;

import DashboardsPack.Client.ClientDash;
import DashboardsPack.UserDash;
import MainPack.Restaurant;
import OrdersPack.Order;
import ReservationPack.Reservation;
import ReservationPack.ReserveItem;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends User {

    private Reservation reservation;
    private Order order;
    private int starPoints; //User get points for discounts and offers

    public Client(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client() {

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void MakeReservation(List<ReserveItem> reserveItems, Date reservationDate, String specialRequests) {
        for (ReserveItem item: reserveItems) { item.Reserve(); }
        Reservation reservation = new Reservation(this,reserveItems,reservationDate,specialRequests);
        this.reservation=reservation;
        Restaurant.getRestaurant().getReservations().add(reservation);
        starPoints += 10;
    }

    public void CancelReservation() {
        for (ReserveItem item: reservation.getReservedItems()) { item.Free(); }
        starPoints -= 10;
        Restaurant.getRestaurant().getReservations().remove(reservation);
        reservation=null;
    }


    public void AddOrder() {
        Order order = new Order();
        /*TODO: MAKE ORDER CODE*/
        starPoints++;
    }

    @Override
    public String dashLocation(){
        return "/DashboardsPack/Client/ClientDash.fxml";
    }
}
