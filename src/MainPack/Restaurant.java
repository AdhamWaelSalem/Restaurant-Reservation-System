package MainPack;

import OrdersPack.Dish;
import OrdersPack.Order;
import OrdersPack.OrderItem;
import ReservationPack.Reservation;
import ReservationPack.ReserveItem;
import ReservationPack.Table;
import UsersPack.User;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static Restaurant Restaurant = new Restaurant();
    private List<User> Users;
    private List<Table> Tables = new ArrayList<>();
    private List<Dish> Dishes = new ArrayList<>();
    private List<Reservation> Reservations = new ArrayList<>();
    private List<Order> Orders= new ArrayList<>();

    //Singleton Class
    private Restaurant() {
    }

    public static MainPack.Restaurant getRestaurant() {
        return Restaurant;
    }


    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
    }

    public List<Table> getTables() {
        return Tables;
    }

    public void setTables(List<Table> tables) {
        Tables = tables;
    }

    public List<Dish> getDishes() {
        return Dishes;
    }

    public void setDishes(List<Dish> dishes) {
        Dishes = dishes;
    }

    public List<Reservation> getReservations() {
        return Reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        Reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        this.Reservations.add(reservation);
    }

    public List<Order> getOrders() {
        return Orders;
    }

    public void setOrders(List<Order> orders) {
        Orders = orders;
    }
}