package Finances.Statement;

import OrdersPack.Order;
import OrdersPack.OrderItem;
import ReservationPack.Reservation;
import UsersPack.Client;
import UsersPack.User;

import java.util.ArrayList;
import java.util.List;

class Sales extends StatementValue{

    private List<Order> orders = new ArrayList<>();

    public Sales(List<User> users) {
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
                value+=item.getPrice()*(1+item.getTaxes());
            }
        }return value;
    }

}
