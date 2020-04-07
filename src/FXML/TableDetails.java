package FXML;

import ReservationPack.Table;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class TableDetails {
    private String Table;
    private String Seats;
    private String Smoking;
    private String Location;
    private JFXToggleButton Reserve;

    public void setTable(String table) {
        Table = table;
    }

    public void setSeats(String seats) {
        Seats = seats;
    }

    public void setSmoking(String smoking) {
        Smoking = smoking;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setReserve(JFXToggleButton reserve) {
        Reserve = reserve;
    }
}
