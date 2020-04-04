package DashboardsPack.Manager;

import MainPack.Restaurant;
import ReservationPack.Table;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrdersPane implements Initializable {



    @FXML
    private GridPane gridPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Restaurant restaurant = Restaurant.getRestaurant();
        for (int i = 0; i < restaurant.getTables().size(); i++){
            Table table = restaurant.getTables().get(i);
            Button button = new Button();
            button.setText(String.valueOf(table.info()));
            gridPane.add(button,i,i);

        }
    }
}
