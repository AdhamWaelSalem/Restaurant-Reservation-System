package Dashboards.Employee.Chef;

public class OrderDetails {
    private String Order;
    private String Amount;
    private String Table;


    public OrderDetails(String order, String amount, String table) {
        Order = order;
        Amount = amount;
        Table = table;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public String getTable() {
        return Table;
    }

    public void setTable(String table) {
        Table = table;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
