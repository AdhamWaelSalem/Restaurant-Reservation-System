package Finances.Statement;

import MainPack.Restaurant;
import OrdersPack.Order;
import OrdersPack.OrderItem;
import ReservationPack.Reservation;
import UsersPack.Client;
import UsersPack.User;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

class Sales extends StatementItem{

    List<Order> Orders = new ArrayList<>();

    public Sales() {
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user instanceof Client){
                for (Reservation reservation: ((Client) user).getReservations()) {
                    Orders.add(reservation.getOrder());
                }
            }
        }
        Title = "Sales";
        CalculateSales();
    }
    private void CalculateSales(){
        float value = 0;
        for (Order O: Orders) {
            for (OrderItem item: O.getOrderedItems()) {
                value += item.getPrice()*(1+item.getTaxes());
            }
        }
        Value = String.valueOf(value);
    }







    //    private List<Order> orders = new ArrayList<>();
//
//    public Sales(List<User> users) {
//        for (User u: users) {
//            if (u instanceof Client)
//                for (Reservation r: ((Client) u).getReservations()) {
//                    orders.add(r.getOrder());
//                }
//        }
//    }
//
//    @Override
//    protected float calculate() {
//        for (Order order: orders) {
//            for (OrderItem item: order.getOrderedItems()) {
//                value+=item.getPrice()*(1+item.getTaxes());
//            }
//        }return value;
//    }

}
