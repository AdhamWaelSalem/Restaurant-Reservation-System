package Dashboards.Manager;

import MainPack.Restaurant;
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

import java.net.URL;
import java.util.ResourceBundle;

public class Reservations implements Initializable {
    @FXML
    protected AnchorPane pane;
    @FXML
    private TableView<ReservationDetails> ReservationsView;
    @FXML
    private TableColumn<ReservationDetails, String> ClientName;
    @FXML
    private TableColumn<ReservationDetails, String> TableNumber;
    @FXML
    private TableColumn<ReservationDetails, String> Date;

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
        ObservableList<ReservationDetails> managerReservationDetails = FXCollections.observableArrayList();
        for (User u : Restaurant.getRestaurant().getUsers()) {
            if (u instanceof Client) {
                try {
                    for (int i = 0; i < ((Client) u).getReservations().size(); i++) {
                        ReservationDetails m = new ReservationDetails();
                        m.setTableNumber(String.valueOf(((Client) u).getReservations().get(i).getTable().getNumber()));
                        m.setDate(String.valueOf(((Client) u).getReservations().get(i).getReservationDate()));
                        m.setClientName(u.getName());
                        managerReservationDetails.add(m);
                    }
                } catch (Exception e) {
                    continue;
                }

            }
        }
        ReservationsView.setItems(managerReservationDetails);

    }
}
