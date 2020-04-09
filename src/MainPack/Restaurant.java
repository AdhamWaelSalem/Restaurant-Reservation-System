package MainPack;

//import Finances.Statement.IncomeStatement;
import Finances.Statement.IncomeStatement;
import OrdersPack.Order;
import OrdersPack.OrderItem;
import ReservationPack.Reservation;
import ReservationPack.ReserveItem;
import UsersPack.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
public class Restaurant {

    //Attributes
    @XmlElement
    private List<User> Users = new ArrayList<>();
    @XmlElement
    private List<ReserveItem> ReserveItems = new ArrayList<>();
    @XmlElement
    private List<OrderItem> OrderItems = new ArrayList<>();
    private IncomeStatement incomeStatement;

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

    public IncomeStatement getIncomeStatement() {
        setIncomeStatement();
        return incomeStatement;
    }

    public void setIncomeStatement() {
        IncomeStatement incomeStatement = new IncomeStatement();
        this.incomeStatement = incomeStatement;
    }

    public static void setRestaurant(MainPack.Restaurant restaurant) {
        Restaurant = restaurant;
    }
}