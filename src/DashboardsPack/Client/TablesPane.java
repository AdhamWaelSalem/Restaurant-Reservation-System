package DashboardsPack.Client;

import MainPack.Restaurant;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TablesPane implements Initializable {

    @FXML
    JFXButton table1;
    @FXML
    JFXButton table2;
    @FXML
    JFXButton table3;
    @FXML
    JFXButton table4;
    @FXML
    JFXButton table5;
    @FXML
    JFXButton table6;
    @FXML
    JFXButton table7;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table1.setText(Restaurant.getRestaurant().getTables().get(0).info());
        table2.setText(Restaurant.getRestaurant().getTables().get(1).info());
        table3.setText(Restaurant.getRestaurant().getTables().get(2).info());
        table4.setText(Restaurant.getRestaurant().getTables().get(3).info());
        table5.setText(Restaurant.getRestaurant().getTables().get(4).info());
        table6.setText(Restaurant.getRestaurant().getTables().get(5).info());
        table7.setText(Restaurant.getRestaurant().getTables().get(6).info());
    }


}
