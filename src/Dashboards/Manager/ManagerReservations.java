package Dashboards.Manager;

import Dashboards.Client.DishDetails;
import MainPack.Restaurant;
import ReservationPack.Reservation;
import UsersPack.Client;
import UsersPack.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ManagerReservations implements Initializable {
    @FXML
    protected AnchorPane pane;
    @FXML
    private TableView<ManagerReservationDetails> ReservationsView;
    @FXML
    private TableColumn<ManagerReservationDetails, String> ClientName;
    @FXML
    private TableColumn<ManagerReservationDetails, String> TableNumber;
    @FXML
    private TableColumn<ManagerReservationDetails, String> Date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        loadReservations();
    }

    private void initColumns() {
        ClientName.setCellValueFactory(new PropertyValueFactory<>("ClientName"));
        TableNumber.setCellValueFactory(new PropertyValueFactory<>("TableNumber"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }

    private void loadReservations() {
        ObservableList<ManagerReservationDetails> managerReservationDetails = FXCollections.observableArrayList();
        for (User u : Restaurant.getRestaurant().getUsers()) {
            if (u instanceof Client) {
                ManagerReservationDetails m = new ManagerReservationDetails();
                try {
                    m.setTableNumber(String.valueOf(((Client) u).getReservations().get(0).getTable().getNumber()));
                    m.setDate(String.valueOf(((Client) u).getReservations().get(0).getReservationDate()));
                    m.setClientName(u.getName());
                    managerReservationDetails.add(m);
                } catch (Exception e) {
                    continue;
                }

            }
        }
        ReservationsView.setItems(managerReservationDetails);

    }
}
