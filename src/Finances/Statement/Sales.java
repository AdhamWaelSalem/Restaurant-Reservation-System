package Finances.Statement;

import Main.Restaurant;
import Orders.Order;
import Orders.OrderItem;
import Reservation.Reservation;
import Users.Client;
import Users.User;

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
