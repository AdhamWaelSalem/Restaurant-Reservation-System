package Dashboards.Employee.Reservations;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class ReservationDetails {

    private String Client;
    private String Table;
    private String Date;
    private String Order;
    private String Check;

    public ReservationDetails(String client, String table, String date) {
        Client = client;
        Table = table;
        Date = date;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    public String getTable() {
        return Table;
    }

    public void setTable(String table) {
        Table = table;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public String getCheck() {
        return Check;
    }

    public void setCheck(String check) {
        Check = "$ " + check;
    }
}
