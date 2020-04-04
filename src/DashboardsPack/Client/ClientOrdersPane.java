package DashboardsPack.Client;

import MainPack.Restaurant;
import OrdersPack.Dish;
import ReservationPack.Table;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClientOrdersPane implements Initializable {
    @FXML
    GridPane Gridpane = new GridPane();
    List<JFXButton> tab = new ArrayList<>();

    public void clickOnButton() {
        Gridpane.getChildren().forEach(node -> {
            node.setOnMouseClicked(event -> {
                int i;
                if (event.getPickResult().getIntersectedNode().getStyle().equals("-fx-background-color: GREEN"))
                    event.getPickResult().getIntersectedNode().setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
                else {
                    for (i = 0; i < Gridpane.getChildren().size(); i++) {
                        if (Gridpane.getChildren().get(i).getStyle().equals("-fx-background-color: GREEN")) {
                            Gridpane.getChildren().get(i).setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
                            break;
                        }
                    }
                    event.getPickResult().getIntersectedNode().setStyle("-fx-background-color: GREEN");


                }
            });
        });

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int i = 0, j = 0;
        for (Dish dish: Restaurant.getRestaurant().getDishes()) {
            JFXButton b = new JFXButton(dish.info());
            b.setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
            b.setTextAlignment(TextAlignment.CENTER);
            tab.add(b);
            GridPane.setHgrow(b, Priority.ALWAYS);
            GridPane.setVgrow(b, Priority.ALWAYS);
            GridPane.setConstraints(b, i, j / 2);
            Gridpane.getChildren().add(b);
            if (i == 0)
                i = 1;
            else
                i = 0;
            j++;
        }
        clickOnButton();

    }
}
