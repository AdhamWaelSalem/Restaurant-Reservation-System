package ReservationPack;

import OrdersPack.Order;
import UsersPack.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {

    private Table table;
    private Order order;
    private Date reservationDate;
    private String specialRequest;

    //Constructor

    public Reservation() {
    }

    public Reservation(Table table, Date reservationDate) {
        this.table = table;
        this.reservationDate = reservationDate;
    }



    //Methods

    //Getters and Setters
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

}
