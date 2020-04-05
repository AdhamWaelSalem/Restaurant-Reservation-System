package FinancesPack.Statement;

import MainPack.Restaurant;
import OrdersPack.Order;
import OrdersPack.OrderItem;

import java.util.List;

class Sales extends StatementValue{

    private List<Order> orders;

    public Sales(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    protected float calculate() {
        for (Order order: orders) {
            for (OrderItem item: order.getOrderedItems()) {
                value+=item.getPrice()*(1+item.getTaxes());
            }
        }return value;
    }

}
