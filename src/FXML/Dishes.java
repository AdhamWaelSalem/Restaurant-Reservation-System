package FXML;

import MainPack.Restaurant;
import OrdersPack.Dish;
import OrdersPack.OrderItem;
import ReservationPack.ReserveItem;
import ReservationPack.Table;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Dishes implements Initializable {
    @FXML
    private TableView<DishDetails> DishesView;
    @FXML
    private TableColumn<DishDetails,String> Name;
    @FXML
    private TableColumn<DishDetails,String> Price;
    @FXML
    private TableColumn<DishDetails, JFXSlider> Amount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        LoadDishes();
    }

    private void initColumns(){
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
    }

    private void LoadDishes(){
        ObservableList<DishDetails> Dishes = FXCollections.observableArrayList();
        for (OrderItem o: Restaurant.getRestaurant().getOrderItems()) {
            if (o instanceof Dish){
                DishDetails d = new DishDetails();
                d.setName(o.getName());
                d.setPrice(String.valueOf(o.getPrice()));
                d.setAmount(new JFXSlider());
                Dishes.add(d);
            }
        }
        DishesView.setItems(Dishes);
    }
}
