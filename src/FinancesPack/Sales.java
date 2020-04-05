package FinancesPack;

import OrdersPack.OrderItem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Sales {
    private List<OrderItem> orderItems = new ArrayList<>();
    private float salesAmount;
    public float getSalesAmount(){
        float f=0;
        for (OrderItem order: this.orderItems) {
            f+=order.getPrice();
        }
        this.salesAmount=f;
        return this.salesAmount;
    }
}
