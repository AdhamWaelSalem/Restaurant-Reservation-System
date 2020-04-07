package UsersPack;

import MainPack.Restaurant;
import OrdersPack.Order;
import OrdersPack.OrderItem;
import ReservationPack.Reservation;
import ReservationPack.ReserveItem;
import java.util.Date;
import java.util.List;

public class Client extends User {

    private List<Reservation> Reservations;
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
        return "/Dashboards/Client/Home.fxml";
    }

    public void MakeReservation(List<ReserveItem> reserveItems,Date date,String specialRequests) {
        for (ReserveItem item: reserveItems) {
            item.Reserve();
        }
        Reservation reservation = new Reservation(reserveItems,date,specialRequests);
        Reservations.add(reservation);
        Restaurant.getRestaurant().getReservations().add(reservation);
        starPoints += 10;
    }
    public void CancelReservation(Reservation reservation) {
        for (ReserveItem item: reservation.getReservedItems()) {
            item.Free();
        }
        Reservations.remove(reservation);
        Restaurant.getRestaurant().getReservations().remove(reservation);
        starPoints -= 10;
    }
    public void AddOrder(Reservation reservation, List<OrderItem> orderItems,String specialRequests) {
        Order order = new Order(orderItems,specialRequests);
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
