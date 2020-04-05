package FinancesPack.Invoice;

import OrdersPack.OrderItem;
import UsersPack.Client;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private Client client;
    private List<String> info = new ArrayList<>();
    public List<String> getInvoice(){
        info.add("Order\tPrice\tTaxes\tAfter Taxes");
        float a=0,b=0,c=0;
        for (OrderItem item: client.getOrder().getOrderedItems()) {
            info.add(item.getName()+"\t"+item.getPrice()+"\t"+item.getTaxes()*item.getPrice()+"\t"+((item.getTaxes()+1)*item.getPrice()));
            a+=item.getPrice();b+=item.getTaxes()*item.getPrice();c+=(item.getTaxes()+1)*item.getPrice();
        }
        info.add("______________________________________");
        info.add("\t"+a+"\t"+b);
        info.add("\n");
        info.add("Total\t\t\t"+c);
        return info;
    }
}
