package Finances.Invoice;

import OrdersPack.Order;
import OrdersPack.OrderItem;
import UsersPack.Client;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private List<String> info = new ArrayList<>();
    private Order order;
    private int Amount;
    private List<List> lists = new ArrayList<>();
/*
    public void Number(List<OrderItem> o) {
        boolean flag = false;
        List<OrderItem> list = new ArrayList<>();
        list.add(o.get(0));
        for (int i = 1; i < o.size(); i++) {
            if (o.get(i).getName().equals(o.get(i - 1).getName())) {
                list.add(o.get(i));
            } else {
                lists.add(list);
                for (int j = 0; j < lists.size(); j++) {
                    if (o.get(j).getName().equals(((OrderItem) lists.get(j).get(0)).getName())) {
                        lists.get(j).add(o.get(i));
                        flag = true;
                    }
                }
                if (!flag) {
                    List<OrderItem> NewList = new ArrayList<>();
                    NewList.add(o.get(i));
                }

            }
        }

    }*/

    public Invoice(Order order) {
        this.order = order;
    }

    /*public List<String> getInvoice() {
        info.add("Order\tPrice\tTaxes\tAfter Taxes");
        float a = 0, b = 0, c = 0;
        for (OrderItem item : order.getOrderedItems()) {
            info.add(item.getName() + "\t" + item.getPrice() + "\t" + item.getTaxes() * item.getPrice() + "\t" + ((item.getTaxes() + 1) * item.getPrice()));
            a += item.getPrice();
            b += item.getTaxes() * item.getPrice();
            c += (item.getTaxes() + 1) * item.getPrice();
        }
        info.add("______________________________________");
        info.add("\t" + a + "\t" + b);
        info.add("\n");
        info.add("Total\t\t\t" + c);
        return info;
    }*/


}
