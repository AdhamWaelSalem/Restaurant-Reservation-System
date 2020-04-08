package FXML;

import MainPack.Restaurant;
import ReservationPack.ReserveItem;
import ReservationPack.Table;
import UsersPack.Client;
import UsersPack.User;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class Tables implements Initializable {
    @FXML
    private TableView<TableDetails> TablesView;
    @FXML
    private TableColumn<TableDetails, String> Table;
    @FXML
    private TableColumn<TableDetails, String> Seats;
    @FXML
    private TableColumn<TableDetails, String> Smoking;
    @FXML
    private TableColumn<TableDetails, String> Location;
    @FXML
    private TableColumn<TableDetails, JFXToggleButton> Reserve;
    List<JFXToggleButton> jfxToggleButtons = new ArrayList<>();

    @Override

    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        LoadTables();
    }

    private void initColumns() {
        Table.setCellValueFactory(new PropertyValueFactory<>("Table"));
        Seats.setCellValueFactory(new PropertyValueFactory<>("Seats"));
        Smoking.setCellValueFactory(new PropertyValueFactory<>("Smoking"));
        Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
        Reserve.setCellValueFactory(new PropertyValueFactory<>("Reserve"));
    }

    private void LoadTables() {
        ObservableList<TableDetails> Tables = FXCollections.observableArrayList();
        for (ReserveItem t : Restaurant.getRestaurant().getReserveItems()) {
            if (t instanceof Table) {
                TableDetails D = new TableDetails();
                D.setTable("Table " + ((Table) t).getNumber());
                D.setSeats(((Table) t).getNumberOfSeats() + " Seats");
                D.setSmoking(((Table) t).isSmoking() ? "Smoking" : "Non Smoking");
                D.setLocation(((Table) t).getLocation().toString());
                ///////////
                JFXToggleButton jfxToggleButton = new JFXToggleButton();
                jfxToggleButtons.add(jfxToggleButton);
                if (Restaurant.getRestaurant().getReserveItems().get(jfxToggleButtons.indexOf(jfxToggleButton)).isReserved()) {
                    jfxToggleButton.setDisable(true);
                    jfxToggleButton.setSelected(true);
                    jfxToggleButton.setToggleLineColor(Color.RED);
                    jfxToggleButton.setToggleColor(Color.RED);
                }
                D.setReserve(jfxToggleButton);
                Tables.add(D);
            }
        }
        TablesView.setItems(Tables);
    }


    public void confirmReservation(MouseEvent mouseEvent) {
        List<ReserveItem> confirmedReservedItems = new ArrayList<>();
        for (JFXToggleButton b : jfxToggleButtons) {
            if (b.isSelected()) {
                confirmedReservedItems.add(Restaurant.getRestaurant().getReserveItems().get(jfxToggleButtons.indexOf(b)));
                // Restaurant.getRestaurant().getReserveItems().get(jfxToggleButtons.indexOf(b)).
                b.setToggleLineColor(Color.RED);
                b.setToggleColor(Color.RED);
                b.setDisable(true);
                //System.out.println("hi");
            }

        }

        for (int i = 0; i < Restaurant.getRestaurant().getUsers().size(); i++) {
            User user = Restaurant.getRestaurant().getUsers().get(i);
            if (user.isLoggedIn()) {
                Client client = (Client) Restaurant.getRestaurant().getUsers().get(i);
                ((Client) Restaurant.getRestaurant().getUsers().get(i)).MakeReservation(confirmedReservedItems, Calendar.getInstance().getTime(), " ");

            }

        }
        //System.out.println();
    }
}
