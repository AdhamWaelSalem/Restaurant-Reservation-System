package OrdersPack;

import ReservationPack.ReserveItem;
import UsersPack.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Client client;
    private List<OrderItem> OrderedItems;
    private Date readyAt;
    private String specialRequest;

    public Order() {
    }

    public Order(List<OrderItem> OrderedItems, Client client, Date date) {
        this.OrderedItems = OrderedItems;
        this.readyAt = date;
        this.client = client;
    }
}
