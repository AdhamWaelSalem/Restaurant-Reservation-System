package FXML;

import MainPack.Restaurant;
import OrdersPack.Dish;
import OrdersPack.OrderItem;
import ReservationPack.ReserveItem;
import ReservationPack.Table;
import UsersPack.Client;
import UsersPack.User;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class Dishes implements Initializable {
    @FXML
    private TableView<DishDetails> DishesView;
    @FXML
    private TableColumn<DishDetails, String> Name;
    @FXML
    private TableColumn<DishDetails, String> Price;
    @FXML
    private TableColumn<DishDetails, JFXSlider> Amount;

    List<JFXSlider> jfxSliders = new ArrayList<>();
    List<Label> labelList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        LoadDishes();
    }

    private void initColumns() {
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
    }

    private void LoadDishes() {
        ObservableList<DishDetails> Dishes = FXCollections.observableArrayList();
        for (OrderItem o : Restaurant.getRestaurant().getOrderItems()) {
           // int i=0;
            if (o instanceof Dish) {
                DishDetails d = new DishDetails();
                d.setName(o.getName());
                d.setPrice(String.valueOf(o.getPrice()));
                JFXSlider jfxSlider = new JFXSlider(0, 20, 0);
                Label label = new Label();

                jfxSliders.add(jfxSlider);
                jfxSlider.setShowTickLabels(true);
                jfxSlider.setShowTickMarks(true);
                jfxSlider.setMajorTickUnit(5f);
                // jfxSlider.setBlockIncrement(1f);
                labelList.add(label);
                label.textProperty().bind(Bindings.format("%.0f", jfxSlider.valueProperty()));
                System.out.println(label.getText());

       /*         if (jfxSliders.get(i).getValue() != 0)
                    jfxSlider.setDisable(true);
*/
                d.setAmount(jfxSlider);
                Dishes.add(d);
            }//i++;
        }
        DishesView.setItems(Dishes);
    }

    public void confirmOrder(MouseEvent mouseEvent) {
      /*  for (Label label:labelList) {
            System.out.println(label.getText());
        }*/
        List<OrderItem> confirmedOrderedItems = new ArrayList<>();
        for (JFXSlider jfxslider : jfxSliders) {
            if (jfxslider.getValue() != 0) {
                for (int i = 0; i < (int) (jfxslider.getValue()); i++)
                    ///LOL
                    confirmedOrderedItems.add(Restaurant.getRestaurant().getOrderItems().get(jfxSliders.indexOf(jfxslider)));
                jfxslider.setDisable(true);
            }
            for (int i = 0; i < Restaurant.getRestaurant().getUsers().size(); i++) {
                User user = Restaurant.getRestaurant().getUsers().get(i);
                if (user.isLoggedIn()) {
                    Client client = (Client) Restaurant.getRestaurant().getUsers().get(i);
                    try {
                        ((Client) Restaurant.getRestaurant().getUsers().get(i)).AddOrder(((Client) Restaurant.getRestaurant().getUsers().get(i)).getReservations().get(0), confirmedOrderedItems, " ");

                    } catch (Exception e) {
                        System.out.println("NO RESERVATION MADE");

                    }

                    break;
                }

            }
        }

    }
}
