package FinancesPack;

import MainPack.Restaurant;
import OrdersPack.OrderItem;
import UsersPack.Employee;
import UsersPack.Manager;
import UsersPack.User;
import UsersPack.Waiter;

import java.util.ArrayList;
import java.util.List;

public class IncomeStatement {
    private Sales sales = new Sales();
    private float profit;
    private float service;
    private float wages;
    private float expenses;

    public float getWages() {
        float w=0;
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user instanceof Employee)
                w+=((Employee) user).getDailyWages();
        }
        wages = w;
        return wages;
    }

    public float getExpenses() {
        expenses = sales.getTaxesAmount()+service+wages;
        return expenses;
    }

    public float getProfit(){
        profit = sales.getSalesAmount() - expenses + sales.getTaxesAmount();
        return profit;
    }


}
