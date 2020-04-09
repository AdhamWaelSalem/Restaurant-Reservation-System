package Dashboards.Employee.Reservations;

import Main.Restaurant;
import Orders.OrderItem;
import Reservation.Reservation;
import Users.Client;
import Users.User;
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
    private TableColumn<ReservationDetails, String> Client;
    @FXML
    private TableColumn<ReservationDetails, String> Table;
    @FXML
    private TableColumn<ReservationDetails, String> Order;
    @FXML
    private TableColumn<ReservationDetails, String> Check;
    @FXML
    private TableColumn<ReservationDetails, String> Date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        loadReservations();
    }

    private void initColumns() {
        Client.setCellValueFactory(new PropertyValueFactory<>("Client"));
        Table.setCellValueFactory(new PropertyValueFactory<>("Table"));
        Order.setCellValueFactory(new PropertyValueFactory<>("Order"));
        Check.setCellValueFactory(new PropertyValueFactory<>("Check"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }

//    private void LoadReservations() {
//        ObservableList<ReservationDetails> M = FXCollections.observableArrayList();
//        for (User u : Restaurant.getRestaurant().getUsers()) {
//            if (u instanceof Client) {
//                try {
//                    for (int i = 0; i < ((Client) u).getReservations().size(); i++) {
//                        ReservationDetails m = new ReservationDetails();
//                        m.setTableNumber(String.valueOf(((Client) u).getReservations().get(i).getTable().getNumber()));
//                        m.setDate(String.valueOf(((Client) u).getReservations().get(i).getReservationDate()));
//                        m.setClientName(u.getName());
//                        M.add(m);
//                    }
//                } catch (Exception e) {
//                    //
//                }
//
//            }
//        }
//        ReservationsView.setItems(M);
//
//    }

    private void loadReservations() {
        ObservableList<ReservationDetails> O = FXCollections.observableArrayList();
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user instanceof Client){
                for (Reservation r: ((Client) user).getReservations()) {
                    ReservationDetails d = new ReservationDetails(user.getName(),String.valueOf(r.getTable().getNumber()),String.valueOf(r.getReservationDate()));
                    try {
                        r.getOrder();
                        String order = new String();
                        float check = 0;
                        for (OrderItem i: r.getOrder().getOrderedItems()) {
                            order += i.getAmount() + " " + i.getName() + "\n";
                            check += i.getAmount()*i.getPrice()*(1+i.getTaxes());
                        }
                        d.setCheck(String.valueOf(check));
                        d.setOrder(order);
                    }catch (NullPointerException n){
                        //NO ORDER
                    }
                    O.add(d);
                }
            }
        }
        ReservationsView.setItems(O);
    }
}
