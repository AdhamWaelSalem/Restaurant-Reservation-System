package FinancesPack;

import OrdersPack.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class IncomeStatement {
    private Sales sales = new Sales();
    private float profit;
    private float taxes;
    private float service;
    private float wages;
    private float expenses;

    public float getExpenses() {
        expenses = taxes+service+wages;
        return expenses;
    }

    public float getTaxes() {

        return taxes;
    }

    public float getProfit(){
        profit = sales.getSalesAmount() - expenses + taxes;
        return profit;
    }


}
