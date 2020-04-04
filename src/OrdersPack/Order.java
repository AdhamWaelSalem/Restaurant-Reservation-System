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

}
