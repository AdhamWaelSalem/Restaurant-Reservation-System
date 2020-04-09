package Orders;

import Finances.Invoice.Invoice;

import java.util.ArrayList;
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

    public Invoice getPaymentCheck() {
        return PaymentCheck;
    }

    public void setPaymentCheck(Invoice paymentCheck) {
        PaymentCheck = paymentCheck;
    }
}
