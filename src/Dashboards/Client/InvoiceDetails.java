package Dashboards.Client;

import Orders.OrderItem;

public class InvoiceDetails {


    private String order;
    private String price;
    private String amount;
    private String sumPrice;
    private String taxes;
    private String afterTaxes;

    public InvoiceDetails(OrderItem orderItem) {
        order = orderItem.getName();
        price = String.valueOf(orderItem.getPrice());
        amount = String.valueOf(orderItem.getAmount());
        sumPrice = String.valueOf(orderItem.getPrice()*orderItem.getAmount());
        taxes = String.valueOf(orderItem.getTaxes()*orderItem.getPrice()*orderItem.getAmount());
        afterTaxes = String.valueOf((orderItem.getTaxes()+1)*orderItem.getPrice()*orderItem.getAmount());
    }

    //Getters and Setters
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(String sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes;
    }

    public String getAfterTaxes() {
        return afterTaxes;
    }

    public void setAfterTaxes(String afterTaxes) {
        this.afterTaxes = afterTaxes;
    }
}
