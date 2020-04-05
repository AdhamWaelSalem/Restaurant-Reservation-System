package OrdersPack;

import ReservationPack.ReserveItem;
import UsersPack.Client;

import java.util.Date;
import java.util.List;

public class Order {

    private Client client;
    private List<OrderItem> OrderedItems;
    private Date readyAt;
    private String specialRequest;

    public Order() {
    }
    public Order(List<OrderItem> OrderedItems, Date date) {
        this.OrderedItems = OrderedItems;
        this.readyAt = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderedItems() {
        return OrderedItems;
    }

    public void setOrderedItems(List<OrderItem> orderedItems) {
        OrderedItems = orderedItems;
    }

    public Date getReadyAt() {
        return readyAt;
    }

    public void setReadyAt(Date readyAt) {
        this.readyAt = readyAt;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
}
