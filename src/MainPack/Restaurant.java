package MainPack;

//import Finances.Statement.IncomeStatement;
import OrdersPack.Order;
import OrdersPack.OrderItem;
import ReservationPack.Reservation;
import ReservationPack.ReserveItem;
import UsersPack.User;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    //Attributes
    private List<User> Users = new ArrayList<>();
    private List<ReserveItem> ReserveItems = new ArrayList<>();
    private List<OrderItem> OrderItems = new ArrayList<>();
    //private IncomeStatement IncomeStatement;

    //Singleton Class
    private static Restaurant Restaurant = new Restaurant();
    public static MainPack.Restaurant getRestaurant() {
        return Restaurant;
    }

    //Methods

    //Getters and Setter
    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
    }

    public List<ReserveItem> getReserveItems() {
        return ReserveItems;
    }

    public void setReserveItems(List<ReserveItem> reserveItems) {
        ReserveItems = reserveItems;
    }

    public List<OrderItem> getOrderItems() {
        return OrderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        OrderItems = orderItems;
    }

//    public Finances.Statement.IncomeStatement getIncomeStatement() {
//        return IncomeStatement;
//    }

//    public void setIncomeStatement(Finances.Statement.IncomeStatement incomeStatement) {
//        IncomeStatement = incomeStatement;
//    }

    public static void setRestaurant(MainPack.Restaurant restaurant) {
        Restaurant = restaurant;
    }
}