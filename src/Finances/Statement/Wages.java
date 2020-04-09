package Finances.Statement;

import MainPack.Restaurant;
import OrdersPack.Order;
import OrdersPack.OrderItem;
import ReservationPack.Reservation;
import UsersPack.Client;
import UsersPack.Employee;
import UsersPack.User;

import java.util.ArrayList;
import java.util.List;

class Wages extends StatementItem{

    public Wages() {

        Title = "Wages";
        CalculateWages();
    }
    private void CalculateWages(){
        float value = 0;
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user instanceof Employee){
                value += ((Employee) user).getWages();
            }
        }
        Value = String.valueOf(value) ;
    }
}
