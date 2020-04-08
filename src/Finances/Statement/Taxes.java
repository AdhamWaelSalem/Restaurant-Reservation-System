package Finances.Statement;

import OrdersPack.Order;
import OrdersPack.OrderItem;
import ReservationPack.Reservation;
import UsersPack.Client;
import UsersPack.User;

import java.util.ArrayList;
import java.util.List;

class Taxes extends StatementValue{
    private List<Order> orders = new ArrayList<>();

    public Taxes(List<User> users) {
        for (User u: users) {
            if (u instanceof Client)
            for (Reservation r: ((Client) u).getReservations()) {
                orders.add(r.getOrder());
            }
        }
    }

    @Override
    protected float calculate() {
        for (Order order: orders) {
            for (OrderItem item: order.getOrderedItems()) {
                value+=item.getPrice()*(item.getTaxes());
            }
        }return value;
    }
}
