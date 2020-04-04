package DashboardsPack.Manager;

import MainPack.Restaurant;
import ReservationPack.Reservation;
import ReservationPack.Table;
import UsersPack.Client;
import com.jfoenix.controls.JFXListView;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.*;

public class ReservationsPane implements Initializable {

    @FXML
    private JFXListView<String> listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
