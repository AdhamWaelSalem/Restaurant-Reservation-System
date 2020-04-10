package Dashboards.Employee.Manager;

import Dashboards.Client.DishDetails;
import Dashboards.Client.HomePage;
import Main.Restaurant;
import Orders.Dish;
import Orders.OrderItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    @FXML
    AnchorPane pane;
    @FXML
    private TableView<DishDetails> DishesView;
    @FXML
    private TableColumn<DishDetails, String> Name;
    @FXML
    private TableColumn<DishDetails, String> Price;
    @FXML
    private TableColumn<DishDetails,String> Type;

    Restaurant restaurant = Restaurant.getRestaurant();
    List<OrderItem> orderItems = restaurant.getOrderItems();

    private HomePage homePage;
    protected void initHomePage(HomePage controller){
        homePage = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        LoadDishes();
    }

    private void initColumns() {
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Type.setCellValueFactory(new PropertyValueFactory<>("Type"));
    }

    private void LoadDishes() {
        ObservableList<DishDetails> Dishes = FXCollections.observableArrayList();
        for (OrderItem o :orderItems) {
            if (o instanceof Dish) {
                DishDetails d = new DishDetails();
                d.setName(o.getName());
                d.setPrice(String.valueOf(o.getPrice()));
                d.setType(((Dish) o).getType().toString());
                Dishes.add(d);
            }
        }
        DishesView.setItems(Dishes);
    }


}
