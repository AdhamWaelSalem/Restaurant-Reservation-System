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
/////
    private boolean confirmed;
    //Constructor

    public Reservation() {
    }

    public Reservation(Table table, Date reservationDate) {
        this.table = table;
        this.reservationDate = reservationDate;
        this.confirmed=false;
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

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
