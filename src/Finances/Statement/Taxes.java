package Finances.Statement;

import Main.Restaurant;
import Orders.Order;
import Orders.OrderItem;
import Reservation.Reservation;
import Users.Client;
import Users.User;

import java.util.ArrayList;
import java.util.List;

class Taxes extends StatementItem{

    List<Order> Orders = new ArrayList<>();

    public Taxes() {
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user instanceof Client){
                for (Reservation reservation: ((Client) user).getReservations()) {
                    Orders.add(reservation.getOrder());
                }
            }
        }
        Title = "Taxes";
        CalculateTaxes();
    }
    private void CalculateTaxes(){
        float value = 0;
        for (Order O: Orders) {
            for (OrderItem item: O.getOrderedItems()) {
                value += item.getPrice()*(item.getTaxes());
            }
        }
        Value = String.valueOf(value) ;
    }
}
