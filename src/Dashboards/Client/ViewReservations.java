package Dashboards.Client;

import Dashboards.Employee.Reservations.ReservationDetails;
import Main.Restaurant;
import Orders.OrderItem;
import Reservation.Reservation;
import Users.Client;
import Users.Employee;
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

public class ViewReservations implements Initializable {
    @FXML
    protected AnchorPane pane;
    @FXML
    private TableView<ReservationDetails> ReservationsView;
    @FXML
    private TableColumn<ReservationDetails, String> Table;
    @FXML
    private TableColumn<ReservationDetails, String> Order;
    @FXML
    private TableColumn<ReservationDetails, String> Check;
    @FXML
    private TableColumn<ReservationDetails, String> Date;


    private HomePage homePage;
    protected void initHomePage(HomePage controller){
        homePage = controller;
        loadReservations();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();

    }

    private void initColumns() {
        Table.setCellValueFactory(new PropertyValueFactory<>("Table"));
        Order.setCellValueFactory(new PropertyValueFactory<>("Order"));
        Check.setCellValueFactory(new PropertyValueFactory<>("Check"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }

    private void loadReservations() {
        ObservableList<ReservationDetails> O = FXCollections.observableArrayList();
                for (Reservation r: ((Client) homePage.user).getReservations()) {
                    ReservationDetails d = new ReservationDetails((homePage.user).getName(),String.valueOf(r.getTable().getNumber()),String.valueOf(r.getReservationDate()));
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
        ReservationsView.setItems(O);
    }
}
