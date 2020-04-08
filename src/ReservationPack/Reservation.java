package ReservationPack;

import OrdersPack.Order;
import UsersPack.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {

    private List<ReserveItem> reservedItems = new ArrayList<>();
    private Order order;
    private Date reservationDate;
    private String specialRequest;

    //Constructor

    public Reservation() {
    }

    public Reservation(List<ReserveItem> reservedItems, Date reservationDate, String specialRequest) {
        this.reservedItems = reservedItems;
        this.reservationDate = reservationDate;
        this.specialRequest = specialRequest;
    }



    //Methods
    public boolean valid() {
        for (ReserveItem ri : reservedItems) {
            if (ri.isMajor())
                return true;
        }
        return false;
    }

    //Getters and Setters
    public List<ReserveItem> getReservedItems() {
        return reservedItems;
    }

    public void setReservedItems(List<ReserveItem> reservedItems) {
        this.reservedItems = reservedItems;
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
