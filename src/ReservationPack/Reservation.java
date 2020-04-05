package ReservationPack;

import UsersPack.Client;
import UsersPack.User;

import java.util.Date;
import java.util.List;

public class Reservation {

    private Client client;
    private List<ReserveItem> ReservedItems;
    private Table table;
    private Date reservationDate;
    private String specialRequest;

    public Reservation(Client client, List<ReserveItem> reservedItems, Date reservationDate, String specialRequest) {
        this.client = client;
        this.ReservedItems = reservedItems;
        this.reservationDate = reservationDate;
        this.specialRequest = specialRequest;
    }

    public Reservation(Client client,Table table,Date date) {
        this.table=table;
        this.reservationDate=date;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ReserveItem> getReservedItems() {
        return ReservedItems;
    }

    public void setReservedItems(List<ReserveItem> reservedItems) {
        ReservedItems = reservedItems;
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

    public String info() {
        String reservedItems = null;
        for (ReserveItem reserveItem : this.ReservedItems) {
            reservedItems.concat(reserveItem.getClass().toString() + "\n" + reserveItem.info());
        }

        return "Client: " + this.client.info() + "\n" +
                "Date: " + this.reservationDate.toString() + "\n" +
                "Reserved Items\n" + reservedItems;
    }
}
