package OrdersPack;

import ReservationPack.ReserveItem;
import UsersPack.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private List<OrderItem> OrderedItems;
    private String specialRequest;

    public Order() {
    }

    public Order(List<OrderItem> orderedItems, String specialRequest) {
        OrderedItems = orderedItems;
        this.specialRequest = specialRequest;
    }

    public List<OrderItem> getOrderedItems() {
        return OrderedItems;
    }

    public void setOrderedItems(List<OrderItem> orderedItems) {
        OrderedItems = orderedItems;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
}
