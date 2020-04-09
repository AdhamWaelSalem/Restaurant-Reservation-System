package Main;

//import Finances.Statement.StatementItem;
import Finances.Statement.IncomeStatement;
import Orders.OrderItem;
import Reservation.ReserveItem;
import Users.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    //Attributes
    private List<User> Users = new ArrayList<>();
    private List<ReserveItem> ReserveItems = new ArrayList<>();
    private List<OrderItem> OrderItems = new ArrayList<>();
    private IncomeStatement incomeStatement;

    //Singleton Class
    private static Restaurant Restaurant = new Restaurant();
    public static Restaurant getRestaurant() {
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

    public IncomeStatement getIncomeStatement() {
        setIncomeStatement();
        return incomeStatement;
    }

    public void setIncomeStatement() {
        IncomeStatement incomeStatement = new IncomeStatement();
        this.incomeStatement = incomeStatement;
    }

    public static void setRestaurant(Restaurant restaurant) {
        Restaurant = restaurant;
    }
}