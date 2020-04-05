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

    private List<Reservation> Reservations = new ArrayList<>();
    private List<Order> Orders = new ArrayList<>();
    private int starPoints; //User get points for discounts and offers

    public Client(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void MakeReservation(List<ReserveItem> reserveItems, Date reservationDate, String specialRequests) {
        for (ReserveItem item: reserveItems) { item.Reserve(); }
        Reservation reservation = new Reservation(this,reserveItems,reservationDate,specialRequests);
        starPoints += 10;
        this.Reservations.add(reservation);
        Restaurant.getRestaurant().getReservations().add(reservation);
    }

    public void CancelReservation(Reservation reservation) {
        for (ReserveItem item: reservation.getReservedItems()) { item.Free(); }
        starPoints -= 10;
        this.Reservations.remove(reservation);
        Restaurant.getRestaurant().getReservations().remove(reservation);
    }


    public void AddOrder() {
        Order order = new Order();
        /*TODO: MAKE ORDER CODE*/
        starPoints++;
        this.Orders.add(order);
    }

    @Override
    public String dashLocation(){
        return "/DashboardsPack/Client/ClientDash.fxml";
    }
}
