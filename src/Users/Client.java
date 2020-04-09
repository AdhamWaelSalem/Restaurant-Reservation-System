package Users;

import Orders.Order;
import Orders.OrderItem;
import Reservation.Reservation;
import Reservation.Table;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
    public Order AddOrder(Reservation reservation, List<OrderItem> orderItems) {
        Order order = new Order(orderItems);
        reservation.setOrder(order);
        starPoints += 5;
        return order;
    }

    //Getters and Setters
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

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
