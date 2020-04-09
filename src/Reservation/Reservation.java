package Reservation;

import Orders.Order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

public class Reservation {

    private Table table;
    private Order order;
    private Date reservationDate;
    private String specialRequest;
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
    @XmlElement
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    @XmlElement
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    @XmlElement
    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
    @XmlElement
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
