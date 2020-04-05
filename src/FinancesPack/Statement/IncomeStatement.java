package FinancesPack.Statement;

import MainPack.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class IncomeStatement {
    Restaurant restaurant = Restaurant.getRestaurant();


    List<String> info = new ArrayList<>();
    public List<String> getInfo(){
        try {
            Sales sales = new Sales(restaurant.getOrders());
            Taxes taxes = new Taxes(restaurant.getOrders());
            Wages wages = new Wages(restaurant.getUsers());
            Profit profit = new Profit(sales,taxes,wages);
            info.add("Sales\t"+sales.calculate());
            info.add("Taxes\t("+taxes.calculate()+")");
            info.add("Wages\t("+wages.calculate()+")");
            info.add("_______________________");
            if (profit.calculate()>=0)
                info.add("Profit\t"+profit.calculate());
            else info.add("Loss\t("+profit.calculate()+")");
            return info;
        }catch (NullPointerException e){
            info.add("No Orders Made Yet");
            return info;
        }
    }
}
