package FinancesPack;

import OrdersPack.OrderItem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Sales {
    private List<OrderItem> orderItems = new ArrayList<>();

    public float getSalesAmount(){
        float salesAmount=0;
        for (OrderItem order: this.orderItems) {
            salesAmount+=order.getPrice();
        }
        return salesAmount;
    }

    public float getTaxesAmount(){
        float taxesAmount=0;
        for (OrderItem order: this.orderItems) {
            taxesAmount+=order.getPrice()*order.getTaxes();
        }
        return taxesAmount;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
