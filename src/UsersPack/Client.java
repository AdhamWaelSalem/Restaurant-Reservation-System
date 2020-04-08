package UsersPack;

import MainPack.Restaurant;
import OrdersPack.Order;
import OrdersPack.OrderItem;
import ReservationPack.Reservation;
import ReservationPack.ReserveItem;
import ReservationPack.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends User {

    private List<Reservation> Reservations = new ArrayList<>();
    private int starPoints;

    //Constructor
    public Client() {
    }
    public Client(String name, String username, String password) {
        super(name, username, password);
    }

    //Methods
    @Override
    public String dashLocation(){
        return "../Dashboards/Client/HomePage.fxml";
    }

    public void MakeReservation(Table table, Date date) {
        table.Reserve();
        Reservation reservation = new Reservation(table,date);
        Reservations.add(reservation);
        starPoints += 10;
    }
    public void CancelReservation(Reservation reservation) {
        reservation.getTable().Free();
        Reservations.remove(reservation);
        starPoints -= 10;
    }
    public void AddOrder(Reservation reservation, List<OrderItem> orderItems) {
        Order order = new Order(orderItems);
        reservation.setOrder(order);
        starPoints += 5;
    }

    //Getters and Setters
    public List<Reservation> getReservations() {
        return Reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        Reservations = reservations;
    }

    public int getStarPoints() {
        return starPoints;
    }

    public void setStarPoints(int starPoints) {
        this.starPoints = starPoints;
    }
}
