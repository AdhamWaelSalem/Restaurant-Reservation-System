package Dashboards.Client;

import Main.Restaurant;
import Orders.Dish;
import Orders.OrderItem;
import Users.Client;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
