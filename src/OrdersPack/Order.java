package OrdersPack;

import Finances.Invoice.Invoice;
import ReservationPack.ReserveItem;
import UsersPack.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private List<OrderItem> OrderedItems;
    private Invoice PaymentCheck = new Invoice(this);

    public Order() {
    }

    public Order(List<OrderItem> orderedItems) {
        OrderedItems = orderedItems;
    }

    public List<String> Details(){
        List<String> details = new ArrayList<>();
        for (OrderItem o: OrderedItems) {
            if(o instanceof Dish){
                details.add(((Dish) o).getType().toString() +"\t"+ o.getName() +"\t"+ o.getAmount() +" Dishes");
            }
        }
        return details;
    }


    public List<OrderItem> getOrderedItems() {
        return OrderedItems;
    }

    public void setOrderedItems(List<OrderItem> orderedItems) {
        OrderedItems = orderedItems;
    }

}
