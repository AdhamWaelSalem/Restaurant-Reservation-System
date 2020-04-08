package Dashboards.Client;

import com.jfoenix.controls.JFXToggleButton;

public class TableDetails {

    private String Table;
    private String Seats;
    private String Smoking;
    private String Location;
    private JFXToggleButton Reserve;

    public String getTable() {
        return Table;
    }

    public void setTable(String table) {
        Table = table;
    }

    public String getSeats() {
        return Seats;
    }

    public void setSeats(String seats) {
        Seats = seats;
    }

    public String getSmoking() {
        return Smoking;
    }

    public void setSmoking(String smoking) {
        Smoking = smoking;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public JFXToggleButton getReserve() {
        return Reserve;
    }

    public void setReserve(JFXToggleButton reserve) {
        Reserve = reserve;
    }
}
