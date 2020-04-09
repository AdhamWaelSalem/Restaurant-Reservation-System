package Dashboards.Manager;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.util.Date;

public class ReservationDetails {

    @FXML
    private Pane Pane;

    private String ClientName;
    private String TableNumber;
    private String Date;

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getTableNumber() {
        return TableNumber;
    }

    public void setTableNumber(String tableNumber) {
        TableNumber = tableNumber;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
