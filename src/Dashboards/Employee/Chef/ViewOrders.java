package Dashboards.Employee.Chef;

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

import java.net.URL;
import java.util.ResourceBundle;

public class ViewOrders implements Initializable {

    @FXML
    private TableView<OrderDetails> Orders;
    @FXML
    private TableColumn<OrderDetails,String> Order;
    @FXML
    private TableColumn<OrderDetails,String> Amount;
    @FXML
    private TableColumn<OrderDetails,String> Table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        loadOrders();
    }

    public void initColumns(){
        Order.setCellValueFactory(new PropertyValueFactory<>("Order"));
        Amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        Table.setCellValueFactory(new PropertyValueFactory<>("Table"));
    }
    public void loadOrders(){
        ObservableList<OrderDetails> O = FXCollections.observableArrayList();
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user instanceof Client){
                for (Reservation r: ((Client) user).getReservations()) {
                    for (OrderItem i: r.getOrder().getOrderedItems()) {
                        O.add(new OrderDetails(i.getName(),String.valueOf(i.getAmount()),String.valueOf(r.getTable().getNumber())));
                    }
                }
            }
        }
        Orders.setItems(O);
    }


}
